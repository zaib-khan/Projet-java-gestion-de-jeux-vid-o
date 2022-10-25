package viewPackage;

import controllerPackage.Control;
import exceptionPackage.ConnexionException;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class FenetrePrixMoyenJeux extends JFrame {

    private Container container;

    private JPanel bouton;
    private JPanel donneRecherche;

    private JLabel prixMoyen ;

    private JLabel affichagePrix;

    private DecimalFormat decFor;

    private Double resPrixMoyen;


    public FenetrePrixMoyenJeux() throws  ConnexionException{
        super("Prix de base moyen des jeux dans le catalogue Game Stop© ");

        setBounds(900, 200, 500, 200);


            container = this.getContentPane();
            container.setLayout(new BorderLayout());
            setResizable(false);
            setVisible(true);

            decFor = new DecimalFormat();
            decFor.setMaximumFractionDigits(3);
            decFor.setMinimumFractionDigits(1);
            resPrixMoyen = new Control().prixBaseMoyen();

            bouton = new JPanel(new GridLayout(1, 2));
            donneRecherche = new JPanel(new GridLayout(2, 1));

            container.add(donneRecherche, BorderLayout.CENTER);
            container.add(bouton, BorderLayout.SOUTH);

            prixMoyen = new JLabel("Prix Moyen des jeux du catalogue GameStop : ");
            prixMoyen.setHorizontalAlignment(SwingConstants.CENTER);
            donneRecherche.add(prixMoyen);

            affichagePrix = new JLabel("<html><FONT COLOR=\"#ff0000\"> " +  decFor.format(resPrixMoyen)+"</FONT> euros </html>");
            affichagePrix.setHorizontalAlignment(SwingConstants.CENTER);
            donneRecherche.add(affichagePrix);
        }

    }


