package EserciziTest;

import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        // Richiesta all'utente dei dati da inserire
        Scanner inputInt = new Scanner(System.in);
        System.out.println("Qual'è la tua età?:");
        int eta = inputInt.nextInt();
        System.out.println("Quanti anni hai di esperienza?:");
        int esperienza = inputInt.nextInt();
        System.out.println("Quante certificazioni hai ottenuto?:");
        int certificazioni = inputInt.nextInt();

        int totaleAnni = (eta + esperienza);
        System.out.println(totaleAnni);
        // Stampa della radice quadrata di totaleAnni
        System.out.println("totale anni: " + Math.sqrt(totaleAnni));
        // condizioni per poter soddisfare il corso
        boolean verifica = (eta > 18 && esperienza == 2 || certificazioni >= 1 && eta >= 16 && eta <= 18);
        // Verifica se l'utente può accedere a un corso avanzato
        if (verifica == true) {
            System.out.println("Idoneo al corso");
        } else {
            System.out.println("Non idoneo al corso");
        }
    }
}
