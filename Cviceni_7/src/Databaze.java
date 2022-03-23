import java.util.Scanner;
import java.util.HashMap;

public class Databaze {
	public Databaze(int pocetPrvku)
	{
		database = new HashMap<>();
		sc=new Scanner(System.in);
	}
	
	public void setStudent()
	{
		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno=sc.next();
		int rok=Test.pouzeCelaCisla(sc);
		database.put(jmeno, new Student(jmeno, rok));
	}
	
	public boolean tryGetStudent(String key) 
	{
		if(database.containsKey(key))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public Student getStudent(String key)
	{
		return database.get(key);
	}
	
	public boolean trySetPrumer(String key)
	{
		if(database.containsKey(key))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void setPrumer(String key, float prumer) throws prumerException
	{
		database.get(key).setStudijniPrumer(prumer);
	}

	public HashMap<String, Student> vypisDatabaze()
	{
		return database;
	}
	
	public boolean odstranStudenta(String key)
	{
		if(database.containsKey(key))
		{
			database.remove(key);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private Scanner sc;
	private HashMap<String, Student> database;

	public void napln()
	{
		try
		{
			database.put("David", new Student("David", 2000));
			database.get("David").setStudijniPrumer(1.5F);

			database.put("Martin", new Student("Martin", 1999));
			database.get("Martin").setStudijniPrumer(1.3F);

			database.put("Petr", new Student("Petr", 2002));
			database.get("Petr").setStudijniPrumer(2.2F);

			database.put("Honza", new Student("Honza", 2001));
			database.get("Honza").setStudijniPrumer(1.8F);


		}
		catch (prumerException e)
		{
		}
	}
}