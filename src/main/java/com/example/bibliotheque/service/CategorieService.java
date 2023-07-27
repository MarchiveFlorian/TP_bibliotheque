package com.example.bibliotheque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotheque.dao.CategorieRepository;
import com.example.bibliotheque.entity.Categorie;


@Service
public class CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    public void addCategorie(Categorie newcategorie) {
        categorieRepository.save(newcategorie);
    }

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public void deleteCategorie(int id) {
        categorieRepository.deleteById(id);
    }

    public Optional<Categorie> getOneCategorie(Integer id) {
        return categorieRepository.findById(id);
    }

    public void editCategorie(Integer id, Categorie categorie) {
        categorieRepository.save(categorie);
    }
}