import java.util.Scanner;

public class DatabaseOperation {
    
    public static void main(String[] args) throws Exception {
        
    

    Database database[] = new Database[3];
    
    String jmeno;
    int rok;

    for(int i = 0; i < database.length; i++)
    {
        Scanner reader = new Scanner(System.in);
        System.out.format("Zadejte %d. jmeno: ", i+1);
        jmeno = reader.nextLine();
        System.out.print("Zadejte rok narození osoby " + jmeno + ": ");
        rok = reader.nextInt();

        database[i] = new Database(jmeno, rok);
        //System.out.println(database[i].getName());
        //System.out.println(database[i].getYear());

    }
    Scanner reader = new Scanner(System.in);
    System.out.print("Zadejte maximalni mozny uvazek: ");
    Database.setMaximalniUvazek(reader.nextFloat());


    while(true)
    {
        Scanner reader1 = new Scanner(System.in);
        System.out.print("Zadejte index osoby: ");
        int index = reader1.nextInt();
        System.out.print("Zadejte novou vysi uvazku osoby " + database[index].getName() + ": ");
        float novyUvazek = reader1.nextFloat();
        if(database[index].novyUvazek(novyUvazek))
        {
            System.out.println("Aktualizované údaje osoby:");
            System.out.format("Jmeno: " + database[index].getName() + ", Rok narozeni: %d, Vyse uvazku: %f", database[index].getYear(), database[index].getUvazek());
            System.out.println();
        }
        else
        {
            System.out.println("Tento uvazek presahuje maximalni moznou miru!");
        }

    }
    }
}
