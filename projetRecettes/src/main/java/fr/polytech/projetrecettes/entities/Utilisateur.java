package fr.polytech.projetrecettes.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Utilisateur {
    @Id
    private int identifiant;
    private String nom;
    private String prenom;
    private String pseudo;
    private String mdp;
    private String mail;
    private boolean admin;
}
