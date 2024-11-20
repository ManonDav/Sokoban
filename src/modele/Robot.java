package modele;
import javax.swing.ImageIcon;

/**Classe qui modélise un robot */
public class Robot extends ElementBase{

    private int ligne;
    private int colonne;
    private ImageIcon image;
    private Direction dir;

    /** Constructeur d'un robot
     *  @param symbole : le caractère qui représente un robot
     * @param x : la coordonnée qui représente la ligne sur laquelle se trouve le robot
     * @param y : la coordonnée qui représente la colonne sur laquelle se trouve le robot
     * @param dir : la direction du robot
     */
    public Robot(char symbole,int x ,int y,Direction dir){
        super(symbole);
        this.ligne=x;
        this.colonne=y;
        this.image=new ImageIcon("bin\\images\\img\\Bas.gif");
        this.dir=dir;
    }

    /** accesseur pour le numéro de la ligne où se trouve le robot
     * @return le numéro de la ligne
     */
    public int getLigne(){
        return ligne;
    }

    /** accesseur pour le numéro de la ligne où se trouve le robot
     * @return le numéro de la ligne
     */
    public int getColonne(){
        return colonne;
    }

    /** Change les coordonnées du robot
     * @param ligne : ligne où se trouve le robot
     * @param colonne : colonne où se trouve le robot
     */
    public void ChangerCoord(int ligne, int colonne){
        this.ligne=ligne;
        this.colonne=colonne;
    }

     /** accesseur pour l'image qui représente un robot
     * @return l'imageIcon du robot
     */
    public ImageIcon getImageIcon(){
        return image;
    }

    /** Change l'image du robot en fonction de sa direction*/
    public void ChangerImage(){
        if (dir==Direction.BAS){
            this.image=new ImageIcon("bin\\images\\img\\Bas.gif");
        }
        else if (dir==Direction.GAUCHE){
            this.image=new ImageIcon("bin\\images\\img\\Gauche.gif");
        }
        else if (dir==Direction.DROITE){
            this.image=new ImageIcon("bin\\images\\img\\Droite.gif");
        }else{
            this.image=new ImageIcon("bin\\images\\img\\Haut.gif");
        }
    }

    /** accesseur pour la direction du robot
     * @return la direction du robot
     */
    public Direction getDirection(){
        return dir;
    }

}
