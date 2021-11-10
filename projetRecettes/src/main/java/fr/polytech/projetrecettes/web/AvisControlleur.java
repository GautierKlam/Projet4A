package fr.polytech.projetrecettes.web;

import fr.polytech.projetrecettes.dao.AvisInterface;
import fr.polytech.projetrecettes.entities.Avis;
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

    //Modifier à jour la note
    @PutMapping("/avis")
    public Avis saveNote(Avis avis,@PathVariable("note") double note){
        avis.setNote(note);
        return avisInterface.save(avis);
    }

    //Mettre à jour le commentaire
    @PutMapping("/avis")
    public Avis saveCommentaire(Avis avis,@PathVariable("commentaire")String commentaire){
        avis.setCommentaire(commentaire);
        return avisInterface.save(avis);
    }

    //suppression d'un avis
    @DeleteMapping("/avis/{id_avis}")
    public void save(@PathVariable("id_avis")int id){
        avisInterface.deleteById(id);
    }
}
