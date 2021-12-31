import javax.swing.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Automate {
    private static ArrayList<Etat> etats;
    private static ArrayList<Transition> transitions;

    public Automate() {
        etats = new ArrayList<Etat>();
        transitions = new ArrayList<Transition>();
    }

    public static void addEtat(Etat etat) {
        int r=0;
        int ei = 0;

        for(Etat e: etats){
            if(e.getContenu().equals(etat.getContenu())){
                r+=1;
                showMessageDialog(null, "Cet état existe déja !");
                break;
            }
            if((e.getType() == "einit" && etat.getType() == "einit")){
                r+=1;
                showMessageDialog(null, "Un état initial existe déja !");
            }
        }
        if(r == 0){
            etats.add(etat);
            showMessageDialog(null, "L'état a été ajouter avec succès !");
        }
    }

    public static ArrayList<Etat> getEtats() {
        return etats;
    }

    public static Etat getEtatFromEtats(String s){
        Etat r = null;
        for(Etat e: etats){
            if(e.getContenu().equals(s)){
                r = e;
            }
        }
        return r;
    }

    public static Etat getEtatInit(){
        Etat eInit = null;
        for(Etat e: etats){
            if(e.getType().equals("einit")){
                eInit = e;
                break;
            }
        }
        return eInit;
    }

    public static String getEtatsFinal(){
        String s = "       [";

        for(Etat e: etats){
            if(e.getType().equals("ef")){
                s+= e.getContenu() +", ";
            }
        }

        return s + "]";
    }

    public static ArrayList<String> getEtatsContenu() {
        ArrayList<String> eC = new ArrayList<String>();
        for(Etat e: etats){
            eC.add(e.getContenu());
        }
        return eC;
    }

    public static void addTransition(Transition transition){
        int r = 0;
        for(Transition t: transitions){
            if(transition.equals(t)){
                r+=1;
                showMessageDialog(null, "Cette transition existe déja !");
            }
        }
        if(r == 0){
            transitions.add(transition);
            showMessageDialog(null, "La transition a été ajouter avec succès !");
        }
    }

    public static ArrayList<Transition> getTransitions() {
        return transitions;
    }


}
