
public class Student {
	public Student(String jmeno, int rocnik)
	{
		this.jmeno=jmeno;
		this.rocnik=rocnik;
	}
	
	public String getJmeno()
	{
		return jmeno;
	}
	
	public int getRocnik()
	{
		return rocnik;
	}
	
	public float getStudijniPrumer() throws MojeVyjimka {
		
		if(studijniPrumer == 0)
			throw new MojeVyjimka();

		else
			return studijniPrumer;
	}

	public void setStudijniPrumer(float studijniPrumer2) throws MojeVyjimka{
		
		if(studijniPrumer2 >= 1 && studijniPrumer2 <= 5)
			studijniPrumer = studijniPrumer2;
		else
			throw new MojeVyjimka(studijniPrumer2);
	}
	
	private String jmeno;
	private int rocnik;
	private float studijniPrumer;
}