import javax.swing.*;

/**
 * Created by JP on 10/05/2015.
 */
public class LigneCombo extends Thread {

    public LigneCombo()
    {
        super();
    }

    public void run(JButton j)
    {
        j.repaint();
    }
}
