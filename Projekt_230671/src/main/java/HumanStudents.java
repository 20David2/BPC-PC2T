package main.java;
import java.util.Calendar;
import java.util.GregorianCalendar;

//studenti technickeho obrou, umi rici, v jakem znameni zverokruhu se narodili
public class HumanStudents extends Students implements Humanitarian {
 
    
    private static String zodiacSigns[] = new String[] //jmeno znameni
        {"Capricornus (Kozoroh)","Aquarius (Vodnar)", "Pisces (Ryby)","Aries(Beran)","Taurus (Byk)","Gemini (Blizenci)","Cancer (Rak)","Leo (Lev)","Virgo (Panna)","Libra (Vahy)","Scorpius (Stir)","Sagittarius (Strelec)","Capricornus (Kozoroh)"};

    private static Calendar dates[][] = new Calendar[][] //data začátku a konce znameni
    {
        {new GregorianCalendar(0, 0, 01),new GregorianCalendar(0, 0, 21),new GregorianCalendar(0, 1, 21),new GregorianCalendar(0, 2, 21),new GregorianCalendar(0, 3, 21),new GregorianCalendar(0, 4, 22),new GregorianCalendar(0, 5, 22),new GregorianCalendar(0, 6, 23),new GregorianCalendar(0, 7, 23),new GregorianCalendar(0,  8, 23),new GregorianCalendar(0,  9, 24),new GregorianCalendar(0, 10, 23),new GregorianCalendar(0, 11, 22)},
        {new GregorianCalendar(0, 0, 20),new GregorianCalendar(0, 1, 20),new GregorianCalendar(0, 2, 20),new GregorianCalendar(0, 3, 20),new GregorianCalendar(0, 4, 21),new GregorianCalendar(0, 5, 21),new GregorianCalendar(0, 6, 22),new GregorianCalendar(0, 7, 22),new GregorianCalendar(0, 8, 22),new GregorianCalendar(0,  9, 23),new GregorianCalendar(0, 10, 22),new GregorianCalendar(0, 11, 21),new GregorianCalendar(0, 11, 31)} 
    };
    
    public HumanStudents()
    {
        super();
    }

    public HumanStudents(String name, String surname, int year, int month, int day)
    {
        super(name, surname, year, month, day);
    }

    //vrací název znamení zvěrokruhu
    public String zodiacSign()
    {
        String sign = "";
        int monthOfBirth = dateOfBirth.get(Calendar.MONTH); //mesic narozeni studenta
        int dayOfBirth = dateOfBirth.get(Calendar.DATE);    //den narozeni studenta

        for(int i = 0; i <= 12; i++)
        {
            if(monthOfBirth >= dates[0][i].get(Calendar.MONTH) && monthOfBirth <= dates[1][i].get(Calendar.MONTH))  //kontroluje, zda je mesic vetsi nebo roven pocatku znameni a zaroven mensi nebo roven konci znameni
            {
                if(dayOfBirth >= dates[0][i].get(Calendar.DAY_OF_MONTH) || dayOfBirth <= dates[1][i].get(Calendar.DAY_OF_MONTH)) //kontroluje, zda je den vetsi nebo roven zacatku znameni, nebo mensi nebo roven konci znameni
                {
                    sign = zodiacSigns[i];
                    break;
                }
            }
        }
        return sign;
    }

    //prepise hodnoty do stringu pripraveneho na zapis do souboru, csv
    public String toFile()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1,"); //identifikator human
        stringBuilder.append(name);
        stringBuilder.append(",");
        stringBuilder.append(surname);
        stringBuilder.append(",");
        stringBuilder.append(dateOfBirth.get(Calendar.YEAR));
        stringBuilder.append(",");
        stringBuilder.append(dateOfBirth.get(Calendar.MONTH));
        stringBuilder.append(",");
        stringBuilder.append(dateOfBirth.get(Calendar.DAY_OF_MONTH));
        for (Float mark : marks) {
            stringBuilder.append(",");
            stringBuilder.append(mark);
        }

        return stringBuilder.toString();        
    }

}
