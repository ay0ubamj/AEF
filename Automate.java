import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Automate {
    private static ArrayList<Etat> etats;
    private static ArrayList<Transition> transitions;
    private static String etatInitial;
    private static ArrayList<String> etatsFinaux;
    static HashMap<String, HashMap<String, String>> Graph;

    public Automate() {
        etats = new ArrayList<Etat>();
        transitions = new ArrayList<Transition>();
        etatsFinaux = new ArrayList<String>();
    }

    public static void setGraph(){
        // Construction du graphe
        Graph = new HashMap<String, HashMap<String, String>>();
        for(Etat e: etats){
            Graph.put(e.getContenu(), new HashMap<String, String>());
        }

        // Ajouter les bords adjacents à chaque noeud
        for(Transition t: getTransitions()){
            for(String i : Graph.keySet()) {
                if(t.getSrc().getContenu() == i){
                    Graph.get(i).put(t.getTrans(), t.getDest().getContenu());
                }
            }
        }
    }

    public static boolean testEntree(String entree){
        boolean ok = false;

        HashMap<String, String> iterator = Graph.get(etatInitial);
        String node = null;
        for(int i=0; i<entree.length(); i++){
            node = iterator.get(String.valueOf(entree.charAt(i)));
            iterator = Graph.get(node);
            if(iterator.isEmpty()){
                break;
            }
        }

        if(etatsFinaux.contains(node)){
            ok = true;
        }

        return ok;
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
            if(etat.getType() == "einit"){
                etatInitial = etat.getContenu();
            } else if(etat.getType() == "ef"){
                etatsFinaux.add(etat.getContenu());
            }
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

    public static String getEtatInit(){
        return etatInitial;
    }

    public static String getEtatsFinal(){
        return String.join(",", etatsFinaux);
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
