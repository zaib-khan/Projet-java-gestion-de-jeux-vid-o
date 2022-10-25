package viewPackage.animation;


import java.awt.*;

public class Paroi {

    private int points;
    Rectangle rectangle;


    public Paroi(int coordX, int coordY, int largeur, int hauteur, int points)
    {
        rectangle = new Rectangle(coordX,coordY,largeur,hauteur);
        this.points = points;
    }

    public void dessine(Graphics g)
    {
        g.fillRect(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }

    public int getPoints() {
        return points;
    }

    public boolean collision(Balle balle)
    {
        return rectangle.intersects(balle.getRectangle());
    }

    public int getY(){
        return rectangle.y;
    }



}
