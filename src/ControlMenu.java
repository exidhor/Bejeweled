import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jipay on 29/04/2015.
 */
public class ControlMenu implements ActionListener {

    private Vue vue;
<<<<<<< HEAD
    private Model model;
    private boolean hintPressed;

    public ControlMenu(Vue vue, Model model) {
            this.vue = vue;
            this.model = model;
            ajouterActionListener();
            hintPressed = false;
=======

    public ControlMenu(Vue vue) {
            this.vue = vue;
            ajouterActionListener();
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
        }

    public void ajouterActionListener()
    {
        vue.ajouterActionListener(this, vue.getMenuNouvellePartie());
        vue.ajouterActionListener(this, vue.getMenuScore());
<<<<<<< HEAD
        vue.ajouterActionListener(this, vue.getHint());
        vue.ajouterActionListener(this, vue.getPause());
=======
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vue.getMenuNouvellePartie())
        {
            System.out.println("nouvelle Partie");
<<<<<<< HEAD
            model.genererTableau();
            model.reinitialiser();
            vue.actualiserTableau();
            vue.drawMap();
            vue.setVisible(true);
        }

        else if (e.getSource() == vue.getMenuScore()) {
            vue.afficherScore();
        }

        else if(e.getSource() == vue.getHint() && !hintPressed)
        {
            System.out.println("Hint");
            vue.coloreUnCoupPossible();
            hintPressed = true;
        }

        else if(e.getSource() == vue.getPause())
        {
            System.out.println("Pause");
        }
    }

    public void setHintPressed(boolean state)
    {
        hintPressed = state;
=======
        }

        else if (e.getSource() == vue.getMenuScore()) {
            System.out.println("Menu Score");
        }
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
    }
}
