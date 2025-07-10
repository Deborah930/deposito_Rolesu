/*ESERICIZIO 1: Ereditarietà ed Oggetti
Traccia: 
1.Crea una classe base Veicolo con gli attributi marca, modello e anno. fatto
2.Crea una sottoclasse Auto che eredita da Veicolo e aggiunge l'attributo numeroPorte. fatto
3.Crea una sottoclasse Moto che eredita da Veicolo e aggiunge l'attributo tipoManubrio. fatto
4.Implementa un metodo toString() in tutte le classi per stampare le informazioni del veicolo.fatto
5.Crea un programma principale che istanzia un oggetto Auto e un oggetto Moto, e stampa le loro informazioni. fatto */

public class Esercizio1TerzaDomanda {
    public static void main(String[] args) {

        // creazione oggetto auto
        Auto auto = new Auto("peugeout", "ibrido", 2025, 5);
        // stampa info auto
        System.out.println(auto);
        // creazione oggetto moto
        Moto moto = new Moto("Onda", "bo", 2020, null);
        // stampa info moto
        System.out.println(moto);
    }
}

class Veicolo {
    // Attributi di Veicolo
    protected String marca;
    protected String modello;
    protected int anno;

    // Costruttore di Veicolo
    Veicolo(String marca, String modello, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }

    // metodo get per vedere la marca
    public String getMarca() {
        return marca;
    }

    // metodo get per vedere il modello
    public String getModello() {
        return modello;
    }

    // metodo get per vedere l'anno
    public int getAnno() {
        return anno;
    }

    // to string per vedere in output i dati
    @Override
    public String toString() {

        return " Marca = " + marca + " Modello = " + modello + " Anno = " + anno;
    }

}

// classe Auto
class Auto extends Veicolo { // attributi Auto
    private int numeroPorte;

    // Costruttore Auto
    Auto(String marca, String modello, int anno, int numeroPorte) {
        super(marca, modello, anno);
        this.numeroPorte = numeroPorte;
    }

    // get per vedere in output il numero di porte
    public int getNumeroPorte() {
        return numeroPorte;
    }

    // to string per vedere in output i dati
    @Override
    public String toString() {

        return super.toString() + " Numero porte = " + numeroPorte;
    }

}

// classe
class Moto extends Veicolo { // attributi Moto
    private String tipoManubrio;

    // Costruttore Moto
    Moto(String marca, String modello, int anno, String tipoManubrio) {
        super(marca, modello, anno);
        this.tipoManubrio = tipoManubrio;
    }

    // get per vedere in output il tipo di manubrio
    public String getTipoManubrio() {
        return tipoManubrio;
    }

    // to string per vedere in output i dati
    @Override
    public String toString() {

        return super.toString() + " Tipo manubrio = " + tipoManubrio;
    }
}