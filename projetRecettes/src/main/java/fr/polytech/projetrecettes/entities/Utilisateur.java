package fr.polytech.projetrecettes.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data // génére le get et le set automatiquement
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // permet l'autoincrément de l'id
    private int identifiant;
    private String nom;
    private String prenom;
    private String pseudo;
    private String mdp;
    private String mail;
    private boolean admin;
}
