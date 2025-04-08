package main.java.ETU003059;


public class Prevision {
    private int id;
    private String libelle;
    public Prevision(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    private int montant;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public int getMontant() {
        return montant;
    }
    public void setMontant(int montant) {
        this.montant = montant;
    }
    public Prevision() {
    }
    
    public Prevision(String libelle, int montant) {
        this.libelle = libelle;
        this.montant = montant;
    }
 

   
  
}