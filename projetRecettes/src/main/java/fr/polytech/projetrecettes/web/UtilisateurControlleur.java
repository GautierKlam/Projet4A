package fr.polytech.projetrecettes.web;

import fr.polytech.projetrecettes.dao.UtilisateurInterface;
import fr.polytech.projetrecettes.entities.Avis;
import fr.polytech.projetrecettes.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UtilisateurControlleur {
    @Autowired //injection des dépendances
    private UtilisateurInterface utilisateurInterface;


    //renvoie la liste des utilisateurs
    @GetMapping(value = "utilisateur")
    public ArrayList<Utilisateur> utilisateurList(){
        return (ArrayList<Utilisateur>) utilisateurInterface.findAll();
    }

    //renvoie le nombre d'utilisateurs
    private int taille() {
        int taille = 0;
        for(Utilisateur utilisateur : utilisateurList())taille++;
        return taille;
    }

    //ajouter un utilisateur
    @PostMapping(path = "/utilisateur")
    public Utilisateur save(Utilisateur utilisateur){
        return utilisateurInterface.save(utilisateur);
    }

    //Rechercher un utilisateur par son identifiant
    @GetMapping("utilisateur/{identifiant}")
    public Utilisateur getUtilisateur(@PathVariable(value = "identifiant")int identifiant){
        return utilisateurInterface.findById(identifiant).get();
    }

    //Mise à jour identifiant
    @PutMapping("/{utilisateur}/{id}")
    public Utilisateur saveId(Utilisateur utilisateur,@PathVariable("identifiant")int identifiant){
        utilisateur.setIdentifiant(identifiant);
        return utilisateurInterface.save(utilisateur);
    }

    //Mise à jour nom
    @PutMapping("/{utilisateur}/{nom}")
    public Utilisateur saveNom(Utilisateur utilisateur,@PathVariable("nom")String nom){
        utilisateur.setNom(nom);
        return utilisateurInterface.save(utilisateur);
    }

    //Mise à jour prénom
    @PutMapping("/{utilisateur}/{prenom}")
    public Utilisateur savePrenom(Utilisateur utilisateur,@PathVariable("prenom")String prenom){
        utilisateur.setPrenom(prenom);
        return utilisateurInterface.save(utilisateur);
    }

    //Mise à jour pseudo
    @PutMapping("/{utilisateur}/{pseudo}")
    public Utilisateur savePseudo(Utilisateur utilisateur,@PathVariable("pseudo")String pseudo){
        utilisateur.setPseudo(pseudo);
        return utilisateurInterface.save(utilisateur);
    }

    //Mise à jour mdp
    @PutMapping("/{utilisateur}/{mdp}")
    public Utilisateur saveMdp(Utilisateur utilisateur,@PathVariable("mdp")String mdp){
        utilisateur.setPseudo(mdp);
        return utilisateurInterface.save(utilisateur);
    }

    //Mise à jour mail
    @PutMapping("/{utilisateur}/{mail}")
    public Utilisateur saveMail(Utilisateur utilisateur,@PathVariable("mail")String mail){
        utilisateur.setMail(mail);
        return utilisateurInterface.save(utilisateur);
    }

    //Mise à jour admin
    @PutMapping("/{utilisateur}/{admin}")
    public Utilisateur saveAdmin(Utilisateur utilisateur,@PathVariable("admin")boolean admin){
        utilisateur.setAdmin(admin);
        return utilisateurInterface.save(utilisateur);
    }

    //suppression d'un utilisateur
    @DeleteMapping("/utilisateur/{identifiant}")
    public void save(@PathVariable("identifiant")int identifiant){
        utilisateurInterface.deleteById(identifiant);
    }
}
