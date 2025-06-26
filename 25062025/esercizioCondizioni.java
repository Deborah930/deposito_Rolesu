
import java.util.Scanner;

public class EsercizioCondizioni {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci l'eta: ");

        int eta = input.nextInt();
        
        Scanner input2 = new Scanner(System.in);
        System.out.println("Hai corso almeno una volta i 100 metri in meno di 12 secondi? : ");

        boolean corsa = input2.nextBoolean();
       

        Scanner input3 = new Scanner(System.in);
        System.out.println("peso:");
        double peso = input3.nextDouble();
       
        Scanner input4 = new Scanner(System.in);
        System.out.println("altezza:");
        double altezza = input3.nextDouble();
      
        double BMI = peso / Math.pow(altezza, 2);

        boolean ammesso = (eta >= 18 && eta <= 40) && (corsa == true) && (BMI < 25);

        if (ammesso) {

            System.out.println("Ammesso alla gara ");
        } else
            System.out.println("Non ammesso alla gara");

    }

}
