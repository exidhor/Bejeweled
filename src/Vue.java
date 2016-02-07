import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by jipay on 24/04/2015.
 */
public class Vue extends JFrame{

    private Model model;
    private Bijou[][] tableauBijouButton;

    private JMenuBar menuBar;
    private JMenu menuOption;
    private JMenuItem menuScore, menuNouvellePartie;

    public Vue(Model model)
    {
        super();

        initAttribut(model);
        creerMenu();
        drawMap();

        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);

    }

    private void initAttribut(Model model)
    {
        this.model = model;

        tableauBijouButton = new Bijou[model.getTableauBijou().length][model.getTableauBijou()[0].length];
        for(int i = 0; i < model.getTableauBijou().length; i++)
        {
            for(int j = 0; j < model.getTableauBijou()[i].length; j++)
            {
                tableauBijouButton[i][j] = new Bijou(model.getTableauBijou()[i][j], new Coord(i, j));
                tableauBijouButton[i][j].setIcon(model.getTextures()[model.getTableauBijou()[i][j].getIndex()]);
            }
        }

        menuOption = new JMenu("Options");
        menuScore = new JMenuItem("Meilleurs Scores");
        menuNouvellePartie = new JMenuItem("Nouvelle Partie");
    }

    public void drawMap()
    {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(8, 8));
        for(int i = 0; i < tableauBijouButton.length; i++)
        {
            for(int j = 0; j < tableauBijouButton.length; j++)
            {
                contentPane.add(tableauBijouButton[i][j]);
            }
        }
        coloreCoupPossible();
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

        setJMenuBar(menuBar);
    }

    public void ajouterActionListener(ActionListener actionListener, AbstractButton abstractButton)
    {
        abstractButton.addActionListener(actionListener);
    }

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

    public void actualiserCase(Coord coord)
    {
        tableauBijouButton[coord.getX()][coord.getY()].setIcon(model.getTextures()[model.getTableauBijou()[coord.getX()][coord.getY()].getIndex()]);
    }

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

            coloreCoupPossible();
        }
    }

}
