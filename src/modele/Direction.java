package modele;

/** Enumération pour les 4 directions possibles */
public enum Direction{
    HAUT(-1,0),
    BAS(1,0),
    GAUCHE(0,-1),
    DROITE(0,1);

    private int ligne;
    private int colonne;

    /** Constructeur pour l'énumération Direction
     * @param ligne : coordonnée x de déplacement
     * @param colonne : coordonnée y de déplacement
     */
    Direction(int ligne, int colonne){
        this.ligne=ligne;
        this.colonne=colonne;
    }

    /** accesseur pour la direction en ordonnée
     * @return la direction en ordonnée
     */
    public int getLigne(){
        return this.ligne;
    }

    /** accesseur pour la direction en abcisse
     * @return la direction en abcisse
     */
    public int getColonne(){
        return this.colonne;
    }
}
