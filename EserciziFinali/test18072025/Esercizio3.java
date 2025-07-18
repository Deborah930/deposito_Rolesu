/*Esercizio 3 – Uso dei Design Pattern 
Obiettivo: Applicare uno o più pattern di progettazione.
Immagina un sistema per inviare notifiche.
 Usa il pattern Singleton per la classe NotificationService che gestisce l’invio delle notifiche. 
 Usa il pattern Observer per notificare più utenti (User) ogni volta che viene inviata una nuova notifica. 
 Aggiungi opzionalmente un Factory Method per creare notifiche di tipo Email, SMS, Push, ecc.
 Nel main, simula l'invio di una notifica a più utenti registrati e stampa un messaggio di conferma per ciascuno.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Esercizio3 {

    public static void main(String[] args) {
        Scanner inputI = new Scanner(System.in); // per gli input di  numeri
        Scanner inputS = new Scanner(System.in); // per gli input di stringhe

        Notification service = Notification.getInstance();//richiamo dell'unica istanza fatta con il singleton
        int scelta;

        do {
            System.out.println("--- MENU NOTIFICHE ---");
            System.out.println("1. Registra un nuovo utente");
            System.out.println("2. Invia una notifica");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = inputI.nextInt();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci nome utente: ");
                    String nome = inputS.nextLine();
                    service.registraUtente(new Utente(nome));
                    System.out.println(" Utente registrato.");
                    break;

                case 2:
                    System.out.println("Tipi disponibili: email, whatsapp, telegram");
                    System.out.print("Tipo: ");
                    String tipo = inputS.nextLine();

                    System.out.print("Messaggio: ");
                    String messaggio = inputS.nextLine();

                    Notifica notifica = NotificaFactory.creaNotifica(tipo, messaggio);
                    if (notifica != null) {
                        service.invia(notifica);
                    } else {
                        System.out.println(" Tipo di notifica non valido.");
                    }
                    break;

                case 0:
                    System.out.println("Esci.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        inputI.close();// chiusura di input
        inputS.close();//chiusura di input
    }
}

// interfaccia notifica
public interface Notifica {
    String getMessaggio();
}

// classe di notifica
class EmailNotifica implements Notifica {
    private String messaggio;

    public EmailNotifica(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String getMessaggio() {
        return "EMAIL :" + messaggio;
    }
}

//classe di notifica
class WhatsappNotifica implements Notifica {
    private String messaggio;

    public WhatsappNotifica(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String getMessaggio() {
        return "WHATSAPP: " + messaggio;
    }
}

//classe di notifica
class TelegramNotifica implements Notifica {
    private String messaggio;

    public TelegramNotifica(String messaggio) {
        this.messaggio = messaggio;
    }

    @Override
    public String getMessaggio() {
        return "TELEGRAM: " + messaggio;
    }
}

// Factory Method
class NotificaFactory {
    //creazione delle modalità di notifica
    public static Notifica creaNotifica(String tipo, String messaggio) {
        switch (tipo.toLowerCase()) {
            case "email":
                return new EmailNotifica(messaggio);//creazione email
            case "whatsapp":
                return new WhatsappNotifica(messaggio);//creazione whastapp
            case "telegram":
                return new TelegramNotifica(messaggio); // creazione telegram
            default:
                System.out.println("Modalità di notifica non supportato");
        }
        return null;
    }
}

// Singleton
class Notification {
    private static Notification instance;// istanza
    private List<User> utenti = new ArrayList<>();//array per aggiunta utenti
    //costruttore privato 
    private Notification() {
    }

    public static Notification getInstance() {
        if (instance == null) {
            instance = new Notification();//creazione unica istanza
        }
        return instance;
    }
    //aggiunta utente
    public void registraUtente(User user) {
        utenti.add(user);
    }
    //invia notifiche agli utenti
    public void invia(Notifica notifica) {
        for (User user : utenti) {
            user.riceviNotifica(notifica);
        }
    }
}

// Observer
public interface User {
    void riceviNotifica(Notifica notifica);
}
//classe osservatori
class Utente implements User {
    private String nome;

    public Utente(String nome) {
        this.nome = nome;
    }

    //override del metodo ricevinotifica
    @Override
    public void riceviNotifica(Notifica notifica) {
        System.out.println("→ " + nome + " ha ricevuto: " + notifica.getMessaggio());
    }
}