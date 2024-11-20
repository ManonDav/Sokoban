package vueGraphique;
import java.util.HashMap;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import modele.*;

/** Classe qui permet de modéliser la vue du jeu Sokoban */
public class VueSokoban {

    private Carte modele;
    private JFrame fenetre;
    private Container cont;
    private HashMap<Integer,Direction> dicoDirec = new HashMap();
    private JLabel[][] tabLabels;
    private JLabel score;
    
    /** Constructeur d'une vueSokoban 
     * @param modele : la carte du jeu
    */
    public VueSokoban(Carte modele){
        this.modele=modele;
        dicoDirec.put(KeyEvent.VK_LEFT,Direction.GAUCHE);
        dicoDirec.put(KeyEvent.VK_UP,Direction.HAUT);
        dicoDirec.put(KeyEvent.VK_RIGHT,Direction.DROITE);
        dicoDirec.put(KeyEvent.VK_DOWN,Direction.BAS);
        JFrame fenetre = new JFrame("Sokoban");
        JMenuBar menuBar = new JMenuBar();
        JMenu retour = new JMenu("Retour");
        JMenu Jeu = new JMenu("Jeu");
        JMenu aPropos = new JMenu("A propos");
        JMenuItem recommencer = new JMenuItem("Recommencer");
        JMenuItem quitter = new JMenuItem("Quitter");
        JMenuItem aProposDe = new JMenuItem("A propos");
        JMenuItem retour2 = new JMenuItem("Retour");
        menuBar.add(retour);
        menuBar.add(Jeu);
        menuBar.add(aPropos);
        retour.add(retour2);
        Jeu.add(recommencer);
        Jeu.add(quitter);
        aPropos.add(aProposDe);
        
        aProposDe.addActionListener(new Propos(fenetre));
        
        
        JPanel barre = new JPanel();
        barre.add(menuBar);

        fenetre.setLayout(new BorderLayout());
        JPanel jeu = new JPanel();
        this.fenetre=fenetre;
        jeu.setLayout(new GridLayout(modele.getNbLignes(),modele.getNbColonnes()));

        tabLabels = new JLabel[modele.getNbLignes()][modele.getNbColonnes()];

        for(int i=0; i<modele.getNbLignes(); i++){
            for(int j=0; j<modele.getNbColonnes(); j++){
                if (modele.getElement(i, j)=='/'){
                    tabLabels[i][j] = new JLabel();
                }else{
                    tabLabels[i][j] = new JLabel(modele.getImageIcon(i,j));
                }
                jeu.add(tabLabels[i][j]);
            }
        }
        retour2.addActionListener(new Retour(modele,tabLabels));
        recommencer.addActionListener(new Recommencer(modele,tabLabels));
        quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        this.score = new JLabel("Score : 0  ");
        JPanel scorePanel = new JPanel();
        scorePanel.add(score);

        fenetre.add(barre,BorderLayout.NORTH);
        fenetre.add(jeu,BorderLayout.CENTER);
        fenetre.add(scorePanel,BorderLayout.SOUTH);

        fenetre.addKeyListener(new ListenerKey(modele,dicoDirec,this));
        fenetre.pack();
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    /** Met à jour la vue */
    public void mettreAJourVue() {
        for (int i = 0; i < modele.getNbLignes(); i++) {
            for (int j = 0; j < modele.getNbColonnes(); j++) {
                if (modele.getElement(i, j) != '/' && modele.getElement(i, j) != '#') {
                    tabLabels[i][j].setIcon(modele.getImageIcon(i, j));
                }
            }
        }   
        mettreAJourScore();     
    }

    /** Met à jour le score */
    public void mettreAJourScore(){
        score.setText("Score : " + modele.getScore());
    }

    /** Reinitialise la vue */
    public void reinitialiserVue(){
        fenetre.dispose();
        VueSokoban nvSokoban = new VueSokoban(modele);
    }

    /** Affiche un message pour la fin du jeu */
    public void afficherMessage(){
        JOptionPane.showMessageDialog(fenetre, "Bravo vous avez terminé le jeu !!!", "Fin de la partie ", JOptionPane.INFORMATION_MESSAGE);
    }


}
