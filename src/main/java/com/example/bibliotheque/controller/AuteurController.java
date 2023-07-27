package com.example.bibliotheque.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotheque.entity.Auteur;
import com.example.bibliotheque.service.AuteurService;

@RestController
@RequestMapping("api")
public class AuteurController {

    // Injection
    @Autowired
    AuteurService auteurService;

    // Méthode GET ALL
    @GetMapping("auteurs")
    public List<Auteur> getAllAuteurs() {
        return auteurService.getAllAuteurs();
    }

    // Méthode GET ONE
    @GetMapping("auteurs/{id}")
    public ResponseEntity<Auteur> getOneAuteur(@PathVariable("id") Integer id) {
        Optional<Auteur> optional = auteurService.getOneAuteur(id);

        if (optional.isPresent()) {
            Auteur auteur = optional.get();
            return ResponseEntity.ok(auteur);
        } else {// if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }

    // Méthode POST
    @PostMapping("auteurs")
    public void postAuteur(@RequestBody Auteur newAuteur) {
        System.out.println(newAuteur);
        auteurService.addAuteur(newAuteur);
    }

    // Méthode DELETE
    @DeleteMapping("auteurs/{id}")
    public void deleteAuteur(@PathVariable("id") Integer id) {
        auteurService.deleteAuteur(id);
    }

    // Méthode PUT (modify/edit)
    @PutMapping("auteurs/{id}")
    public ResponseEntity<Auteur> putAuteur(@PathVariable("id") Integer id, @RequestBody Auteur auteur) {

        if (!id.equals(auteur.getId())) {
            return ResponseEntity.badRequest().build();
        }

        if (auteurService.getOneAuteur(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        auteurService.editAuteur(id, auteur);
        return ResponseEntity.ok().build();
    }
}