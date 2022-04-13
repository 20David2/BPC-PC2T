
public class Hranol extends Ctverec{ //překlep 2.

	// konstruktor se zadanim delky hrany, vysky a materialu
	Hranol(float podstava,float vyska, boolean drevena){
		
		super(podstava);		//špatně vytvořený konstruktor odvozené třídy 3.
		this.vyska = vyska;
		zeDreva=drevena;
		pocetHranolu++;
		
	}
	
	// vypocet objemu hranolu
	float vypoctiObjem() {
		return this.vyska*vypoctiObsah();		//chybějící this 5. chyba
	}
	
	// nastaveni materialu
	void setDreveny(boolean dreveny){
		zeDreva=dreveny;
	}
	
	// zjisteni materialu
	boolean jeDreveny(){
		return zeDreva;
	}
	
	// zjisteni celkoveho poctu existujicich kostek
	static int getPocetHranolu(){
		return pocetHranolu;
	}
	
	/*	zbytečné -- už existuje v rodičovské třídě 6.
	// zjisteni vysky hranolu
	float getHrana(){					
		return hrana;
	}
	// nastaveni vysky hranolu
	void setHrana(float delka){			
		hrana=delka;
	}
	*/
		
	private float vyska;
	boolean zeDreva;
	static int pocetHranolu = 0; //není konstanta --> not final, static!	4. chyba	
	
	
}
