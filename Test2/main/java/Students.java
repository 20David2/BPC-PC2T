package main.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

//abstraktni trida, ze ktere se odvozujou studenti jednotlivych oboru
public abstract class Students implements Comparable<Students> {
    
    protected int ID;
    protected String name;
    protected String surname;
    protected GregorianCalendar dateOfBirth;
    protected ArrayList<Float> marks = new ArrayList<Float>();

    private static int idCount = 0; //skryta promenna pro automaticke prirazovani id studenta
    private Scanner sc;

    //konstruktor tridy
    public Students()
    {
        sc = new Scanner(System.in);
        setName();
        setSurname();
        setDateOfBirth();
        idCount++;
        setID();
    }

    //pretizeny konstruktor pro nacitani ze souboru
    public Students(String name, String surname, int year, int month, int day)
    {
        sc = new Scanner(System.in);
        this.name = name;
        this.surname = surname;
        dateOfBirth = new GregorianCalendar(year, month-1, day);
        idCount++;
        setID();
    }

    //nastavi jmeno studenta(ky), muze nabyvat jakehokoli stringu
    public void setName()
    {
        System.out.println("Zadejte jmeno studenta (studentky):");
		name = sc.nextLine();
    }

    //vrati jmeno studenta(ky)
    public String getName()
    {
        return name;
    }
    
    //nastavi prijmeni studenta(ky), muze nabyvat jakehokoli stringu
    public void setSurname()
    {
        System.out.println("Zadejte prijmeni studenta (studentky):");
		surname = sc.nextLine();
    }

    //vrati prijmeni studenta(ky)
    public String getSurname()
    {
        return surname;
    }

    //nastavi datum narozeni studenta(ky)
    public void setDateOfBirth()
    {
        //obsahuje celkem tri kroky - nejdrive se zadava rok, pote mesic a nakonec den narozeni
        int year = -1, month = -1, day = -1;
        boolean booleanYear = false, booleanMonth = false, booleanDay = false;
        ArrayList<Integer> month31 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12)); //vsechny mesice, ktere maji 31 dni
        ArrayList<Integer> month30 = new ArrayList<>(Arrays.asList(4, 6, 9, 11)); //vsechny mesice, ktere maji 30 dni
        GregorianCalendar cal = new GregorianCalendar(); //instance pro zjisteni, zda je rok prestupny

        //zadani roku narozeni
        System.out.println("Zadejte rok narozeni studenta (studentky):");
        //cyklus opakujici se do naplneni vsech podminek (int, 1500-2500)
        do{
            //overeni, zda je na vstupu int
            while(!sc.hasNextInt())
            {
                System.out.println("Zadejte rok ve formatu 'XXXX' obsahujici pouze cisla!");
                System.out.println("Zadejte rok narozeni studenta (studentky):");
                sc.next();
            }
            
            while(!booleanYear)
            {
                if(sc.hasNextInt())
                {
                    year = sc.nextInt();
                    //overeni, zda je int ze zadaneho intervalu
                    if(year >= 1500 && year <= 2500)
                    {
                        booleanYear = true;
                    }
                    else
                    {
                        System.out.println("Zadejte rok ve formatu 'XXXX' obsahujici pouze cisla od 1500 do 2500!");
                        year = -1;
                        booleanYear = false;
                    }
                }
                
            }
        }while(!booleanYear);
        
        //zadani mesice narozeni
        System.out.println("Zadejte mesic narozeni studenta (studentky):");
        //cyklus opakujici se do naplneni vsech podminek (int, 1-12)
        do{
            //overeni, zda je na vstupu int
            while(!sc.hasNextInt())
            {
                System.out.println("Zadejte mesic ve formatu 'X' obsahujici pouze cisla!");
                System.out.println("Zadejte mesic narozeni studenta (studentky):");
                sc.next();
            }
            
            while(!booleanMonth)
            {
                if(sc.hasNextInt())
                {
                    month = sc.nextInt();
                    //overeni, zda je int ze zadaneho intervalu
                    if(month >= 1 && month <= 12)
                    {
                        booleanMonth = true;
                    }
                    else
                    {
                        System.out.println("Zadejte mesic ve formatu 'X' obsahujici pouze cisla od 1 do 12!");
                        month = -1;
                        booleanMonth = false;
                    }
                }
            }
        }while(!booleanMonth);
        
        //zadani dne narozeni
        System.out.println("Zadejte den narozeni studenta (studentky):");
        //cyklus opakujici se do naplneni vsech podminek (int, 1-31 v zavislosti na zadanem mesici a prestupnem roce)
        do{
            //overeni, zda je na vstupu int
            while(!sc.hasNextInt())
            {
                System.out.println("Zadejte den ve formatu 'X' obsahujici pouze cisla!");
                System.out.println("Zadejte den narozeni studenta (studentky):");
                sc.next();
            }
            
            while(!booleanDay)
            {
                if(sc.hasNextInt())
                {
                    day = sc.nextInt();
                    if(month == 2 && day <= 31 && day >= 1) //Pokud je den z intervalu 1-31 a zaroven je zadany mesic unor
                    {
                        if((cal.isLeapYear(year) && day <= 29) || day <= 28) //Overeni, ze je den mensi nez 28, pripadne 29 v prestupne roky
                        {
                            booleanDay = true;  //ukonceni cyklu
                        }
                        else if(cal.isLeapYear(year)) //pokud je prestupny rok a zadany den je vetsi nez 29
                        {
                            System.out.println("Mesic unor v zadanem roce ma jen 29 dni!");
                            System.out.println("Zadejte den narozeni studenta (studentky):");
                            booleanDay = false;
                        }
                        else    //pokud neni prestupny rok a zadany den je vetsi nez 28
                        {
                            System.out.println("Mesic unor v zadanem roce ma jen 28 dni!");
                            System.out.println("Zadejte den narozeni studenta (studentky):");
                            booleanDay = false;
                        }
                        
                    }
                    else if(day >= 1 && day <= 30 && month != 2)    //pokud mesic neni unor a zaroven je den 1-30
                    {   
                        booleanDay = true;  //ukonceni cyklu
                    }
                    else if (day == 31) //pokud je den 31
                    {
                        if(month31.contains(month)) //kontrola, zda zadany mesic ma 31 dni
                        {
                            booleanDay = true;  //ukonceni cyklu
                        }
                        else if(month30.contains(month))    //pokud ma zadany mesic 30 dni --> opakovani cyklu
                        {
                            System.out.println("Zadany mesic ma jen 30 dni!");
                            System.out.println("Zadejte den narozeni studenta (studentky):");
                            booleanDay = false;
                        }
                    }
                    else    //pri zadani dne mimo rozsah
                    {
                        System.out.println("Zadejte den ve formatu 'X' obsahujici pouze cisla od 1 do 31!");
                        day = -1;
                        booleanDay = false;
                    }
                }
            }
        }while(!booleanDay);

		dateOfBirth = new GregorianCalendar(year, month-1, day);  //naplneni ziskanych hodnot do promenne

    }

    //vrati datum narozeni studenta(ky) ve formatu DD.MM.YYYY
    public String getDateOfBirth()
    {
        return String.format("%d.%d.%d", dateOfBirth.get(Calendar.DATE), dateOfBirth.get(Calendar.MONTH)+1, dateOfBirth.get(Calendar.YEAR));
    }

    //vrati datum narozeni studenta(ky) ve formatu YYYY-MM-DD
    public String getDateOfBirthDB()
    {
        return String.format("%d-%d-%d", dateOfBirth.get(Calendar.YEAR), dateOfBirth.get(Calendar.MONTH)+1, dateOfBirth.get(Calendar.DATE));
    }

    //prida studentovi novou znamku
    public void addMark()
    {
        ArrayList<Float> possibleMarks = new ArrayList<Float>(Arrays.asList(1F, 1.5F, 2F, 2.5F, 3F, 3.5F, 4F, 4.5F, 5F)); //vycet moznach znamek
        boolean booleanMark = false;
        float mark = 0;

        System.out.println("Zadejte novou znamku studenta (studentky):");
        //cyklus opakujici se do doby, nez jsou splneny vsechyn podminky pro zanmku (float + dana hodnota)
        do{
            //kontrola, zda lze ze zadaneho cisla udelat float
            while(!sc.hasNextFloat())
            {
                System.out.println("Zadejte známku obsahujici pouze cisla od 1 do 5 v krocich po 0,5!");
                System.out.println("Zadejte novou znamku studenta (studentky):");
                sc.next();
            }
            
            while(!booleanMark)
            {
                if(sc.hasNextFloat())
                {
                    mark = sc.nextFloat();
                    //kontrola, zda zadana znamka spada do moznych znamek
                    if(possibleMarks.contains(mark))
                    {
                        booleanMark = true;
                    }
                    else
                    {
                        System.out.println("Zadejte známku obsahujici pouze cisla od 1 do 5 v krocich po 0,5!");
                        System.out.println("Zadejte novou znamku studenta (studentky):");
                        mark = 0;
                        booleanMark = false;
                    }
                }
                
            }
        }while(!booleanMark);

        marks.add(mark);
    }

    //prida studentovi novou znamku
    public void addMark(Float mark)
    {
        marks.add(mark);
    }

    public void addMarks(ArrayList<Float> addMarks)
    {
        marks.addAll(addMarks);
    }

    //vrati vsechny znamky jako ArrayList<Float>
    public ArrayList<Float> getMarks()
    {
        return marks;
    }

    //vrati prumer ze znamek studenta(ky) jako Float
    public Float getAverageMark()
    {
        Float average = 0F;
        for (var mark : marks)
        {
            average += mark;
        }
        average /= marks.size();
        
        return average;
    }

    //privatni metoda pro nastaveni ID studenta
    private void setID()
    {
        ID = idCount;
    }

    //vrati id studenta
    public int getID()
    {
        return ID;
    }

    //vrací ID posledního studenta
    public static int getIDCount()
    {
        return idCount;
    }

    //vypise podrobnosti o studentovi do stringu (mimo ID)
    public String toString()
    {
        return String.format("Jmeno: %s, Prijmeni: %s, Rok narozeni: %d, Studijni prumer: %.2f", getName(), getSurname(), dateOfBirth.get(Calendar.YEAR), getAverageMark());
    }

    //vypise podrobnosti o studentovi do stringu (vcetne ID)
    public String toString(int ID)
    {
        return String.format("ID: %d, Jmeno: %s, Prijmeni: %s, Rok narozeni: %d, Studijni prumer: %.2f", getID(), getName(), getSurname(), dateOfBirth.get(Calendar.YEAR), getAverageMark());
    }

    //abstraktni metoda pro zapis do souboru (kazda odvozena trida ma svuj idetifikator - tech = 0, human = 1, comb = 2), 
    abstract String toFile();
    
    //implementace rozhrani comparable pro razeni podle prijmeni
    public int compareTo(Students st)
    {
        return this.getSurname().compareTo(st.getSurname());
    }
}

//interface pro humanitni obor
interface Humanitarian {
    public String zodiacSign();
}

//interface pro technicky obor
interface Technician {
    public boolean isLeapYear();
}
