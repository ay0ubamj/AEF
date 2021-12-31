import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class addTransition extends JFrame implements ActionListener{
    String[] etats = Automate.getEtatsContenu().toArray(new String[0]);

    JLabel title = new JLabel("Ajouter une transition");
    JLabel etatSourceLabel = new JLabel("Etat source :");
    JLabel transitionLabel = new JLabel("Transition :");
    JLabel etatDestinationLabel = new JLabel("Etat de déstination :");
    JTextField transition = new JTextField();
    JComboBox etatSource = new JComboBox(etats);
    JComboBox etatDestination = new JComboBox(etats);
    JButton ajouter = new JButton("Ajouter la transition");

    public addTransition(){
        super("Ajout de transition");
        this.setLayout(null);
        this.setSize(500,350);
        this.setResizable(false);

        title.setBounds(160,20,200,20);
        title.setFont(new Font("Montserat", Font.PLAIN, 18));

        etatSourceLabel.setBounds(50,80,100,20);
        etatSource.setBounds(180,80,250,20);
        transitionLabel.setBounds(50,125,100,20);
        transition.setBounds(180,125,250,20);
        etatDestinationLabel.setBounds(50,170,120,20);
        etatDestination.setBounds(180,170,250,20);

        ajouter.setBounds(175,230,150,40);
        ajouter.setBackground(Color.decode("#bdc3c7"));
        ajouter.setBorder(new LineBorder(Color.BLACK));

        this.add(title);
        this.add(etatSourceLabel);
        this.add(transitionLabel);
        this.add(etatDestinationLabel);
        this.add(etatSource);
        this.add(transition);
        this.add(etatDestination);
        this.add(ajouter);

        // ActionListener
        ajouter.addActionListener(this);
        ajouter.setActionCommand("ajouterTransition");

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ajouterTransition")){
            Automate.addTransition(new Transition(Automate.getEtatFromEtats((String) etatSource.getSelectedItem()), Automate.getEtatFromEtats((String) etatDestination.getSelectedItem()), transition.getText().toLowerCase(Locale.ROOT)));
        }
    }
}
