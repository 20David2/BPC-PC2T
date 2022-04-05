package cz.vutbr.feec.dbconnection;

import java.util.Scanner;

/**
 * Trida slouzici k vyberu uzivatelske volby z konzole
 * 
 * Jiri Prinosil
 * 
 */
public class ConsoleInput {

  public static int readNumberInputFromConsole(Scanner sc) {
    int cislo = 0;
    try {
      cislo = sc.nextInt();
    } catch (Exception e) {
      System.out.println("Nastala vyjimka typu " + e.toString());
      System.out.println("zadejte prosim cele cislo ");
      sc.nextLine();
      cislo = readNumberInputFromConsole(sc);
    }
    return cislo;
  }

}
