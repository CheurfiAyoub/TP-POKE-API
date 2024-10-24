package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.Fight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightRepository extends JpaRepository<Fight, String> { }
