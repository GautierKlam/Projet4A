package fr.polytech.projetrecettes.web;

import fr.polytech.projetrecettes.dao.UtilisateurInterface;
import fr.polytech.projetrecettes.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UtilisateurControlleur {
    @Autowired //injection des dépendances
    private UtilisateurInterface utilisateurInterface;

    @GetMapping("utilisateur/{identifiant}")
    public Utilisateur getUtilisateur(@PathVariable(value = "identifiant")int identifiant){
        return utilisateurInterface.findById(identifiant).get(identifiant);
    }

    //Mise à jour
    @PutMapping("/utilisateur")
    public Utilisateur save(Utilisateur utilisateur,@PathVariable("identifiant")int identifiant){
        utilisateur.setIdentifiant(identifiant);
        return utilisateurInterface.save(utilisateur);
    }

    //suppression d'un utilisateur
    @DeleteMapping("/utilisateur/{identifiant}")
    public void save(@PathVariable("identifiant")int identifiant){
        utilisateurInterface.deleteById(identifiant);
    }
}
