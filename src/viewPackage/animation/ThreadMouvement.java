package viewPackage.animation;

public class ThreadMouvement extends Thread {

    private Pong pong;
    private boolean etatGauche;
    private boolean etatDroite;


    public ThreadMouvement(Pong pong) {
        super("ThreadMouvement");
        this.pong = pong;
        etatDroite = true;
        etatGauche = false;
    }

    public boolean changement(boolean etat){
        return etat = !etat;
    }


    public void run() {
        while (true) {
            try {

                if(pong.getBalle().collisionDroite()){
                    etatDroite = changement(etatDroite);
                    etatGauche = changement(etatGauche);
                }

                if(pong.getBalle().collisionGauche()){
                    etatGauche = changement(etatGauche);
                    etatDroite = changement(etatDroite);
                }

                if(etatDroite){
                    pong.getGardienDroite().bouge();
                }
                if (etatGauche){
                    pong.getGardienGauche().bouge();
                }

                pong.getBalle().bouge();
                pong.repaint();
                Thread.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (java.util.ConcurrentModificationException e){
                e.printStackTrace();
            }
        }


    }
}
