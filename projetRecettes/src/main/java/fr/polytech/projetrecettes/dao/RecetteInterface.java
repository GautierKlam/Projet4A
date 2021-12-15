package fr.polytech.projetrecettes.dao;

import fr.polytech.projetrecettes.entities.Ingredient;
import fr.polytech.projetrecettes.entities.Recette;
import fr.polytech.projetrecettes.entities.RecetteType;
import org.hibernate.type.EnumType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Enumerated;
import java.util.List;

@RepositoryRestResource
public interface RecetteInterface extends JpaRepository<Recette, Integer> {
    public List<Recette> findByNomContaining(String nom);
    public List<Recette> findByRecetteType(RecetteType recetteType);
    public List<Recette> findByIngredientsContaining(Ingredient[] ingredients); //marche po
}
