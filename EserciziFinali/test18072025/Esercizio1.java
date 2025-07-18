/*Esercizio 1 – Le Tre Regole Fondamentali dell’OOP 
Obiettivo: Applicare incapsulamento, ereditarietà e polimorfismo
Progetta un semplice sistema per la gestione di veicoli. Crea una classe base Veicolo che contenga almeno due attributi (es. marca, anno) e un metodo dettagli().
 Applica l'incapsulamento rendendo gli attributi privati e usando getter/setter. 
 Crea due sottoclassi: Auto e Moto, che ereditano da Veicolo. 
 Sovrascrivi il metodo dettagli() nelle sottoclassi per polimorfismo.
 Infine, nel main, crea un arraylist di Veicolo e stampa i dettagli di ogni elemento.
Gestisci il tutto tramite menu */

import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        ArrayList<Veicolo> listaVeicoli = new ArrayList<>();//array x la creazione dei veicoli 
        Scanner inputS = new Scanner(System.in);//scanner di stringhe
        Scanner inputI = new Scanner(System.in);// scanner di input
        int scelta;

        do {
            System.out.println("\n--- MENU VEICOLI ---");
            System.out.println("1. Aggiungi Auto");
            System.out.println("2. Aggiungi Moto");
            System.out.println("3. Visualizza Tutti i Veicoli");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = inputI.nextInt();
            

            switch (scelta) {
                case 1:
                    System.out.print("Marca: ");
                    String marcaAuto = inputS.nextLine();
                    System.out.print("Anno: ");
                    int annoAuto = inputI.nextInt();
                    System.out.print("Numero di porte: ");
                    int porte = inputI.nextInt();
                    listaVeicoli.add(new Auto(marcaAuto, annoAuto, porte));
                    break;

                case 2:
                    System.out.print("Marca: ");
                    String marcaMoto = inputS.nextLine();
                    System.out.print("Anno: ");
                    int annoMoto = inputI.nextInt();
                    listaVeicoli.add(new Moto(marcaMoto, annoMoto));
                    break;

                case 3:
                    System.out.println("--- VEICOLI ---");
                    for (Veicolo v : listaVeicoli) {
                        System.out.println(v.dettagli());
                    }
                    break;

                case 0:
                    System.out.println("Esci.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        inputI.close();//chiusura scanner
        inputS.close();//chiusura scanner
    }
}

// classe base
abstract class Veicolo {
    private String marca;
    private int anno;
//costruttore da implementare nelle sottoclassi
    public Veicolo(String marca, int anno) {
        this.marca = marca;
        this.anno = anno;
    }

    // Get e Set per la lettura e il settaggio di marca e anno
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    // stampa dei dettagli 
    public String dettagli() {
        return "Marca: " + marca + " Anno: " + anno;
    }
}

// classe auto che estende la classe veicolo
//sottoclasse
class Auto extends Veicolo {
    private int porte;
//costruttore 
    public Auto(String marca, int anno, int porte) {
        super(marca, anno);
        this.porte = porte;
    }

    // override del metodo dettagli
    @Override
    public String dettagli() {
        return "Auto: " + super.dettagli() + " Porte: " + porte;
    }
}

// classe moto che estende veicolo
//sottoclasse
 class Moto extends Veicolo {
//costruttore
    public Moto(String marca, int anno) {
        super(marca, anno);// richiamo delle variabili di veicolo

    }

    // override del metodo dettagli
    @Override
    public String dettagli() {
        return "Moto: " + super.dettagli();
    }
}
