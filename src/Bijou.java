import javax.swing.*;
import java.awt.*;
import java.awt.Window;

/**
 * Created by jipay on 24/04/2015.
 */
public class Bijou extends JButton {

    private TypeBijou type;
    private Coord position;

    public Bijou()
    {

    }

    public Bijou(TypeBijou type, Coord position)
    {
        super();

        //setText(applyTexture(type));
<<<<<<< HEAD
        //setSize(0,0);
=======
        setSize(200, 200);
>>>>>>> a787bfda138c7240827a5684a06dd0bf7425342d
        this.type = type;
        this.position = position;
    }

    public void paintCompenent(Graphics g)
    {
        super.paintComponent(g);
        //g.setColor(Color.RED);
        //g.fillRect(position.getX()*20 + 20,position.getY()*20 + 20, 10, 10);
    }

    public TypeBijou getTypeBijou() { return type; }

    private String applyTexture(TypeBijou type)
    {
        switch(type)
        {
            case ROUGE :
                return "rouge";

            case BLEU :
                return "bleu";

            case VERT :
                return "vert";

            case JAUNE :
                return "jaune";

            case ORANGE :
                return "orange";

            case GRIS :
                return "gris";

            case VIOLET :
                return "violet";

            case ROSE :
                return "rose";

            default :
                return "inconnu";
        }
    }

    public String toString()
    {
        return type + " " + position;
    }

    public Coord getPosition()
    {
        return position;
    }

    public void setType(TypeBijou type)
    {
        this.type = type;
    }
}
