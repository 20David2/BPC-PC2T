package src;

public class Potravina extends Zbozi {

    private int trvanlivost;

    public Potravina(String nazev, double cenaBezDph, int trvanlivost)
    {
        super(nazev, cenaBezDph);
        this.trvanlivost = trvanlivost;
    }

    public int getTrvanlivost()
    {
        return trvanlivost;
    }

    public void setTrvanlivost(int trvanlivost)
    {
        this.trvanlivost = trvanlivost;
    }

    @Override
    public String getJednotka()
    {
        return "dnu";
    }

}