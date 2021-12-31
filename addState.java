import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addState extends JFrame implements ActionListener {

    JLabel title = new JLabel("Ajouter un état");
    JLabel etatLabel = new JLabel("Etat :");
    JTextField etatValue = new JTextField();
    JLabel etatTypeLabel = new JLabel("Choisir le type de l'état :");
    ButtonGroup btnGroup = new ButtonGroup();
    JRadioButton etatInitial = new JRadioButton("Etat initial");
    JRadioButton etatInter = new JRadioButton("Etat intérmédiaire");
    JRadioButton etatFinal = new JRadioButton("Etat final");
    JButton ajouter = new JButton("Ajouter l'état");

    public addState(){
        super("Ajout d'états");
        this.setLayout(null);
        this.setSize(500,300);
        this.setResizable(false);

        title.setBounds(200,20,200,20);
        title.setFont(new Font("Montserat", Font.PLAIN, 18));

        etatLabel.setBounds(50,80,100,20);
        etatValue.setBounds(150,80,250,20);
        etatTypeLabel.setBounds(50,120,150,20);
        etatInitial.setBounds(70,150,100,20);
        etatInter.setBounds(170,150,150,20);
        etatFinal.setBounds(320,150,100,20);

        ajouter.setBounds(175,190,150,40);
        ajouter.setBackground(Color.decode("#bdc3c7"));
        ajouter.setBorder(new LineBorder(Color.BLACK));

        this.add(title);
        this.add(etatLabel);
        this.add(etatValue);
        this.add(etatTypeLabel);
        btnGroup.add(etatInitial);
        this.add(etatInitial);
        etatInitial.setActionCommand("einit");
        btnGroup.add(etatInter);
        this.add(etatInter);
        btnGroup.add(etatInter);
        etatInter.setActionCommand("einter");
        btnGroup.add(etatFinal);
        this.add(etatFinal);
        etatFinal.setActionCommand("ef");
        this.add(ajouter);

        // ActionListener
        ajouter.addActionListener(this);
        ajouter.setActionCommand("ajouterEtat");

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ajouterEtat")){
            Automate.addEtat(new Etat(etatValue.getText(), btnGroup.getSelection().getActionCommand()));
        }
    }
}
