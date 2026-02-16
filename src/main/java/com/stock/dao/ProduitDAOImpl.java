package com.stock.dao;

import com.stock.model.Produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOImpl implements IProduitDAO {

    private String url = "jdbc:sqlserver://localhost:1433;databaseName=stockdb;encrypt=false;trustServerCertificate=true";
    private String user = "sabri";
    private String password = "sabri123";

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(url, user, password);
                    PreparedStatement ps = conn.prepareStatement("SELECT * FROM produit");
                    ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Produit p = new Produit();
                    p.setId(rs.getInt("id"));
                    p.setNom(rs.getString("nom"));
                    p.setPrix(rs.getDouble("prix"));
                    produits.add(p);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e); // On "lance" l'exception pour qu'elle soit vue
        }
        return produits;
    }

    @Override
    public void add(Produit p) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String sql = "INSERT INTO produit(nom, prix) VALUES (?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, p.getNom());
                    ps.setDouble(2, p.getPrix());
                    ps.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String sql = "DELETE FROM produit WHERE id=?";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
