package com.stock.model;

import java.io.Serializable;

/**
 * Pourquoi faut-il obligatoirement des getters/setters publics ?
 * Réponse : Pour respecter la spécification Java Bean, permettant aux
 * frameworks
 * (comme JSTL/EL ou Hibernate) d'accéder aux propriétés par
 * introspection/réflexion.
 */
public class Produit implements Serializable {
    private int id;
    private String nom;
    private double prix;

    public Produit() {
    }

    public Produit(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
