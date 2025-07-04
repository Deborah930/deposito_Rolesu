import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioInterfaccia {
    public static void main(String[] args) {
        Scanner inputS = new Scanner(System.in);
        Scanner inputI = new Scanner(System.in);
        ArrayList<VeicoloConsegna> veicoli = new ArrayList<>();// creazione arraylist di oggetti VeicoloConsegna
        veicoli.add(new Furgone("FG6756", 1000));// aggiunta furgone
        veicoli.add(new Drone("HU780", 10));// aggiunta drone
        for (VeicoloConsegna v : veicoli)// stampa dei metodi
        {
            v.consegnaPacco("Via Giacomo Leopardi, 20");
            v.StampaInfo();
        }
    }
}

// interface
interface Tracciabile {
    public void tracciaConsegna(String codiceTracking);
}

// creazione classe astratta
abstract class VeicoloConsegna {
    // attributi
    protected String targa;
    protected float caricoMassimo;

    // costruttore
    public VeicoloConsegna(String targa, float caricoMassimo) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }

    // metoo per la consegna dei pacchi
    public abstract void consegnaPacco(String destinazione);

    // stampa delle informazioni relative ai veicoli
    public void StampaInfo() {
        System.out.println("Targa: " + targa + " Carico massimo: " + caricoMassimo);
    }
}

// creazione classe furgone che estende VeicoloConsegna, che implementa
// un'interfaccia
class Furgone extends VeicoloConsegna implements Tracciabile {
    // costruttore
    public Furgone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }
    // metodo ereditato dalla classe astratta

    public void consegnaPacco(String destinazione) {
        System.out.println("Targa furgone: " + targa + " in consegna in " + destinazione);
    }

    // metodo implementato dall'interfaccia
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Tracking: " + codiceTracking);
    }
}

// classe drone

class Drone extends VeicoloConsegna implements Tracciabile {// costruttore
    public Drone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    // metodo ereditato dalla classe astratta
    public void consegnaPacco(String destinazione) {
        System.out.println("Identificativo drone: " + targa + " vola verso: " + destinazione);
    }

    // metodo implementato dall'interfaccia
    public void tracciaConsegna(String codiceTracking) {
        System.out.println(" Tracking automatico: " + codiceTracking);
    }
}
