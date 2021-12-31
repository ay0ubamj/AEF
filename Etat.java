public class Etat {
    private String contenu;
    private String type;

    public Etat(String contenu, String type) {
        this.type = type;
        this.contenu = contenu;
    }

    public String getType() {
        return this.type;
    }

    public String getContenu() {
        return this.contenu;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(!(obj instanceof Etat)){
            return false;
        }
        Etat o = (Etat) obj;

        return this.contenu == o.contenu;
    }
}
