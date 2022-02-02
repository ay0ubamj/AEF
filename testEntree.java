import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import static javax.swing.JOptionPane.showMessageDialog;

public class testEntree extends JFrame implements ActionListener {

    JLabel exprLabel = new JLabel("Entrer l'expression içi :");
    JTextField exprValue = new JTextField();
    JButton tester = new JButton("Tester l'expression");

    public testEntree(){
        super("Tester l'expression");
        this.setLayout(null);
        this.setSize(500,200);

        exprLabel.setBounds(50,30,150,20);
        exprValue.setBounds(200,30,250,20);

        tester.setBounds(175,80,150,40);
        tester.setBackground(Color.decode("#bdc3c7"));
        tester.setBorder(new LineBorder(Color.BLACK));

        this.add(exprLabel);
        this.add(exprValue);
        this.add(tester);

        // ActionListener
        tester.addActionListener(this);
        tester.setActionCommand("tester");


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("tester")){
            if(Automate.testEntree(exprValue.getText())){
                showMessageDialog(null, "L'expression est accepté par l'automate !");
            }else{
                showMessageDialog(null, "L'expression n'est pas accepté par l'automate !");
            }

        }
    }
}
