package fr.polytech.projetrecettes.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity
public class Recette {
    @Id
    private int identifiant;
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
}