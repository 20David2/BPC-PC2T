import java.util.Scanner;

public class Test {
    
    public static void main(String[] args){
    

        BPC1 bpc1 = new BPC1();
        BPC2 bpc2 = new BPC2();
        BPIS bpis = new BPIS();

        
        
        Scanner scanner = new Scanner(System.in);

        //BPC1
        System.out.println("Predmet BPC1:");
        boolean pokracovat = true;
        while(pokracovat)
        {
            System.out.print("Zadejte body ze cviceni: ");
            float points = scanner.nextFloat();
            if(bpc1.addPointsFromExercise(points))
            {
                System.out.println("Body pridany.");
            }
            else
            {
                System.out.println("Body presahly mozne maximum.");
            }

            System.lineSeparator();

            System.out.print("Chcete pokracovat v zadavani bodu ze cviceni? [y/n]: ");

            if(scanner.next().equals("y"))
            {
                pokracovat = true;
            }
            else
            {
                pokracovat = false;
            }
            
        }

        System.lineSeparator();

        pokracovat = true;
        while(pokracovat) {

            System.out.print("Zadejte body ze zkousky: ");
            float points = scanner.nextFloat();
            if(bpc1.setPointsFromFinalExam(points))
            {
                System.out.println("Body pridany.");
                pokracovat = false;
            }
            else
            {
                System.out.println("Body presahly mozne maximum.");
                pokracovat = true;
            }
        }

        System.lineSeparator();
        
        //BPC2
        System.out.println("Predmet BPC2:");

        pokracovat = true;
        while(pokracovat) {

            System.out.print("Zadejte body za projekt: ");
            float points = scanner.nextFloat();
            if(bpc2.setPointsFromProject(points))
            {
                System.out.println("Body pridany.");
                pokracovat = false;
            }
            else
            {
                System.out.println("Body presahly mozne maximum.");
                pokracovat = true;
            }
        }

        pokracovat = true;
        while(pokracovat) {

            System.out.print("Zadejte body za pulsemestralni test: ");
            float points = scanner.nextFloat();
            if(bpc2.setPointsFromExam(points))
            {
                System.out.println("Body pridany.");
                pokracovat = false;
            }
            else
            {
                System.out.println("Body presahly mozne maximum.");
                pokracovat = true;
            }
        }

        pokracovat = true;
        while(pokracovat) {

            System.out.print("Zadejte body za zkousku: ");
            float points = scanner.nextFloat();
            if(bpc2.setPointsFromFinalExam(points))
            {
                System.out.println("Body pridany.");
                pokracovat = false;
            }
            else
            {
                System.out.println("Body presahly mozne maximum.");
                pokracovat = true;
            }
        }

        System.lineSeparator();

        //BPIS

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Predmet BPIS:");
        System.out.print("Zadejte zda student získal zapocet [true]: ");
            
        if(scanner2.nextLine().equals("true"))
        {
            bpis.setCredit(true);
            System.out.println("Zapocet udelet.");
        }
        else
        {
            bpis.setCredit(false);
            System.out.println("Zapocet neudelen.");
        }

        //Shrnuti

        System.lineSeparator();
        System.lineSeparator();

        System.out.print("V predmetu BPC1: ");
        if(bpc1.getCredit() == true)
        {
            System.out.print("zapocet udelen, predmet absolvovan s ");
            System.out.print(bpc1.getPoints());
            System.out.println(" body.");
        }
        else
        {
            System.out.println("zapocet neudelen.");
        }

        System.out.print("V predmetu BPC2: ");
        if(bpc2.getCredit() == true)
        {
            System.out.print("zapocet udelen, predmet absolvovan s ");
            System.out.print(bpc2.getPoints());
            System.out.println(" body.");
        }
        else
        {
            System.out.println("zapocet neudelen.");
        }
        
        
        System.out.print("V predmetu BPIS: ");
        if(bpis.getCredit() == true)
        {
            System.out.println("zapocet udelen.");
        }
        else
        {
            System.out.println("zapocet neudelen.");
        }
    
    }
}
