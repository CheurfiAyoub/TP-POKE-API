package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.dto.CreateFight;
import fr.efrei.pokemon.dto.UpdateFight;
import fr.efrei.pokemon.models.Fight;
import fr.efrei.pokemon.services.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fights")
public class FightController {

    private final FightService fightService;

    @Autowired
    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    // Récupérer tous les combats
    @GetMapping
    public ResponseEntity<List<Fight>> findAll() {
        return new ResponseEntity<>(fightService.findAll(), HttpStatus.OK);
    }

    // Récupérer un combat par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Fight> findById(@PathVariable String id) {
        Fight fight = fightService.findById(id);
        if (fight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fight, HttpStatus.OK);
    }

    // Créer un nouveau combat
    @PostMapping
    public ResponseEntity<?> save(@RequestBody CreateFight fight) {
        fightService.save(fight);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Mettre à jour un combat existant
    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UpdateFight fightBody) {
        Fight fight = fightService.findById(id);
        if (fight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        fightService.update(id, fightBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Supprimer un combat
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Fight fight = fightService.findById(id);
        if (fight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        fightService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
