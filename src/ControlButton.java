import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jipay on 29/04/2015.
 */
public class ControlButton implements ActionListener {

    private Vue vue;
    private Model model;
    private Bijou bouton1;
    private boolean bouton1selectionne;
    private Bijou bouton2;

    public ControlButton(Vue vue, Model model) {
        this.vue = vue;
        this.model = model;
        ajouterAllActionListener();
        bouton1 = new Bijou();
        bouton2 = new Bijou();
        bouton1selectionne = false;
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
        System.out.println(e.getSource().toString() + model.getBijou(((Bijou) e.getSource()).getPosition()));
        if(e.getSource().getClass() == bouton1.getClass())
        {
            if(bouton1selectionne && estProche((Bijou)e.getSource()))
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
                    /*try {
                        Thread.sleep(1000);
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

                    /*try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }*/

                    vue.coloreLigneCombo();

                    /*try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }*/

                    model.actualiserCoupPossible();
                    vue.actualiserTableau();

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
}
