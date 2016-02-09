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
        controlMenu = new ControlMenu(vue, model);
        controlBoutton = new ControlButton(vue, model, controlMenu);

        vue.setVisible(true);

    }
}

