package viewPackage;

import exceptionPackage.*;
import modelPackage.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class FenetreListeClient extends JFrame {

    private TableauListeClient tabMod = new TableauListeClient();

    private JTable tableau;

    private Client client;

    public FenetreListeClient()throws NomException, PrenomException, ConnexionException, ParseException, CodePostalException, RueException,DateNaissanceException
            ,VilleException,NumeroException,IdentifiantException,TelephoneException,EmailException
    {
        super("Liste des clients de GameStop");

        setBounds(5,10,900,800);
        tableau = new JTable(tabMod);
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);


        JPanel boutons = new JPanel();

        boutons.add(new JButton(new Ajouter()));
        boutons.add(new JButton(new Quitter()));
        boutons.add(new JButton(new ModifierCellule()));

        getContentPane().add(boutons, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    private class Ajouter extends AbstractAction {
        private Ajouter() {
            super("Ajouter");

        }


        public void actionPerformed(ActionEvent e) {
             new FenetreInscription();
            dispose();
        }
    }

    private class Quitter extends AbstractAction {
        private Quitter() {
            super("Quitter");

        }


        public void actionPerformed(ActionEvent e) {
            dispose();
        }

    }
    private class ModifierCellule extends AbstractAction {
        private ModifierCellule() {
            super("Modifier");
        }

        public void actionPerformed(ActionEvent e) {

            new FenetreChoixModif();
            dispose();
        }
    }







}

