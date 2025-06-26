
import java.util.Scanner;

public class EsercizioFor {
    public static void main(String[] args) {
        // richiesta all'utente quanti voti vuole inserire
        Scanner input = new Scanner(System.in);

        int Numerovoti = 0;

        // ciclo while per validare che il numero sia maggiore di zero

        while (Numerovoti <= 0) {
            System.out.println("Quanti voti vuoi inserire? :");
            Numerovoti = input.nextInt();
            if (Numerovoti <= 0) {
                System.out.println("Inserisci un numero di voti:");
            }

        }
        // ciclo for per inserire ogni voto
        int votoValido = 0;
        for (int i = 0; i < Numerovoti; i++) {
            System.out.println("Inserisci voto:" + (i + 1) + ":");
            int voto = input.nextInt();
            // i voti devono essere tra 0 e 30
            if (voto >= 0 && voto <= 30) {
                votoValido++;// incrementa
                // stampa per il voto tra 18 e 24
                if (voto >= 18 && voto <= 24) {
                    System.out.println("Sufficiente");
                }
                // stampa per il voto maggiore di 24
                if (voto >= 24) {
                    System.out.println("Buono/ Ottimo");
                }
                // stampa del voto se è minore di 18
                else {
                    System.out.println("Insufficiente");
                }

            }
            // stampa se il voto non è compreso tra 18 e 30
            else {
                System.out.println("Voto non valido");
            }
        }
        // stampa dei voti totali validi
        System.out.println("Totale voti validi:" + votoValido);

    }
}
