package vuetexte;
import modele.*;

/** Classe qui modélise la Vue en modeTexte */
public class ModeTexte {
    
    private Carte modele;
    private Direction[] dir;

    /** Constructeur d'un ModeTexte
     * @param modele : le modele qui va permettre la création de la vue
     * @param dir : les directions autorisées
     */
    public ModeTexte(Carte modele, Direction[] dir){
        this.modele=modele;
        this.dir=dir;
    }

    /** Demande au joueur de choisir une direction */
    public void DemanderDirectionJoueur(){
        System.out.println("Entrer un caractère entre q(gauche), z(haut), d(droite), s(bas)");
        char c = Outil.lireCaractere();
        while (c!='q' && c!='z' && c!='d' && c!='s'){
            System.out.println("Le caractère saisi est incorrecte: veuillez en écrire un nouveau");
            c = Outil.lireCaractere();
        }
        if (c=='q'){
            modele.deplacerRobot(dir[0]);
        }
        if (c=='z'){
            modele.deplacerRobot(dir[1]);
        }
        if (c=='d'){
            modele.deplacerRobot(dir[2]);
        }
        if (c=='s'){
            modele.deplacerRobot(dir[3]);
        }
    }

    /** Lance la partie et l'arrête quand le jeu est fini */
    public void lancerPartie(){
        while (!(modele.finDePartie())){
            System.out.println(modele.toString());
            DemanderDirectionJoueur();
        }
    }

}
