package vueGraphique;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.HashMap;
import modele.Carte;
import modele.Direction;

/** Classe qui gére les appuis sur une touche */
public class ListenerKey implements KeyListener {

    private Carte modele;
    private HashMap<Integer,Direction> dico;
    private VueSokoban vue;

    /** Constructeur d'un ListenerKey
     * @param modele : la carte du jeu
     * @param dicoDirec : le dictionnaire des Directions associé à leur touche
     * @param vue : la vue graphique
     */
    public ListenerKey(Carte modele, HashMap<Integer,Direction> dicoDirec,VueSokoban vue){
        this.modele=modele;
        this.dico=dicoDirec;
        this.vue=vue;
    }

    /** Deplace le robot et met la vue à jour selon la touche appuyé */
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (dico.containsKey(keyCode)){
            Direction dir = dico.get(keyCode);
            modele.deplacerRobot(dir);
            vue.mettreAJourVue();
            if (modele.finDePartie()){
                if (modele.getNiveau()==1){
                    modele.reinitialiserMatrice(new File("bin/map/map/map2.txt"));
                    vue.reinitialiserVue();
                }
                else if (modele.getNiveau()==2){
                    modele.reinitialiserMatrice(new File("bin/map/map/map3.txt"));
                    vue.reinitialiserVue();
                }
                else{
                    vue.afficherMessage();
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        // Non utilisé dans cet exemple
    }


    public void keyTyped(KeyEvent e) {
        // Non utilisé dans cet exemple
    }
    
}
