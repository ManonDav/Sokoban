package modele;
import javax.swing.ImageIcon;

/** Classe abstraite qui modélise un Element du Jeu */
public abstract class ElementBase {
    
    private char symbole;

    /**Constructeur d'un élément de base du jeu
     * @param symbole : le caractère qui représente un élément de base du jeu
     */
    public ElementBase(char symbole){
        this.symbole=symbole;
    }

    /** Retourne une présentation textuelle du symbole */
    public String toString(){
        return ""+symbole;
    }

    /** Accesseur pour le symbole
     * @return le symbole associé à l'élément
    */
    public char getSymbol(){
        return symbole;
    }

    public void changerSymbol(char symb){
        this.symbole=symb;
    }

    /** Méthode abstraite pour retourner l'image correspondant à l'élément */
    public abstract ImageIcon getImageIcon();

}
