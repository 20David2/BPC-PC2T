package main.java;
import java.util.Calendar;
import java.util.GregorianCalendar;

//studenti kombinovaneho oboru, kombinuji vlastnosti studentu technickeho i humanitniho oboru
public class CombStudents extends Students implements Technician, Humanitarian {
    
    private static String zodiacSigns[] = new String[]  //viz HumanStudents
        {"Capricornus (Kozoroh)","Aquarius (Vodnar)", "Pisces (Ryby)","Aries(Beran)","Taurus (Byk)","Gemini (Blizenci)","Cancer (Rak)","Leo (Lev)","Virgo (Panna)","Libra (Vahy)","Scorpius (Stir)","Sagittarius (Strelec)","Capricornus (Kozoroh)"};

    private static Calendar dates[][] = new Calendar[][]{   //viz HumanStudents
        {new GregorianCalendar(0, 0, 01),new GregorianCalendar(0, 0, 21),new GregorianCalendar(0, 1, 21),new GregorianCalendar(0, 2, 21),new GregorianCalendar(0, 3, 21),new GregorianCalendar(0, 4, 22),new GregorianCalendar(0, 5, 22),new GregorianCalendar(0, 6, 23),new GregorianCalendar(0, 7, 23),new GregorianCalendar(0,  8, 23),new GregorianCalendar(0,  9, 24),new GregorianCalendar(0, 10, 23),new GregorianCalendar(0, 11, 22)},
        {new GregorianCalendar(0, 0, 20),new GregorianCalendar(0, 1, 20),new GregorianCalendar(0, 2, 20),new GregorianCalendar(0, 3, 20),new GregorianCalendar(0, 4, 21),new GregorianCalendar(0, 5, 21),new GregorianCalendar(0, 6, 22),new GregorianCalendar(0, 7, 22),new GregorianCalendar(0, 8, 22),new GregorianCalendar(0,  9, 23),new GregorianCalendar(0, 10, 22),new GregorianCalendar(0, 11, 21),new GregorianCalendar(0, 11, 31)} 
    };

    public CombStudents()
    {
        super();
    }

    public CombStudents(String name, String surname, int year, int month, int day)
    {
        super(name, surname, year, month, day);
    }

    //viz TechStudents
    public boolean isLeapYear()
    {
        GregorianCalendar cal = new GregorianCalendar();
        return cal.isLeapYear(dateOfBirth.get(Calendar.YEAR));
    }

    //viz HumanStudents
    public String zodiacSign()
    {
        String sign = "";
        int monthOfBirth = dateOfBirth.get(Calendar.MONTH);
        int dayOfBirth = dateOfBirth.get(Calendar.DATE);

        for(int i = 0; i <= 12; i++)
        {
            if(monthOfBirth >= dates[0][i].get(Calendar.MONTH) && monthOfBirth <= dates[1][i].get(Calendar.MONTH)) 
            {
                if(dayOfBirth >= dates[0][i].get(Calendar.DAY_OF_MONTH) || dayOfBirth <= dates[1][i].get(Calendar.DAY_OF_MONTH))
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
        stringBuilder.append("2,"); //identifikator comb
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
