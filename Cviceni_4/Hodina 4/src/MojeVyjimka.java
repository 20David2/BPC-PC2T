public class MojeVyjimka extends java.lang.Exception  // Konstruktor který doplňuje Exception class
{
    public MojeVyjimka()
    {
        super("Nebyl zadan prumer");
    }
    public MojeVyjimka(double prumer)
    {
        super("Prumer nebyl zadan v intervalu 1 az 5.");
    }
}