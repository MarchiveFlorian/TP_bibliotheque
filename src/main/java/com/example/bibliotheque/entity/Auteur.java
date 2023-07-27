package com.example.bibliotheque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "auteurs")
public class Auteur {

    // Attribut
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String nationalité;

    // Constructeurs
    public Auteur() {
    }

    public Auteur(int id, String nom, String prenom, String nationalité) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nationalité = nationalité;
    }

    // Getters setters
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalité() {
        return nationalité;
    }

    public void setNationalité(String nationalité) {
        this.nationalité = nationalité;
    }

    // To string
    @Override
    public String toString() {
        return "Auteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nationalité=" + nationalité + "]";
    }
}
