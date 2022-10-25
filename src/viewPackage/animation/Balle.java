package viewPackage.animation;

import java.awt.*;

public class Balle {

    private Rectangle rectangle;

    private Pong pong;

    private int deltaX, deltaY;


    public Balle(Pong pong, int coordX, int coordY, int largeur, int hauteur )
    {
        this.pong = pong;
        this.rectangle = new Rectangle(coordX,coordY,largeur,hauteur);

        deltaY = 1;
        deltaX = 1;
    }

    public int getBalleY(){
        return rectangle.y;
    }


    public void bouge()
    {
        rectangle.x += this.deltaX;
        rectangle.y += this.deltaY;

        for(Paroi p :  pong.getParoisVerticale())
        {
            if(p.collision(this))
            {
                deltaX = -deltaX;
            }
        }

        for(Paroi p : pong.getParoisHorizontale())
        {
            if(p.collision(this)) {
                deltaY = -deltaY;
            }
        }

        if(collisionGauche()){
            deltaX = -deltaX;
            //deltaY = -deltaY;
        }
        if(collisionDroite()){
            deltaX = -deltaX;
        }


    }


    public boolean collisionGauche(){
        return pong.getGardienGauche().collision(this);
    }
    public boolean collisionDroite(){
        return pong.getGardienDroite().collision(this);
    }



    public Rectangle getRectangle() {
        return rectangle;
    }

    public void dessine(Graphics g)
    {
        g.fillOval(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }


    public boolean collision(Balle balle){
        return rectangle.intersects(balle.getRectangle());
    }

}
