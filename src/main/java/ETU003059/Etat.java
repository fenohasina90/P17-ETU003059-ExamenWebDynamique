package main.java.ETU003059;

public class Etat {
    public int id;
    public int prevision;
    public int depense;
    public int reste;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPrevision() {
        return prevision;
    }
    public void setPrevision(int prevision) {
        this.prevision = prevision;
    }
    public int getDepense() {
        return depense;
    }
    public void setDepense(int depense) {
        this.depense = depense;
    }
    public int getReste() {
        return reste;
    }
    public void setReste(int reste) {
        this.reste = reste;
    }
    public Etat(int id, int prevision, int depense, int reste) {
        this.id = id;
        this.prevision = prevision;
        this.depense = depense;
        this.reste = reste;
    }
}
