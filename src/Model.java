import javax.lang.model.element.TypeElement;
import javax.swing.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jipay on 24/04/2015.
 */
public class Model {

    final static Random rand = new Random();

    private TypeBijou[][] tableau;
    private ImageIcon[] typeTexure;
    private ArrayList<Coup> coupsPossibles;
    private int score;
    private int tries;
    private int level;
    private boolean estEnJeu = false;

    public Model() {
        genererTableau();
        reinitialiser();
        initialiserTextures();
    }

    public boolean getEstEnJeu()
    {
        return estEnJeu;
    }

    public void setEstEnJeu(boolean state)
    {
        estEnJeu = state;
    }

    public void reinitialiser()
    {
        score = 0;
        tries = 15;
        level = 1;

    }

    public void genererTableau()
    {
        tableau = new TypeBijou[8][8];
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                tableau[i][j] = randomBijou();
                verificationConstruction(i, j);
            }
        }
        coupsPossibles = unCoupEstPossible();
        for(int i = 0; i < coupsPossibles.size(); i++)
        {
            try
            {
                //System.out.println(coupsPossibles.get(i));
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                //System.out.println("erreur dans coup possible");
            }
        }
    }

    public ArrayList<Coup> getCoupsPossibles()
    {
        return coupsPossibles;
    }

    public void actualiserCoupPossible()
    {
        coupsPossibles = unCoupEstPossible();
    }

    private void initialiserTextures()
    {
        typeTexure =  new ImageIcon[8];

        for (TypeBijou typeBijou : TypeBijou.values()) {
            typeTexure[typeBijou.getIndex()] = new ImageIcon(getPathTexture(typeBijou));
        }

    }

    public ImageIcon[] getTextures()
    {
        return typeTexure;
    }

    public TypeBijou[][] getTableauBijou() {
        return tableau;
    }

    private TypeBijou randomBijou() {
        int pick = rand.nextInt(TypeBijou.values().length);
        return TypeBijou.values()[pick];
    }

    public Coup getUnCoupPossible()
    {
        return coupsPossibles.get(rand.nextInt(coupsPossibles.size()));
    }
    private TypeBijou randomBijou(TypeBijou type1) {
        TypeBijou randPick;
        do
        {
           randPick = this.randomBijou();
        } while(type1 == randPick);

        return randPick;
    }

    public TypeBijou getBijou(Coord p1)
    {
        return tableau[p1.getX()][p1.getY()];
    }

    private TypeBijou randomBijou(TypeBijou type1, TypeBijou type2) {
        TypeBijou randPick;
        do
        {
            randPick = this.randomBijou();
        } while(type1 == randPick || type2 == randPick);

        return randPick;
    }

    public void verificationConstruction(int i, int j) {
        TypeBijou typeColonne = TypeBijou.BLEU;
        boolean estUneColonneCombo = false;
        TypeBijou typeLigne = TypeBijou.BLEU;
        boolean estUneLigneCombo = false;
       if(i >= 2)
       {
           if(estUneColonneCombo(i, j))
           {
               estUneColonneCombo = true;
               typeColonne = tableau[i][j];
               tableau[i][j] = randomBijou(typeColonne);
           }
       }
        if(j >= 2)
        {
            if(estUneLigneCombo(i, j))
            {
                estUneLigneCombo = true;
                typeLigne = tableau[i][j];
                tableau[i][j] = randomBijou(typeLigne);
            }
        }
        if(estUneColonneCombo && estUneLigneCombo)
        {
            tableau[i][j] = randomBijou(typeLigne, typeColonne);
        }

    }

    //parcours la ligne de 3 cases vers la gauche
    //renvoi true si la ligne comporte 3 cases identiques
    public boolean estUneLigneCombo(int abs, int ord)
    {
        return tableau[abs][ord] == tableau[abs][ord-1] && tableau[abs][ord] == tableau[abs][ord-2];
    }

    //parcours la colonne de 3 cases vers le haut
    //renvoi true si la colonne comporte 3 cases identiques
    public boolean estUneColonneCombo(int abs, int ord)
    {
        return tableau[abs][ord] == tableau[abs-1][ord] && tableau[abs][ord] == tableau[abs-2][ord];
    }

    public ArrayList<Coup> unCoupEstPossible()
    {
        ArrayList<Coup> pointsValid = new ArrayList<Coup>();

        TypeBijou currentType;
        //parcours en horizontal
        //System.out.println("Parcours horizontal -------------------------------------");
        for(int i = 0; i < tableau.length; i++)
        {
            currentType = tableau[i][0];

            for(int j = 0; j < tableau[i].length; j++)
            {
                //System.out.println(i + " " + j + " " + "currentType " + currentType );
                if(currentType == tableau[i][j] && j != 0)
                {
                    //System.out.println("current == tab");
                    //point a gauche
                    if(j - 2 >= 0)
                    {
                        //System.out.println("etude point gauche");
                        pointsValid.addAll(trouverCaseDeplacable(new Coord(i, j - 2), Direction.DROITE, currentType));
                    }

                    //point a droite
                    if(j + 1 <= 7)
                    {
                        //System.out.println("etude point droit");
                        pointsValid.addAll(trouverCaseDeplacable(new Coord(i, j + 1), Direction.GAUCHE, currentType));
                    }
                }
                //si jamais disposition en "chapeau"


                //en haut
                if(j + 2 <= 7 && i - 1 >= 0)
                {
                    if(tableau[i][j] == tableau[i-1][j+1] && tableau[i][j] == tableau[i][j+2])
                    {
                        pointsValid.add(new Coup(new Coord(i-1, j+1), new Coord(i, j+1)));
                    }
                }
                //en bas
                if(j + 2 <= 7 && i + 1 <= 7)
                {
                    if(tableau[i][j] == tableau[i+1][j+1] && tableau[i][j] == tableau[i][j+2])
                    {
                        pointsValid.add(new Coup(new Coord(i+1, j+1), new Coord(i, j+1)));
                    }
                }

                currentType = tableau[i][j];
            }
        }

        //System.out.println("Parcours vertical -------------------------------------");
        //parcours en vertical
        for(int j = 0; j < tableau.length; j++)
        {
            currentType = tableau[0][j];
            for(int i = 0; i < tableau.length; i++)
            {
                //System.out.println(i + " " + j + " " + "currentType " + currentType );
                if(currentType == tableau[i][j] && i != 0)
                {
                    //System.out.println("current == tab");
                    //point en haut
                    if(i - 2 >= 0)
                    {
                        //System.out.println("etude point haut");
                        pointsValid.addAll(trouverCaseDeplacable(new Coord(i - 2, j), Direction.BAS, currentType));
                    }

                    //point en bas
                    if(i + 1 <= 7)
                    {
                        //System.out.println("etude point bas");
                        pointsValid.addAll(trouverCaseDeplacable(new Coord(i + 1, j), Direction.HAUT, currentType));
                    }
                }


                //en position chapeau
                //a gauche
                if(j - 1 >= 0 && i + 2 <= 7)
                {
                    //System.out.println("etude gauche possible");
                    if(tableau[i][j] == tableau[i+1][j-1] && tableau[i][j] == tableau[i+2][j])
                    {
                        //System.out.println("point valide");
                        pointsValid.add(new Coup(new Coord(i+1, j-1), new Coord(i+1, j)));
                    }
                }
                //a droite
                if(j + 1 <= 7 && i + 2 <= 7)
                {
                    if(tableau[i][j] == tableau[i+1][j+1] && tableau[i][j] == tableau[i+2][j])
                    {
                        pointsValid.add(new Coup(new Coord(i+1, j+1), new Coord(i+1, j)));
                    }
                }

                currentType = tableau[i][j];
            }
        }
        return pointsValid;
    }

    public ArrayList<Coup> trouverCaseDeplacable(Coord p1, Direction direction, TypeBijou type)
    {
        ArrayList<Coup> resultat = new ArrayList<Coup>();
        //System.out.println("trouverCaseDeplacable");
        if(direction != Direction.HAUT)
        {
            //System.out.println("etude case du haut");
            if(p1.getX() >= 1)
            {
                //System.out.println("case assez loin");
                if(type == tableau[p1.getX() - 1][p1.getY()])
                {
                    //System.out.println("point valide");
                    resultat.add(new Coup(new Coord(p1.getX() - 1, p1.getY()), p1));
                }
            }
        }

        if(direction != Direction.GAUCHE)
        {
            //System.out.println("etude case gauche");
            if(p1.getY() >= 1)
            {
                //System.out.println("case assez loin");
                if(type == tableau[p1.getX()][p1.getY() - 1])
                {
                    //System.out.println("point valide");
                    resultat.add(new Coup(new Coord(p1.getX(), p1.getY() - 1), p1));
                }
            }
        }

        if(direction != Direction.BAS)
        {
            //System.out.println("etude case du bas");
            if(p1.getX() <= 6)
            {
                //System.out.println("case assez loin");
                if(type == tableau[p1.getX() + 1][p1.getY()]) {
                    //System.out.println("point valide");
                    resultat.add(new Coup(new Coord(p1.getX() + 1, p1.getY()), p1));
                }
            }
        }

        if(direction != Direction.DROITE)
        {
            //System.out.println("etude case droite");
            if(p1.getY() <= 6)
            {
                //System.out.println("case assez loin");
                if(type == tableau[p1.getX()][p1.getY() + 1])
                {
                    //System.out.println("point valide");
                    resultat.add(new Coup(new Coord(p1.getX(), p1.getY() + 1), p1));
                }
            }
        }
        //System.out.println("ERREUR dans trouverCaseDeplacable, direction a une valeur invalide");
        return resultat;
    }

    public String getPathTexture(TypeBijou type)
    {
        String path = "img/";
        switch(type)
        {
            case VERT :
                return path + "icon_vert.jpg";
            case ROUGE :
                return path + "icon_rouge.jpg";
            case JAUNE :
                return path + "icon_jaune.jpg";
            case GRIS :
                return path + "icon_blanc.jpg";
            case ORANGE :
                return path + "icon_orange.jpg";
            case VIOLET :
                return path + "icon_noir.jpg";
            case BLEU :
                return path + "icon_bleu.jpg";
            case ROSE :
                return path + "icon_rose.jpg";
            default :
                System.out.println("erreur durant l'attribution du chemin de la texture (getTexturePath(" + type + ")");
                return "";
        }
    }

    public boolean estUnCoupValide(Coup coup)
    {
        for(int i = 0; i < coupsPossibles.size(); i++)
        {
            if(coup.equals(coupsPossibles.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void permut(Coord coord1, Coord coord2)
    {
        TypeBijou tmp = getBijou(coord1);
        tableau[coord1.getX()][coord1.getY()] = getBijou(coord2);
        tableau[coord2.getX()][coord2.getY()] = tmp;
    }

    public ArrayList<ArrayList<Coord> > getLignesCombo()
    {
        ArrayList<ArrayList<Coord> > lignesCombo = new ArrayList<ArrayList<Coord>>();
        ArrayList<Coord> ligne;
        for(int i  = 0; i < tableau.length; i++)
        {
            TypeBijou currentType = tableau[i][0];
            ligne = new ArrayList<Coord>();

            for(int j  = 0; j < tableau[i].length; j++)
            {
                if(tableau[i][j] == currentType)
                {
                    ligne.add(new Coord(i, j));
                }
                else
                {
                    if(ligne.size() >= 3)
                    {
                        lignesCombo.add(new ArrayList<Coord>(ligne));
                    }
                    ligne = new ArrayList<Coord>();
                    ligne.add(new Coord(i, j));
                }
                currentType = tableau[i][j];
            }

            if(ligne.size() >= 3)
            {
                lignesCombo.add(new ArrayList<Coord>(ligne));
            }
        }

        for(int j  = 0; j < tableau[0].length; j++)
        {
            TypeBijou currentType = tableau[0][j];
            ligne = new ArrayList<Coord>();
            for(int i  = 0; i < tableau.length; i++)
            {
                if(tableau[i][j] == currentType)
                {
                    ligne.add(new Coord(i, j));
                }
                else
                {
                    if(ligne.size() >= 3)
                    {
                        lignesCombo.add(new ArrayList<Coord>(ligne));
                    }
                    ligne = new ArrayList<Coord>();
                    ligne.add(new Coord(i, j));
                }
                currentType = tableau[i][j];
            }
            if(ligne.size() >= 3)
            {
                lignesCombo.add(new ArrayList<Coord>(ligne));
            }
        }

        supprimeLigneCombo(lignesCombo);
        return lignesCombo;

    }

    public void supprimeLigneCombo(ArrayList<ArrayList<Coord> > lignesCombo)
    {
        for(int i = 0; i < lignesCombo.size(); i++)
        {
            for(int j = 0; j < lignesCombo.get(i).size(); j++)
            {
                if(lignesCombo.get(i).get(0).getY() != lignesCombo.get(i).get(1).getY())
                    descendreColonne(lignesCombo.get(i).get(j));

                else{
                    descendreColonne(lignesCombo.get(i).get(lignesCombo.get(i).size() - 1));
                }

                System.out.print("LigneCombo (" + lignesCombo.get(i).get(j).getX() + ", " + lignesCombo.get(i).get(j).getY() + ")");
            }
            System.out.print('\n');
        }
    }

    public void descendreColonne(Coord coord)
    {
        for(int i = coord.getX(); i > 0; i--)
        {
            tableau[i][coord.getY()] = tableau[i-1][coord.getY()];
        }
        tableau[0][coord.getY()] = randomBijou();
    }

    //renvoie faux si la partie doit s'arreter
    public boolean enleveUnTrie()
    {
        tries--;
        if(tries > 0)
        {
            return true;
        }

        return false;
    }

    public int getTries()
    {
        return tries;
    }

    public int getScore()
    {
        return score;
    }

    public int getLevel()
    {
        return level;
    }

    public void addScore(int score)
    {
        this.score += score;
    }

    public void upLevel()
    {
        level++;
    }
}