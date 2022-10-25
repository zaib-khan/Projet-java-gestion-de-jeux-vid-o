package viewPackage;

import modelPackage.ModelRechercheGoodie;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FenetreGoodieClient extends JFrame {

    private TableauListeGoodieClient tabMod;
    private JTable tableau;

    public FenetreGoodieClient(ArrayList<ModelRechercheGoodie> goodies){

        super("Liste des jeux d'un client a partir d'une date");
        setBounds(100,100,1000,500);

        tabMod = new TableauListeGoodieClient(goodies);
        tableau = new JTable(tabMod);

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
        setVisible(true);

    }
}