import javax.swing.*;

/**
 * Created by JP on 10/05/2015.
 */
public class TheProgressBar extends Thread {
    private JProgressBar progressBar;
    private float value;
    private Vue vue;

    public TheProgressBar(Vue vue)
    {
        super();
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        value = 50;
        progressBar.setValue((int)value);
        this.vue = vue;
    }

    public JProgressBar getProgressBar()
    {
        return progressBar;
    }

    public void incrementeValue(int value)
    {
        this.value += value;
    }

    public void run()
    {
        while(value > 0)
        {
            value -= vue.getModel().getLevel();
            progressBar.setValue((int)value);

            long t1 = System.currentTimeMillis();
            long t2;

            do {
                t2 = System.currentTimeMillis();
            }while(t2-t1 < 3000);
            /*
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }

        vue.partieEstPerdu(" temps (Barre de progression a 0)");
    }

    public int getValue()
    {
        return (int)value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}
