package vueGraphique;
import java.io.File;
import modele.Carte;
import modele.Lecture;

/** Classe qui permet de lancer le jeu Sokoban en version graphique*/
public class Sokoban {
    public static void main(String[] args) {
        Lecture map = new Lecture(new File("bin/map/map/map1.txt"));
        Carte carte = new Carte(map);
        VueSokoban vue = new VueSokoban(carte); 
    }
}
