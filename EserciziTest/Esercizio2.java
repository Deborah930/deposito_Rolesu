package EserciziTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio2 {

    public static void main(String[] args) {
        // creazione di un array che contenga gli articoli
        Scanner inputString = new Scanner(System.in);
        ArrayList<String> articoli = new ArrayList<>();
        String elementi;
        // richiesta all'utente di inserimento nome articoli se scrive fine il programma
        // termina
        do {
            System.out.println("Inserisci gli elementi (scrivi fine per completare) : ");
            elementi = inputString.nextLine();
            articoli.add(elementi);
            if (elementi.contains("pane") && elementi.contains("latte")) {
                System.out.println("Hai pensato alla colazione");// se l'utente scrive pane e latte nuova uscita al
                                                                 // video
            }

        } while (!elementi.equalsIgnoreCase("fine"));// condizione di fine programma

        System.out.println("Numero totale elementi inseriti: " + articoli.size());// numero totale di elementi inseriti
                                                                                  // dall'utente
    }
}
