package pattern;



public class EsercizioSingleton2 {
    public static void main(String[] args) {
        //faccio due richieste e due connessioni tramite il metodo connect()
        //controllo se le due istanze sono uguali. 
        //Se le istanze sono uguali stamperà l'oggetto è sempre lo stesso altrimenti gli oggetti non sono uguali
        //se gli oggetti non sono uguali il singleton non sta funzionando correttamente
        //stampo a video quante connessioni sono state effettuate
        //in questo caso ho effettuato due richieste con connect() quindi le connessioni saranno in totale due
        DatabaseManager richiesta = DatabaseManager.getIstance();
        richiesta.connect();
        DatabaseManager richiesta2 = DatabaseManager.getIstance();
        richiesta2.connect();
        if (richiesta.equals(richiesta2)) {
            System.out.println("L'oggetto è sempre lo stesso");
        } else {
            System.out.println("Gli oggetti non sono uguali");
        }
        System.out.println("Numero connessioni: " + richiesta.getConnectionCount());

    }
}
// nella classe DatabaseManager ho creato due cose: uno l'istanza, due un contatore per questa classe
// ho controllato che l'istanza fosse presente con l'if e quindi l'ho creata e sarà l'unica istanza 
//ho creato il metodo connect che incrementa il contatore ogni volta che viene richiamato il metodo e stampa a video quante connessioni ci sono
//ho creato un metodo per restituire il valore del contatore 
class DatabaseManager {
    private static DatabaseManager istanza;
    private static int contatore = 0;

    private DatabaseManager() {

    }

    public static DatabaseManager getIstance() {
        if (istanza == null) {
            istanza = new DatabaseManager();
        }

        return istanza;
    }

    public void connect() {
        contatore++;
        System.out.println("Connessione stabilita. Connessioni attive: " + contatore);

    }

    public int getConnectionCount() {
        return contatore;
    }

}

