package fr.polytech.projetrecettes.web;

import fr.polytech.projetrecettes.dao.RecetteInterface;
import fr.polytech.projetrecettes.entities.Avis;
import fr.polytech.projetrecettes.entities.Ingredient;
import fr.polytech.projetrecettes.entities.Recette;
import fr.polytech.projetrecettes.entities.RecetteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecetteControlleur {
    @Autowired
    private RecetteInterface recetteInterface;

    //renvoie la liste des recettes
    @GetMapping(value = "/recettes")
    public ArrayList<Recette> recetteList(){
        return (ArrayList<Recette>) recetteInterface.findAll();
    }

    //renvoie la liste des ingrédients
    @GetMapping(value = "/{recette}/ingredients")
    public List<Ingredient> ingredientsList(@PathVariable Recette recette){
        return recette.getIngredients();
    }

    //renvoie la liste des avis
    @GetMapping(value = "/{recette}/avis")
    public List<Avis> avisList(@PathVariable Recette recette){
        return recette.getAvis();
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
    @PostMapping(path = "/recettes")
    public Recette save(Recette recette){
        return recetteInterface.save(recette);
    }

    //ajouter un ingrédient à une recette
    @PostMapping(path = "/{recette}/ingredients")
    public Recette save(@PathVariable Recette recette, Ingredient ingredient){
        recette.getIngredients().add(ingredient);
        return recetteInterface.save(recette);
    }

    //ajouter un avis
    @PostMapping(path = "/{recette}/avis")
    public Recette save(@PathVariable Recette recette, Avis avis){
        recette.getAvis().add(avis);
        return recetteInterface.save(recette);
    }

    //chercher une recette à l'aide de son identifiant
    @GetMapping("/recettes/{identifiant}")
    public Recette getRecette(@PathVariable("identifiant")int id){
        return recetteInterface.findById(id).get();
    }

    //chercher une recette à l'aide de son nom
    @GetMapping("/recettes/{nom}")
    public ArrayList<Recette> getRecette(@PathVariable String nom){
        ArrayList<Recette> resultat = new ArrayList<>();
        for(Recette recette : recetteList()){
            if(recette.getNom().equals(nom)) resultat.add(recette);
        }
        return resultat;
    }

    //chercher une recette qui contiennent les ingrédients demandés
    @GetMapping("/recettes/{ingredients}")
    public ArrayList<Recette> getRecette(@PathVariable String[] ingredients){
        ArrayList<Recette> resultat = new ArrayList<>();
        for(String ingredient : ingredients){
            for(Recette recette : recetteList()){
                if(recette.getIngredients().contains(ingredient) && !resultat.contains(recette)) resultat.add(recette);
            }
        }
        return resultat;
    }

    //chercher une recette correspond au type demandé (entree, plat...)
    @GetMapping("/recettes/{type}")
    public ArrayList<Recette> getRecette(@PathVariable RecetteType type){
        ArrayList<Recette> resultat = new ArrayList<>();
        for(Recette recette : recetteList()) {
            if (recette.getRecetteType() == type) resultat.add(recette);
        }
        return resultat;
    }

    //Mettre à jour l'identifiant d'une recette
    @PutMapping("/{recette}/identifiant")
    public Recette saveIntro(@PathVariable Recette recette,@PathVariable int identifiant){
        recette.setId_recette(identifiant);
        return recetteInterface.save(recette);
    }

    //Mettre à jour le nombre de personnes
    @PutMapping("/{recette}/nb_personnes")
    public Recette saveNb(@PathVariable Recette recette,@PathVariable int nb_personnes){
        recette.setNb_personnes(nb_personnes);
        return recetteInterface.save(recette);
    }

    //Mettre à jour le nom
    @PutMapping("/{recette}/nom")
    public Recette saveNom(@PathVariable Recette recette,@PathVariable String nom){
        recette.setNom(nom);
        return recetteInterface.save(recette);
    }

    //Mettre à jour l'introduction
    @PutMapping("/{recette}/introduction")
    public Recette saveIntro(@PathVariable Recette recette,@PathVariable String introduction){
        recette.setIntroduction(introduction);
        return recetteInterface.save(recette);
    }

    //Mettre à jour la description
    @PutMapping("/{recette}/description")
    public Recette saveDescription(@PathVariable Recette recette,@PathVariable String description){
        recette.setDescription(description);
        return recetteInterface.save(recette);
    }

    //Mettre à jour l'identifiant d'un ingredient
    @PutMapping("/{recette}/{ingredient}/identifiant")
    public Recette saveId(@PathVariable Recette recette, @PathVariable Ingredient ingredient, @PathVariable int identifiant){
        recette.getIngredients().get(ingredient.getId_ingredient()-1).setId_ingredient(identifiant);
        return recetteInterface.save(recette);
    }

    //Modifier le nom d'un ingrédient
    @PutMapping("/{recette}/{ingredient}/nom")
    public Recette saveNomIngredient(@PathVariable Recette recette, @PathVariable Ingredient ingredient,@PathVariable String nom){
        recette.getIngredients().get(ingredient.getId_ingredient()-1).setNom(nom);
        return recetteInterface.save(recette);
    }

    //Modifier la quantité d'un ingrédient
    @PutMapping("/{recette}/{ingredient}/quantite")
    public Recette saveQuantiteIngredient(@PathVariable Recette recette, @PathVariable Ingredient ingredient,@PathVariable String quantite){
        recette.getIngredients().get(ingredient.getId_ingredient()-1).setQuantite(quantite);
        return recetteInterface.save(recette);
    }

    //Mettre à jour le type
    @PutMapping("/{recette}/type")
    public Recette saveType(@PathVariable Recette recette,@PathVariable RecetteType type){
        recette.setRecetteType(type);
        return recetteInterface.save(recette);
    }

    //Mettre à jour l'identifiant d'un avis
    @PutMapping("/{recette}/{avis}/identifiant")
    public Recette saveId(@PathVariable Recette recette, @PathVariable Avis avis, @PathVariable int identifiant){
        recette.getAvis().get(avis.getId_avis()-1).setId_avis(identifiant);
        return recetteInterface.save(recette);
    }

    //Modifier la note d'un avis
    @PutMapping("/{recette}/{avis}/note")
    public Recette saveNote(@PathVariable Recette recette, @PathVariable Avis avis,@PathVariable double note){
        recette.getAvis().get(avis.getId_avis()-1).setNote(note);
        return recetteInterface.save(recette);
    }

    //Modifier le commentaire d'un avis
    @PutMapping("/{recette}/{avis}/commentaire")
    public Recette saveCommentaire(@PathVariable Recette recette, @PathVariable Avis avis,@PathVariable String commentaire){
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