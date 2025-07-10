/*
Esercizio 2: Incapsulamento e metodi
Traccia: 
Crea una classe ContoBancario con gli attributi privati numeroConto, saldo e titolare.fatto
Implementa i metodi pubblici getNumeroConto(), getSaldo(), getTitolare(), deposita(double importo) e preleva(double importo) per accedere e modificare i dati del conto.fatto
Crea un programma principale che istanzia un oggetto ContoBancario, deposita e preleva fondi, e stampa il saldo finale. 
*/

import java.util.Scanner;

public class Esercizio2QuintaDomanda {
    public static void main(String[] args) {
        //scanner per accettare gli input diversi
        Scanner inputS = new Scanner(System.in);
        Scanner inputI = new Scanner(System.in);
        Scanner inputD = new Scanner(System.in);
        //creazione oggetto contoBancario
        ContoBancario conto = new ContoBancario("It95ns6303", 1000, "Luca Rossi");
        boolean continua = true;
        //menù per il conto bancario
        while (continua) {
            System.out.println("\n--- Conto bancario ---");
            System.out.println("1. Visualizza informazioni conto");
            System.out.println("2. Deposita");
            System.out.println("3. Preleva");
            System.err.println("4.Saldo finale");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = inputI.nextInt();
            switch (scelta) {// entrerà in un case diverso a seconda di cosa si è digitato
                case 1:
                    System.out.println("Numero conto: " + conto.getNumeroConto());
                    System.out.println("Titolare: " + conto.getTitolare());
                    System.out.println("Saldo attuale: €" + conto.getSaldo());
                    break;
                case 2:
                    System.out.print("Inserisci l'importo da depositare: ");
                    double deposito = inputD.nextDouble();
                    conto.deposita(deposito);
                    break;
                case 3:
                    System.out.print("Inserisci l'importo da prelevare: ");
                    double prelievo = inputD.nextDouble();
                    conto.preleva(prelievo);
                    break;
                case 4:
                    System.out.println("Saldo finale: €" + conto.getSaldo());
                    break;
                case 0:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");// nel caso di inserimento non valido
            }
        }
        System.out.println(" arrivederci!");// messaggio di uscita

    }
}

// classe ContoBancario
class ContoBancario {
    private String numeroConto;
    private float saldo;
    private String titolare;

    // Costruttore ContoBancario
    ContoBancario(String numeroConto, float saldo, String titotale) {
        this.numeroConto = numeroConto;
        this.saldo = saldo;
        this.titolare = titolare;
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getTitolare() {
        return titolare;
    }

    public void deposita(double importo) {
        if (importo > 0) {
            saldo += importo;
            System.out.println("Deposito di: " + importo + " euro ");
        } else {
            System.out.println("Importo non valido");
        }
    }

    public void preleva(double importo) {
        if (importo > 0) {
            saldo -= importo;
            System.out.println("Prelievo di : " + importo + " euro ");
        } else {
            System.out.println("Prelievo  non valido");
        }
    }
}