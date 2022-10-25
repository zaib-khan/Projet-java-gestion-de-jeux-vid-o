package viewPackage;

import modelPackage.ModelRechercheFacture;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FenetreFactureDate extends JFrame {

    private TableauListeFactureDate tabMod;
    private JTable tableau;

    public FenetreFactureDate(ArrayList<ModelRechercheFacture> facture) {

        super("Liste des jeux d'un client a partir d'une date");
        setBounds(100,100,1000,500);

        tabMod = new TableauListeFactureDate(facture);
        tableau = new JTable(tabMod);

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
        setVisible(true);




    }
}