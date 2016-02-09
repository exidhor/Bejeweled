/**
 * Created by jipay on 27/04/2015.
 */
public enum TypeBijou {
    ROUGE(0), BLEU(1) , VERT(2) , JAUNE(3), ORANGE(4), GRIS(5), VIOLET(6), ROSE(7);
    private int index;

    TypeBijou(int index)
    {
        this.index = index;
    }

    int getIndex()
    {
        return index;
    }
}
