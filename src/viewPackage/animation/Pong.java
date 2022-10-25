package viewPackage.animation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pong extends JPanel {

    private ArrayList<Paroi> arrayVerticale = new ArrayList<>();
    private ArrayList<Paroi> arrayHorizontale = new ArrayList<>();

    private  List<Paroi> paroisVerticale = Collections.synchronizedList(arrayVerticale);
    private  List<Paroi> paroisHorizontale = Collections.synchronizedList(arrayHorizontale);

    private Balle balle;
    private Gardien gardienGauche;
    private Gardien gardienDroite;


    public static int totalPoints ;

    public Pong()
    {
        paroisVerticale.add(new Paroi(100,0,2,272,0));
        paroisVerticale.add(new Paroi(600,0,2,274,0));

        paroisHorizontale.add(new Paroi(100,0,500,2,1));//top
        paroisHorizontale.add(new Paroi(100,272,500,2,1));//bot

        balle = new Balle(this,300,250,15,15);

        gardienGauche = new Gardien(this,110,50,10,60);
        gardienDroite = new Gardien(this,582,80,10,60);

        new ThreadMouvement(this).start();

    }



    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        for(Paroi p : paroisHorizontale)
        {
            p.dessine(g);
        }

        for(Paroi p : paroisVerticale)
        {
            p.dessine(g);
        }

        gardienGauche.dessine(g);
        gardienDroite.dessine(g);

        balle.dessine(g);
    }


    public Balle getBalle() {
        return balle;
    }

    public List<Paroi> getParoisVerticale() {
        return paroisVerticale;
    }

    public List<Paroi> getParoisHorizontale() {
        return paroisHorizontale;
    }

    public Gardien getGardienGauche() {
        return gardienGauche;
    }

    public Gardien getGardienDroite() {
        return gardienDroite;
    }

}
