package viewPackage;


import controllerPackage.Control;
import exceptionPackage.*;
import modelPackage.Client;
import modelPackage.Etablissement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class FenetreInscription extends JFrame {

    private Container container;

    private Client nouveauClient;
    private Control controller;

    private static  double tailleCLDefaut;
    private static  String tailleVetementDefaut;

    private JTextField textIdentifiant;
    private JTextField textNom;
    private JTextField textPrenom;
    private JTextField textCodePostal;
    private JTextField textVille;
    private JTextField textRue;
    private JTextField textNumero;
    private JTextField textTelephone;
    private JTextField textEmail;

    private JPanel formulaire;
    private  JPanel bouton;

    private  GridBagConstraints c;

    private JComboBox comboVetement;

    private JComboBox etablissmentJcombo;
    private ArrayList<Etablissement> etablissements;

    private JSpinner spinnerLunette;
    private JSpinner spinnerCeinture;
    private JSpinner dateNaissance;

    private JCheckBox checkBoxCarte;
    private JCheckBox checkBoxInfoSup;

    private JButton boutonQuitter;
    private JButton boutonEnregistrer;
    private JButton boutonEffacer;
    private JButton boutonVerification;

    private List<JLabel> labelList = new ArrayList<>();
    private List<JComponent> componentList = new ArrayList<>();

    private String [] taille = {"XS","S","M","L","XL","XXL"};
    private ArrayList<Client> clientList;




    public FenetreInscription(){

        super("Inscription client");

        try {

            setBounds(900, 170, 600, 520);
            container = this.getContentPane();
            container.setLayout(new BorderLayout());
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {

                }
            });
            setVisible(true);

            formulaire = new JPanel(new GridBagLayout());
            bouton = new JPanel(new GridLayout(1, 3));

             controller = new Control();

            container.add(formulaire, BorderLayout.NORTH);
            container.add(bouton, BorderLayout.SOUTH);

            boutonEffacer = new JButton("Tout effacer");
            boutonEnregistrer = new JButton("Enregistrer");
            boutonQuitter = new JButton("Quitter");
            boutonVerification = new JButton("Verifier pseudo");

            boutonQuitter.addActionListener(new ActionQuitter());
            boutonEffacer.addActionListener(new ActionEffacer());
            boutonEnregistrer.addActionListener(new ActioncEnregistre());
            boutonEnregistrer.addActionListener(new ActionVerifie());
            boutonVerification.addActionListener(new ActionVerifie());

            bouton.add(boutonEffacer);
            bouton.add(boutonEnregistrer);
            bouton.add(boutonQuitter);

            spinnerCeinture = new JSpinner(new SpinnerNumberModel(70, 70, 95, 5.0));

            spinnerLunette = new JSpinner(new SpinnerNumberModel(10, 10, 14, 0.1));
            comboVetement = new JComboBox(taille);
            comboVetement.setSelectedItem("M");

            checkBoxCarte = new JCheckBox("Carte de fidélité ? ");
            checkBoxInfoSup = new JCheckBox("Infomration supplémentaire");
            checkBoxCarte.setSelected(false);
            checkBoxInfoSup.setSelected(false);
            checkBoxInfoSup.addItemListener(new CheckBoxInfoListener());


            c = new GridBagConstraints();
            c.anchor = GridBagConstraints.LINE_END;
            c.insets = new Insets(5, 0, 0, 0);

            labelList.add(new JLabel("Pseudo : "));
            labelList.add(new JLabel("Nom : "));
            labelList.add(new JLabel("Prénom : "));
            labelList.add(new JLabel("Ville : "));
            labelList.add(new JLabel("Rue : "));
            labelList.add(new JLabel("Numéro : "));
            labelList.add(new JLabel("Code Postal : "));
            labelList.add(new JLabel("Date de naissance : "));
            labelList.add(new JLabel("Etablissement : "));
            labelList.add(new JLabel("Téléphone : "));
            labelList.add(new JLabel("e-Mail : "));
            labelList.add(new JLabel("Taille lunette (cm) : "));
            labelList.add(new JLabel("Taille Ceinture (cm): "));
            labelList.add(new JLabel("Taille vêtement : "));

            textIdentifiant = new JTextField(12);
            textNom = new JTextField(12);
            textPrenom = new JTextField(12);
            textVille = new JTextField(12);
            textRue = new JTextField(12);
            textNumero = new JTextField(5);
            textCodePostal = new JTextField(5);


            Calendar calendar = Calendar.getInstance();
            Date initDate = calendar.getTime();
            calendar.add(Calendar.YEAR, -1);
            Date earliestDate = calendar.getTime();
            calendar.add(Calendar.YEAR, 1);
            Date latestDate = calendar.getTime();

            SpinnerDateModel model = new SpinnerDateModel(initDate,earliestDate,latestDate,Calendar.YEAR);
            dateNaissance = new JSpinner(model);
            JSpinner.DateEditor editor = new JSpinner.DateEditor(dateNaissance, "dd-MM-yyyy");
            dateNaissance.setEditor(editor);
            model.setStart(editor.getFormat().parse("1-01-1900") );

            textTelephone = new JTextField(8);
            textEmail = new JTextField(15);

            etablissements = new Control().getEnsembleEtablissement();
            clientList = new Control().getEnsembleClient();

            etablissmentJcombo = new JComboBox();

            for (int i = 0 ; i < etablissements.size(); i++) {
                etablissmentJcombo.addItem(etablissements.get(i).getNom());
            }


            spinnerLunette.setEnabled(false);
            spinnerCeinture.setEnabled(false);
            comboVetement.setEnabled(false);

            componentList.add(textIdentifiant);
            componentList.add(textNom);
            componentList.add(textPrenom);
            componentList.add(textVille);
            componentList.add(textRue);
            componentList.add(textNumero);
            componentList.add(textCodePostal);
            componentList.add(dateNaissance);
            componentList.add(etablissmentJcombo);
            componentList.add(textTelephone);
            componentList.add(textEmail);
            componentList.add(spinnerLunette);
            componentList.add(spinnerCeinture);
            componentList.add(comboVetement);
            componentList.add(checkBoxInfoSup);
            componentList.add(checkBoxCarte);


            c.gridx = 2;
            formulaire.add(boutonVerification,c);

            resetXY();
            for (JLabel label : labelList) {
                formulaire.add(label, c);
                nextY();
            }
            resetXY();
            c.gridx = 1;
            c.anchor = GridBagConstraints.LINE_START;

            for (JComponent component : componentList) {
                formulaire.add(component, c);
                nextY();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void nextY(){
        c.gridy++;
    }

    private void resetXY(){
        c.gridx = 0;
        c.gridy = 0;
    }

    private class ActionQuitter implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            dispose();

        }
    }

    private class ActionEffacer implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            for (JComponent component : componentList){
                if(component instanceof JTextField){
                    ((JTextField) component).setText("");
                }

            }
            spinnerCeinture.setValue(((SpinnerNumberModel)spinnerCeinture.getModel()).getMinimum());
            spinnerLunette.setValue(((SpinnerNumberModel)spinnerLunette.getModel()).getMinimum());

            comboVetement.setSelectedItem("M");
            checkBoxCarte.setSelected(false);
        }
    }

    private class CheckBoxInfoListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            if (itemEvent.getStateChange() == ItemEvent.SELECTED){
                for (JComponent component : componentList){
                    if(!component.isEnabled()){
                        component.setEnabled(true);
                    }
                }
            }
            else{

                spinnerLunette.setEnabled(false);
                spinnerCeinture.setEnabled(false);
                comboVetement.setEnabled(false);
            }
        }
    }

    public String getTextIdentifiant() {
        return textIdentifiant.getText();
    }

    public int getMatriculeEtablissement(){
        int indiceListeEtablissement = etablissmentJcombo.getSelectedIndex();
        return etablissements.get(indiceListeEtablissement).getMatricule();
    }

    public String getTextNom() {
        return textNom.getText();
    }

    public String getTextPrenom() {
        return textPrenom.getText();
    }

    public String getTextCodePostal() {
        return textCodePostal.getText();
    }

    public String getTextVille() {
        return textVille.getText();

    }

    public String getTextRue() {
        return textRue.getText();
    }

    public String getTextNumero() {
        return textNumero.getText();
    }

    public String getTextTelephone() {

        if(textTelephone.getText().isEmpty())
        {
            return null;
        }
        else {
            return textTelephone.getText();
        }
    }

    public String getTextEmail() {
        if(textEmail.getText().isEmpty())
        {
            return null;
        }
        else {
            return textEmail.getText();
        }
    }

    public GregorianCalendar getDateNaissance() {
        Date dateNaissanceJS = (Date) dateNaissance.getValue();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dateNaissanceJS);
        return calendar;
    }

    public Double getSpinnerLunette() {
        double res = (Double)spinnerLunette.getValue();
        return  res;

    }

    public Double getSpinnerCeinture() {

        double  res = (Double) spinnerCeinture.getValue();
        return res;
    }

    public boolean getCarteFidelite(){
        return  checkBoxCarte.isSelected();

    }

    public String getComboVetement() {
        int indiceTailleVetement = comboVetement.getSelectedIndex();
        return taille[indiceTailleVetement].toString();
    }




    private boolean verificationPseudo(String pseudo){
        boolean reponse = false;
        for(Client client : clientList){
            if(client.getIdentifiant().equals(pseudo)){
                reponse = true;
            }
        }
        return reponse;
    }

    private class ActionVerifie implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String reponse = "";

            if(textIdentifiant.getText().isEmpty()){
               reponse = "Le pseudo est vide";
            }
            else {
                if(verificationPseudo(textIdentifiant.getText()))
                {
                   reponse = "Le pseudo est déja utilisé";
                }
                else {
                    reponse = "Le pseudo est libre";
                }
            }
            JOptionPane.showMessageDialog(null, reponse, "Verification Pseudo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class ActioncEnregistre implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            try {

                    if(checkBoxInfoSup.isSelected()) {
                        nouveauClient = new Client(getTextIdentifiant(), getMatriculeEtablissement(), getTextNom(), getTextPrenom(), getTextCodePostal(), getTextVille(), getTextRue(), getTextNumero(), getDateNaissance(), getTextTelephone(), getTextEmail(), getCarteFidelite(), getSpinnerLunette(), getSpinnerCeinture(), getComboVetement());

                    }else {

                        nouveauClient = new Client(getTextIdentifiant(), getMatriculeEtablissement(), getTextNom(), getTextPrenom(), getTextCodePostal(), getTextVille(), getTextRue(), getTextNumero(), getDateNaissance(), getTextTelephone(), getTextEmail(), getCarteFidelite(),tailleCLDefaut,tailleCLDefaut,tailleVetementDefaut);

                    }


                if (actionEvent.getSource() == boutonEnregistrer) {
                    if (JOptionPane.showConfirmDialog(null, "Voulez vous enregistrer ce nouveau client ?", "inscription client", JOptionPane.YES_NO_OPTION) == 0) {

                       new Control().ajouterClient(nouveauClient);

                       new FenetreListeClient();

                        JOptionPane.showMessageDialog(null, "Le client a bien été enregistré", "Inscription réussite", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                dispose();

                } catch (PrenomException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur prenom",
                            JOptionPane.ERROR_MESSAGE);
                } catch (NomException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur nom",
                            JOptionPane.ERROR_MESSAGE);
                } catch (ConnexionException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur Connexion",
                            JOptionPane.ERROR_MESSAGE);
                } catch (DateNaissanceException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Probleme date naissance",
                            JOptionPane.ERROR_MESSAGE);
                } catch (VilleException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Probleme de ville",
                            JOptionPane.ERROR_MESSAGE);
                } catch (CodePostalException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de code postal",
                            JOptionPane.ERROR_MESSAGE);
                } catch (RueException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de rue",
                            JOptionPane.ERROR_MESSAGE);
                } catch (NumeroException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de numero",
                            JOptionPane.ERROR_MESSAGE);
                }
                catch (IdentifiantException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur d'identifiant",
                            JOptionPane.ERROR_MESSAGE);
                }
            catch (TelephoneException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de numero de telephone",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (EmailException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur d'email",
                        JOptionPane.ERROR_MESSAGE);
            }catch (ParseException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur de date",
                        JOptionPane.ERROR_MESSAGE);
            }
        }


    }

}