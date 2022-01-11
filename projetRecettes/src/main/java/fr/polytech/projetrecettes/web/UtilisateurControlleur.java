package fr.polytech.projetrecettes.web;

import fr.polytech.projetrecettes.dao.UtilisateurInterface;
import fr.polytech.projetrecettes.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class UtilisateurControlleur {
    @Autowired //injection des dépendances
    private UtilisateurInterface utilisateurInterface;

    //renvoie la liste des utilisateurs
    @GetMapping(value = "/utilisateurs")
    public ArrayList<Utilisateur> utilisateurList(){
        return (ArrayList<Utilisateur>) utilisateurInterface.findAll();
    }

    //ajouter un utilisateur
    @PostMapping("/saveUtilisateur")
    public Utilisateur saveUtilisateur(@ModelAttribute Utilisateur utilisateur){
        return utilisateurInterface.save(utilisateur);
    }
}