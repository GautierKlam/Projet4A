package fr.polytech.projetrecettes;
import fr.polytech.projetrecettes.dao.RecetteInterface;
import fr.polytech.projetrecettes.dao.UtilisateurInterface;
import fr.polytech.projetrecettes.entities.*;
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
    CommandLineRunner start(RecetteInterface recetteInterface, UtilisateurInterface utilisateurInterface){
        return args -> {
            utilisateurInterface.save(new Utilisateur(1,"Deniere","Jade","Jade","$2y$10$vtJSdxIFFwCtpdXXhGRJSOuenRJPEEiQqVO.c9Rf5iW2n6LvjVjM6","jade.deniere@gmail.fr",false));
            utilisateurInterface.save(new Utilisateur(2,"Delarue","Jean","Jean","$2y$10$zGlgWeBQgKSAZjsxTOh5Uu5VonRKHRvIWopK7AuUITWRwWBDupI/O","jean.delarue@gmail.fr",true));

            recetteInterface.save(new Recette(1,"Salade de pâtes",4,"Très bonne recette, idéale pour l'été !","- Faites cuire vos pâtes<br>- Mélangez les pâtes refroidies avec le basilic, le jambon, les tomates cerises, la roquette et la mozzarella<br>- Ajoutez de l'huile et du vinaigre, salez, poivrez",new ArrayList<Ingredient>(){{add(new Ingredient("Roquette","200g", recetteInterface.getById(1)));add(new Ingredient("Jambon de pays","4 tranches", recetteInterface.getById(1)));add(new Ingredient("Tomates cerises","500g",recetteInterface.getById(1)));add(new Ingredient("Mozzarella","100g",recetteInterface.getById(1)));add(new Ingredient("Basilic","Quelques feuilles",recetteInterface.getById(1)));}}, RecetteType.PLAT,new ArrayList<Avis>(){{add(new Avis(4,"Effectivement très frais !",recetteInterface.getById(1),utilisateurInterface.getById(1)));add(new Avis(5,"Rien à redire, parfait",recetteInterface.getById(1),utilisateurInterface.getById(2)));}},utilisateurInterface.getById(1)));
            recetteInterface.save(new Recette(2,"Magret de canard",2,"Super","Description magret de canard",new ArrayList<Ingredient>(){{add(new Ingredient("Magret de canard","2",recetteInterface.getById(2)));}}, RecetteType.PLAT, new ArrayList<Avis>(){{add(new Avis(5,"Super recette, je recommande !", recetteInterface.getById(2), utilisateurInterface.getById(1)));}}, utilisateurInterface.getById(2)));
            recetteInterface.save(new Recette(3,"Avocats",1,"Top","Description avocats",new ArrayList<Ingredient>(){{add(new Ingredient("Avocat","1",recetteInterface.getById(3)));}}, RecetteType.ENTREE, new ArrayList<Avis>(){{add(new Avis(3,"Bravo, tout le monde a adoré !",recetteInterface.getById(3),utilisateurInterface.getById(1)));}}, utilisateurInterface.getById(1)));
            recetteInterface.save(new Recette(4,"Tomates farcies",2,"Cool","Descritpion tomates farcies",new ArrayList<Ingredient>(){{add(new Ingredient("Tomates","4",recetteInterface.getById(4)));add(new Ingredient("Farce","150g",recetteInterface.getById(4)));}}, RecetteType.PLAT,new ArrayList<Avis>(){{add(new Avis(1,"Pas fou, on sent à peine le goût de la viande...", recetteInterface.getById(4), utilisateurInterface.getById(2)));}}, utilisateurInterface.getById(2)));
            recetteInterface.save(new Recette(5,"Tomates provençales",4,"Génial","Description tomates", new ArrayList<Ingredient>(){{add(new Ingredient("Tomates","8",recetteInterface.getById(5)));}}, RecetteType.PLAT, new ArrayList<Avis>(){{add(new Avis(4,"Topitop !",recetteInterface.getById(5),utilisateurInterface.getById(2)));}}, utilisateurInterface.getById(1)));
        };
    }
}