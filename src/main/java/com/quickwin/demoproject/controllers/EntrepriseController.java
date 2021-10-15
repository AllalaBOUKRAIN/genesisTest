package com.quickwin.demoproject.controllers;

import com.quickwin.demoproject.entities.Contact;
import com.quickwin.demoproject.entities.Entreprise;
import com.quickwin.demoproject.repositories.IContactRepo;
import com.quickwin.demoproject.repositories.IEntrepriseRepo;
import com.quickwin.demoproject.services.IContactService;
import com.quickwin.demoproject.services.IEntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EntrepriseController {

    @Autowired
    private IEntrepriseService entrepriseService;

    @GetMapping("/entreprises")
    public ResponseEntity<List<Entreprise>> getAllEntreprises() {
        return ResponseEntity.ok().body(entrepriseService.getAllEntreprise());
    }

    @GetMapping("/entreprises/{id}")
    public ResponseEntity<Entreprise> getEntreprise(@PathVariable Long id) {
        return ResponseEntity.ok().body(entrepriseService.getEntrepriseById(id));
    }

    @PostMapping("/entreprises")
    public ResponseEntity<Entreprise> saveEntreprise(@RequestBody Entreprise entreprise) {
        return ResponseEntity.ok().body(this.entrepriseService.createEntreprise(entreprise));
    }

    @PutMapping("/entreprises")
    public ResponseEntity<Entreprise> updateEntreprise(@PathVariable long id, @RequestBody Entreprise entreprise) {
        entreprise.setId(id);
        return ResponseEntity.ok().body(this.entrepriseService.updateEntreprise(entreprise));
    }

    @DeleteMapping("/entreprises/{id}")
    public HttpStatus deleteEntreprise(@PathVariable Long id) {
        this.entrepriseService.deleteEntreprise(id);
        return HttpStatus.OK;
    }

}
