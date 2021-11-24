package fr.polytech.projetrecettes.entities;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity
public class Avis {
    @Id
    @GeneratedValue
    private int id_avis;
    private double note;
    private String commentaire;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_recette")
    private Recette recette;

    public Avis(double note, String commentaire) {
        this.note = note;
        this.commentaire = commentaire;
    }
}
