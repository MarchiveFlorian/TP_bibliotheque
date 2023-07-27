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

import com.example.bibliotheque.entity.Livre;
import com.example.bibliotheque.service.LivreService;

@RestController
@RequestMapping("api")
public class LivreController {

    // Injection
    @Autowired
    LivreService livreService;

    // Méthode GET ALL
    @GetMapping("livres")
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    // Méthode GET ONE
    @GetMapping("livres/{id}")
    public ResponseEntity<Livre> getOneLivre(@PathVariable("id") Integer id) {
        Optional<Livre> optional = livreService.getOneLivre(id);

        if (optional.isPresent()) {
            Livre livre = optional.get();
            return ResponseEntity.ok(livre);
        } else {// if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }

    // Méthode POST
    @PostMapping("livres")
    public void postLivre(@RequestBody Livre newLivre) {
        System.out.println(newLivre);
        livreService.addLivre(newLivre);
    }

    // Méthode DELETE
    @DeleteMapping("livres/{id}")
    public void deleteLivre(@PathVariable("id") Integer id) {
        livreService.deleteLivre(id);
    }

    // Méthode PUT (modify/edit)
    @PutMapping("livres/{id}")
    public ResponseEntity<Livre> putLivre(@PathVariable("id") Integer id, @RequestBody Livre livre) {

        if (!id.equals(livre.getId())) {
            return ResponseEntity.badRequest().build();
        }

        if (livreService.getOneLivre(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        livreService.editLivre(id, livre);
        return ResponseEntity.ok().build();
    }
}
