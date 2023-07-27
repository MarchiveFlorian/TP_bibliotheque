package com.example.bibliotheque.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livres")
public class Livre {

    // Attribut
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToOne
    private Auteur auteur;

    @ManyToMany
    private List<Categorie> Collections = new ArrayList<>();

    // Constructeurs
    public Livre() {
    }

    public Livre(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public List<Categorie> getCollections() {
        return Collections;
    }

    public void setCollections(List<Categorie> collections) {
        Collections = collections;
    }

    // To string
    @Override
    public String toString() {
        return "Livre [id=" + id + ", title=" + title + "]";
    }

    // Add collections
    public void addCollection(Categorie newCollections) {
        Collections.add(newCollections);
    }
}
