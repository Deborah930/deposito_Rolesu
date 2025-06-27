import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class EsercizioArrayList {
    public static void main(String[] args) {
        ArrayList<String> nomeStudente = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String nome;
        //DA CORREGGERE PERCHè NON FA INSERIRE ALTRI NOMI!!
        do {
            System.out.println("Inserisci il nome dello studente ,scrivi fine per terminare : ");
            nome = input.nextLine();
            if (nome.equals("fine")) {
                break;
            } else {
                nomeStudente.add(nome);
            }

        } while (nome.equals("nome"));

        Collections.sort(nomeStudente);
        System.out.println("Totale numero studenti inseriti: " + nomeStudente.size());

        System.out.println("Vuoi eliminare uno studente? si/no : ");
        String risposta = input.nextLine();
        if (risposta.equals("si")) {
            System.out.println("Qual'è il nome dello studente da eliminare? :");
            String rimuovi = input.nextLine();
            if (nomeStudente.remove(rimuovi)) {
                System.out.println("Studente rimosso");
            } else {
                System.out.println("Studente non presente");
            }

        }
        input.close();
    }
}
