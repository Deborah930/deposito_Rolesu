import java.util.ArrayList;
import java.util.Scanner;

public class UltimoEsercizioOggetti {
    public static void main(String[] args) {
        Officina officina = new Officina();
        Scanner inputString = new Scanner(System.in);// lo scanner 99.99% va nel main

        System.out.println("Inserisci la targa: ");
        String targa = inputString.nextLine();// richiamo le variabili dichiarate nel costruttore

        System.out.println("Inserisci il modello: ");
        String modello = inputString.nextLine();// richiamo le variabili dichiarate nel costruttore

        Auto auto = new Auto(targa, modello);// creo l'oggetto passandogli i parametri che voglio visualizzare
        
        auto.visualizza();// richiamo dei metodi
        officina.addAuto(auto);// richiamo dei metodi
        System.out.println("Lista auto: ");
        officina.listAuto();// richiamo dei metodi

    }

}

class Auto {
    private String targa;// dichiarazione attributi
    private String modello;

    // costruttore
    Auto(String targa, String modello) {// richiamo gli attributi con un nome leggermente diverso come targai=targainput

        this.targa = targa;// this. variabile= a quello dichiarato tra le parentesi del costruttore
        this.modello = modello;

    }

    public String getTarga() {
        return this.targa;
    }

    public String getModello() {
        return this.modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    void visualizza() {// metodo per visualizzare la targa e il modello
        System.out.println("targa: " + targa + " Modello:  " + modello);
    }

}

class Officina {
    private ArrayList<Auto> officina = new ArrayList<>();// array di oggetto Auto

    public void addAuto(Auto auto) {// metodo per aggiungere un auto all'arrayList
        officina.add(auto);
        System.out.println("L'auto aggiunta: ");
        auto.visualizza();
    }

    public void listAuto() {// metodo per visualizzare le auto presenti e controllo se ci sono auto
      
            
            for (Auto auto : officina) {// foreach per vedere la lista di auto
                auto.visualizza();
            }
        
    }
}