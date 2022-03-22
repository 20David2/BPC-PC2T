package src;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {

		Zbozi[] zbozi = new Zbozi[4];
		zbozi[0] = new Potravina("Rohlik", 1.5 , 1);
		zbozi[1] = new Naradi("Kleste", 278.0 , 24);
	    zbozi[2] = new Potravina("Chleba", 20.8, 6);
		zbozi[3] = new Potravina("Jablko", 51.0, 20);

		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);

		for (int i = 0; i < zbozi.length; i++) {
			System.out.print(zbozi[i].getNazevZbozi() + ", cena: " + df.format(zbozi[i].getCenaDph()));
			if (zbozi[i] instanceof Potravina) {
				Potravina potravina = (Potravina) zbozi[i];
				System.out.println(", " + potravina.getTrvanlivost() + " " + potravina.getJednotka());

			}
			else if(zbozi[i] instanceof Naradi){
				System.out.println();
			}
			else{
				System.out.println();
			}

		}
	}

}