package fr.polytech.projetrecettes.entities;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_avis;
    private double note;
    private String commentaire;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_recette")
    private Recette recette;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    public Avis(double note, String commentaire, Recette recette, Utilisateur utilisateur) {
        this.note = note;
        this.commentaire = commentaire;
        this.recette = recette;
        this.utilisateur = utilisateur;
    }
}
