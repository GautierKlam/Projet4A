package fr.polytech.projetrecettes.web;

import fr.polytech.projetrecettes.dao.RecetteInterface;
import fr.polytech.projetrecettes.entities.Avis;
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
    @GetMapping(value = "recettes")
    public ArrayList<Recette> recetteList(){
        return (ArrayList<Recette>) recetteInterface.findAll();
    }

    //renvoie le nombre de recettes
    private int taille() {
        return recetteList().size();
    }

    //ajouter une recette
    @PostMapping(path = "/recettes")
    public Recette save(Recette recette){
        return recetteInterface.save(recette);
    }

    //ajouter un ingrédient à une recette
    @PostMapping(path = "/{recette}/ingredients")
    public Recette save(@PathVariable("recette") Recette recette, String ingredient, String quantité){
        recette.getIngredients().add(ingredient);
        recette.getQuantite().add(quantité);
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

    //Mettre à jour le nombre de personnes
    @PutMapping("/{recette}/{nb_personnes}")
    public Recette saveNb(@PathVariable("recette") Recette recette,@PathVariable("nb_personnes")int nb_personnes){
        recette.setNb_personnes(nb_personnes);
        return recetteInterface.save(recette);
    }

    //Mettre à jour le nom
    @PutMapping("/{recette}/{nom}")
    public Recette saveNom(@PathVariable("recette") Recette recette,@PathVariable("nom")String nom){
        recette.setNom(nom);
        return recetteInterface.save(recette);
    }

    //Mettre à jour l'introduction
    @PutMapping("/{recette}/{introduction}")
    public Recette saveIntro(@PathVariable("recette") Recette recette,@PathVariable("introduction")String introduction){
        recette.setIntroduction(introduction);
        return recetteInterface.save(recette);
    }

    //Mettre à jour la description
    @PutMapping("/{recette}/{description}")
    public Recette saveDescription(@PathVariable("recette") Recette recette,@PathVariable("description")String description){
        recette.setDescription(description);
        return recetteInterface.save(recette);
    }

    //Mettre à jour un ingrédient
    @PutMapping("/{recette}/{ingredient}")
    public Recette saveIngredient(@PathVariable("recette") Recette recette, int indice, @PathVariable("ingredient")String ingredient){
        recette.getIngredients().set(indice,ingredient);
        return recetteInterface.save(recette);
    }

    //Mettre à jour la quantité d'un ingrédient
    @PutMapping("/{recette}/{ingredient}/{quantite}")
    public Recette saveQuantite(@PathVariable("recette") Recette recette,@PathVariable("ingredient") String ingredient, @PathVariable("quantite")String quantite){
        for(int i = 0; i<taille();i++){
            if(recette.getIngredients().get(i).equals(ingredient))recette.getQuantite().set(i,quantite);
        }
        return recetteInterface.save(recette);
    }

    //Mettre à jour le type
    @PutMapping("/{recette}/{type}")
    public Recette saveType(@PathVariable("recette") Recette recette,@PathVariable("type")RecetteType type){
        recette.setRecetteType(type);
        return recetteInterface.save(recette);
    }

    //Mettre à jour un avis
    @PutMapping("/{recette}/{avis}")
    public Recette saveAvis(@PathVariable("recette") Recette recette,@PathVariable("avis")Avis avis){
        List<Avis> avisList = recette.getAvis();
        for(Avis avis1 : avisList){
            if(avis1.getId_avis() == avis.getId_avis()){
                avis1.setCommentaire(avis.getCommentaire());
                avis1.setNote(avis.getNote());
            }
        }
        recette.setAvis(avisList);
        return recetteInterface.save(recette);
    }

    //Suppression d'un ingredient
    @DeleteMapping("/{recette}/{ingredient}")
    public Recette deleteIngredient(@PathVariable("recette") Recette recette,@PathVariable("description")String ingredient){
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