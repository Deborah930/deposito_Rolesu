import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioHamburgheria {
    public static void main(String[] args) {
        Scanner inputS = new Scanner(System.in);// Scanner per le stringhe
        Scanner inputI = new Scanner(System.in);// Scanner per gli interi
        ArrayList<Hamburger> ordine = new ArrayList<>();// arrayList dell'oggetto Hamburger
        boolean continua = true;// boolean che fa si che il while sia sempre in true e quindi continui a ciclare

        // Menù per la scelta dell'hamburger
        // Ogni volta si aprirà un menù dove richiede la scelta dell'opzione da eseguire
        // e in input si sceglie dove entrare nel case
        // Ogni numero fa una cosa diversa:
        // 1 aggiunge un Cheeseburger all' arrayList ordine
        // 2 aggiunge un VegBurger all' arrayList ordine
        // 3 aggiunge un DoubleBacon all'arrayList ordine
        // 4 fa visualizzare l'arrayList ordine e il metodo prepara() di quel panino
        // 0 fa uscire dal menù e visualizza un messaggio di fine "Grazie per aver ordinato, arrivederci!"
        while (continua) {
            System.out.println("\n--- MENU HAMBURGERIA ---");
            System.out.println("1. Cheeseburger");
            System.out.println("2. VegBurger");
            System.out.println("3. DoubleBacon");
            System.out.println("4. Visualizza ordine e prepara");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = inputI.nextInt();
            switch (scelta) {//entrerà in un case diverso a seconda di cosa si è digitato (1,2,3,4,0)
                case 1:
                    ordine.add(new Cheeseburger());// aggiunge un Cheeseburger
                    System.out.println("Cheeseburger aggiunto all'ordine.");
                    break;
                case 2:
                    ordine.add(new VegBurger());// aggiunge un VegBurger
                    System.out.println("VegBurger aggiunto all'ordine.");
                    break;
                case 3:
                    ordine.add(new DoubleBacon());// aggiunge un DoubleBacon
                    System.out.println("DoubleBacon aggiunto all'ordine.");
                    break;
                case 4:
                    System.out.println("\n--- Preparazione Ordine ---");
                    for (Hamburger h : ordine) {// usa il metodo prepara per quel panino selezionato
                        h.prepara();
                    }
                    ordine.clear();// pulisce l'array
                    break;
                case 0:
                    continua = false;// chiude il menù
                    break;
                default:
                    System.out.println("Scelta non valida.");// nel caso di inserimento non valido
            }
        }
        System.out.println("Grazie per aver ordinato, arrivederci!");// messaggio di uscita
    }
}

// classe Hamburger
class Hamburger {
    // attributi
    private String nome;

    // costruttore
    Hamburger(String nome) {
        this.nome = nome;
    }

    // metodo get per poter visualizzare il nome
    public String getNome() {
        return nome;
    }

    // metodo prepara base
    public void prepara() {
        System.out.println("Preparazione Hamburger");
    }

}

// classe Cheeseburger che eredita da Hamburger
class Cheeseburger extends Hamburger {
    // costruttore
    Cheeseburger() {
        super("Cheeseburger");
    }

    // override del metodo prepara che cambia messaggio
    @Override
    public void prepara() {
        System.out.println("Preparazione Cheeseburger: pane, carne, formaggio, ketchup");
    }
}

// classe VegBurger che eredita da Hamburger
class VegBurger extends Hamburger {
    // costruttore
    VegBurger() {
        super("VegBurger");
    }

    // override del metodo prepara che cambia ancora messaggio
    @Override
    public void prepara() {
        System.out.println("Preparazione VegBurger: pane integrale, burger vegetale, insalata, pomodoro");
    }
}

// classe DoubleBacon che eredita da Hamburger
class DoubleBacon extends Hamburger {
    // costruttore
    DoubleBacon() {
        super("DoubleBacon");
    }

    // override del metodo prepara che cambia ancora messaggio
    @Override
    public void prepara() {
        System.out.println("Preparazione DoubleBacon: pane, doppia carne, bacon, cheddar, maionese");
    }
}





