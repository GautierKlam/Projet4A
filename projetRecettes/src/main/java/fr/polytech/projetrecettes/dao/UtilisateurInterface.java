package fr.polytech.projetrecettes.dao;

import fr.polytech.projetrecettes.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurInterface extends JpaRepository<Utilisateur, Integer> {
    public List<Utilisateur> findById(int identifiant);
}
