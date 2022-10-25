package viewPackage;

import modelPackage.ModelRechercheJeuAchete;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FentreJeuClient  extends JFrame {

    private TableauListeJeuClient tabMod;
    private JTable tableau;

    public FentreJeuClient(ArrayList<ModelRechercheJeuAchete> jeu){

        super("Liste des jeux d'un client a partir d'une date");
        setBounds(100,100,1000,500);

        tabMod = new TableauListeJeuClient(jeu);
        tableau = new JTable(tabMod);

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
        setVisible(true);

    }

}
