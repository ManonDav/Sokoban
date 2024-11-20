package vuetexte;
import java.io.File;
import modele.*;

/** Classe qui permet de lancer le jeu du Sokoban dans la console (en mode texte) */
public class SokobanTexte {
    
    public static void main(String[] args) {
        //String[] carte_main = {"//####///","###  ####","#     $ #","# #  #$ #","# . .#@ #","#########"};
        //Carte map = new Carte(carte_main, 6);
        Lecture map = new Lecture(new File("bin/map/map/map1.txt"));
        Carte carte = new Carte(map);
        Direction[] dir = new Direction[4];
        dir[0]=Direction.GAUCHE;
        dir[1]=Direction.HAUT;
        dir[2]=Direction.DROITE;
        dir[3]=Direction.BAS;
        ModeTexte vue = new ModeTexte(carte,dir);
        vue.lancerPartie();
    }

}
