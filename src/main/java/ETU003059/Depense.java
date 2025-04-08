package main.java.ETU003059;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Depense {
    public int id;
    public int  libelle;
    public int montant;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getLibelle() {
        return libelle;
    }
    public void setLibelle(int libelle) {
        this.libelle = libelle;
    }
    public int getMontant() {
        return montant;
    }
    public void setMontant(int montant) {
        this.montant = montant;
    }
    public Depense(int libelle, int montant) {
        this.libelle = libelle;
        this.montant = montant;
    }
    public static ArrayList<Prevision> getAllPrev() throws SQLException {
        ArrayList<Prevision> previsions = new ArrayList<>();
        String sql = "SELECT id,libelle FROM prevision";

        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                previsions.add(new Prevision(rs.getInt("id"), rs.getString("libelle")));
            }

        } catch (SQLException e) {
        }

        return previsions;
    }
   
}
