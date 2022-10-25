package viewPackage;

import controllerPackage.Control;
import exceptionPackage.*;
import modelPackage.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FenetreChoixModif extends JFrame {

    private Container container;

    private Control controller;
    private static String clientASupprimer;


    private JPanel formulaire;
    private JPanel bouton;

    private JButton boutonQuitter;
    private JButton boutonModifier;

    private JTextField textBouton;

    private GridBagConstraints c;

    private JComboBox clientJCombo;


    private ArrayList<Client> listeClient;
    private java.util.List<JLabel> labelList = new ArrayList<>();
    private List<JComponent> componentList = new ArrayList<>();

    public FenetreChoixModif()
    {
        super("Modification  Client");

        try {

            setBounds(500, 370, 300, 120);
            setResizable(false);
            container = this.getContentPane();
            container.setLayout(new BorderLayout());


            formulaire = new JPanel(new GridBagLayout());
            bouton = new JPanel(new GridLayout(1, 3));


            container.add(formulaire, BorderLayout.NORTH);
            container.add(bouton, BorderLayout.SOUTH);

            boutonQuitter = new JButton("Quitter");
            boutonModifier = new JButton("Modifier");

            bouton.add(boutonQuitter);
            bouton.add(boutonModifier);

            c = new GridBagConstraints();
            c.anchor = GridBagConstraints.LINE_END;
            c.insets = new Insets(5, 0, 0, 0);

            labelList.add(new JLabel("Liste Client  : "));


            listeClient = new Control().getEnsembleClient();

            clientJCombo = new JComboBox();

            int tailleListeClient = listeClient.size();

            for (int i = 0; i < tailleListeClient; i++) {
                clientJCombo.addItem(listeClient.get(i).getNom() + " " + listeClient.get(i).getPrenom() + " ( " + listeClient.get(i).getIdentifiant() + " )");
            }
            componentList.add(clientJCombo);

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

            boutonQuitter.addActionListener(new Quitter());
            boutonModifier.addActionListener(new Modifier());

            setVisible(true);

        }catch (PrenomException e) {
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
        catch (IdentifiantException em) {
            JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur d'identifiant",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (TelephoneException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de numero de telephone",
                    JOptionPane.ERROR_MESSAGE);
        }catch (EmailException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de mail",
                    JOptionPane.ERROR_MESSAGE);
        }


    }
    private void nextY() {
        c.gridy++;
    }

    private void resetXY() {
        c.gridx = 0;
        c.gridy = 0;
    }

    private class Quitter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();

        }
    }

    private class Modifier implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Client clientAModif = getClientChoisi();

                new FenetreInfoAModif(clientAModif);
                dispose();
            }
            catch (MatriculeEtablissementException me)
            {
                JOptionPane.showMessageDialog(null, me.getMessage(), "Erreur matricule",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Client getClientChoisi() throws MatriculeEtablissementException {
        int indiceIdentifiantClient = clientJCombo.getSelectedIndex();
        //
        if (indiceIdentifiantClient < 0) {
            throw new MatriculeEtablissementException();
        }
        return listeClient.get(indiceIdentifiantClient);
    }

    public String getMatriculeEtablissement() throws MatriculeEtablissementException {
        int indiceIdentifiantClient = clientJCombo.getSelectedIndex();
        //
        if (indiceIdentifiantClient < 0) {
            throw new MatriculeEtablissementException();
        }
        return listeClient.get(indiceIdentifiantClient).getIdentifiant();
    }

}
