package src;

public class Naradi extends Zbozi {

    private int zaruka;
    
    public Naradi(String nazev, double cenaBezDph, int zaruka)
    {
        super(nazev, cenaBezDph);
        this.zaruka = zaruka;
    }

    public int getZaruka()
    {
        return zaruka;
    }

    public void setZaruka(int zaruka)
    {
        this.zaruka = zaruka;
    }
 
    @Override
    public String getJednotka()
    {
        return "mesicu";
    }
    
}