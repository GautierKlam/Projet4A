package fr.polytech.projetrecettes.entities;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id_recette;
    private String nom;
    private int nb_personnes;
    private String introduction;
    private String description;
    @ElementCollection
    private List<String> quantite;
    @ElementCollection
    private List<String> ingredients;
    @Enumerated(EnumType.STRING)
    private RecetteType recetteType;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="recette")
    private List<Avis> avis;

    public Recette(String nom, int nb_personnes, String introduction, String description, List<String> quantite, List<String> ingredients, RecetteType recetteType, List<Avis> avis) {
        this.nom = nom;
        this.nb_personnes = nb_personnes;
        this.introduction = introduction;
        this.description = description;
        this.quantite = quantite;
        this.ingredients = ingredients;
        this.recetteType = recetteType;
        this.avis = avis;
    }
}