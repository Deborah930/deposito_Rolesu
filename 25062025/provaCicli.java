
import java.util.Scanner;

public class ProvaCicli {
    public static void main(String[] args) {
      
      
      
      
      
        // while
        int i = 1;
        // Inizializzazione della variabile di controllo
        while (i <= 5) {
            i++;// Incremento della variabile di controllo
            System.out.println(i);
        }

        Scanner input = new Scanner(System.in);
        int numero;
        do {
            System.out.print("Inserisci un numero (0 per uscire):");
            numero = input.nextInt();
        } while (numero != 0);

        System.out.println("Hai inserito 0. Programma terminato. ");
    input.close();




    // for

    Scanner scanner = new Scanner(System.in);

    // Richiede un numero all'utente
    System.out.println("Inserisci un numero: ");
    int numero1 = scanner.nextInt();

    // Stampa la tabellina del numero
    System.out.println("Tabellina del "+numero1+":");

    // Ciclo for per moltiplicare il numero da 1 a 10
    for(int j=1;j<=10;j++)
    {
        System.out.println(numero1 + " x" + j + " = " + (numero1 * j));

    }
    scanner.close();







    }
}

