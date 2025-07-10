package pattern;

public class EsercizioSingleton {
    public static void main(String[] args) {
        //l'istanza del Logger1 è solo una
        Logger1 logger1= Logger1.getIstanza();
        logger1.ScriviMessagio("Inizio 07/07/2025 Ora: 16.30 ");
        //si tratta sempre della stessa istanza
        Logger1 logger2= Logger1.getIstanza();
        logger2.ScriviMessagio("fine 07/07/2025 Ora: 17.00");
        //conferma che le istanze sono uguali
        if(logger1.equals(logger2))
        {
            System.out.println("Sono la stessa istanza");
        }else{
            System.out.println("Non sono la stessa istanza");
        }
    }
}
class Logger1
{
//campo privato di Logger1
private static Logger1 istanza;
//costruttore che deve essere privato e che impedisce la creazione di istanze dall'esterno
private Logger1()
{
 
}
//questo metodo è l'unico modo per ottenere l'istanza 
public static Logger1 getIstanza()
{
    if (istanza == null) 
    {
      istanza = new Logger1();
    }
    
    return istanza;
}
//metodo di scrittura da chiamare
public void ScriviMessagio(String messaggio)
{
    System.err.println( messaggio );
}
}
