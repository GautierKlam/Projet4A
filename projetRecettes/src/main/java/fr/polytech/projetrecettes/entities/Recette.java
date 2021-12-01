package fr.polytech.projetrecettes.entities;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recette")
    private int id_recette;
    private String nom;
    private int nb_personnes;
    private String introduction;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "recette")
    private List<Ingredient> ingredients;
    @Enumerated(EnumType.STRING)
    private RecetteType recetteType;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="recette")
    private List<Avis> avis;

    public Recette(String nom, int nb_personnes, String introduction, String description, List<Ingredient> ingredients, RecetteType recetteType, List<Avis> avis) {
        this.nom = nom;
        this.nb_personnes = nb_personnes;
        this.introduction = introduction;
        this.description = description;
        this.recetteType = recetteType;
        this.avis = avis;
        this.ingredients = ingredients;
    }
}