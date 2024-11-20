package modele;
import javax.swing.ImageIcon;

/** Classe qui modélise le sol */
public class Sol extends ElementBase{
 
    private ImageIcon image;

    /** Constructeur d'un sol
     * @param symbole : le caractère qui représente le sol
     */
    public Sol(char symbole){
        super(symbole);
        this.image=new ImageIcon("bin\\images\\img\\sol.gif");
    }

     /** accesseur pour l'image qui représente un sol
     * @return l'imageIcon du sol
     */
    public ImageIcon getImageIcon(){
        return image;
    }

}
