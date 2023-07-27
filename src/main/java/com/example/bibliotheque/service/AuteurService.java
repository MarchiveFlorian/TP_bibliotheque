package com.example.bibliotheque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotheque.dao.AuteurRepository;
import com.example.bibliotheque.entity.Auteur;


@Service
public class AuteurService {

    @Autowired
    AuteurRepository auteurRepository;

    public void addAuteur(Auteur newauteur) {
        auteurRepository.save(newauteur);
    }

    public List<Auteur> getAllAuteurs() {
        return auteurRepository.findAll();
    }

    public void deleteAuteur(int id) {
        auteurRepository.deleteById(id);
    }

    public Optional<Auteur> getOneAuteur(Integer id) {
        return auteurRepository.findById(id);
    }

    public void editAuteur(Integer id, Auteur auteur) {
        auteurRepository.save(auteur);
    }
}