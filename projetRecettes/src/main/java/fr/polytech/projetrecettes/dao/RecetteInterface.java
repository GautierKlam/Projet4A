package fr.polytech.projetrecettes.dao;

import fr.polytech.projetrecettes.entities.Recette;
import fr.polytech.projetrecettes.entities.RecetteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface RecetteInterface extends JpaRepository<Recette, Integer> {
    public List<Recette> findByNomContaining(String nom);
}