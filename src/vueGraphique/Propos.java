package vueGraphique;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/** Classe pour afficher un message */
public class Propos extends AbstractAction {

    private Frame fenetre;

    /** Constructeur d'un Propos
     * @param fen : la fenetre du jeu
     */
    public Propos(Frame fen){
        this.fenetre=fen;
    }

    /** Construit le message à afficher */
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(fenetre, "Fait le 03/04/2024 par Manon Davion", "Message caché ", JOptionPane.INFORMATION_MESSAGE);
    }
}