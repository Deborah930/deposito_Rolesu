import java.util.Scanner;

//slide 170 da finire. ultimo punto zoo
public class EsercizioEreditarieta {
    public static void main(String[] args) {
        Scanner inputS = new Scanner(System.in);// scanner per stringhe
        Scanner inputI = new Scanner(System.in);// scanner per interi
        System.out.println("Quanti animali vuoi inserire?");//richiesta all'utente degli animali da inserire
        int numero = inputI.nextInt();
        Animale[] animali = new Animale[numero];// array di animali
        //inserimento degli animali nell'array animali
        for (int i = 0; i < numero; i++) {
            System.out.println("Tipo animale: ");//richiesta di che tipo di animale si tratta
            String tipo = inputS.nextLine();

            System.out.println("Nome: ");
            String nome = inputS.nextLine();//inserimento nome animale
            System.out.println("Eta: ");
            int eta = inputI.nextInt();//inserimento età animale
            //controllo se si tratta di un cane o di un gatto
            if (tipo.equals("cane")) {
                animali[i] = new Cane(nome, eta);
            } else if (tipo.equals("gatto")) {
                animali[i] = new Gatto(nome, eta);
            } else {
                System.err.println("Non è ne un cane ne un gatto");
                animali[i] = new Animale(nome, eta);
            }

        }
        // foreach per vedere a video il nome e l'età dell'animale
        for (Animale a : animali) {
            System.out.println("Nome: " + a.nome + ", Età: " + a.eta);
            a.faiVerso();//richiamo del metodo verso in base all'animale farà un verso diverso
        }

    }
}
//creazione della classe animale
class Animale {
    //attributi classe base
    public String nome;
    public int eta;
// costruttore
    Animale(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }
//verso generico
    public void faiVerso() {
        System.out.println("Verso generico..");
    }
}
//classe cane che eredita da classe animale attributi e metodi
class Cane extends Animale {
    Cane(String nome, int eta) {
        super(nome, eta);
    }
// ovveride del metodo faiVerso
@Override
    public void faiVerso() {
        System.out.println("Bau!");
    }
}
//classe gatto che eredita da classe animale attributi e metodi
class Gatto extends Animale {
    //costruttore
    Gatto(String nome, int eta) {
        super(nome, eta);
    }
 // ovveride del metodo faiVerso
 @Override
    public void faiVerso() {
        System.out.println("Miao!");
    }
}

