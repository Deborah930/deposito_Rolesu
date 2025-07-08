import java.util.ArrayList;

public class Esercizio3Pattern {
    public static void main(String[] args) {
        //creazione di un Hamburger base 
        //aggiunta all'ordine del formaggio e del bacon all'ordine 
        Hamburger ordine = new BaseBurger();
      ordine= new DecoratorFormaggio(ordine);
      ordine= new DecoratorBacon(ordine);
            //nuova creazione ordine con aggiunta solo del bacon
      Hamburger ordine2= new BaseBurger();
      ordine2= new DecoratorBacon(ordine2);
       //nuova creazione ordine con aggiunta solo del formaggio
      Hamburger ordine3= new BaseBurger();
      ordine3= new DecoratorFormaggio(ordine3);
      //richiamo l'istanza della gestione degli ordini
      GestioneOrdini gestioneOrdini= GestioneOrdini.getIstanza();
        //richiamo del metodo per l'observer
      gestioneOrdini.notificaOrdine(ordine);
      gestioneOrdini.notificaOrdine(ordine2);
      gestioneOrdini.notificaOrdine(ordine3);
      gestioneOrdini.removeOrdine(ordine2);
      //stampa del riepilogo degli ordini effettuati
      gestioneOrdini.stampaOrdine();
     }
}

// creazione di un'interfaccia implementando i metodi getDescrizione e getPrezzo che saranno la base dell'hamburger
interface Hamburger
{
    String getDescrizione();
    double getPrezzo();
}
//creazione della classe concreta in cui creo un hamburger base dando una descrizione un prezzo iniziale
//classe concreta
class BaseBurger implements Hamburger
{
   private String descrizione;
   private double prezzo;
   public String getDescrizione()
   {
    return "Hamburger base: pane,insalata,Hamburger ";
   }
   public double getPrezzo()
   {
    return 5.00;
   }
}

//creazione di una classe astratta per definire un pattern Decorator per aggiungere qualcosa all'hambuger 
//decoratore astratto
abstract class DecoratorHamburger implements Hamburger
{
    protected Hamburger hamburger;

    public DecoratorHamburger(Hamburger hamburger)
    {
        this.hamburger=hamburger;
    }
}

//creazione di una classe concreta che estende quella astratta per aggiungere il formaggio all'hamburger base
//decoratore concreto
class DecoratorFormaggio extends DecoratorHamburger
{
DecoratorFormaggio(Hamburger hamburger)
{
    super(hamburger);
}
//richiamo della descrizione iniziale più formaggio
@Override
public String getDescrizione() {
    
    return hamburger.getDescrizione() + " Formaggio " ;
}
//richiamo del prezzo iniziale più il prezzo nuovo
@Override
public double getPrezzo() {
    
    return hamburger.getPrezzo() + 0.50 ;
}

}

//creazione di una classe concreta che estende quella astratta per aggiungere il bacon all'hamburger base
//secondo decoratore concreto
class DecoratorBacon extends DecoratorHamburger
{
    DecoratorBacon(Hamburger hamburger)
    {
        super(hamburger);
    }
    //richiamo della descrizione di base più bacon
    @Override
    public String getDescrizione() {
        
        return hamburger.getDescrizione() + " Bacon ";
    }
    //richiamo del prezzo iniziale più il prezzo nuovo
    @Override
    public double getPrezzo() {
       
        return hamburger.getPrezzo() + 0.80;
    }
}
//Pattern observe per controllare la notifica dell'ordine
// observe
interface ObserverOrdine
{
    void notificaOrdine(Hamburger h);
    
}

// gestione degli ordini dove aggiungo, rimuovo o vedo l'ordine

//singleton 
class GestioneOrdini implements ObserverOrdine
{
    private static GestioneOrdini istanza;
    private ArrayList <Hamburger> ordini= new ArrayList<>();


public static GestioneOrdini getIstanza()
{
    if(istanza == null)
    {
        istanza= new GestioneOrdini();
    }
    return istanza;
}

public void notificaOrdine(Hamburger h)
{
    ordini.add(h);
    System.out.println("Ordine: " + h.getDescrizione() + " Prezzo : " + h.getPrezzo());
}

public void removeOrdine(Hamburger h)
{
    ordini.remove(h);
}

public void stampaOrdine()
{
    System.out.println("Riepilogo ordine: ");
    for(Hamburger h : ordini)
    {
        System.out.println("Ordine: " + h.getDescrizione() + " " + h.getPrezzo() );
    }
}
}

