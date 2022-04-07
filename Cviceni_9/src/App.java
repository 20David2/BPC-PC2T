package src;

import java.util.*;

import src.Animals.*;
import src.AnimalsImpl.*;
import java.io.*;

public class App {

    public static void listToConsole(List<Employee> list)
    {
        
        for (Employee employee : list) {
            System.out.print(employee.getNickname());
            System.out.print( ", ");
            System.out.print(employee.getEmail());
            System.out.print(", ");
            System.out.print(employee.getPassword());

            if(employee instanceof Secretarian)
            {
                System.out.print(", ");
                System.out.print(((Secretarian)employee).getAge());
            }

            System.out.print(System.lineSeparator());
        }
    }

    public static String listAToString(List<Animal> list)
    {
        String text = "";
        for (Animal animal : list) {
            text += animal.sound();
            text += System.lineSeparator();
        }
        return text;
    }

    public static void animalToFile(List<Animal> list, String fileName)
    {
        try{
			FileWriter soubor = new FileWriter(fileName);
			soubor.write(listAToString(list));
			soubor.close();
			System.out.println("Uspesne zapsano do souboru.");
		}
		catch (Exception e) {
			System.out.println("Chyba pri zapisu do souboru.");
			System.out.println(e.getMessage());
		}
    }
    
    /*
        Abstract class - můžeme definovat "obyčejné" i abstraktní metody a členy
        Interface - všechny metody musí být abstraktní

        enum - pokud máme daný předem známý neměnný výběr, nemůže nabývat jiných hodnot než jaké jsou v něm vyčteny
    */

    public static void main(String [] args)
    {
        char[] password = {'a', 'b', 'c'};
        Employee e1 = new Employee("Employee 1","Employee1@email.com",password);
        Employee e2 = new Employee("Employee 2","Employee2@email.com",password);
        Employee e3 = new Employee("Employee 3","Employee3@email.com",password);
        Employee e4 = new Employee("Employee 4","Employee4@email.com",password);
        Employee e5 = new Employee("Employee 5","Employee5@email.com",password);
        Manager m1 = new Manager("Manager 1","Manager1@email.com",password);
        Secretarian s1 = new Secretarian("Secretarian 1","Secretarian1@email.com",password, 25);
        Secretarian s2 = new Secretarian("Secretarian 2","Secretarian2@email.com",password, 23);

        m1.addEmployee(e1);
        m1.addEmployee(e2);
        m1.addEmployee(e3);
        m1.addEmployee(e4);
        m1.addEmployee(e5);

        m1.addRelationship(s1);

        listToConsole(m1.getListOfEmployees());

        System.out.println();

        listToConsole(m1.getListOfRelationships());

        System.out.println();

        List<AbstractAnimal> abstractAnimals = new ArrayList<AbstractAnimal>(Arrays.asList(new Cat((byte)5), new Cow((byte)3), new Dog((byte)3), new Goat((byte)5), new Pig((byte)3)));

        for (AbstractAnimal abstractAnimal : abstractAnimals) {
            System.out.println(abstractAnimal.sound());
        }

        System.out.println();

        List<Animal> animalsImpl = new ArrayList<Animal>(Arrays.asList(new CatImpl((byte)5), new CowImpl((byte)3), new DogImpl((byte)3), new GoatImpl((byte)5), new PigImpl((byte)3)));

        for (Animal animal : animalsImpl) {
            System.out.println(animal.sound());
        }

        System.out.println();

        animalToFile(animalsImpl, "animals.txt");

        System.out.println();

        System.out.println(m1.toString());

        System.out.println();

        if(m1.compareTo(s1) > 0)
        {
            System.out.printf("%s is bigger than %s", m1.getEmail(), s1.getEmail());
        } else if(m1.compareTo(s1) < 0)
        {
            System.out.printf("%s is smaller than %s", m1.getEmail(), s1.getEmail());
        }else{
            System.out.printf("%s is same as %s", m1.getEmail(), s1.getEmail());
        }

    }
}
