/**
 * Created by jipay on 30/04/2015.
 */
public class Coup {
    private Coord coord1;
    private Coord coord2;

    public Coup(Coord coord1, Coord coord2)
    {
        if(!(coord1.equals(coord2)))
        {
            this.coord1 = coord1;
            this.coord2 = coord2;
        }
        else
        {
            System.out.println("coup invalide");
        }
    }

    public String toString()
    {
        return coord1.toString() + " " + coord2.toString();
    }

    public Coord getCoord1() {
        return coord1;
    }

    public Coord getCoord2() {
        return coord2;
    }

    public boolean equals(Object o)
    {
        if(o == null)
            return false;

        if(!(this.getClass() == o.getClass()))
        {
            return false;
        }

        if(this.coord1.equals(((Coup)o).coord1) || this.coord1.equals(((Coup)o).coord2))
        {
            if(this.coord2.equals(((Coup)o).coord1) || this.coord2.equals(((Coup)o).coord2))
            {
                return true;
            }
        }
        return false;
    }
}
