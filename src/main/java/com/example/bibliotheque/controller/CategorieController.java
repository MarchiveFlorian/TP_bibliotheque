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

import com.example.bibliotheque.entity.Categorie;
import com.example.bibliotheque.service.CategorieService;

@RestController
@RequestMapping("api")
public class CategorieController {

    // Injection
    @Autowired
    CategorieService categorieService;

    // Méthode GET ALL
    @GetMapping("categories")
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    // Méthode GET ONE
    @GetMapping("categories/{id}")
    public ResponseEntity<Categorie> getOneCategorie(@PathVariable("id") Integer id) {
        Optional<Categorie> optional = categorieService.getOneCategorie(id);

        if (optional.isPresent()) {
            Categorie categorie = optional.get();
            return ResponseEntity.ok(categorie);
        } else {// if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        }
    }

    // Méthode POST
    @PostMapping("categories")
    public void postCategorie(@RequestBody Categorie newCategorie) {
        System.out.println(newCategorie);
        categorieService.addCategorie(newCategorie);
    }

    // Méthode DELETE
    @DeleteMapping("categories/{id}")
    public void deleteCategorie(@PathVariable("id") Integer id) {
        categorieService.deleteCategorie(id);
    }

    // Méthode PUT (modify/edit)
    @PutMapping("categories/{id}")
    public ResponseEntity<Categorie> putCategorie(@PathVariable("id") Integer id, @RequestBody Categorie categorie) {

        if (!id.equals(categorie.getId())) {
            return ResponseEntity.badRequest().build();
        }

        if (categorieService.getOneCategorie(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        categorieService.editCategorie(id, categorie);
        return ResponseEntity.ok().build();
    }
}
