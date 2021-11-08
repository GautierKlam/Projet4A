package fr.polytech.projetrecettes;

import fr.polytech.projetrecettes.dao.RecetteInterface;
import fr.polytech.projetrecettes.entities.Recette;
import fr.polytech.projetrecettes.entities.RecetteType;
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
    CommandLineRunner start(RecetteInterface recetteInterface){
        return args -> {
            recetteInterface.save(new Recette(1,"Salade de pâtes",4,"Très bonne recette, idéale pour l'été !","- Faites cuire vos pâtes\n- Mélangez les pâtes refroidies avec le basilic, le jambon, les tomates cerises, la roquette et la mozzarella\n- Ajoutez de l'huile et du vinaigre, salez, poivrez",new ArrayList<String>(){{add("200g");add("4 tranches");add("500g");add("100g");add("Quelques feuilles");}} ,new ArrayList<String>(){{add("Roquette");add("Jambon de pays");add("Tomates cerises");add("Mozzarella");add("Basilic");}}, RecetteType.PLAT));
            recetteInterface.save(new Recette(2,"Magret de canard",2,"Super","Description magret de canard",new ArrayList<String>(){{add("2");}},new ArrayList<String>(){{add("Magret de canard");}}, RecetteType.PLAT));
            recetteInterface.save(new Recette(3,"Avocats",1,"Top","Description avocats",new ArrayList<String>(){{add("1");}},new ArrayList<String>(){{add("Avocats");}}, RecetteType.ENTREE));
            recetteInterface.save(new Recette(4,"Tomates farcies",2,"Cool","Descritpion tomates farcies",new ArrayList<String>(){{add("2");add("150g");}},new ArrayList<String>(){{add("Tomates");add("Farce");}}, RecetteType.PLAT));
        };
    }
}
