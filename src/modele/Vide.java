package modele;
import javax.swing.ImageIcon;

/** Classe qui modélise le vide */
public class Vide extends ElementBase{

    /** Constructeur du vide 
     * @param symbole : le caractère qui représente le vide
     */
    public Vide (char symbole){
        super(symbole);
    }

     /** accesseur pour l'image qui représente le vide
     * @return l'imageIcon du vide
     */
    public ImageIcon getImageIcon(){
        return null;
    }


}
