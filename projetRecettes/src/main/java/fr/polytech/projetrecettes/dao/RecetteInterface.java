package fr.polytech.projetrecettes.dao;

import fr.polytech.projetrecettes.entities.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteInterface extends JpaRepository<Recette, Integer> {
}
