package fr.efrei.pokemon.services;

import fr.efrei.pokemon.dto.CreateFight;
import fr.efrei.pokemon.dto.UpdateFight;
import fr.efrei.pokemon.models.Fight;
import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.repositories.FightRepository;
import fr.efrei.pokemon.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FightService {

    private final FightRepository fightRepository;
    private final TrainerRepository trainerRepository;

    @Autowired
    public FightService(FightRepository fightRepository, TrainerRepository trainerRepository) {
        this.fightRepository = fightRepository;
        this.trainerRepository = trainerRepository;
    }

    public List<Fight> findAll() {
        return fightRepository.findAll();
    }

    public Fight findById(String id) {
        return fightRepository.findById(id).orElse(null);
    }

    public void save(Fight fight) {
        // Vérification si les dresseurs existent
//        Trainer trainer1 = trainerRepository.findById(fight.getTrainer1().getId()).orElse(null);
//        Trainer trainer2 = trainerRepository.findById(fight.getTrainer2().getId()).orElse(null);
//
//        if (trainer1 != null && trainer2 != null) {
//            fight.setTrainer1(trainer1);
//            fight.setTrainer2(trainer2);
            fightRepository.save(fight);
//        } else {
//            // Gérer le cas où les dresseurs n'existent pas
//            throw new RuntimeException("un ou plusieurs Dresseur n'existent pas.");
//        }
    }

    public void delete(String id) {
        fightRepository.deleteById(id);
    }

    public void update(String id, Fight fightBody) {
        Fight existingFight = findById(id);
        if (existingFight != null) {
            // Mettez à jour les dresseurs et les résultats si nécessaire
            existingFight.setTrainer1(fightBody.getTrainer1());
            existingFight.setTrainer2(fightBody.getTrainer2());
            existingFight.setResult(fightBody.getResult());
            fightRepository.save(existingFight);
        }
    }

    public void save(CreateFight fight) {
    }

    public void update(String id, UpdateFight fightBody) {
    }
}
