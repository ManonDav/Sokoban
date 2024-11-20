package vueGraphique;
import modele.Carte;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JLabel;

/** Classe qui modélise le retour en arrière d'une action */
public class Retour extends AbstractAction{
    
    private Carte modele;
    private JLabel[][] tabLabels;

    /** Constructeur d'un retour
     * @param mat : la carte du jeu
     * @param lab : la matrice avec les JLabels pour l'affichage
     */
    public Retour(Carte mat, JLabel[][] lab){
        this.modele=mat;
        this.tabLabels=lab;
    }

    /** Reconstruit la matrice et change la vue pour revenir en arrière d'un coup */
    public void actionPerformed(ActionEvent e){
        modele.reinitialiserCoup();
        for (int i=0; i<modele.getNbLignes(); i++){
            for (int j=0; j<modele.getNbColonnes(); j++){
                this.tabLabels[i][j].setIcon(modele.getImageIcon(i, j));
            }
        }
    }

}
