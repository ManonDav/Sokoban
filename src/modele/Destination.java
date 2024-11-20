package modele;
import javax.swing.ImageIcon;

/** Classe qui modélise une destination */
public class Destination extends ElementBase{

    private int ligne;
    private int colonne;
    private boolean aCaisse;
    private ImageIcon image;
    
    /** Constructeur d'une destination
     *  @param symbole : le caractère qui représente une destination
     * @param x : la coordonnée qui représente la ligne où se trouve la destination
     * @param y : la coordonnée qui représente la colonne où se trouve la destination
    */
    public Destination (char symbole,int x ,int y){
        super(symbole);
        this.ligne=x;
        this.colonne=y;
        this.aCaisse=false;
        this.image=new ImageIcon("bin\\images\\img\\but.gif");
    }

    /** accesseur pour le numéro de la ligne où se trouve la destination
     * @return le numéro de la ligne
     */
    public int getLigne(){
        return ligne;
    }

    /** accesseur pour le numéro de la colonne où se trouve la destination
     * @return le numéro de la colonne
     */
    public int getColonne(){
        return colonne;
    }

    /** Accesseur sur le fait d'avoir une caisse ou non sur la destination
     * @return si il y a une caisse ou non sur l'objectif
     */
    public boolean ACaisse(){
        return aCaisse;
    }

    /** Change le fait d'avoir une caisse ou non sur la destination */
    public void ChangerACaisse(){
        this.aCaisse=!aCaisse;
    }

    /** accesseur pour l'image qui représente une destination
     * @return l'imageIcon de la destination
     */
    public ImageIcon getImageIcon(){
        return image;
    }

    

}
