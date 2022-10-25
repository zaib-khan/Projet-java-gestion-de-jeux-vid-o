package viewPackage;

import exceptionPackage.*;
import viewPackage.animation.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;


public class FenetrePrincipal extends JFrame {

    private Container conteneurPrincipal;

    private JMenuBar barreMenu;

    private JMenu menuFichier;
    private JMenu menuClient;
    private JMenu menuRecherche;
    private JMenu menuContact;
    private JMenu menuInformation;

    private JMenuItem menuClientInscription;
    private JMenuItem listeClient;
    private JMenuItem exit;
    private JMenuItem infoContact;
    private JMenuItem adresseContact;
    private JMenuItem rechercheDateFacture;
    private JMenuItem supressionClient;
    private JMenuItem rechercheGoodieDate;
    private JMenuItem modificationClient;
    private JMenuItem rechercheDate2Factures;
    private JMenuItem infoPrixMoyenJeuxAVendre;
    private JMenuItem infoLimiteAgeMoyen;

    private Pong pong;

    private ImageIcon icon;
    private JLabel image;


    public FenetrePrincipal() {
        super("Game Stop©");

        pong = new Pong();
        setBounds(850, 130, 700, 720);
        conteneurPrincipal = this.getContentPane();
        conteneurPrincipal.setLayout(new BorderLayout());
        conteneurPrincipal.add(pong, BorderLayout.CENTER);
        setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        icon = new ImageIcon("src\\viewPackage\\animation\\logo-game-stop.png");
        image = new JLabel(icon);
        conteneurPrincipal.add(image,BorderLayout.NORTH);
        barreMenu = new JMenuBar();
        setJMenuBar(barreMenu);

        menuFichier = new JMenu("Fichier");
        barreMenu.add(menuFichier);
        menuFichier.setMnemonic('F');
        exit = new JMenuItem("Quitter");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        menuFichier.add(exit);


        menuClient = new JMenu("Client");
        barreMenu.add(menuClient);
        menuClient.setMnemonic('C');
        menuClientInscription = new JMenuItem("Inscription client");
        menuClientInscription.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        menuClient.add(menuClientInscription);
        listeClient = new JMenuItem("Liste client");
        listeClient.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
        menuClient.add(listeClient);
        supressionClient = new JMenuItem("Suppression Client");
        supressionClient.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
        menuClient.add(supressionClient);
        modificationClient = new JMenuItem("Modification Client");
        modificationClient.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
        menuClient.add(modificationClient);

        menuRecherche = new JMenu("Recherche");
        barreMenu.add(menuRecherche);
        menuRecherche.setMnemonic('R');
        rechercheDateFacture = new JMenuItem("Jeux d'un client après une date ");
        rechercheDateFacture.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        menuRecherche.add(rechercheDateFacture);
        rechercheDate2Factures = new JMenuItem("Facture d'un client entre 2 dates ");
        rechercheDate2Factures.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        menuRecherche.add(rechercheDate2Factures);
        rechercheGoodieDate = new JMenuItem("Goodies d'un client après un date ");
        rechercheGoodieDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
        menuRecherche.add(rechercheGoodieDate);

        menuInformation = new JMenu("Information");
        barreMenu.add(menuInformation);
        menuInformation.setMnemonic('I');
        infoPrixMoyenJeuxAVendre = new JMenuItem("Prix de base moyen des jeux chez Game Stop©");
        infoPrixMoyenJeuxAVendre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        menuInformation.add(infoPrixMoyenJeuxAVendre);
        infoLimiteAgeMoyen = new JMenuItem("Limite d'âge moyen des jeux vendus chez Game Stop©");
        infoLimiteAgeMoyen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        menuInformation.add(infoLimiteAgeMoyen);


        menuContact = new JMenu("Contact");
        barreMenu.add(menuContact);
        menuContact.setMnemonic('C');
        infoContact = new JMenuItem("Infos");
        infoContact.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
        menuContact.add(infoContact);
        adresseContact = new JMenuItem("Coordonnées");
        adresseContact.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        menuContact.add(adresseContact);

        menuClientInscription.addActionListener(new InscriptionListenner());


        exit.addActionListener(new Quitter());
        infoContact.addActionListener(new InformationContact());
        adresseContact.addActionListener(new CoordonnéesDuContact());
        rechercheDateFacture.addActionListener(new rechercheJeuDate());
        rechercheGoodieDate.addActionListener(new RechercheGoodieDate());
        listeClient.addActionListener(new ListeClientListenner());
        supressionClient.addActionListener(new SuppressionClient());
        modificationClient.addActionListener(new ModifClient());

        rechercheDate2Factures.addActionListener(new rechercheFac2Dates());
        infoPrixMoyenJeuxAVendre.addActionListener(new PrixMoyenJeux());
        infoLimiteAgeMoyen.addActionListener(new LimiteAgeMoyenJeux());

        setVisible(true);

    }

    private class LimiteAgeMoyenJeux implements ActionListener
    {
        @Override
        public  void actionPerformed(ActionEvent actionEvent) {
            try {
                new FenetreLimiteAgeMoyenJeux();
            }
            catch (ConnexionException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur Connexion",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private class PrixMoyenJeux implements ActionListener
    {
        @Override
        public  void actionPerformed(ActionEvent actionEvent) {
            try {
                new FenetrePrixMoyenJeux();
            }
            catch (ConnexionException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur Connexion",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private class ModifClient implements ActionListener
    {
        @Override
        public  void actionPerformed(ActionEvent actionEvent) {
            new FenetreChoixModif();
        }
    }


    private class SuppressionClient implements ActionListener
    {
        @Override
        public  void actionPerformed(ActionEvent actionEvent) {
                new FenetreSuppression();
        }
    }


    private class ListeClientListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            try {
                new FenetreListeClient();

            } catch (PrenomException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur prenom",
                        JOptionPane.ERROR_MESSAGE);
            } catch (NomException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur nom",
                        JOptionPane.ERROR_MESSAGE);

            }  catch (ConnexionException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur Connexion",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (ParseException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de date",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (DateNaissanceException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Probleme date naissance",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (VilleException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Probleme de ville",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (CodePostalException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de code postal",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (RueException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de rue",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (NumeroException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de numero",
                        JOptionPane.ERROR_MESSAGE);
            }catch (IdentifiantException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur d'identifiant",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (TelephoneException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de numero de telephone",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (EmailException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de date",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    
    private class RechercheGoodieDate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                new FenetreRechercheGoodie();
            }
            catch (PrenomException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur prenom",
                        JOptionPane.ERROR_MESSAGE);
            } catch (NomException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur nom",
                        JOptionPane.ERROR_MESSAGE);

            }  catch (ConnexionException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur Connexion",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (ParseException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de date",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (DateNaissanceException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Probleme date naissance",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (VilleException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Probleme de ville",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (CodePostalException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de code postal",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (RueException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de rue",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (NumeroException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de numero",
                        JOptionPane.ERROR_MESSAGE);
            }catch (IdentifiantException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur d'identifiant",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (TelephoneException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de numero de telephone",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (EmailException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de date",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class InscriptionListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new FenetreInscription();
        }
    }


    private class Quitter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            System.exit(0);
        }
    }

    private class InformationContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new InfoContact();
        }
    }

    private class CoordonnéesDuContact implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new CoordonnéesContact();
        }
    }
private class rechercheJeuDate implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        try {
            new FenetreRechercheJeuDate();

        } catch (PrenomException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur prenom",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NomException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur nom",
                    JOptionPane.ERROR_MESSAGE);

        }  catch (ConnexionException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur Connexion",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de date",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (DateNaissanceException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Probleme date naissance",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (VilleException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Probleme de ville",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (CodePostalException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de code postal",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (RueException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de rue",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (NumeroException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de numero",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (IdentifiantException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur d'identifiant",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (TelephoneException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de numero telephone",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch (EmailException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de mail",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
    private class rechercheFac2Dates implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

           try {
                  new FenetreRechercheFacDate();
            } catch (PrenomException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur prenom",
                        JOptionPane.ERROR_MESSAGE);
            } catch (NomException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur nom",
                        JOptionPane.ERROR_MESSAGE);

            }  catch (ConnexionException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur Connexion",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (ParseException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de date",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (DateNaissanceException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Probleme date naissance",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (VilleException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Probleme de ville",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (CodePostalException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de code postal",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (RueException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de rue",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (NumeroException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de numero",
                        JOptionPane.ERROR_MESSAGE);
            }catch (IdentifiantException em) {
                JOptionPane.showMessageDialog(null, em.getMessage(), "Erreur d'identifiant",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (TelephoneException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de numero de telephone",
                        JOptionPane.ERROR_MESSAGE);
            }
           catch (EmailException e){
               JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de mail",
                       JOptionPane.ERROR_MESSAGE);

           }
        }
    }
}

