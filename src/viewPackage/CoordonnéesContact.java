package viewPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CoordonnéesContact extends JFrame {

    private Container container;

    private JPanel bouton;
    private JPanel information;

    private JButton boutonQuitter;

    private  JLabel label;

    public  CoordonnéesContact()
    {
        super("Pour nous retrouver");
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
                        "<h1><i>Coordonnées : </i> </h1>"
                            +"<p><BLOCKQUOTE>Site Web  : <address>https://www.gamestop.com/</address></BLOCKQUOTE></p>"
                            +"<p><BLOCKQUOTE>Telephone  :<a href=\"tel:+33102030405\"> +33102030405 </a> </BLOCKQUOTE></p>"+
                        "</html>");

        information.add(label);
        boutonQuitter.addActionListener(new CoordonnéesContact.ActionRetour());

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
