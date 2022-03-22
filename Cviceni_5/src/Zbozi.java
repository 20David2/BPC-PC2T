package src;

public abstract class Zbozi {

    private String nazevZbozi;
    private double cena;
    private static float dph = 21.0F;

    public Zbozi(String nazev, double cenaBezDph)
    {
        super();
        nazevZbozi = nazev;
        cena = cenaBezDph;
    }

    public void setNazevZbozi(String nazev)
    {
        nazevZbozi = nazev;
    }

    public String getNazevZbozi()
    {
        return nazevZbozi;
    }

    public void setCena(float cenaBezDph)
    {
        cena = cenaBezDph;
    }

    public Double getCenaDph()
    {
        return cena + (cena*(dph/100));
    }

    public abstract String getJednotka();


}