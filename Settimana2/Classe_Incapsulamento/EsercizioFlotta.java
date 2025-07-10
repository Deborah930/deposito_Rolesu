
import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioFlotta {
    public static void main(String[] args) {
        Scanner inputS = new Scanner(System.in);// scanner per stringhe
        Scanner inputI = new Scanner(System.in);// scanner per interi

        System.out.println("Inserisci il nome della compagnia aerea: ");// richiesta di inserimento del nome della compagnia aerea
        String nomeC = inputS.nextLine();// inserimento in input
        CompagniaAerea compagnia = new CompagniaAerea();// creazione oggetto compagnia aerea
        // Inserimento dei dati dell'aereo
        for (int i = 1; i <= 2; i++) {
            System.out.println("Dati Aereo " + "-");
            Aereo aereo = new Aereo();// creazione oggetto aereo
            // inserimento del modello dell'aereo tramite input
            System.out.println("Modello: ");
            aereo.setModello(inputS.nextLine());
            // inserimento del codice tramite input
            System.out.println("Codice: ");
            aereo.setCodice(inputS.nextLine());
            // inserimento dei numeri posti in input
            System.out.println("Numero posti: ");
            aereo.setnumeroPosti(inputI.nextInt());
            compagnia.addAereo(aereo);

        }
        // inserimento dati dei piloti
        for (int i = 1; i <= 2; i++) {
            System.out.println("Inserire i dati del pilota " +  "-");
            Pilota pilota = new Pilota();// creazione oggetto pilota

            System.out.println("Nome Pilota ");
            pilota.setNome(inputS.nextLine());// inserimento in input del nome del pilota

            System.out.println("Numero del brevetto: ");
            pilota.setnumeroBrevetto(inputS.nextLine());// inserimento in input del numero del brevetto

            System.out.println(" Ore di volo: ");
            pilota.setOreVolo(inputI.nextInt());// inserimento in input delle ore di volo

            compagnia.addPilota(pilota);// aggiunta del pilota in compagniaAerea
        }
        // Stampa delle informazioni della compagnia
        
        compagnia.stampaInfo();//probema nello stampare i dati totali

    }
}

class Aereo { // attributi
    private String modello;
    private int numeroPosti;
    private String codice;

    Aereo() {// costruttore
        this.modello = modello;
        this.numeroPosti = numeroPosti;
        this.codice = codice;
    }

    public String getModello()// get
    {
        return this.modello;
    }

    public int getnumeroPosti()// get
    {
        return this.numeroPosti;
    }

    public String getCodice()// get
    {
        return this.codice;
    }

    public void setModello(String modello)// set
    {
        this.modello = modello;
    }

    public void setnumeroPosti(int numeroPosti)// set
    {
        if (numeroPosti % 2 == 0)// condizione per cui i numeri dei posti devono essere pari
        {
            this.numeroPosti = numeroPosti;
        } else {
            System.out.println("Il numero dei posti deve essere positivo");
        }

    }

    public void setCodice(String codice)// set
    {
        this.codice = codice;
    }

    public void lettura()// lettura di quello che c'è dentro aereo
    {
        System.out.println("Modello: " + modello + " numeroPosti " + numeroPosti + "Codice: " + codice);
    }

}

class Pilota {// attributi
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    Pilota() {// costruttore
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        this.oreVolo = oreVolo;

    }

    public String getNome()// get
    {
        return this.nome;
    }

    public String getNumeroBrevetto()// get
    {
        return this.numeroBrevetto;
    }

    public int getOreVolo()// get
    {
        return this.oreVolo;
    }

    public void setNome(String nome)// set
    {
        this.nome = nome;
    }

    public void setnumeroBrevetto(String numeroBrevetto)// set
    {
        this.numeroBrevetto = numeroBrevetto;
    }

    public void setOreVolo(int oreVolo)// set
    {
        if (oreVolo > 0) { // Condizioni per cui le ore di volo devono essere maggiori di 0
            this.oreVolo = oreVolo;
        } else {
            System.out.println("Le ore di volo sono minori di zero ");
        }
    }

    public void lettura()// lettura dei dati di pilota
    {
        System.out.println("Nome: " + nome + "Numero brevetto: " + numeroBrevetto + "Ore di volo: " + oreVolo);
    }
}

class CompagniaAerea {// attributi
    private String nome;
    private ArrayList<Aereo> flotta = new ArrayList<>();
    private ArrayList<Pilota> piloti = new ArrayList<>();
 CompagniaAerea()
 {
    this.nome=nome;
    this.flotta= new ArrayList<>();
    this.piloti= new ArrayList<>();
 }
    // metodo per aggiungere un aereo all'arrayList "flotta"
    public void addAereo(Aereo aereo) {
        flotta.add(aereo);
    }

    // metodo per aggiungere un pilota all'arrayList "piloti"
    public void addPilota(Pilota pilota) {
        piloti.add(pilota);
    }

    public void stampaInfo()// stampa delle informazioni di compagnia aerea
    {
        System.out.println("Compagnia aerea: " + nome + "-");
        System.out.println("Flotta");
        // inserimento degli aerei in flotta
        for (Aereo a : flotta) {
            System.out.println(a);
            a.lettura();
        }
        System.out.println("Piloti: ");
        // inserimento del pilota in piloti (dobbiamo dare un nome per stamparlo(p))
        for (Pilota p : piloti) {
           p.lettura();
        }
    }
}