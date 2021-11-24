/*package fr.polytech.projetrecettes.web;

import fr.polytech.projetrecettes.dao.AvisInterface;
import fr.polytech.projetrecettes.entities.Avis;
import fr.polytech.projetrecettes.entities.Recette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AvisControlleur {
    @Autowired
    private AvisInterface avisInterface;

    //renvoie la liste des avis
    @GetMapping(value = "avis")
    public ArrayList<Avis> avisList(){
        return (ArrayList<Avis>) avisInterface.findAll();
    }

    //renvoie le nombre d'avis
    private int taille() {
        return avisList().size();
    }

    //ajouter un avis
    @PostMapping(path = "/avis")
    public Avis save(Avis avis){
        return avisInterface.save(avis);
    }

    //Mettre à jour l'identifiant
    @PutMapping("/{avis}/{identifiant}")
    public Avis saveIntro(@PathVariable("avis") Avis avis, @PathVariable("identifiant")int identifiant){
        avis.setId_avis(identifiant);
        return avisInterface.save(avis);
    }

    //Modifier la note
    @PutMapping("/{avis}/{note}")
    public Avis saveNote(@PathVariable("avis") Avis avis,@PathVariable double note){
        avis.setNote(note);
        return avisInterface.save(avis);
    }

    //Modifier le commentaire
    @PutMapping("/{avis}/{commentaire}")
    public Avis saveCommentaire(@PathVariable("avis") Avis avis,@PathVariable String commentaire){
        avis.setCommentaire(commentaire);
        return avisInterface.save(avis);
    }

    //suppression d'un avis
    @DeleteMapping("/avis/{id_avis}")
    public void delete(@PathVariable int id){
        avisInterface.deleteById(id);
    }
}
*/