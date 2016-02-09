/**
 * Created by jipay on 24/04/2015.
 */
public class Controleur {
    private ControlMenu controlMenu;
    private ControlButton controlBoutton;
    private Vue vue;

    public Controleur(Model model)
    {
        vue = new Vue(model);
<<<<<<< HEAD
        controlMenu = new ControlMenu(vue, model);
        controlBoutton = new ControlButton(vue, model, controlMenu);
=======
        controlBoutton = new ControlButton(vue, model);
        controlMenu = new ControlMenu(vue);
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d

        vue.setVisible(true);

    }
}

