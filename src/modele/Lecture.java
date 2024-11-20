package modele;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/** Classe qui modélise la lecture d'un fichier*/
public class Lecture {

    private int nbLigne;
    private int nbColonne;
    private String[] map;

    /** Constructeur d'une lecture d'un fichier
     * @param fichier : le fichier à lire
     */
    public Lecture(File fichier){
        try{
            Scanner scan= new Scanner(fichier);
            ArrayList<String> lignes = new ArrayList<>();
            while (scan.hasNextLine()){
                String ligne = scan.nextLine();
                lignes.add(ligne);
            }
            scan.close();
            this.nbLigne=lignes.size();
            this.map = new String[lignes.size()];
            map = lignes.toArray(map);
            this.nbColonne=map[0].length();
        } catch (FileNotFoundException e) {
            System.err.println("Le fichier spécifié est introuvable : " + e.getMessage());
        }
    }

    /** accesseur pour le nombre de lignes
     * @return le nombre de ligne
     */
    public int getNbLigne(){
        return nbLigne;
    }

    /** accesseur pour le nombre de colonne 
     * @return le nombre de colonne
     */
    public int getNbColonne(){
        return nbColonne;
    }

    /** Retourne la ligne de numéro indice
     * @param indice : numéro de la ligne à lire
     * @return la ligne à lire
    */
    public String getLigne(int indice){
        if (indice>=0 && indice<nbLigne){
            return map[indice];
        }
        return "";
    }

}
