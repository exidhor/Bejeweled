import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d

/**
 * Created by jipay on 29/04/2015.
 */
public class ControlButton implements ActionListener {

    private Vue vue;
    private Model model;
    private Bijou bouton1;
    private boolean bouton1selectionne;
    private Bijou bouton2;
<<<<<<< HEAD
    private ControlMenu controlMenu;

    public ControlButton(Vue vue, Model model, ControlMenu controlMenu) {
        this.vue = vue;
        this.model = model;
        vue.ajouterAllActionListener(this);
        bouton1 = new Bijou();
        bouton2 = new Bijou();
        bouton1selectionne = false;
        this.controlMenu = controlMenu;
=======

    public ControlButton(Vue vue, Model model) {
        this.vue = vue;
        this.model = model;
        ajouterAllActionListener();
        bouton1 = new Bijou();
        bouton2 = new Bijou();
        bouton1selectionne = false;
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
    }

    private boolean estProche(Bijou bijou2)
    {
        int differenceX = bouton1.getPosition().getX() - bijou2.getPosition().getX();
        int differenceY = bouton1.getPosition().getY() - bijou2.getPosition().getY();
        if(((differenceX == 1 || differenceX == -1) && differenceY == 0) || (differenceX == 0 && (differenceY == -1 || differenceY == 1)))
        {
           return true;
        }
        else
            return false;
    }

    public void actionPerformed(ActionEvent e)
    {
<<<<<<< HEAD
        if(!model.getEstEnJeu())
        {
            vue.getProgressBar().start();
            model.setEstEnJeu(true);
        }

        System.out.println(e.getSource().toString() + model.getBijou(((Bijou) e.getSource()).getPosition()));
        if(e.getSource().getClass() == bouton1.getClass())
        {
            if(bouton1selectionne && estProche((Bijou) e.getSource()))
=======
        System.out.println(e.getSource().toString() + model.getBijou(((Bijou) e.getSource()).getPosition()));
        if(e.getSource().getClass() == bouton1.getClass())
        {
            if(bouton1selectionne && estProche((Bijou)e.getSource()))
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
            {
                bouton2.setBackground(Color.WHITE);
                bouton2 =(Bijou)e.getSource();
                bouton2.setBackground(Color.DARK_GRAY);

                //model.permut(bouton1.getPosition(), bouton2.getPosition());
                //vue.actualiserCase(bouton1.getPosition());
                //vue.actualiserCase(bouton2.getPosition());

                model.actualiserCoupPossible();
                vue.actualiserTableau();

                if(model.estUnCoupValide(new Coup(bouton1.getPosition(), bouton2.getPosition())))
                {
<<<<<<< HEAD
                    controlMenu.setHintPressed(false);
                    /*
                    try {
                        Thread.sleep(500);
=======
                    /*try {
                        Thread.sleep(1000);
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }*/
                    model.permut(bouton1.getPosition(), bouton2.getPosition());
                    vue.actualiserCase(bouton1.getPosition());
                    vue.actualiserCase(bouton2.getPosition());

                    bouton1selectionne = false;
                    bouton1.setBackground(Color.WHITE);
                    bouton2.setBackground(Color.WHITE);
                    //model.actualiserCoupPossible();
                    //vue.coloreCoupPossible();
                    System.out.println("coup valide");

<<<<<<< HEAD
                    /*
                    try {
                        Thread.sleep(500);
=======
                    /*try {
                        Thread.sleep(1000);
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }*/

<<<<<<< HEAD
                    int score = 0;
                    int newScore = 0;
                    int progres = 0;
                    ArrayList<ArrayList<Coord>> lignesCombo;
                    do
                    {
                        lignesCombo = vue.coloreLigneCombo();
                        newScore = compteScore(lignesCombo);
                        score += newScore;
                        progres += compteProgres(lignesCombo);
                    } while(newScore != 0);

                    model.addScore(score);
                    vue.actualiserProgres(progres);
                    vue.actualiserScore();

                    /*
                    try {
                        Thread.sleep(500);
=======
                    vue.coloreLigneCombo();

                    /*try {
                        Thread.sleep(1000);
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }*/

                    model.actualiserCoupPossible();
                    vue.actualiserTableau();

<<<<<<< HEAD
                    if(vue.getProgressBar().getValue() >= 100)
                    {
                        model.genererTableau();
                        model.upLevel();
                        vue.actualiserTableau();
                        vue.drawMap();
                        vue.setVisible(true);
                        vue.getProgressBar().setValue(50);
                    }
                }
                else
                {
                    model.enleveUnTrie();
                    vue.actualiserTries();
=======
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
                }
            }
            else
            {
                bouton1.setBackground(Color.WHITE);
                bouton2.setBackground(Color.WHITE);
                bouton1 = (Bijou)e.getSource();
                bouton1.setBackground(Color.DARK_GRAY);
                bouton1selectionne = true;
            }
        }
    }

<<<<<<< HEAD
    public int compteScore(ArrayList<ArrayList<Coord>> lignesCombo)
    {
        int score = 0;
        for(int i = 0; i < lignesCombo.size(); i++)
        {
            if(lignesCombo.get(i).size() == 3)
            {
                score += 100 * model.getLevel();
            }

            else if(lignesCombo.get(i).size() == 4)
            {
                score += 300 * model.getLevel();
            }

            else if(lignesCombo.get(i).size() >= 5)
            {
                score += 1000 * model.getLevel();
            }
        }

        return score;
    }

    public int compteProgres(ArrayList<ArrayList<Coord>> lignesCombo)
    {
        int progres = 0;
        for(int i = 0; i < lignesCombo.size(); i++)
        {

            if(lignesCombo.get(i).size() == 3)
            {
                progres += 10;
            }

            else if(lignesCombo.get(i).size() == 4)
            {
                progres += 25;
            }

            else if(lignesCombo.get(i).size() >= 5)
            {
                progres += 50;
            }
        }

        return progres;
    }

=======
    private void ajouterAllActionListener()
    {
        for(int i = 0; i < model.getTableauBijou().length; i++)
        {
            for(int j = 0; j < model.getTableauBijou()[i].length; j++)
            {
                vue.ajouterActionListener(this, vue.getTableauBijouButton()[i][j]);
            }
        }
    }
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
}
