import java.util.Scanner;

public class Pole {

	// Konstruktor s velikosti pole
	Pole(int velikost)
	{
		mojeHranoly = new Hranol[velikost];
		sc=new Scanner(System.in);
	}
	
	// vlozeni hranolu do pole na prvni volnou pozici
	void zadejHranol(){
		boolean drevena=false;
		float delka=0;
		float vyska=0;
		System.out.println("Zadejte delku podstavy hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		delka=sc.nextFloat();
		System.out.println("Zadejte vysku hranolu");
		while(!sc.hasNextFloat())
		{
			sc.next();
		}
		vyska=sc.nextFloat();
		System.out.println("Je drevena?");
		while(!sc.hasNextBoolean())		//hasnextBoolean 7.
		{
			sc.next();
		}
		drevena=sc.nextBoolean();
		if (Hranol.getPocetHranolu()>mojeHranoly.length)
		{
			System.out.println("Pole uz je zaplneno");
			return;
		}
		//mojeHranoly[Hranol.getPocetHranolu()].setHrana(delka);			
		//mojeHranoly[Hranol.getPocetHranolu()].setHrana(vyska);
		//mojeHranoly[Hranol.getPocetHranolu()].setDreveny(drevena);
		mojeHranoly[Hranol.getPocetHranolu()] = new Hranol(delka, vyska, drevena); //inicializace objektu pomocí kontstruktoru 8.
	}	
	
	// vypis objemu vsech hranolu
	void vypoctiObjem()
	{
		for (int i=0;i<Hranol.getPocetHranolu();i++)
		{	//System.out.println("Objem i. hranolu je" + mojeHranoly[i].vypoctiObsah());
			System.out.printf("Objem %d hranolu je %f%n", i, mojeHranoly[i].vypoctiObjem()); 	//špatné formátování řetězce v i. 9., prohozené Obsah a objem 10.
		}	
	}
	
	// vypis obsahu podstavy vsech hranolu
	void vypoctiObsahPodstavy()
	{
		for (int i=0;i<Hranol.getPocetHranolu();i++)
			System.out.printf("Obsah podstavy %d hranolu je %d%n", i, mojeHranoly[i].vypoctiObsah()); 	// same as vypoctiObjem()
	}
	
	// nalezeni indexu nejmensiho hranolu
	int najdiNejmensiObjem()
	{
		float min = Float.MAX_VALUE;	 //pokud je min 0, nic nebude menší			11.					
		int idx=0;										
		for (int i=0;i<Hranol.getPocetHranolu();i++)
		{
			if (mojeHranoly[i].vypoctiObjem() < min){
				min=mojeHranoly[i].vypoctiObjem();
				idx=i;
			}
		}
		return idx;
	}
	
	// zjisteni celkoveho poctu drevenych kostek
	int zjistiPocetDrevenych(){
		int pocetDrevenych=0;
		for (int i=0;i<mojeHranoly.length;i++)				//	i = 0, i<moje hranoly 12.
		{
			if (mojeHranoly[i].zeDreva==true)				// = místo == 13.
				pocetDrevenych++;
		}
		return pocetDrevenych;
	}

	private Scanner sc;
	private Hranol []mojeHranoly;
}
