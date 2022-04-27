package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Test {

    private static ArrayList<Students> students = new ArrayList<>();
    
    //zjisti, zda existuje student se zadanym ID
    public static boolean containsID(ArrayList<Students> students, int ID)
    {
        for (var student : students) 
        {
            if(student.getID() == ID)
            return true;   
        }
        return false;
    }

    //vraci studenta se zadanym ID, nutno volat az po overeni existence studenta!
    public static Students getStudentByID(ArrayList<Students> students, int ID)
    {
        for (var student : students) 
        {
            if(student.getID() == ID)
            return student;
        }
        return new Students(){@Override
        String toFile() {
            return null;
        }};
    }

    //nacte jeden radek csv 
    public static void readFile(String row)
    {
        ArrayList<Float> marks = new ArrayList<Float>();
        String data[] = row.split(","); //rozdeleni podle ,
        switch(data[0])
        {
            case "0":   //techStudents
                students.add(new TechStudents(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5])));
                if(data.length-1 >= 6)
                {
                    for(int i = 6; i<= data.length-1; i++)
                    {
                        marks.add(Float.parseFloat(data[i]));
                    }
                    getStudentByID(students, Students.getIDCount()).addMarks(marks);
                }
            break;
            case "1":   //humanStudents
                students.add(new HumanStudents(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5])));
                if(data.length-1 >= 6)
                {
                    for(int i = 6; i<= data.length-1; i++)
                    {
                        marks.add(Float.parseFloat(data[i]));
                    }
                    getStudentByID(students, Students.getIDCount()).addMarks(marks);
                }
            break;
            case "2":   //combStudents
                students.add(new CombStudents(data[1], data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5])));
                if(data.length-1 >= 6)
                {
                    for(int i = 6; i<= data.length-1; i++)
                    {
                        marks.add(Float.parseFloat(data[i]));
                    }
                    getStudentByID(students, Students.getIDCount()).addMarks(marks);
                }
            break;
        }
    }

    //metoda main
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        boolean proceed = true;
        int choice = 0;
        int ID = 0;
        
        System.out.println("Databaze studentu");

        while(proceed)  //while opakujici se do konce programu
        {
            //switch na vyber akce
            System.out.println(System.lineSeparator() + "Vyberte volbu:");
            System.out.println("(1) Pridat studenta (studentku)");
            System.out.println("(2) Pridat studentovi (studentce) znamku");
            System.out.println("(3) Propustit studenta (studentku)");
            System.out.println("(4) Vypsani studenta (studentky)");
            System.out.println("(5) Spustit dovednost studenta (studentky)");
            System.out.println("(6) Vypis vsech studentu dle abecedy a podle oboru");
            System.out.println("(7) Vypis studijniho prumeru podle oboru");
            System.out.println("(8) Vypis poctu studentu podle oboru");
            System.out.println("(9) Nacteni studentu ze souboru");
            System.out.println("(10) Vypis studentu do souboru");
            System.out.println("(11) Nacteni studentu z databaze");
            System.out.println("(12) Vypis studentu do databaze");
            System.out.println("(13) Ukonceni programu");
            
            //kontrola vstupu do switche
            while(!sc.hasNextInt())
            {
                System.out.println("Zadejte cislo volby ve formatu 'X' obsahujici pouze cela cisla!");
                sc.next();
            }

            choice = sc.nextInt();
            System.out.println();

            switch(choice)  //hlavni napidka
            {
                case 1: //pridani studenta
                    int specialization = 0;
                    System.out.println("Vyberte obor studia:");
                    System.out.println("(1) Technicky obor");
                    System.out.println("(2) Humanitni obor");
                    System.out.println("(3) Kombinovany obor");

                    while(!sc.hasNextInt())
                    {
                        System.out.println("Zadejte cislo volby ve formatu 'X' obsahujici pouze cela cisla!");
                        sc.next();
                    }

                    specialization = sc.nextInt();

                    switch(specialization)  //vyber oboru
                    {
                        case 1:
                            students.add(new TechStudents());
                        break;

                        case 2:
                            students.add(new HumanStudents());
                        break;

                        case 3:
                            students.add(new CombStudents());
                        break;

                        default:
                            System.out.println("Neplatná volba");
                        break;
                    }
                break;
                case 2: //pridani znamky
                    ID = 0;
                    System.out.println("Zadejte ID studenta (studentky):");
                    while(!sc.hasNextInt())
                    {
                        System.out.println("Zadejte ID ve formatu 'X' obsahujici pouze cela cisla!");
                        sc.next();
                    }
                    ID = sc.nextInt();
                    if(containsID(students, ID))
                    {
                        getStudentByID(students, ID).addMark();
                    }
                    else
                    {
                        System.out.println("Neplatne ID studenta (studentky)");
                    }
                break;
                case 3: //smazani studenta
                    ID = 0;
                    System.out.println("Zadejte ID studenta (studentky):");
                    while(!sc.hasNextInt())
                    {
                        System.out.println("Zadejte ID ve formatu 'X' obsahujici pouze cela cisla!");
                        sc.next();
                    }
                    ID = sc.nextInt();
                    if(containsID(students, ID))
                    {
                        students.remove(getStudentByID(students, ID));
                        System.out.println("Student uspesne propusten");
                    }
                    else
                    {
                        System.out.println("Neplatne ID studenta (studentky)");
                    }
                break;
                case 4: //vypsani studenta podle ID
                    ID = 0;
                    System.out.println("Zadejte ID studenta (studentky):");
                    while(!sc.hasNextInt())
                    {
                        System.out.println("Zadejte ID ve formatu 'X' obsahujici pouze cela cisla!");
                        sc.next();
                    }
                    ID = sc.nextInt();
                    if(containsID(students, ID))
                    {
                        System.out.println(getStudentByID(students, ID).toString());
                    }
                    else
                    {
                        System.out.println("Neplatne ID studenta (studentky)");
                    }
                break;
                case 5: //volani dovednosti studenta
                    ID = 0;
                    System.out.println("Zadejte ID studenta (studentky):");
                    while(!sc.hasNextInt())
                    {
                        System.out.println("Zadejte ID ve formatu 'X' obsahujici pouze cela cisla!");
                        sc.next();
                    }
                    ID = sc.nextInt();
                    if(containsID(students, ID))
                    {
                        Students student = getStudentByID(students, ID);

                        if(student instanceof TechStudents) //pokud je student technickeho oboru, vypise prestupny rok
                        {
                            if(((TechStudents) student).isLeapYear())
                            {
                                System.out.printf("Rok narozeni studenta (studentky) %s %s je prestupny.", student.getName(), student.getSurname());
                            }
                            else
                            {
                                System.out.printf("Rok narozeni studenta (studentky) %s %s neni prestupny.", student.getName(), student.getSurname());
                            }
                            
                        }
                        else if(student instanceof HumanStudents)   //pokud je student humanitniho oboru, vypise sve znameni zverokruhu
                        {
                            System.out.printf("Znameni zverokruhu studenta (studentky) %s %s je %s.", student.getName(), student.getSurname(), ((HumanStudents) student).zodiacSign() );
                        }
                        else if(student instanceof CombStudents)    //pokud je student kombinovaneho oboru, vypise prestupny rok a znameni zverokruhu
                        {
                            if(((CombStudents) student).isLeapYear())
                            {
                                System.out.printf("Rok narozeni studenta (studentky) %s %s je prestupny.", student.getName(), student.getSurname());
                            }
                            else
                            {
                                System.out.printf("Rok narozeni studenta (studentky) %s %s neni prestupny.", student.getName(), student.getSurname());
                            }
                            System.out.print(System.lineSeparator());
                            System.out.printf("Znameni zverokruhu studenta (studentky) %s %s je %s.", student.getName(), student.getSurname(), ((CombStudents) student).zodiacSign() );
                        }
                        System.out.print(System.lineSeparator());
                    }
                    else
                    {
                        System.out.println("Neplatne ID studenta (studentky)");
                    }
                break;
                case 6: //vypis studentu dle abecedy a oboru --> nepouziti TreeSet kvůli duplikaci klice
                    do{
                        ArrayList<TechStudents> techStudents = new ArrayList<>();
                        ArrayList<HumanStudents> humanStudents = new ArrayList<>();
                        ArrayList<CombStudents> combStudents = new ArrayList<>();

                        for (Students student : students) {
                            if(student instanceof TechStudents)
                            {
                                techStudents.add((TechStudents)student);
                            }
                            if(student instanceof HumanStudents)
                            {
                                humanStudents.add((HumanStudents)student);
                            }
                            if(student instanceof CombStudents)
                            {
                                combStudents.add((CombStudents)student);
                            }
                        }

                        Collections.sort(techStudents);
                        Collections.sort(humanStudents);
                        Collections.sort(combStudents);

                        System.out.println("Studenti technickeho oboru:");
                        for (TechStudents techStudent : techStudents) {
                            System.out.println(techStudent.toString(ID));
                        }

                        System.out.println();

                        System.out.println("Studenti humanitniho oboru:");
                        for (HumanStudents humanStudent : humanStudents) {
                            System.out.println(humanStudent.toString(ID));
                        }

                        System.out.println();

                        System.out.println("Studenti kombinovaneho oboru:");
                        for (CombStudents combStudent : combStudents) {
                            System.out.println(combStudent.toString(ID));
                        }
                    }while(false);
                break;
                case 7: //vypocet a vypsani studijniho prumeru v jednotlivych oborech
                    do{
                        TreeMap<Integer, TechStudents> techStudents = new TreeMap<>();
                        TreeMap<Integer, HumanStudents> humanStudents = new TreeMap<>();
                        TreeMap<Integer, CombStudents> combStudents = new TreeMap<>();
                        Float averageTech = 0F;
                        Float averageHuman = 0F;
                        Float averageComb = 0F;

                        //rozdeleni studentu do oboru
                        for (Students student : students) {
                            if(student instanceof TechStudents)
                            {
                                techStudents.put(student.getID(), (TechStudents)student);
                            }
                            if(student instanceof HumanStudents)
                            {
                                humanStudents.put(student.getID(), (HumanStudents)student);
                            }
                            if(student instanceof CombStudents)
                            {
                                combStudents.put(student.getID(), (CombStudents)student);
                            }
                        }

                        //vypocet a vypsani prumeru v jednotlivych oborech
                        for (TechStudents techStudent : techStudents.values()) {
                            averageTech += techStudent.getAverageMark();
                        }
                        System.out.printf("Prumer studentu technickeho oboru: %.2f", averageTech/techStudents.size());
                        System.out.print(System.lineSeparator());

                        for (HumanStudents humanStudent : humanStudents.values()) {
                            averageHuman += humanStudent.getAverageMark();
                        }
                        System.out.printf("Prumer studentu humanitniho oboru: %.2f", averageHuman/humanStudents.size());
                        System.out.print(System.lineSeparator());

                        for (CombStudents combStudent : combStudents.values()) {
                            averageComb += combStudent.getAverageMark();
                        }
                        System.out.printf("Prumer studentu kombinovaneho oboru: %.2f", averageComb/combStudents.size());
                        System.out.print(System.lineSeparator());
                    }while(false);
                break;
                case 8: //vypise pocet studentu v jednotlivych oborech (nestaci staticky promenne pro kazdou skupinu kvuli moznosti odstranovani studentu --> slozite)
                    do{
                        TreeMap<Integer, TechStudents> techStudents = new TreeMap<>();
                        TreeMap<Integer, HumanStudents> humanStudents = new TreeMap<>();
                        TreeMap<Integer, CombStudents> combStudents = new TreeMap<>();

                        //rozdeleni studentu do skupin
                        for (Students student : students) {
                            if(student instanceof TechStudents)
                            {
                                techStudents.put(student.getID(), (TechStudents)student);
                            }
                            if(student instanceof HumanStudents)
                            {
                                humanStudents.put(student.getID(), (HumanStudents)student);
                            }
                            if(student instanceof CombStudents)
                            {
                                combStudents.put(student.getID(), (CombStudents)student);
                            }
                        }

                        //vypsani poctu studentu v kazde skupine
                        System.out.printf("Pocet studentu technickeho oboru: %d", techStudents.size());
                        System.out.print(System.lineSeparator());
                        System.out.printf("Pocet studentu humanitniho oboru: %d", humanStudents.size());
                        System.out.print(System.lineSeparator());
                        System.out.printf("Pocet studentu kombinovaneho oboru: %d", combStudents.size());
                        System.out.print(System.lineSeparator());

                    }while(false);
                break;
                case 9: //nacteni dat ze souboru
                    do{
                        //zadani jmena souboru
                        System.out.println("Zadejte jmeno souboru: ");
                        String fileName=sc.next();
                        
                        //pokusi se nacist ze souboru, pripadne vypise chybu
                        try 
                        {
                            File soubor = new File(fileName);
                            Scanner scanner = new Scanner(soubor);
                            while(scanner.hasNextLine()){
                                readFile(scanner.nextLine());
                            }
                            scanner.close();
                            System.out.println("Uspesne nacteno.");;
                        }
                        catch (FileNotFoundException e)
                        {
                            System.out.println("Soubor se zadanym jmenem nenalezen!");
                
                        }
                    }while(false);
                break;
                case 10://vypsani dat do souboru
                    do{
                        System.out.println("Zadejte jmeno souboru: ");
                        String fileName=sc.next();
                
                        try{
                            FileWriter file = new FileWriter(fileName);
                            for (var student : students) {
                                file.write(student.toFile()+System.lineSeparator());
                            }
                            file.close();
                            System.out.println("Uspesne zapsano do souboru.");
                        }
                        catch (Exception e) {
                            System.out.println("Chyba pri zapisu do souboru.");
                            System.out.println(e.getMessage());
                        }
                    }while(false);
                break;
                case 11:
                    DBConnection.getDBConnection();
                break;
                case 12:

                break;
                case 13:
                    proceed = false;
                    System.out.println("Konec programu");
                break;
            }
        }

        sc.close();
    }
}