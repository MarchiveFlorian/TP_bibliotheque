package com.example.bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bibliotheque.entity.Livre;

public interface LivreRepository extends JpaRepository<Livre, Integer> {

    public List<Livre> findAllByTitle(String title);

}
