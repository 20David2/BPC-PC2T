public class Database {
    
    private String Name;
    private int Year;
    private float Uvazek;
    private static float maximalniUvazek = 1;

    public Database(String name, int year)
    {
        Name = name;
        Year = year;
    }

    public String getName()
    {
        return Name;
    }

    public int getYear()
    {
        return Year;
    }

    public float getUvazek()
    {
        return Uvazek;
    }

    public static void setMaximalniUvazek(float newUvazek)
    {
        maximalniUvazek = newUvazek;
    }

    public boolean novyUvazek(float novyUvazek)
    {
        if(novyUvazek+Uvazek >= maximalniUvazek)
        {
            return false;
        }
        else
        {
            Uvazek = Uvazek + novyUvazek;
            return true;
        }
    }

    


}
