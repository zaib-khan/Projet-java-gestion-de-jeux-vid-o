package viewPackage;

import controllerPackage.Control;
import exceptionPackage.*;
import modelPackage.Client;
import modelPackage.Facture;
import modelPackage.ModelRechercheFacture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.*;

public class FenetreRechercheFacDate extends JFrame {

    private Container container;

    private JPanel bouton;
    private JPanel donneRecherche;

    private JButton boutonQuitter;
    private JButton boutonRecherche;

    private JLabel nomClient;
    private JLabel dateDebut;
    private JLabel dateFin;

    private JComboBox comboListeClient;
    private ArrayList<Client> listeClient;
    private ArrayList<Facture>facture;
    private ArrayList<ModelRechercheFacture>listFacture;


    private JSpinner dateDebutFacture;
    private JSpinner dateFinFacture;



    public FenetreRechercheFacDate() throws NomException, PrenomException, ConnexionException, ParseException, CodePostalException,RueException,DateNaissanceException
            ,VilleException,NumeroException,TelephoneException,IdentifiantException,EmailException{
        super("Fenetre recherche Facture entre 2 dates");

        setBounds(900, 200, 500, 200);
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);

        bouton = new JPanel(new GridLayout(1, 2));
        donneRecherche = new JPanel(new GridLayout(3,2));

        container.add(donneRecherche, BorderLayout.CENTER);
        container.add(bouton, BorderLayout.SOUTH);

        nomClient = new JLabel("Client : ");
        nomClient.setHorizontalAlignment(SwingConstants.RIGHT);


        listeClient = new Control().getEnsembleClient();
        comboListeClient = new JComboBox();
        comboListeClient.setAlignmentX(SwingConstants.RIGHT);


        for (int i = 0; i < listeClient.size(); i++) {
            comboListeClient.addItem(listeClient.get(i).getNom()+" "+ listeClient.get(i).getPrenom()+" ( "+ listeClient.get(i).getIdentifiant()+" )");
        }

        facture = new Control().getEnsembleFacture();

        dateDebut = new JLabel("Date début facture : ");
        dateDebut.setHorizontalAlignment(SwingConstants.RIGHT);
        dateFin = new JLabel("Date Fin Facture : ");
        dateFin.setHorizontalAlignment(SwingConstants.RIGHT);


        Calendar calendar = Calendar.getInstance();
        Date initDate = calendar.getTime();
        calendar.add(Calendar.YEAR, -1);
        Date earliestDate = calendar.getTime();
        calendar.add(Calendar.YEAR, 1);
        Date latestDate = calendar.getTime();

        SpinnerDateModel modelDeb = new SpinnerDateModel(initDate,earliestDate,latestDate,Calendar.YEAR);
        dateDebutFacture = new JSpinner(modelDeb);
        JSpinner.DateEditor editorDeb = new JSpinner.DateEditor(dateDebutFacture, "dd-MM-yyyy");
        dateDebutFacture.setEditor(editorDeb);
        modelDeb.setStart(editorDeb.getFormat().parse("1-01-1900"));

        SpinnerDateModel modelFin = new SpinnerDateModel(initDate,earliestDate,latestDate,Calendar.YEAR);
        dateFinFacture = new JSpinner(modelFin);
        JSpinner.DateEditor editorFin = new JSpinner.DateEditor(dateFinFacture, "dd-MM-yyyy");
        dateFinFacture.setEditor(editorFin);
        modelFin.setStart(editorFin.getFormat().parse("1-01-1900"));

        donneRecherche.add(nomClient);
        donneRecherche.add(comboListeClient);

        donneRecherche.add(dateDebut);
        donneRecherche.add(dateDebutFacture);

        donneRecherche.add(dateFin);
        donneRecherche.add(dateFinFacture);


        boutonQuitter = new JButton("Quitter");
        boutonRecherche = new JButton("Recherche");

        bouton.add(boutonRecherche);
        bouton.add(boutonQuitter);

        boutonQuitter.addActionListener(new ActionQuitter());
        boutonRecherche.addActionListener(new ActionRecherche());
    }


    private class ActionQuitter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();

        }
    }

    public GregorianCalendar getDatFin() {
        Date dateFin = (Date) dateFinFacture.getValue();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dateFin);
        return calendar;
    }

    public GregorianCalendar getDateDebut() {
        Date dateDebut = (Date) dateDebutFacture.getValue();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dateDebut);
        return calendar;
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

    private class ActionRecherche implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            if(!contientFacture(getClientSelectionner())){
                JOptionPane.showMessageDialog(null, comboListeClient.getModel().getSelectedItem().toString()+" a acheté aucun goodies", "Erreur recherche client", JOptionPane.ERROR_MESSAGE);
            }
            else{
                try{
                    listFacture = new Control().getFacture2Date(getClientSelectionner(),getDateDebut(),getDatFin());
                    new FenetreFactureDate(listFacture);
                }
                catch (ConnexionException exception){
                    exception.getMessage();
                }
            }

        }
    }

}

