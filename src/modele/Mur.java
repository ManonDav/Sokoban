package modele;
import javax.swing.ImageIcon;

/** Classe qui modélise un mur */
public class Mur extends ElementBase{

    private ImageIcon image;

    /** Constructeur d'un mur
     * @param symbole : le caractère qui représente un mur
     */
    public Mur(char symbole){
        super(symbole);
        this.image=new ImageIcon("bin\\images\\img\\mur.gif");
    }

    /** accesseur pour l'image qui représente un mur
     * @return l'imageIcon du mur
     */
    public ImageIcon getImageIcon(){
        return image;
    }

}