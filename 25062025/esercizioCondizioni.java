
import java.util.Scanner;

public class esercizioCondizioni {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci l'eta: ");

        int eta = input.nextInt();

        Scanner input2 = new Scanner(System.in);
        System.out.print("Hai corso almeno una volta i 100 metri in meno di 12 secondi? : ");

        boolean corsa = input2.nextBoolean();

        Scanner input3 = new Scanner(System.in);
        System.out.print("peso:");
        double peso = input3.nextDouble();
        Scanner input4 = new Scanner(System.in);
        System.out.print("altezza:");
        double altezza = input3.nextDouble();
        double BMI = peso / Math.pow(altezza, 2);

        boolean ammesso = (eta >= 18 && eta <= 40) && (corsa == true) && (BMI < 25);

        if (ammesso) {

            System.out.print("Ammesso alla gara ");
        } else
            System.out.print("Non ammesso alla gara");

    }

}
