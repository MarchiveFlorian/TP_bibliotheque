package com.example.bibliotheque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Categorie {

    // Attribut
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String genre;

    // Constructeurs
    public Categorie() {
    }

    public Categorie(int id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    // Getters setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // To string
    @Override
    public String toString() {
        return "Categorie [id=" + id + ", genre=" + genre + "]";
    }

}
