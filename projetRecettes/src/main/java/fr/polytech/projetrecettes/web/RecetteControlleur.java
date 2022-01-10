package fr.polytech.projetrecettes.web;

import fr.polytech.projetrecettes.dao.RecetteInterface;
import fr.polytech.projetrecettes.dao.UtilisateurInterface;
import fr.polytech.projetrecettes.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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

    //renvoie la liste des ingrédients
    @GetMapping(value = "/recettes/{identifiant}/ingredients")
    public List<Ingredient> ingredientsList(@PathVariable int identifiant){
        return recetteInterface.getById(identifiant).getIngredients();
    }

    //renvoie la liste des avis
    @GetMapping(value = "/recettes/{identifiant}/avis")
    public List<Avis> avisList(@PathVariable int identifiant){
        return recetteInterface.getById(identifiant).getAvis();
    }

    //renvoie le nombre de recettes
    private int taille() {
        return recetteList().size();
    }

    //renvoie le nombre d'avis d'une recette
    private int tailleAvis(Recette recette){
        return recette.getAvis().size();
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

    //chercher une recette à l'aide de son identifiant
    @GetMapping("/recettes/{identifiant}")
    public Recette getRecette(@PathVariable("identifiant")int id){
        return recetteInterface.findById(id).get();
    }

    //Mettre à jour l'identifiant d'une recette
    @PutMapping("/recettes/{id}/identifiant")
    public Recette saveIntro(@PathVariable int id, int identifiant){
        Recette recette = recetteInterface.getById(id);
        recette.setId_recette(identifiant);
        return recetteInterface.save(recette);
    }

    //Mettre à jour le nombre de personnes
    @PutMapping("/{recette}/nb_personnes")
    public Recette saveNb(@PathVariable Recette recette, int nb_personnes){
        recette.setNb_personnes(nb_personnes);
        return recetteInterface.save(recette);
    }

    //Mettre à jour le nom
    @PutMapping("/{recette}/nom")
    public Recette saveNom(@PathVariable Recette recette, String nom){
        recette.setNom(nom);
        return recetteInterface.save(recette);
    }

    //Mettre à jour l'introduction
    @PutMapping("/{recette}/introduction")
    public Recette saveIntro(@PathVariable Recette recette, String introduction){
        recette.setIntroduction(introduction);
        return recetteInterface.save(recette);
    }

    //Mettre à jour la description
    @PutMapping("/{recette}/description")
    public Recette saveDescription(@PathVariable Recette recette, String description){
        recette.setDescription(description);
        return recetteInterface.save(recette);
    }

    //Mettre à jour l'identifiant d'un ingredient
    @PutMapping("/{recette}/{ingredient}/identifiant")
    public Recette saveId(@PathVariable Recette recette, @PathVariable Ingredient ingredient, int identifiant){
        recette.getIngredients().get(ingredient.getId_ingredient()-1).setId_ingredient(identifiant);
        return recetteInterface.save(recette);
    }

    //Modifier le nom d'un ingrédient
    @PutMapping("/{recette}/{ingredient}/nom")
    public Recette saveNomIngredient(@PathVariable Recette recette, @PathVariable Ingredient ingredient, String nom){
        recette.getIngredients().get(ingredient.getId_ingredient()-1).setNom(nom);
        return recetteInterface.save(recette);
    }

    //Modifier la quantité d'un ingrédient
    @PutMapping("/{recette}/{ingredient}/quantite")
    public Recette saveQuantiteIngredient(@PathVariable Recette recette, @PathVariable Ingredient ingredient, String quantite){
        recette.getIngredients().get(ingredient.getId_ingredient()-1).setQuantite(quantite);
        return recetteInterface.save(recette);
    }

    //Mettre à jour le type
    @PutMapping("/{recette}/type")
    public Recette saveType(@PathVariable Recette recette, RecetteType type){
        recette.setRecetteType(type);
        return recetteInterface.save(recette);
    }

    //Mettre à jour l'identifiant d'un avis
    @PutMapping("/{recette}/{avis}/identifiant")
    public Recette saveId(@PathVariable Recette recette, @PathVariable Avis avis,  int identifiant){
        recette.getAvis().get(avis.getId_avis()-1).setId_avis(identifiant);
        return recetteInterface.save(recette);
    }

    //Modifier la note d'un avis
    @PutMapping("/{recette}/{avis}/note")
    public Recette saveNote(@PathVariable Recette recette, @PathVariable Avis avis, double note){
        recette.getAvis().get(avis.getId_avis()-1).setNote(note);
        return recetteInterface.save(recette);
    }

    //Modifier le commentaire d'un avis
    @PutMapping("/{recette}/{avis}/commentaire")
    public Recette saveCommentaire(@PathVariable Recette recette, @PathVariable Avis avis, String commentaire){
        recette.getAvis().get(avis.getId_avis()-1).setCommentaire(commentaire);
        return recetteInterface.save(recette);
    }

    //suppression d'un avis
    @DeleteMapping("/{recette}/avis/{identifiant}")
    public Recette deleteAvis(@PathVariable Recette recette, @PathVariable("identifiant") int id){
        recette.getAvis().remove(id);
        return recetteInterface.save(recette);
    }

    //suppression d'un ingredient
    @DeleteMapping("/{recette}/ingredients/{identifiant}")
    public Recette deleteIngredient(@PathVariable Recette recette, @PathVariable("identifiant") int id){
        recette.getIngredients().remove(id);
        return recetteInterface.save(recette);
    }

    //suppression d'une recette
    @DeleteMapping("/recettes/{identifiant}")
    public void delete(@PathVariable("identifiant")int id){
        recetteInterface.deleteById(id);
    }
}