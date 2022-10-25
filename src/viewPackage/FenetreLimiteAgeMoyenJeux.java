package viewPackage;

import controllerPackage.Control;
import exceptionPackage.ConnexionException;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class FenetreLimiteAgeMoyenJeux extends JFrame {

    private Container container;

    private JPanel bouton;
    private JPanel donneRecherche;

    private JLabel limiteAgeMoyen ;

    private JLabel affichagePrix;

    private DecimalFormat decFor;

    private Double resLimiteAgeMoyen;

    public FenetreLimiteAgeMoyenJeux() throws  ConnexionException{
        super("Limite d'âge moyen des jeux dans le catalogue Game Stop© ");

        setBounds(900, 200, 500, 200);


        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);

        decFor = new DecimalFormat();
        decFor.setMaximumFractionDigits(3);
        decFor.setMinimumFractionDigits(1);
        resLimiteAgeMoyen = new Control().limiteAgeMoyenJeux();

        bouton = new JPanel(new GridLayout(1, 2));
        donneRecherche = new JPanel(new GridLayout(2, 1));

        container.add(donneRecherche, BorderLayout.CENTER);
        container.add(bouton, BorderLayout.SOUTH);

        limiteAgeMoyen = new JLabel("La limite d'âge moyen des jeux du catalogue GameStop : ");
        limiteAgeMoyen.setHorizontalAlignment(SwingConstants.CENTER);
        donneRecherche.add(limiteAgeMoyen);

        affichagePrix = new JLabel("<html><FONT COLOR=\"#ff0000\"> " +  decFor.format(resLimiteAgeMoyen)+"</FONT> ans </html>");
        affichagePrix.setHorizontalAlignment(SwingConstants.CENTER);
        donneRecherche.add(affichagePrix);
    }

}


