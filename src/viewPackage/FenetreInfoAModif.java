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

public class FenetreInfoAModif extends JFrame {

    private Container container;

    private Client nouveauClient;
    private Control controller;

    private static  double tailleDefaut;
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
    private JButton boutonVerification;

    private java.util.List<JLabel> labelList = new ArrayList<>();
    private List<JComponent> componentList = new ArrayList<>();

    private String [] taille = {"XS","S","M","L","XL","XXL"};
    private ArrayList<Client> clientList;

    private Client clientModif;

    private int indexEtablissement;
    private int indexTailleVetement;




    public FenetreInfoAModif(Client client)
    {

        super("Formulaire de modification client");
        clientModif = client;
        //super("Inscription client");

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


            boutonEnregistrer = new JButton("Enregistrer");
            boutonQuitter = new JButton("Quitter");

            bouton.add(boutonEnregistrer);
            bouton.add(boutonQuitter);

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

            textIdentifiant = new JTextField(clientModif.getIdentifiant(),12);
            textIdentifiant.setEnabled(false);
            textNom = new JTextField(clientModif.getNom(),12);
            textPrenom = new JTextField(clientModif.getPrenom(),12);
            textVille = new JTextField(clientModif.getVille(),12);
            textRue = new JTextField(clientModif.getRue(),12);
            textNumero = new JTextField(clientModif.getNumero(),5);
            textCodePostal = new JTextField(clientModif.getCodePostal(),5);


            Calendar calendar = Calendar.getInstance();
            Date initDate = calendar.getTime();
            calendar.add(Calendar.YEAR, -1);
            Date earliestDate = calendar.getTime();
            calendar.add(Calendar.YEAR, 1);
            Date latestDate = calendar.getTime();

            SpinnerDateModel model = new SpinnerDateModel(initDate,earliestDate,latestDate,calendar.YEAR);
            dateNaissance = new JSpinner(model);
            JSpinner.DateEditor editor = new JSpinner.DateEditor(dateNaissance, "dd-MM-yyyy");
            dateNaissance.setEditor(editor);
            model.setStart(editor.getFormat().parse("1-01-1900") );
            dateNaissance.setValue(clientModif.getDateNaissance().getTime());



            textTelephone = new JTextField(clientModif.getTelephone(),8);
            textEmail = new JTextField(clientModif.getEmail(),15);

            etablissements = new Control().getEnsembleEtablissement();
            //clientList = new Control().getEnsembleClient();

            etablissmentJcombo = new JComboBox();

            for (int i = 0 ; i < etablissements.size(); i++) {
                etablissmentJcombo.addItem(etablissements.get(i).getNom());
                if(etablissements.get(i).getMatricule().equals(clientModif.getMatriculeEtablissement())){
                    indexEtablissement = i;
                }
            }
            etablissmentJcombo.setSelectedIndex(indexEtablissement);


            spinnerCeinture = new JSpinner(new SpinnerNumberModel(70, 70, 95, 5.0));

            spinnerLunette = new JSpinner(new SpinnerNumberModel(10, 10, 14, 0.1));
            comboVetement = new JComboBox(taille);
            comboVetement.setSelectedItem("M");

            checkBoxCarte = new JCheckBox("Carte de fidélité ? ");
            checkBoxInfoSup = new JCheckBox("Infomration supplémentaire");
            checkBoxInfoSup.addActionListener(new CheckBoxInfoListener());


            if(clientModif.getTailleLunette()< 10){

                spinnerLunette.setEnabled(false);
                spinnerCeinture.setEnabled(false);
                comboVetement.setEnabled(false);
                checkBoxInfoSup.setSelected(false);

            }else{
                checkBoxInfoSup.setSelected(true);
                spinnerLunette.setValue(clientModif.getTailleLunette());
                spinnerCeinture.setValue(clientModif.getTailleCeinture());
                for(int i = 0;i<taille.length;i++){
                    if (clientModif.getTailleVetement().equals(taille[i])){
                        indexTailleVetement = i;
                    }
                }
                comboVetement.setSelectedIndex(indexTailleVetement);
            }

            checkBoxCarte.setSelected(clientModif.getCarteFidelite());

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

            boutonQuitter.addActionListener(new ActionQuitter());
            boutonEnregistrer.addActionListener(new Modifier());

            c.gridx = 2;

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
            JOptionPane.showMessageDialog(null, "Erreur lors de la modification d'un client", "Erreur de modification", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void boutonInfoSupAction()
    {
        if(checkBoxInfoSup.isSelected())
        {
            JOptionPane.showMessageDialog(null, "hello", "Erreur matricule",
                    JOptionPane.ERROR_MESSAGE);
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

    private class Modifier implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

            try {


                if (checkBoxInfoSup.isSelected()) {
                    nouveauClient = new Client(getTextIdentifiant(), getMatriculeEtablissement(), getTextNom(), getTextPrenom(), getTextCodePostal(), getTextVille(), getTextRue(), getTextNumero(), getDateNaissance(), getTextTelephone(), getTextEmail(), getCarteFidelite(), getSpinnerLunette(), getSpinnerCeinture(), getComboVetement());

                }else
                {
                    nouveauClient = new Client(getTextIdentifiant(), getMatriculeEtablissement(), getTextNom(), getTextPrenom(), getTextCodePostal(), getTextVille(), getTextRue(), getTextNumero(), getDateNaissance(), getTextTelephone(), getTextEmail(), getCarteFidelite(),tailleDefaut,tailleDefaut,tailleVetementDefaut);

                }
                if (e.getSource() == boutonEnregistrer) {
                    if (JOptionPane.showConfirmDialog(null, "Voulez vous enregistrer ce nouveau client ?", "inscription client", JOptionPane.YES_NO_OPTION) == 0) {

                        new Control().modifierClient(nouveauClient);

                        JOptionPane.showMessageDialog(null, "Le client a bien été enregistré", "Inscription réussite", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                new FenetreListeClient();
                dispose();



            }catch (PrenomException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur prenom",
                        JOptionPane.ERROR_MESSAGE);
            } catch (NomException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur nom",
                        JOptionPane.ERROR_MESSAGE);
            } catch (ConnexionException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur Connexion",
                        JOptionPane.ERROR_MESSAGE);
            } catch (DateNaissanceException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Probleme date naissance",
                        JOptionPane.ERROR_MESSAGE);
            } catch (VilleException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Probleme de ville",
                        JOptionPane.ERROR_MESSAGE);
            } catch (CodePostalException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur de code postal",
                        JOptionPane.ERROR_MESSAGE);
            } catch (RueException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur de rue",
                        JOptionPane.ERROR_MESSAGE);
            } catch (NumeroException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur de numero",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (IdentifiantException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur d'identifiant",
                        JOptionPane.ERROR_MESSAGE);
            }catch (EmailException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur de mail",
                        JOptionPane.ERROR_MESSAGE);
            }catch (ParseException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur de Date",
                        JOptionPane.ERROR_MESSAGE);
            }catch (TelephoneException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur de telephone",
                        JOptionPane.ERROR_MESSAGE);
            }



    }
    }



    private class CheckBoxInfoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent itemEvent) {
            if(checkBoxInfoSup.isSelected())
            {
                spinnerLunette.setEnabled(true);
                spinnerCeinture.setEnabled(true);
                comboVetement.setEnabled(true);
            }
            else {
                spinnerLunette.setEnabled(false);
                spinnerCeinture.setEnabled(false);
                comboVetement.setEnabled(false);
            }
        }

    }



}

