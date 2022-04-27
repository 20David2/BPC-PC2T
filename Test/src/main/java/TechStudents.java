package main.java;
import java.util.Calendar;
import java.util.GregorianCalendar;

//studenti technickeho obrou, umi rici, zda je jejich rok narozeni prestupnym rokem
public class TechStudents extends Students implements Technician{

    public TechStudents()
    {
        super();
    }

    public TechStudents(String name, String surname, int year, int month, int day)
    {
        super(name, surname, year, month, day);
    }
    
    //vraci boolean zda je jejich rok narozeni prestupnym rokem podle Gregorianskeho kalendare
    public boolean isLeapYear()
    {
        GregorianCalendar cal = new GregorianCalendar();
        return cal.isLeapYear(dateOfBirth.get(Calendar.YEAR));
    }

    //prepise hodnoty do stringu pripraveneho na zapis do souboru, csv
    public String toFile()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0,"); //identifikator tech
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
