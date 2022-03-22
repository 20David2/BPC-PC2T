import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Databaze {
	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
	}
	
	public void setStudent()
	{
		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno=sc.next();
		int rok=Test.pouzeCelaCisla(sc);
		prvkyDatabaze[posledniStudent++]=new Student(jmeno,rok);
	}
	
	public Student getStudent(int idx) 
	{
		return prvkyDatabaze[idx];
	}
	
	public void setPrumer(int idx, float prumer) throws prumerException
	{
		prvkyDatabaze[idx].setStudijniPrumer(prumer);
	}

	public String vypisDatabaze()
	{
		StringBuilder str = new StringBuilder();

		for(int i = 0; i < prvkyDatabaze.length; i++)
		{			
			str.append("Jmeno: ");
			str.append(prvkyDatabaze[i].getJmeno());
			str.append(", rok narozeni: ");
			str.append(prvkyDatabaze[i].getRocnik());
			str.append(", studijni prumer: ");
			try
			{
				str.append(prvkyDatabaze[i].getStudijniPrumer());
			}
			catch (prumerException e)
			{
				str.append("nezadan");
			}
			if(i+1 == prvkyDatabaze.length)
			{

			}
			else
			{
				str.append(System.lineSeparator());
			}
		}

		return str.toString();
	}

	public void vypisDatabazeKonzole()
	{
		System.out.println(vypisDatabaze());
	}

	public void vypisDatabazeSoubor()
	{
		System.out.println("Zadejte jmeno souboru: ");
		String fileName=sc.next();

		try{
			FileWriter soubor = new FileWriter(fileName);
			soubor.write(vypisDatabaze());
			soubor.close();
			System.out.println("Uspesne zapsano do souboru.");
		}
		catch (Exception e) {
			System.out.println("Chyba pri zapisu do souboru.");
			System.out.println(e.getMessage());
		}

	}

	public void nacteniDatabazeSoubor()
	{
		System.out.println("Zadejte jmeno souboru: ");
		String fileName=sc.next();
		StringBuilder str = new StringBuilder();

		try
		{
			File soubor = new File(fileName);
			Scanner scanner = new Scanner(soubor);
			while(scanner.hasNextLine()){
				str.append(scanner.nextLine());
				if(scanner.hasNextLine())
				str.append(System.lineSeparator());
			}
			scanner.close();
			naplnDatabazi(str.toString());
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Soubor se zadanym jmenem nenalezen!");

		}
	}

	private void naplnDatabazi(String rawData)
	{
		try{
		String[] radky = rawData.split(System.lineSeparator());
		prvkyDatabaze=new Student[radky.length];
		
			for(int i = 0; i < radky.length; i++)
			{
				String[] radek = radky[i].replace(",", "").split(" ");
				String jmeno = radek[1];
				int rok=Integer.parseInt(radek[4]);
				prvkyDatabaze[i]=new Student(jmeno,rok);
	
				float prumer = Float.parseFloat(radek[7]);
				prvkyDatabaze[i].setStudijniPrumer(prumer);
	
				
			}
			System.out.println("Databaze nactena.");
		}
		catch (Exception e)
		{
			System.out.println("Chyba ve formatovani databaze, zkontrolujte formatovani a zkuste databazi nacist znova!");
			System.out.println(e.getMessage());
		}
		
	}
 

	
	private Scanner sc;
	private Student [] prvkyDatabaze;
	private int posledniStudent;
}