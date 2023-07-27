package com.example.bibliotheque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotheque.dao.LivreRepository;
import com.example.bibliotheque.entity.Livre;


@Service
public class LivreService {

    @Autowired
    LivreRepository livreRepository;

    public void addLivre(Livre newlivre) {
        livreRepository.save(newlivre);
    }

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public void deleteLivre(int id) {
        livreRepository.deleteById(id);
    }

    public Optional<Livre> getOneLivre(Integer id) {
        return livreRepository.findById(id);
    }

    public void editLivre(Integer id, Livre livre) {
        livreRepository.save(livre);
    }
}