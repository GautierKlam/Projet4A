package fr.polytech.projetrecettes.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Data @ToString
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ingredient;
    private String nom;
    private String quantite;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_recette")
    private Recette recette;

    public Ingredient(String nom, String quantite, Recette recette){
        this.nom = nom;
        this.quantite = quantite;
        this.recette = recette;
    }
}
