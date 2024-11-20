package modele;
import java.io.File;
import java.util.*;
import javax.swing.ImageIcon;


/** Classe qui modélise la map de jeu */
public class Carte {
    
    private ElementBase[][] carte;
    private ElementBase[][] ancienCarte;
    private int nbLigne;
    private int nbColonne;
    private Robot robot;
    private Robot ancienRobot;
    private List<Caisse> caisses= new ArrayList<>();
    private List<Caisse> ancienCaisses;
    private List<Destination> desti = new ArrayList<>();
    private int compt;
    private int comptniv;

    /** Constructeur d'une Carte
     * @param CarteModele : carte fourni sous forme de tableau
     * @param taille : taille du tableau fourni
     */
    public Carte(String[] CarteModele, int taille){
        this.nbLigne=taille;
        this.nbColonne=CarteModele[0].length();
        this.carte= new ElementBase[nbLigne][nbColonne];
        for (int i=0; i<taille;i++){
            for(int j=0; j<CarteModele[i].length(); j++){
                if (CarteModele[i].charAt(j)=='@'){
                    this.carte[i][j]=new Robot(CarteModele[i].charAt(j),i,j,Direction.BAS);
                    this.robot= (Robot)carte[i][j];
                }else if(CarteModele[i].charAt(j)=='$') {
                    this.carte[i][j]=new Caisse(CarteModele[i].charAt(j),i,j);
                    caisses.add((Caisse)carte[i][j]);
                }else if(CarteModele[i].charAt(j)=='.'){
                    this.carte[i][j]=new Destination(CarteModele[i].charAt(j),i,j);
                    desti.add((Destination)carte[i][j]);
                }else if (CarteModele[i].charAt(j)=='#'){
                    this.carte[i][j]=new Mur(CarteModele[i].charAt(j));
                }else if (CarteModele[i].charAt(j)==' '){
                    this.carte[i][j]=new Sol(CarteModele[i].charAt(j));
                }else{
                    this.carte[i][j]=new Vide(CarteModele[i].charAt(j));
                }
            }
        }
    }

    /** Constructeur d'une Carte
     * @param map : la lecture d'un fichier contenant une carte de jeu
     */
    public Carte(Lecture map){
        this.nbLigne=map.getNbLigne();
        this.nbColonne=map.getNbColonne();
        this.carte= new ElementBase[nbLigne][nbColonne];
        for (int i=0; i<nbLigne;i++){
            for(int j=0; j<map.getLigne(i).length(); j++){
                if (map.getLigne(i).charAt(j)=='@'){
                    this.carte[i][j]=new Robot(map.getLigne(i).charAt(j),i,j,Direction.BAS);
                    this.robot= (Robot)carte[i][j];
                }else if(map.getLigne(i).charAt(j)=='$') {
                    this.carte[i][j]=new Caisse(map.getLigne(i).charAt(j),i,j);
                    caisses.add((Caisse)carte[i][j]);
                }else if(map.getLigne(i).charAt(j)=='.'){
                    this.carte[i][j]=new Destination(map.getLigne(i).charAt(j),i,j);
                    desti.add((Destination)carte[i][j]);
                }else if (map.getLigne(i).charAt(j)=='#'){
                    this.carte[i][j]=new Mur(map.getLigne(i).charAt(j));
                }else if (map.getLigne(i).charAt(j)==' '){
                    this.carte[i][j]=new Sol(map.getLigne(i).charAt(j));
                }else{
                    this.carte[i][j]=new Vide(map.getLigne(i).charAt(j));
                }
            }
        }
        getElement(0, 0);
    }

    /** Acceseur sur le nombre de colonne
     * @return le nombre de colonne
     */
    public int getNbColonnes(){
        return nbColonne;
    }

    /** Acceseur sur le nombre de ligne
     * @return le nombre de ligne
     */
    public int getNbLignes(){
        return nbLigne;
    }

    /** Accesseur pour l'image qui représente un élément de la carte
     * @param i : numéro de la ligne
     * @param j : numéro de la colonne
     * @return l'image qui représente un élément de la carte à l'emplacement (i,j)
     */
    public ImageIcon getImageIcon(int i, int j){
        return carte[i][j].getImageIcon();
    }

    /** Accesseur sur le symbole qui se trouve à l'emplacement (x,y)
     * @param x : numéro de la ligne où se trouve l'élément recherché
     * @param y : numéro de la colonne où se trouve l'élément recherché
     * @return l'élement à l'emplacement (x,y)
     */
    public char getElement(int x, int y){
        return carte[x][y].getSymbol();
    }

    /** Retourne l'image sous forme textuelle
     * @return l'image sous forme textuelle
     */
    public String toString(){
        String chaine="";
        for (int i=0;i<nbLigne;i++){
            for(int j=0;j<nbColonne;j++){
                chaine+=carte[i][j].toString();
            }
            chaine+="\n";
        }
        return chaine;
    }

    /** Recherche l'élément caisse à l'emplacement (x,y) dans la liste caisses
     * @param x : la ligne de la caisse
     * @param y : la colonne de la caisse
     * @return la caisse qu'on cherchait
     */
    public Caisse trouverCaisse(int x, int y){
        for (int i=0; i<caisses.size();i++){
            if (caisses.get(i).getLigne()==x && caisses.get(i).getColonne()==y){
                return caisses.get(i);
            }
        }
        return null;
    }

    /** Regarde si l'élement aux coordonnées (x,y) est sur une destination
     * @param x : la ligne de l'élément
     * @param y : la colonne de l'élément
     * @return si l'élément est sur une destination
     */
    public boolean EstSurDestination(int x, int y){
        for (int i=0; i<desti.size();i++){
            if (desti.get(i).getLigne()==x && desti.get(i).getColonne()==y){
                return true;
            }
        }
        return false;
    }

    /** Regarde une caisse aux coordonnées (x,y) est sur une destination
     * @param x : la ligne de la caisse
     * @param y : la colonne de la caisse
     * @return si l'élément est sur une destination
     */
    public boolean EstSurDestinationCaisse(int x, int y){
        for (int i=0; i<desti.size();i++){
            if (desti.get(i).getLigne()==x && desti.get(i).getColonne()==y){
                desti.get(i).ChangerACaisse();
                return true;
            }
        }
        return false;
    }

    /** Copie la carte courante pour en garder une trace dans ancienCarte */
    public void copieCarte(){
        this.ancienCarte = new ElementBase[nbLigne][nbColonne];
        for (int i=0; i<nbLigne;i++){
            for (int j=0; j<nbColonne;j++){
                this.ancienCarte[i][j]=carte[i][j];
            }
        }
        this.ancienRobot= new Robot(robot.getSymbol(), robot.getLigne(), robot.getColonne(), robot.getDirection());
        this.ancienCaisses=new ArrayList<>();
        for (int i=0; i<caisses.size(); i++){
            Caisse nvCaisse = new Caisse(caisses.get(i).getSymbol(),caisses.get(i).getLigne(),caisses.get(i).getColonne());
            ancienCaisses.add(nvCaisse);
        }
    }

    /** Déplace le robot si cela est possible
     * @param dir : la direction
     * @return si le robot s'est déplacé ou non
     */
    public boolean deplacerRobot(Direction dir){
        copieCarte();
        if (deplacementPossible(dir, robot.getLigne(),robot.getColonne())){
            if (this.carte[robot.getLigne()+dir.getLigne()][robot.getColonne()+dir.getColonne()].getSymbol()=='$' || this.carte[robot.getLigne()+dir.getLigne()][robot.getColonne()+dir.getColonne()].getSymbol()=='*' ){
                Caisse caisse = trouverCaisse(robot.getLigne()+dir.getLigne(),robot.getColonne()+dir.getColonne());
                if (deplacementPossibleCaisse(dir,caisse.getLigne() , caisse.getColonne())){
                    boolean test = EstSurDestinationCaisse(caisse.getLigne()+dir.getLigne(),caisse.getColonne()+dir.getColonne());
                    if (test){
                        Caisse nvCaisse=new Caisse('*',caisse.getLigne()+dir.getLigne(),caisse.getColonne()+dir.getColonne());
                        this.carte[caisse.getLigne()+dir.getLigne()][caisse.getColonne()+dir.getColonne()]=nvCaisse;                      
                        caisse.ChangerCoord(caisse.getLigne()+dir.getLigne(), caisse.getColonne()+dir.getColonne());
                        nvCaisse.ChangerImageIcon(); 
                    }else{
                        this.carte[caisse.getLigne()+dir.getLigne()][caisse.getColonne()+dir.getColonne()]=new Caisse(caisse.getSymbol(),caisse.getLigne()+dir.getLigne(),caisse.getColonne()+dir.getColonne());
                        caisse.ChangerCoord(caisse.getLigne()+dir.getLigne(), caisse.getColonne()+dir.getColonne());
                        caisse.changerSymbol('$');
                    }
                    this.carte[robot.getLigne()][robot.getColonne()]= new Sol(' ');
                    Robot nvRobot=new Robot(robot.getSymbol(),robot.getLigne(),robot.getColonne(),dir);
                    this.carte[robot.getLigne()+dir.getLigne()][robot.getColonne()+dir.getColonne()]= nvRobot;
                    robot.ChangerCoord(robot.getLigne()+dir.getLigne(), robot.getColonne()+dir.getColonne());
                    nvRobot.ChangerImage();
                        
                }
            }else{
                this.carte[robot.getLigne()][robot.getColonne()]=new Sol(' ');
                Robot nvRobot = new Robot(robot.getSymbol(),robot.getLigne(),robot.getColonne(),dir);
                this.carte[robot.getLigne()+dir.getLigne()][robot.getColonne()+dir.getColonne()]=nvRobot;
                robot.ChangerCoord(robot.getLigne()+dir.getLigne(), robot.getColonne()+dir.getColonne());
                nvRobot.ChangerImage();
            }
            DessineDestination();
            if (EstSurDestination(robot.getLigne(),robot.getColonne())){
                Robot nvRobot = new Robot('+',robot.getLigne(),robot.getColonne(),dir);
                this.carte[robot.getLigne()][robot.getColonne()]=nvRobot;  
                nvRobot.ChangerImage();                    
            }
            compt++;
            return true;
        }
        return false;
    }

    /** Dessine les destinations si rien ne se trouve dessus */
    public void DessineDestination(){
        for (int i=0; i<desti.size(); i++){
            if (carte[desti.get(i).getLigne()][desti.get(i).getColonne()].getSymbol()!='.' && carte[desti.get(i).getLigne()][desti.get(i).getColonne()].getSymbol()!='*'){
                this.carte[desti.get(i).getLigne()][desti.get(i).getColonne()]=new Destination('.',desti.get(i).getLigne(),desti.get(i).getColonne()); 
            }
        }
    }

    /** Vérifie que le déplacement est possible
     * @param dir : la direction
     * @param x : la ligne
     * @param y : la colonne
     * @return si le déplacement est possible
     */
    public boolean deplacementPossible(Direction dir,int x, int y){
        return this.carte[x+dir.getLigne()][y+dir.getColonne()].getSymbol()!= '#';
    }

    /** Vérifie que le déplacement de la caisse est possible
     * @param dir : la direction
     * @param x : la ligne
     * @param y : la colonne
     * @return si le déplacement de la caisse est possible
     */
    public boolean deplacementPossibleCaisse(Direction dir,int x, int y){
        return this.carte[x+dir.getLigne()][y+dir.getColonne()].getSymbol()!= '#' && this.carte[x+dir.getLigne()][y+dir.getColonne()].getSymbol()!= '$' && this.carte[x+dir.getLigne()][y+dir.getColonne()].getSymbol()!= '*';
    }

    /** Teste si on a réussi le niveau 
     * @return si le niveau est finie ou non
    */
    public boolean finDePartie(){
        for (int i=0; i<desti.size(); i++){
            boolean aCaisse= false;
            for (int j=0; j<caisses.size(); j++){
                if (desti.get(i).getLigne()==caisses.get(j).getLigne() && desti.get(i).getColonne()==caisses.get(j).getColonne()){
                    aCaisse=true;
                }
            }
            if (!aCaisse){
                return false;
            }
        }
        comptniv+=1;
        return true;
    }

    /** Accesseur sur le numéro du niveau 
     * @return le numéro du niveau
    */
    public int getNiveau(){
        return comptniv;
    }

    /** Accesseur sur le score
     * @return le score
    */
    public int getScore(){
        return compt;
    }

    /** Réinitialise la carte avec l'ancien carte pour supprimer un coup */
    public void reinitialiserCoup(){
        for (int i=0; i<nbLigne;i++){
            for (int j=0; j<nbColonne;j++){
                this.carte[i][j]=ancienCarte[i][j];
            }
        }
        this.robot=ancienRobot;
        this.caisses=ancienCaisses;
    }

    /** Reinitialise la matrice avec une nouvelle carte à lire
     * @param fichier : fichier à lire contenant la carte
     */
    public void reinitialiserMatrice(File fichier) {
        this.compt=0;
        caisses= new ArrayList<>();
        desti = new ArrayList<>();
        Lecture map = new Lecture(fichier);
        this.nbLigne=map.getNbLigne();
        this.nbColonne=map.getNbColonne();
        this.carte= new ElementBase[nbLigne][nbColonne];
        for (int i=0; i<nbLigne;i++){
            for(int j=0; j<map.getLigne(i).length(); j++){
                if (map.getLigne(i).charAt(j)=='@'){
                    this.carte[i][j]=new Robot(map.getLigne(i).charAt(j),i,j,Direction.BAS);
                    this.robot= (Robot)carte[i][j];
                }else if(map.getLigne(i).charAt(j)=='$') {
                    this.carte[i][j]=new Caisse(map.getLigne(i).charAt(j),i,j);
                    caisses.add((Caisse)carte[i][j]);
                }else if(map.getLigne(i).charAt(j)=='.'){
                    this.carte[i][j]=new Destination(map.getLigne(i).charAt(j),i,j);
                    desti.add((Destination)carte[i][j]);
                }else if (map.getLigne(i).charAt(j)=='#'){
                    this.carte[i][j]=new Mur(map.getLigne(i).charAt(j));
                }else if (map.getLigne(i).charAt(j)==' '){
                    this.carte[i][j]=new Sol(map.getLigne(i).charAt(j));
                }else{
                    this.carte[i][j]=new Vide(map.getLigne(i).charAt(j));
                }
            }
        }
    }

}
