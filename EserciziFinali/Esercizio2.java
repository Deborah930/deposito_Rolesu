import java.util.Scanner;
/*Esercizio 2: Sistema di Pagamento E-commerce
Simula un checkout con metodi di pagamento differenti (Carta,
PayPal, Crypto).
Usa Factory Method per creare il tipo corretto di pagamento.
Usa Facade per nascondere la complessità del processo di
pagamento.
 * 
 */

public class Esercizio2 {

    public static void main(String[] args) {
        Scanner inputI = new Scanner(System.in);
        Scanner inputS = new Scanner(System.in);
        Scanner inputD = new Scanner(System.in);
        PagamentoFacade facade = new PagamentoFacade();// creazione di un oggetto facade per nascondere tutto il
                                                       // procedimento
        while (true) {
            System.out.println("=== Pagamento E-commerce ===");
            System.out.println("Scegli metodo di pagamento:");
            System.out.println("1. Carta");
            System.out.println("2. PayPal");
            System.out.println("3. Crypto");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            int scelta = inputI.nextInt();
            if (scelta == 0)
                break;
            System.out.println("Inserisci importo: ");
            double importo = inputD.nextDouble();
            switch (scelta) {
                case 1:
                    facade.eseguiPagamento("carta", importo);
                    break;
                case 2:
                    facade.eseguiPagamento("paypal", importo);
                    break;
                case 3:
                    facade.eseguiPagamento("crypto", importo);
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }
            // messaggio di uscita
            System.out.println(" Grazie e arrivederci!");
        }
    }
}

// interfaccia per implementare il metodo paga in ogni classe
interface Pagamento {
    void paga(double importo);
}

// pagamento con carta
class PagamentoCarta implements Pagamento {
    public void paga(double importo) {
        System.out.println("Pagamento di " + importo + " € " + " :pagamento con carta ");
    }
}

// pagamento con paypal

class PagamentoPaypal implements Pagamento {
    public void paga(double importo) {
        System.out.println("Pagamento di " + importo + "€" + " :pagamento con paypal");
    }
}

// pagament con crypto
class PagamentoCrypto implements Pagamento {
    public void paga(double importo) {
        System.out.println("Pagamento di " + importo + "€" + " :pagamento con crypto");
    }
}

// factory method
// crea un oggetto del tipo che si sceglie (carta,paypal o crypto)
class PagamentoFactory {
    public static Pagamento creaPagamento(String tipo) {
        switch (tipo) {
            case "carta":
                return new PagamentoCarta();

            case "paypal":
                return new PagamentoPaypal();

            case "crypto":
                return new PagamentoCrypto();

            default:
                System.out.println("Metodo di pagamento non accettato");

        }
        return null;
    }
}

// facade
class PagamentoFacade {
    public void eseguiPagamento(String tipo, double importo) {
        // richiamo il metodo di pagamento della factory
        Pagamento metodo = PagamentoFactory.creaPagamento(tipo);
        // se il metodo è diverso da null allora chiama il metodo paga
        if (metodo != null) {
            metodo.paga(importo);
            System.out.println("Pagamento completato con successo.");
        } else {
            System.out.println("Errore durante il pagamento: metodo non valido.");// se si interisce un tipo sbagliato
        }
    }
}
