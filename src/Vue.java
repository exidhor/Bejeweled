import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Vector;
=======
import java.util.ArrayList;
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d

/**
 * Created by jipay on 24/04/2015.
 */
public class Vue extends JFrame{

    private Model model;
    private Bijou[][] tableauBijouButton;

    private JMenuBar menuBar;
    private JMenu menuOption;
<<<<<<< HEAD
    private JButton hint;
    private JButton pause;
    private JMenuItem menuScore, menuNouvellePartie;

    private JLabel score,level,tries;

    private TheProgressBar progressBar;
    private JPanel contentPane;

=======
    private JMenuItem menuScore, menuNouvellePartie;

>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
    public Vue(Model model)
    {
        super();

        initAttribut(model);
        creerMenu();
        drawMap();

<<<<<<< HEAD
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initAttribut(Model model)
=======
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);

    }

    private void initAttribut(Model model)
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
    {
        this.model = model;

        tableauBijouButton = new Bijou[model.getTableauBijou().length][model.getTableauBijou()[0].length];
        for(int i = 0; i < model.getTableauBijou().length; i++)
        {
            for(int j = 0; j < model.getTableauBijou()[i].length; j++)
            {
                tableauBijouButton[i][j] = new Bijou(model.getTableauBijou()[i][j], new Coord(i, j));
                tableauBijouButton[i][j].setIcon(model.getTextures()[model.getTableauBijou()[i][j].getIndex()]);
<<<<<<< HEAD
                tableauBijouButton[i][j].setBackground(Color.white);
=======
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
            }
        }

        menuOption = new JMenu("Options");
        menuScore = new JMenuItem("Meilleurs Scores");
        menuNouvellePartie = new JMenuItem("Nouvelle Partie");
<<<<<<< HEAD

        hint = new JButton("hint");
        pause = new JButton("pause");

        progressBar = new TheProgressBar(this);

        contentPane = new JPanel();
    }

    public JButton getHint()
    {
        return hint;
    }

    public JButton getPause()
    {
        return pause;
=======
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
    }

    public void drawMap()
    {
<<<<<<< HEAD
        contentPane.removeAll();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        JPanel ligneIndication = new JPanel();
        ligneIndication.setLayout(new GridLayout(1, 3));
        JPanel caseLevel = new JPanel();
        JLabel texteLevel = new JLabel("Level : ");
        caseLevel.add(texteLevel);
        level = new JLabel(String.valueOf(model.getLevel()));
        caseLevel.add(level);
        ligneIndication.add(caseLevel);

        JPanel caseTries = new JPanel();
        JLabel texteTries = new JLabel("Tries : ");
        caseTries.add(texteTries);
        tries = new JLabel(String.valueOf(model.getTries()));
        caseTries.add(tries);
        ligneIndication.add(caseTries);

        JPanel caseScore = new JPanel();
        JLabel texteScore = new JLabel("Score : ");
        caseScore.add(texteScore);
        score = new JLabel(String.valueOf(model.getScore()));
        caseScore.add(score);
        ligneIndication.add(caseScore);

        contentPane.add(ligneIndication);

        JPanel sousContentPane = new JPanel();
        sousContentPane.setLayout(new GridLayout(8, 8));
=======
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(8, 8));
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
        for(int i = 0; i < tableauBijouButton.length; i++)
        {
            for(int j = 0; j < tableauBijouButton.length; j++)
            {
<<<<<<< HEAD
                sousContentPane.add(tableauBijouButton[i][j]);
                tableauBijouButton[i][j].setPreferredSize(new Dimension(60, 60));
            }
        }
        contentPane.add(sousContentPane);

        contentPane.add(progressBar.getProgressBar());

        //coloreCoupPossible();
=======
                contentPane.add(tableauBijouButton[i][j]);
            }
        }
        coloreCoupPossible();
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
        setContentPane(contentPane);
    }

    private void setTexture(JButton button, String path)
    {
        try
        {
            button.setIcon(new ImageIcon(path));
        }
        catch(Exception e)
        {
            System.out.println("Erreur durant le chargement de " + path);
        }

    }

    private void creerMenu()
    {
        menuBar = new JMenuBar();
        menuOption.add(menuNouvellePartie);
        menuOption.add(menuScore);

        menuBar.add(menuOption);
<<<<<<< HEAD
        menuBar.add(pause);
        menuBar.add(hint);
=======
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d

        setJMenuBar(menuBar);
    }

<<<<<<< HEAD
    public void ajouterAllActionListener(ActionListener actionListener)
    {
        for(int i = 0; i < model.getTableauBijou().length; i++) {
            for (int j = 0; j < model.getTableauBijou()[i].length; j++) {
                tableauBijouButton[i][j].addActionListener(actionListener);
            }
        }
    }

public void ajouterActionListener(ActionListener actionListener, AbstractButton abstractButton)
{
    abstractButton.addActionListener(actionListener);
}

=======
    public void ajouterActionListener(ActionListener actionListener, AbstractButton abstractButton)
    {
        abstractButton.addActionListener(actionListener);
    }

>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
    public JMenuItem getMenuScore()
    {
        return menuScore;
    }

    public JMenuItem getMenuNouvellePartie()
    {
        return menuNouvellePartie;
    }

    public Bijou[][] getTableauBijouButton()
    {
        return tableauBijouButton;
    }

    public void coloreCoupPossible()
    {
        ArrayList<Coup> coupsPossibles = model.getCoupsPossibles();

        for(int i = 0; i < coupsPossibles.size(); i++)
        {
            tableauBijouButton[coupsPossibles.get(i).getCoord1().getX()][coupsPossibles.get(i).getCoord1().getY()].setBackground(Color.BLACK);
        }
    }

<<<<<<< HEAD
    public void coloreUnCoupPossible()
    {
        if(model.getCoupsPossibles().size() == 0)
        {
            partieEstPerdu(" coup possible a jouer");
        }

        Coup coupPossible = model.getUnCoupPossible();

        tableauBijouButton[coupPossible.getCoord1().getX()][coupPossible.getCoord1().getY()].setBackground(Color.BLACK);
    }

=======
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
    public void actualiserCase(Coord coord)
    {
        tableauBijouButton[coord.getX()][coord.getY()].setIcon(model.getTextures()[model.getTableauBijou()[coord.getX()][coord.getY()].getIndex()]);
    }

<<<<<<< HEAD
    public ArrayList<ArrayList<Coord> > coloreLigneCombo()
    {
        ArrayList<ArrayList<Coord> > lignesCombo;

        lignesCombo = model.getLignesCombo();
        if(lignesCombo.size() != 0)
        {
            /*
            for (int i = 0; i < lignesCombo.size(); i++) {
                for (int j = 0; j < lignesCombo.get(i).size(); j++) {
                    //tableauBijouButton[lignesCombo.get(i).get(j).getX()][lignesCombo.get(i).get(j).getY()].setBackground(Color.CYAN);
                    tableauBijouButton[lignesCombo.get(i).get(j).getX()][lignesCombo.get(i).get(j).getY()].repaint();
                }
            }*/

            /*
            long time1 = java.lang.System.currentTimeMillis();
            long time2;
            do
            {
                time2 = java.lang.System.currentTimeMillis();
            }while(time1 > time2 + 1000);*/


            for (int i = 0; i < lignesCombo.size(); i++) {
                for (int j = 0; j < lignesCombo.get(i).size(); j++) {
                    tableauBijouButton[lignesCombo.get(i).get(j).getX()][lignesCombo.get(i).get(j).getY()].setBackground(Color.WHITE);
                }
            }
            actualiserTableau();
        }
        return lignesCombo;
=======
    public void coloreLigneCombo()
    {
        ArrayList<ArrayList<Coord> > lignesCombo;
        do {
            lignesCombo = model.getLignesCombo();
            if(lignesCombo.size() != 0)
            {
                for (int i = 0; i < lignesCombo.size(); i++) {
                    for (int j = 0; j < lignesCombo.get(i).size(); j++) {
                        tableauBijouButton[lignesCombo.get(i).get(j).getX()][lignesCombo.get(i).get(j).getY()].setBackground(Color.CYAN);
                    }
                }

                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }*/

                for (int i = 0; i < lignesCombo.size(); i++) {
                    for (int j = 0; j < lignesCombo.get(i).size(); j++) {
                        tableauBijouButton[lignesCombo.get(i).get(j).getX()][lignesCombo.get(i).get(j).getY()].setBackground(Color.WHITE);
                    }
                }
                actualiserTableau();
            }
        } while (lignesCombo.size() > 0);
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
    }

    public void actualiserTableau()
    {
        for(int i = 0; i < tableauBijouButton.length; i++)
        {
            for(int j = 0; j < tableauBijouButton[i].length; j++)
            {
                tableauBijouButton[i][j].setType(model.getTableauBijou()[i][j]);
                tableauBijouButton[i][j].setIcon(model.getTextures()[tableauBijouButton[i][j].getTypeBijou().getIndex()]);

                if(tableauBijouButton[i][j].getBackground() == Color.BLACK)
                {
                    tableauBijouButton[i][j].setBackground(Color.WHITE);
                }
            }

<<<<<<< HEAD
            //coloreCoupPossible();
        }
    }

    public void actualiserTries()
    {
        int nbTries = model.getTries();
        if(nbTries <= 0)
        {
            partieEstPerdu(" trie (essai)");
        }
        tries.setText(String.valueOf(nbTries));
    }

    public void actualiserScore()
    {
        score.setText(String.valueOf(model.getScore()));
    }

    public void actualiserProgres(int progres)
    {
        progressBar.incrementeValue(progres);
    }

    public TheProgressBar getProgressBar()
    {
        return progressBar;
    }

    public void partieEstPerdu(String origineFin)
    {
        boolean newRecord = gestionHighScore();

        StringBuilder message = new StringBuilder();

        message.append("Desole, vous n'avez plus de ");
        message.append(origineFin);
        if(newRecord)
        {
            message.append(", mais vous avez fait un nouveau meilleur score : " + model.getScore());
        }

        JOptionPane optionPane = new JOptionPane();
        JDialog dialog = new JDialog();
        JOptionPane.showMessageDialog(optionPane, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);

        model.genererTableau();
        model.reinitialiser();
        progressBar = new TheProgressBar(this);
        drawMap();
        setVisible(true);
        model.setEstEnJeu(false);
    }

    public Vector<Integer> getHighScore(String chemin)
    {
        BufferedReader reader;
        Vector<Integer> highScores = new Vector<Integer>();
        try {
            reader = new BufferedReader(new FileReader(new File(chemin)));

            do {
                highScores.add(Integer.parseInt(reader.readLine()));
            } while(reader != null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
        }

        return highScores;
    }

    public boolean gestionHighScore()
    {
        String chemin = "HighScore.txt";

        Vector<Integer> highScores = getHighScore(chemin);

        if(highScores.size() != 0 && model.getScore() > highScores.get(highScores.size() - 1) || highScores.size() < 5)
        {
            triTableau(highScores, model.getScore());

            ecrireFichier(chemin, highScores);

            return true;
        }

        return false;
    }

    public Vector<Integer> triTableau(Vector<Integer> tab, int elem)
    {
        for(int i = tab.size() - 1; i > 0; i--)
        {
            if(elem <= tab.get(i))
            {
                if(i == tab.size() - 1)
                {
                    tab.add(elem);
                }
                else
                {
                    tab.insertElementAt(elem, i + 1);
                }
                if(tab.size() > 5)
                {
                    tab.remove(tab.size() - 1);
                }
                return tab;
            }
        }
        tab.insertElementAt(elem, 0);
        if(tab.size() > 5)
        {
            tab.remove(tab.size() - 1);
        }
        return tab;
    }

    public void ecrireFichier(String chemin, Vector<Integer> highScore)
    {
        try
        {
            FileWriter fw = new FileWriter(chemin, false);

            BufferedWriter output = new BufferedWriter(fw);

            for(int i = 0; i < highScore.size(); i++)
            {
                output.write(highScore.get(i).toString());
                output.newLine();
            }

            output.flush();

            output.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public void afficherScore()
    {
        Vector<Integer> highScore = getHighScore("HighScore.txt");

        StringBuilder message = new StringBuilder();
        for(int i = 0; i < highScore.size(); i++)
        {
            message.append(i+1 + " : " + highScore.get(i) + '\n');
        }

        JOptionPane optionPane = new JOptionPane();
        JDialog dialog = new JDialog();
        JOptionPane.showMessageDialog(optionPane, message, "Meilleurs Scores", JOptionPane.INFORMATION_MESSAGE);
    }

    public Model getModel()
    {
        return model;
    }
=======
            coloreCoupPossible();
        }
    }

>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
}
