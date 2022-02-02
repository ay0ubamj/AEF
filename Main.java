import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame implements ActionListener{

    public Main(){
        // GUI
        super("Saisie d'un automate à états finis");
        this.setLayout(null);
        this.setSize(500,300);
        this.setResizable(false);

        JLabel title = new JLabel("Saisie d'un automate à états finis");
        JButton addState = new JButton("Ajout d'état");
        JButton addTransition = new JButton("Ajout de transition");
        JButton showAutomate = new JButton("Afficher l'automate");
        JButton testEntree = new JButton("Tester une expression");

        title.setBounds(125,20,350,20);
        title.setFont(new Font("Montserat", Font.PLAIN, 18));

        addState.setBounds(70,85,150,50);
        addState.setBackground(Color.decode("#bdc3c7"));
        addState.setBorder(new LineBorder(Color.BLACK));

        addTransition.setBounds(280,85,150,50);
        addTransition.setBackground(Color.decode("#bdc3c7"));
        addTransition.setBorder(new LineBorder(Color.BLACK));

        showAutomate.setBounds(70,165,150,50);
        showAutomate.setBackground(Color.decode("#bdc3c7"));
        showAutomate.setBorder(new LineBorder(Color.BLACK));

        testEntree.setBounds(280,165,150,50);
        testEntree.setBackground(Color.decode("#bdc3c7"));
        testEntree.setBorder(new LineBorder(Color.BLACK));

        this.add(title);
        this.add(addState);
        this.add(addTransition);
        this.add(showAutomate);
        this.add(testEntree);

        // ActionListener
        addState.addActionListener(this);
        addState.setActionCommand("etat");
        addTransition.addActionListener(this);
        addTransition.setActionCommand("transition");
        showAutomate.addActionListener(this);
        showAutomate.setActionCommand("showAutomate");
        testEntree.addActionListener(this);
        testEntree.setActionCommand("test");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Initialisation de l'automate
        new Automate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("etat")){
            addState state = new addState();
        }

        if(e.getActionCommand().equals("transition")){
            addTransition transition = new addTransition();
        }

        if(e.getActionCommand().equals("showAutomate")){
            new showAutomate();
        }

        if(e.getActionCommand().equals("test")){
            new testEntree();
            Automate.setGraph();
        }
    }

    public static void main(String[] args){
        new Main();
    }
}
