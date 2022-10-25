package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InfoContact extends JFrame {

    private Container container;

    private JPanel bouton;
    private JPanel information;

    private JButton boutonQuitter;

    private  JLabel label;

    public InfoContact()
    {
        super("Notre histoire");
        setResizable(false);
        setBounds(850,130,400,600);
        container = this.getContentPane();
        container.setLayout(new BorderLayout());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

            }
        });


        bouton = new JPanel(new GridLayout(1,3));
        information = new JPanel(new GridLayout(1,3));

        container.add(bouton, BorderLayout.SOUTH);
        container.add(information, BorderLayout.CENTER);

        boutonQuitter = new JButton("Quitter");

        bouton.add(boutonQuitter);


        label = new JLabel(
                "<html>" +
                        "<h1>Qui sommes nous ?</h1>" +
                        "<p>\"<FONT COLOR=\"#ff0000\">  Gamestop</FONT> est un concept occasion très novateur, profondément ancré dans les nouveaux modes de consommation collaboratifs : autour de l’échange, du partage et du réemploi des objets manufacturés.\n" +
                        "Avec nos produits reconditionnés à neuf, notre expertise sur le prix de l’occasion et nos solutions e-commerce (marketplace permettant aux franchisés d'acheter et de revendre auprès de leurs clients), le groupe <FONT COLOR=\"#ff0000\">  Gamestop</FONT> vous invite à imaginer autrement l’avenir des produits Gaming de seconde main.\n" +
                        "Unique groupe Français couvrant plus de 50 ans de l'Histoire du jeu vidéo,<FONT COLOR=\"#ff0000\">  Gamestop</FONT> est le seul concept réunissant dans ses magasins des produits modernes et des produits rétro-gaming, en passant par des bornes d'arcade ou des produits dérivés de la Culture Geek. Plus économique, plus écologique : partageons l'expérience écogaming <FONT COLOR=\"#ff0000\">  Gamestop</FONT> !\"</p>" +
                        "</html>");

        information.add(label);

        boutonQuitter.addActionListener(new ActionRetour());

        setVisible(true);

    }

    private class ActionRetour implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            dispose();

        }
    }




}
