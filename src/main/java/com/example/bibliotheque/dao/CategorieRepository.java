package com.example.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bibliotheque.entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
