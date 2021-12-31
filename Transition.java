public class Transition {
    private Etat src;
    private Etat dest;
    private String trans;

    public Transition(Etat src, Etat dest, String trans) {
        this.src = src;
        this.dest = dest;
        this.trans = trans;
    }

    public Etat getSrc() {
        return src;
    }

    public Etat getDest() {
        return dest;
    }

    public String getTrans() {
        return trans;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(!(obj instanceof Transition)){
            return false;
        }

        return (this.src.equals(((Transition) obj).src)) && (this.dest.equals(((Transition) obj).dest)) && this.trans == ((Transition) obj).trans;
    }
}
