package modele;
import javax.swing.ImageIcon;


/** Classe qui modelise une caisse */
public class Caisse extends ElementBase{

    private int ligne;
    private int colonne;
    private ImageIcon image;

    /** Constructeur d'une caisse
     * @param symbole : le caractère qui représente une caisse
     * @param x : la coordonnée qui représente la ligne sur laquelle se trouve la caisse
     * @param y : la coordonnée qui représente la colonne sur laquelle se trouve la caisse
     */
    public Caisse(char symbole,int x ,int y){
        super(symbole);
        this.ligne=x;
        this.colonne=y;
        this.image=new ImageIcon("bin\\images\\img\\caisse1.gif");
    }

    /** accesseur pour le numéro de la ligne sur laquelle se situe la caisse
     * @return le numéro de la ligne
     */
    public int getLigne(){
        return ligne;
    }

    /** accesseur pour le numéro de la colonne sur laquelle se situe la caisse
     * @return le numéro de la colonne
     */
    public int getColonne(){
        return colonne;
    }

    /** accesseur pour l'image qui représente une caisse
     * @return l'imageIcon de la caisse
     */
    public ImageIcon getImageIcon(){
        return image;
    }

    /** Change les coordonnées de position de la caisse
     * @param ligne : numéro de la ligne
     * @param colonne : numéro de la colonne
     */
    public void ChangerCoord(int ligne, int colonne){
        this.ligne=ligne;
        this.colonne=colonne;
    }

   
    /** Change l'image de la caisse (quand celle-ci est sur une destination) */
    public void ChangerImageIcon(){
        ImageIcon im= new ImageIcon("bin\\images\\img\\caisse2.gif");
        this.image=im;
    }

    /** Change l'image de la caisse (quand celle-ci n'est pas sur une destination) */
    public void ChangerImageIconInverse(){
        ImageIcon im= new ImageIcon("bin\\images\\img\\caisse1.gif");
        this.image=im;
    }

    

}
