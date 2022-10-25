package viewPackage.animation;

import java.awt.*;

public class Gardien {

    private Rectangle rectangle;

    private Pong pong;

    private Paroi pTop;
    private Paroi pBot;

    private static int DELTA_Y = 1;

    public Gardien(Pong pong, int coordX, int coordY, int largeur, int hauteur){
        this.pong = pong;
        this.rectangle = new Rectangle(coordX,coordY,largeur,hauteur);
        pTop = pong.getParoisHorizontale().get(0);
        pBot = pong.getParoisHorizontale().get(1);
    }


    public void dessine(Graphics g){
        g.fillRect(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }

    public boolean collision(Balle balle){
        return rectangle.intersects(balle.getRectangle());
    }

    public int getGardienCenter(){
        return (rectangle.height/2)+rectangle.y;
    }

    public void bouge(){

        int balleY = pong.getBalle().getBalleY();

        if(getGardienCenter()>balleY){
            if(( rectangle.y+DELTA_Y)>pTop.getY()){
                rectangle.y -= DELTA_Y;
            }
        }

        if(getGardienCenter()<balleY){

            if(( rectangle.y+DELTA_Y+rectangle.height)<pBot.getY()){
                rectangle.y += DELTA_Y;
            }
        }
    }
}
