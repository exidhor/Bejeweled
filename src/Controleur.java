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
        controlBoutton = new ControlButton(vue, model);
        controlMenu = new ControlMenu(vue);

        vue.setVisible(true);

    }
}

