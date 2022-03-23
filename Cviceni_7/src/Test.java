import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;


public class Test {

	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	
	public static float pouzeCisla(Scanner sc) 
	{
		float cislo = 0;
		try
		{
			cislo = sc.nextFloat();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cislo ");
			sc.nextLine();
			cislo = pouzeCisla(sc);
		}
		return cislo;
	}

	public static void main(String[] args) {	
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze(1);
		String jmeno;
		float prumer;
		int volba;
		boolean run=true;
		Student info = null;
		while(run)
		{
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vlozeni noveho studenta");
			System.out.println("2 .. nastaveni prumeru studenta");
			System.out.println("3 .. vypis informace o studentovi");
			System.out.println("4 .. vypis cele databaze");
			System.out.println("5 .. smazani studenta");
			System.out.println("6 .. ukonceni aplikace");
			volba=pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
					try
					{
						mojeDatabaze.setStudent();
					}
					catch (ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Nebylo mozno vytvorit novou polozku, databaze je plna");
					}
					break;
				case 2:
					System.out.println("Zadejte jmeno a prumer studenta");
					jmeno = sc.next();
					prumer = pouzeCisla(sc);
					try
					{
						if(mojeDatabaze.trySetPrumer(jmeno))
							mojeDatabaze.setPrumer(jmeno,prumer);
						else
							System.out.println("Student se zadanym jmenem neni v databazi");
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Vybrana polozka mimo rozsah databaze");
					}
					catch (NullPointerException e)
					{
						System.out.println("Vybrana polozka neexistuje");
					} 
					catch (prumerException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.println("Zadejte jmeno studenta");
					jmeno = sc.next();
					info = null;
					try 
					{	
						if(mojeDatabaze.tryGetStudent(jmeno))
						{
							info=mojeDatabaze.getStudent(jmeno);
							System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
						}
						else
						{
							System.out.println("Student se zadanym jmenem neni v databazi");
						}

					}
					catch (prumerException e)
					{
						System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer nezadan");
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Vybrana polozka mimo rozsah databaze");
					}
					catch (NullPointerException e)
					{
						System.out.println("Vybrana polozka neexistuje");
					}
					break;
				case 4:

					HashMap<String, Student> database = mojeDatabaze.vypisDatabaze();
					info = null;
					Set<String> keys = database.keySet();

					try 
					{	
						for (String key: keys) {
							info=mojeDatabaze.getStudent(key);
							System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
						}

					}
					catch (prumerException e)
					{
						System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer nezadan");
					}					
					
					break;

				case 5:
					System.out.println("Zadejte jmeno studenta");
					jmeno = sc.next();
					if(mojeDatabaze.odstranStudenta(jmeno))
					{
						System.out.println("Student odstranen");
					}
					else
					{
						System.out.println("Student neexistuje");
					}

					break;
				case 6:
					run=false;
					break;

				case 7:
					mojeDatabaze.napln();
				break;
			}
			
		}
	}

}
