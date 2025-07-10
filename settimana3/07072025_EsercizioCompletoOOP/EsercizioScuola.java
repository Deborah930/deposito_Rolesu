import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioScuola {

}

abstract class Persona

{// attributi
    private String nome;
    private int eta;

    // costruttore
    Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // metodi per poter leggere e modificare gli attributi privati
    // get nome
    public String getNome() {
        return nome;
    }

    // set nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // get età
    public int getEta() {
        return eta;
    }

    // set età
    public void setEta(int eta) {
        this.eta = eta;
    }

    public abstract void descriviRuolo();

}

// interface
interface Registrabile {
    // metodo di registrazione da implementare nelle classi
    void registrazione();

}

// classe studente
class Studente extends Persona implements Registrabile {
    private String classeFrequentata;

    // costruttore
    Studente(String nome, int eta, String classeFrequentata) {
        super("Luca", 16);
        this.classeFrequentata = classeFrequentata;
    }

    // get
    public String getClasseFrequentata() {
        return classeFrequentata;
    }

    // override del metodo descriviRuolo
    @Override
    public void descriviRuolo() {
        System.out.println("Sono uno studente della classe.. " + classeFrequentata);

    }

    // implementazione del metodo di registrazione
    public void registrazione() {
        System.out.println("Registrazione tramite modulo online");
    }
    void stampaInfo()
    {
        System.out.println("Nome " + getNome() +"Eta: " +getEta() + classeFrequentata );
    }
}


// classe docente
class Docente extends Persona implements Registrabile {// attributi
    private String materia;

    // costruttore
    Docente(String nome, int eta, String materia) {
        super(nome, eta);
        this.materia = materia;
    }

    // get
    public String getMateria() {
        return materia;
    }

    // override del metodo descrivi ruolo
    @Override
    public void descriviRuolo() {
        System.out.println("Sono un docente di.." + materia);
    }

    // implementazione del metodo registrazione
    public void registrazione() {
        System.out.println("Registrazione tramite segreteria didattica");
    }
    void stampaInfo()
    {
        System.out.println("Nome: " + getNome() + "Eta: " + getEta() + "Materia " + materia );
    }
}

    class GestioneScuola {
    public static void main(String[] args) {
        Scanner inputS= new Scanner(System.in);
        Scanner inputI= new Scanner(System.in);
        ArrayList<Persona> persone = new ArrayList<>();//arrayList di persone
        /*
        creazione degli studenti e dei docenti
        persone.add(new Studente("Luca", 15, "2A"));
        persone.add(new Studente("Luigi", 16, "2B"));
        persone.add(new Docente("Paolo", 50, "Informatica"));
        persone.add(new Docente("Silvia", 40, "Italiano"));
        foreach per richiamare i metodi
        for (Persona p : persone) {
        p.descriviRuolo();// richiama il metodo descriviRuolo
        instance of serve per controllare il tipo di un oggetto
        if (p instanceof Registrabile) {
        ((Registrabile) p).registrazione();// Fa il cast dell’oggetto(lo "vede" come un Registrabile), chiama il metodo registrazione
        */       
            
            boolean continua= true;
            while (continua) {
            System.out.println("\n--- MENU scuola ---");
            System.out.println("1. Studente");
            System.out.println("2. Docente");
            System.out.println("3. Visualizza classe, ruolo e modo di registrazione");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = inputI.nextInt();
            switch (scelta) {//entrerà in un case diverso a seconda di cosa si è digitato (1,2,3,4,0)
                case 1:
                System.out.println("Studente: ");
                String nomeS= inputS.nextLine();
                System.out.println("Eta: ");
                int etaS= inputI.nextInt();
                System.out.println("Classe: ");
                String classeS= inputS.nextLine();
                Studente studente = new Studente(nomeS,etaS,classeS);
                persone.add(studente);
                System.out.println("Studente aggiunto");
                    break;
                case 2:
                System.out.println("Docente: ");
                String nomeD= inputS.nextLine();
                System.out.println("Eta: ");
                int etaD= inputI.nextInt();
                System.out.println("Materia: ");
                String materia= inputS.nextLine();
                Docente docenti = new Docente(nomeD,etaD,materia);
                persone.add(docenti);
                System.out.println("Docente aggiunto");
                break;
                case 3:
                    for (Persona p : persone) {
                    p.descriviRuolo();// richiama il metodo descriviRuolo
                   // instance of serve per controllare il tipo di un oggetto
                   if (p instanceof Registrabile) {
                    ((Registrabile) p).registrazione();
                   }
                }
                    break;
                                    
                case 0:
                    continua = false;// chiude il menù
                    break;
                default:
                    System.out.println("Scelta non valida.");// nel caso di inserimento non valido
            }

            }
        }
    }
        
    





    
