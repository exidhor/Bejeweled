import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jipay on 29/04/2015.
 */
public class ControlMenu implements ActionListener {

    private Vue vue;
    private Model model;
    private boolean hintPressed;

    public ControlMenu(Vue vue, Model model) {
            this.vue = vue;
            this.model = model;
            ajouterActionListener();
            hintPressed = false;
        }

    public void ajouterActionListener()
    {
        vue.ajouterActionListener(this, vue.getMenuNouvellePartie());
        vue.ajouterActionListener(this, vue.getMenuScore());
        vue.ajouterActionListener(this, vue.getHint());
        vue.ajouterActionListener(this, vue.getPause());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vue.getMenuNouvellePartie())
        {
            System.out.println("nouvelle Partie");
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
    }
}
