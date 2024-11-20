package vueGraphique;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JLabel;
import modele.Carte;

/** Classe qui modélise le moyen de recommencer une partie */
public class Recommencer extends AbstractAction {

    private Carte modele;
    private JLabel[][] tabLabels;

    /** Constructeur de Recommencer
     * @param mat : la carte du jeu
     * @param tab : une matrice avec les JLabels pour l'affichage
     */
    public Recommencer(Carte mat,JLabel[][] tab){
        this.modele=mat;
        this.tabLabels=tab;
    }

    /** Réinitialise la vue à partir de la nouvelle matrice */
    public void actionPerformed(ActionEvent e){
        if (modele.getNiveau()==0){
            modele.reinitialiserMatrice(new File("bin/map/map/map1.txt"));
            for (int i=0; i<modele.getNbLignes(); i++){
                for (int j=0; j<modele.getNbColonnes(); j++){
                    this.tabLabels[i][j].setIcon(modele.getImageIcon(i, j));
                }
            }
        }
        if (modele.getNiveau()==1){
            modele.reinitialiserMatrice(new File("bin/map/map/map2.txt"));
            for (int i=0; i<modele.getNbLignes(); i++){
                for (int j=0; j<modele.getNbColonnes(); j++){
                    this.tabLabels[i][j].setIcon(modele.getImageIcon(i, j));
                }
            }
        }
        if (modele.getNiveau()==2){
            modele.reinitialiserMatrice(new File("bin/map/map/map3.txt"));
            for (int i=0; i<modele.getNbLignes(); i++){
                for (int j=0; j<modele.getNbColonnes(); j++){
                    this.tabLabels[i][j].setIcon(modele.getImageIcon(i, j));
                }
            }
        }
    }
}
