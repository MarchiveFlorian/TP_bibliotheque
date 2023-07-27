package com.example.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bibliotheque.entity.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Integer> {

}
