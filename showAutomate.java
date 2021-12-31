import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class showAutomate extends JFrame {

    JLabel automate;
    JLabel etatInit;
    JLabel etatsFin;
    static int y = 80;

    public showAutomate(){
        super("Affichage de l'automate");
        this.setLayout(null);
        this.setSize(500,300);

        etatInit = new JLabel("Etat initial :         " +Automate.getEtatInit().getContenu());
        etatInit.setBounds(50,20,100,20);
        this.add(etatInit);

        etatsFin = new JLabel("Etats finaux :" + Automate.getEtatsFinal());
        etatsFin.setBounds(50,40,200,20);
        this.add(etatsFin);

        JLabel automateTitle = new JLabel("L'automate : ");
        automateTitle.setBounds(50,70,100,20);
        automateTitle.setFont(new Font("Montserat", Font.BOLD, 16));
        this.add(automateTitle);

        for(Transition t: Automate.getTransitions()){
            y+=15;
            automate = new JLabel("(" + t.getSrc().getContenu() + ") ---------(" + t.getTrans() + ")------> (" + t.getDest().getContenu() + ")");
            automate.setBounds(70,y,170,20);
            automate.setFont(new Font("Montserat", Font.BOLD, 14));
            this.add(automate);
        }

        this.setVisible(true);
    }
}
