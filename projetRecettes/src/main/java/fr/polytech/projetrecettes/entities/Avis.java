package fr.polytech.projetrecettes.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity
public class Avis {
    @Id
    private int id_avis;
    private double note;
    private String commentaire;
}
