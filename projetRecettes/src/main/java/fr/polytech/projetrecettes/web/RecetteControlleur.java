package fr.polytech.projetrecettes.web;

import fr.polytech.projetrecettes.dao.RecetteInterface;
import fr.polytech.projetrecettes.dao.UtilisateurInterface;
import fr.polytech.projetrecettes.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class RecetteControlleur {
    @Autowired
    private RecetteInterface recetteInterface;
    private UtilisateurInterface utilisateurInterface;

    public RecetteControlleur(UtilisateurInterface utilisateurInterface) {
        this.utilisateurInterface = utilisateurInterface;
    }

    //renvoie la liste des recettes
    @GetMapping(value = "/recettes")
    public ArrayList<Recette> recetteList(){
        return (ArrayList<Recette>) recetteInterface.findAll();
    }

    //ajouter une recette
    @PostMapping("/saveRecette")
    public Recette saveRecette(Recette recette){
        return recetteInterface.save(recette);
    }

    //ajouter un ingrédient à une recette
    @PostMapping("/saveIngredient")
    public Recette saveIngredient(int id_recette, Ingredient ingredient){
        Recette recette = recetteInterface.getById(id_recette);
        ingredient.setRecette(recette);
        recette.getIngredients().add(ingredient);
        return recetteInterface.save(recette);
    }

    //ajouter un avis
    @PostMapping(path = "/saveAvis")
    public Recette saveAvis(int id_recette, Avis avis, int id_utilisateur){
        Recette recette = recetteInterface.getById(id_recette);
        Utilisateur utilisateur = utilisateurInterface.getById(id_utilisateur);
        avis.setUtilisateur(utilisateur);
        avis.setRecette(recette);
        recette.getAvis().add(avis);
        return recetteInterface.save(recette);
    }

    //Modifier un avis
    @PostMapping("/modifAvis")
    public Recette modifAvis(int id_recette, String commentaire, int note, int id_avis){
        Recette recette = recetteInterface.getById(id_recette);
        Avis avis = recette.getAvis().get(id_avis);
        Avis avis2 = avis;
        recette.getAvis().remove(id_avis);
        avis2.setCommentaire(commentaire);
        avis2.setNote(note);
        recette.getAvis().add(avis);
        return recetteInterface.save(recette);
    }

    //suppression d'un avis
    @PostMapping("/deleteAvis")
    public void deleteAvis(int id_recette, int id_avis){
        Recette recette = recetteInterface.getById(id_recette);
        recette.getAvis().remove(id_avis);
    }

    //suppression d'une recette
    @PostMapping("/deleteRecette")
    public void deleteRecette(int id){
        recetteInterface.deleteById(id);
    }
}