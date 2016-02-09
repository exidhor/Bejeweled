/**
 * Created by jipay on 26/04/2015.
 */
public class Coord {
    private int x;
    private int y;

    public Coord(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX(){return x;}

    public int getY() {return y;}

    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public String toString()
    {
        return "Point(" + y + ", " + x + ")";
    }

    public boolean equals(Object o)
    {
        if(o == null)
            return false;

        if(!(this.getClass() == o.getClass()))
        {
            return false;
        }

        if(this.x == ((Coord)o).x && this.y == (((Coord)o).y))
        {
           return true;
        }
        return false;
    }
}
