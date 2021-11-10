package fr.polytech.projetrecettes;

import fr.polytech.projetrecettes.dao.AvisInterface;
import fr.polytech.projetrecettes.dao.RecetteInterface;
import fr.polytech.projetrecettes.dao.UtilisateurInterface;
import fr.polytech.projetrecettes.entities.Avis;
import fr.polytech.projetrecettes.entities.Recette;
import fr.polytech.projetrecettes.entities.RecetteType;
import fr.polytech.projetrecettes.entities.Utilisateur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class ProjetRecettesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetRecettesApplication.class, args);
    }

    @Bean
    CommandLineRunner start(RecetteInterface recetteInterface, UtilisateurInterface utilisateurInterface, AvisInterface avisInterface){
        return args -> {
            avisInterface.save(new Avis(1,5,"Super recette, je recommande !"));
            avisInterface.save(new Avis(2,3.5,"Bravo, tout le monde a adoré !"));
            avisInterface.save(new Avis(3,1,"Pas fou, on sent à peine le goût de la viande..."));

            utilisateurInterface.save(new Utilisateur(1,"Orlabite","Jade","Le canard","6969","OKLM@gmail.fr",true));
            utilisateurInterface.save(new Utilisateur(2,"Kulfor","Jean","Le pigeon","6969","OKLM2@gmail.fr",true));

            recetteInterface.save(new Recette(1,"Salade de pâtes",4,"Très bonne recette, idéale pour l'été !","- Faites cuire vos pâtes\n- Mélangez les pâtes refroidies avec le basilic, le jambon, les tomates cerises, la roquette et la mozzarella\n- Ajoutez de l'huile et du vinaigre, salez, poivrez",new ArrayList<String>(){{add("200g");add("4 tranches");add("500g");add("100g");add("Quelques feuilles");}} ,new ArrayList<String>(){{add("Roquette");add("Jambon de pays");add("Tomates cerises");add("Mozzarella");add("Basilic");}}, RecetteType.PLAT,new ArrayList<Avis>(){{add(new Avis(1,7,"Effectivement très frais !"));add(new Avis(2,10,"rien à redire c'etait parfait"));}}));
            recetteInterface.save(new Recette(2,"Magret de canard",2,"Super","Description magret de canard",new ArrayList<String>(){{add("2");}},new ArrayList<String>(){{add("Magret de canard");}}, RecetteType.PLAT, new ArrayList<Avis>(){{add(new Avis(1,5,"Super recette, je recommande !"));}}));
            recetteInterface.save(new Recette(3,"Avocats",1,"Top","Description avocats",new ArrayList<String>(){{add("1");}},new ArrayList<String>(){{add("Avocats");}}, RecetteType.ENTREE, new ArrayList<Avis>(){{add(new Avis(1,3.5,"Bravo, tout le monde a adoré !"));}}));
            recetteInterface.save(new Recette(4,"Tomates farcies",2,"Cool","Descritpion tomates farcies",new ArrayList<String>(){{add("2");add("150g");}},new ArrayList<String>(){{add("Tomates");add("Farce");}}, RecetteType.PLAT,new ArrayList<Avis>(){{add(new Avis(1,1,"Pas fou, on sent à peine le goût de la viande..."));}}));
        };
    }
}
