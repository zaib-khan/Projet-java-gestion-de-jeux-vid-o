package viewPackage;

import controllerPackage.Control;
import exceptionPackage.*;
import modelPackage.Client;
import modelPackage.Facture;
import modelPackage.ModelRechercheJeuAchete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class FenetreRechercheJeuDate extends JFrame {

    private Container container;

    private JPanel bouton;
    private JPanel donneRecherche;

    private JButton boutonQuitter;
    private JButton boutonRecherche;

    private JLabel nomClient;
    private JLabel dateDebut;

    private JList tableRecherche;

    private static final int NB_CLIENT = 10;

    private String[] nomDesClient = new String[NB_CLIENT];
    private String[] prenomDesClient = new String[NB_CLIENT];

    private JComboBox comboListeClient;
    private ArrayList<Client> listeClient;
    private ArrayList<Facture>facture;
    private ArrayList<ModelRechercheJeuAchete> jeuClient;

    private JSpinner dateDebutFacture;




    public FenetreRechercheJeuDate() throws NomException, PrenomException, ConnexionException, ParseException, CodePostalException,RueException,DateNaissanceException
            ,VilleException,NumeroException,IdentifiantException,TelephoneException,EmailException
    {

        super("Liste des jeux achetés par un listeClient après une date précise ");

        setBounds(900, 200, 500, 200);
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);

        bouton = new JPanel(new GridLayout(1, 2));
        donneRecherche = new JPanel(new GridLayout(2,1));

        container.add(donneRecherche, BorderLayout.CENTER);
        container.add(bouton, BorderLayout.SOUTH);

        nomClient = new JLabel("Client : ");
        nomClient.setHorizontalAlignment(SwingConstants.RIGHT);
        donneRecherche.add(nomClient);

//----------------------------------------------------------------------------------------
        listeClient = new Control().getEnsembleClient();
        comboListeClient = new JComboBox();
        comboListeClient.setAlignmentX(SwingConstants.RIGHT);


        for (int i = 0; i < listeClient.size(); i++) {
            comboListeClient.addItem(listeClient.get(i).getNom()+" "+ listeClient.get(i).getPrenom()+" ( "+ listeClient.get(i).getIdentifiant()+" )");
        }

        facture = new Control().getEnsembleFacture();



        donneRecherche.add(comboListeClient);


        dateDebut = new JLabel("Date début facture : ");
        dateDebut.setHorizontalAlignment(SwingConstants.RIGHT);
        donneRecherche.add(dateDebut);

        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -1);
        Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 1);
        Date latestDate = calendar.getTime();

        SpinnerDateModel model = new SpinnerDateModel(initDate,earliestDate,latestDate,Calendar.YEAR);
        dateDebutFacture = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateDebutFacture, "dd-MM-yyyy");
        dateDebutFacture.setEditor(editor);
        model.setStart(editor.getFormat().parse("1-01-1900"));

        donneRecherche.add(dateDebutFacture);

        boutonQuitter = new JButton("Quitter");
        boutonRecherche = new JButton("Recherche");

        bouton.add(boutonRecherche);
        bouton.add(boutonQuitter);

        boutonQuitter.addActionListener(new ActionRetour());
        boutonRecherche.addActionListener(new ActionRecherche());
    }

    private Calendar initCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2004, Calendar.JANUARY, 1);
        return calendar;
    }

    private class ActionRetour implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();

        }
    }

    public boolean contientFacture(Client client){
        boolean reponse = false;

        for(Facture fac : facture){
            if (fac.getClient().equals(client.getIdentifiant())){
                reponse = true;
                break;
            }
        }
        return reponse;
    }

    public Client getClientSelectionner(){
        Client reponse = new Client();

        String nomClient [] = comboListeClient.getModel().getSelectedItem().toString().split(" ");
        String pseudoClient = nomClient[3];

        for (Client client : listeClient){
            if(client.getIdentifiant().equals(pseudoClient)){
                reponse = client;
            }
        }
        return reponse;
    }

    public GregorianCalendar getDateNaissance() {
        Date dateNaissanceJS = (Date) dateDebutFacture.getValue();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dateNaissanceJS);
        return calendar;
    }

    private class ActionRecherche implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            if(!contientFacture(getClientSelectionner())){
                JOptionPane.showMessageDialog(null, comboListeClient.getModel().getSelectedItem().toString()+" a acheté aucun jeux", "Erreur recherche client", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
                    jeuClient = new Control().getJeuClient(getClientSelectionner(),getDateNaissance());
                    new FentreJeuClient(jeuClient);


                }
                catch (ConnexionException exception){
                    exception.getMessage();
                }
            }

        }
    }


}


