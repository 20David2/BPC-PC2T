import java.util.InputMismatchException;
import java.util.Scanner;


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
			System.out.println("Zadejte prosim cele cislo ");
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
			System.out.println("Zadevejte prosim pouze cisla ve formátu 0,0");
			sc.nextLine();
			cislo = pouzeCisla(sc);
		}
		return cislo;
	}

	public static int Vypis(Scanner sc){
		System.out.println("Vyberte pozadovanou cinnost:");
		System.out.println("1 .. vytvoreni nove databaze");
		System.out.println("2 .. vlozeni noveho studenta");
		System.out.println("3 .. nastaveni prumeru studenta");
		System.out.println("4 .. vypis informace o studentovi");
		System.out.println("5 .. ukonceni aplikace");
		return pouzeCelaCisla(sc);
	}

		public static void main(String[] args) {	
		
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze(1);
		int idx;
		float prumer;
		int volba;
		boolean run=true;

		volba=Vypis(sc);

		while(run)
		{
			try {
				
				switch(volba)
				{
					case 1:
						System.out.println("Zadejte pocet studentu");
						mojeDatabaze=new Databaze(pouzeCelaCisla(sc));
						break;

					case 2:
						mojeDatabaze.setStudent();
						break;

					case 3:
						System.out.println("Zadejte index a prumer studenta");
						idx = pouzeCelaCisla(sc);
						prumer = pouzeCisla(sc);
						mojeDatabaze.setPrumer(idx,prumer);
						
						
						break;
					case 4:
						System.out.println("Zadejte index studenta");
						idx = pouzeCelaCisla(sc);
						
							Student info=mojeDatabaze.getStudent(idx);
							System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
						
						break;
					case 5:
						run=false;
						break;
					default:
						System.out.println("Neplatná volba, zadejte znova: \n");
			}



			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Nastala vyjimka typu "+e.toString());
				System.out.println("Musite zadat index v navolenem rozsahu databaze.");
			} catch (NullPointerException e) {
				System.out.println("Nastala vyjimka typu "+e.toString());
				System.out.println("Volaný odkaz v databázi je prázdný.");
			} catch (InputMismatchException e) {
				System.out.println("Nastala vyjimka typu "+e.toString());
				System.out.println("Zadejte hodnotu ve správném datovém typu.");
			} catch (MojeVyjimka v) {
				System.out.println("Nastala vyjimka typu "+v.toString());
			} catch (Exception e) {
				System.out.println("Nastala vyjimka typu "+e.toString());
			} finally {

				if(run)
				{
					System.out.println();
					volba = Vypis(sc);
				}

				idx = 0;
				prumer = 0;
		}

			
			
		}
	}

}
