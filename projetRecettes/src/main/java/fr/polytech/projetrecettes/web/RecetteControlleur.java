package fr.polytech.projetrecettes.web;

import fr.polytech.projetrecettes.dao.RecetteInterface;
import fr.polytech.projetrecettes.entities.Recette;
import fr.polytech.projetrecettes.entities.RecetteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RecetteControlleur {
    @Autowired
    private RecetteInterface recetteInterface;

    //renvoie la liste des recettes
    @GetMapping(value = "recettes")
    public ArrayList<Recette> recetteList(){
        return (ArrayList<Recette>) recetteInterface.findAll();
    }

    //renvoie le nombre de recettes
    private int taille() {
        int taille = 0;
        for(Recette recette : recetteList())taille++;
        return taille;
    }

    //ajouter une recette
    @PostMapping(path = "/recettes")
    public Recette save(Recette recette){
        return recetteInterface.save(recette);
    }

    //chercher une recette à l'aide de son identifiant
    @GetMapping("recettes/{identifiant}")
    public Recette getRecette(@PathVariable(value = "id_recette")int id){
        return recetteInterface.findById(id).get();
    }

    //chercher une recette à l'aide de son nom
    @GetMapping("recettes/{nom}")
    public ArrayList<Recette> getRecette(@PathVariable(value = "nom")String nom){
        ArrayList<Recette> resultat = new ArrayList<>();
        for(Recette recette : recetteList()){
            if(recette.getNom().equals(nom)) resultat.add(recette);
        }
        return resultat;
    }

    //chercher une recette qui contiennent les ingrédients demandés
    @GetMapping("recettes/{ingredients}")
    public ArrayList<Recette> getRecette(@PathVariable(value = "ingredients")String[] ingredients){
        ArrayList<Recette> resultat = new ArrayList<>();
        for(String ingredient : ingredients){
            for(Recette recette : recetteList()){
                if(recette.getIngredients().contains(ingredient) && !resultat.contains(recette)) resultat.add(recette);
            }
        }
        return resultat;
    }

    //chercher une recette correspond au type demandé (entree, plat...)
    @GetMapping("recettes/{recetteType}")
    public ArrayList<Recette> getRecette(@PathVariable(value = "recetteType")RecetteType type){
        ArrayList<Recette> resultat = new ArrayList<>();
        for(Recette recette : recetteList()) {
            if (recette.getRecetteType() == type) resultat.add(recette);
        }
        return resultat;
    }

    //Mettre à jour l'identifiant
    @PutMapping("/recettes")
    public Recette saveId(Recette recette,@PathVariable("identifiant")int id){
        recette.setId_recette(id);
        return recetteInterface.save(recette);
    }

    //Mettre à jour le nombre de personnes
    @PutMapping("/recettes")
    public Recette saveNb(Recette recette,@PathVariable("nb_personnes")int nb_personnes){
        recette.setNb_personnes(nb_personnes);
        return recetteInterface.save(recette);
    }

    //Mettre à jour le nom
    @PutMapping("/recettes")
    public Recette saveNom(Recette recette,@PathVariable("nom")String nom){
        recette.setNom(nom);
        return recetteInterface.save(recette);
    }

    //Mettre à jour l'introduction
    @PutMapping("/recettes")
    public Recette saveIntro(Recette recette,@PathVariable("introduction")String introduction){
        recette.setIntroduction(introduction);
        return recetteInterface.save(recette);
    }

    //Mettre à jour la description
    @PutMapping("/recettes")
    public Recette saveDescription(Recette recette,@PathVariable("description")String description){
        recette.setDescription(description);
        return recetteInterface.save(recette);
    }

    //Mettre à jour un ingrédient
    @PutMapping("/recettes")
    public Recette saveIngredient(Recette recette,@PathVariable("description")String ingredient){
        for(int i = 0;i<taille();i++){
            if(recette.getIngredients().get(i).equals(ingredient))recette.getQuantite().set(i,ingredient);
        }
        return recetteInterface.save(recette);
    }

    //Mettre à jour la quantité d'un ingrédient
    @PutMapping("/recettes")
    public Recette saveQuantite(Recette recette, String ingredient, @PathVariable("quantite")String quantite){
        for(int i = 0; i<taille();i++){
            if(recette.getIngredients().get(i).equals(ingredient))recette.getQuantite().set(i,quantite);
        }
        return recetteInterface.save(recette);
    }

    //Mettre à jour le type
    @PutMapping("/recettes")
    public Recette saveType(Recette recette,@PathVariable("introduction")RecetteType type){
        recette.setRecetteType(type);
        return recetteInterface.save(recette);
    }

    //Suppression d'un ingredient
    @PutMapping("/recettes")
    public Recette deleteIngredient(Recette recette,@PathVariable("description")String ingredient){
        for(int i = 0; i<taille();i++){
            if(recette.getIngredients().get(i).equals(ingredient)){
                recette.getIngredients().remove(i);
                recette.getQuantite().remove(i);
            }
        }
        return recetteInterface.save(recette);
    }

    //suppression d'une recette
    @DeleteMapping("/recettes/{id_recette}")
    public void save(@PathVariable("id_recette")int id){
        recetteInterface.deleteById(id);
    }
}