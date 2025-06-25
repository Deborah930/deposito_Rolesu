package deposito_Rolesu;

import java.util.Scanner;

public class esercizioWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci la password: ");

        String password = input.nextLine();
        int i = 1;
        while (i <= 3) {
            i++;
            if (password == "java123") {
                Scanner input1 = new Scanner(System.in);
                String conferma;
                do {
                    System.out.println("Vuoi accedere al sistema?  ");
                    conferma = input1.nextLine();

                } while (conferma == "s" || conferma == "n");
                {
                    if (conferma == "s") {
                        System.out.println("Accesso al sistema effettuato");

                    }
                    if (conferma == "n") {
                        System.out.println("Accesso annullato");
                    } else
                        System.out.println("Vuoi accedere al sistema?");
                }
            } else {
                System.out.println("Password sbagliata");
            }
        }
    }
}
