import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jipay on 29/04/2015.
 */
public class ControlMenu implements ActionListener {

    private Vue vue;

    public ControlMenu(Vue vue) {
            this.vue = vue;
            ajouterActionListener();
        }

    public void ajouterActionListener()
    {
        vue.ajouterActionListener(this, vue.getMenuNouvellePartie());
        vue.ajouterActionListener(this, vue.getMenuScore());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vue.getMenuNouvellePartie())
        {
            System.out.println("nouvelle Partie");
        }

        else if (e.getSource() == vue.getMenuScore()) {
            System.out.println("Menu Score");
        }
    }
}
