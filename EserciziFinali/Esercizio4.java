import java.util.ArrayList;
import java.util.List;

/*
 * Esercizio 4: Sistema di Notifiche per Smart Home
Simula una smart home dove dispositivi (sensori, luci, allarmi)
comunicano cambiamenti.
Usa Observer per notificare i cambiamenti di stato.
Usa Adapter per far comunicare dispositivi di produttori diversi.
 */
public class Esercizio4 {
    public static void main(String[] args) {
        SensoreMovimento sensore= new SensoreMovimento();//subject
        Allarme allarme= new Allarme();//osservatori
        Luce luce= new Luce();//osservatori
        DispositivoEsterno esterno= new DispositivoEsterno();//dispositivo esterno da adattare
        DispositivoEsternoAdapter adapter= new DispositivoEsternoAdapter(esterno);//dispositivo adattato
        sensore.aggiungiObserver(allarme);//aggiunta osservatore
        sensore.aggiungiObserver(luce);//aggiunta osservatore
        sensore.aggiungiObserver(adapter);//adattato

        //simulazione di rilevamento di un movimento dove gli osservatori vengono notificati
        sensore.rilevaMovimento();

        

    }
}

//Interfaccia observer
interface Observer{
    void aggiorna(String messaggio);
}

//interfaccia Subject, soggetto da osservare
interface Subject
{
    void aggiungiObserver(Observer o);
    void rimuoviObserver(Observer o);
    void notificaObservers(String messaggio);
}
// classe aggiunta osservatori e notificatore osservatori
class SensoreMovimento implements Subject
{
    private List<Observer> observers= new ArrayList<>();//lista di osservatori

    @Override
    public void aggiungiObserver(Observer o)
    {
        observers.add(o);
    }

    @Override
    public void rimuoviObserver(Observer o)
    {
      observers.remove(o);  
    }

    @Override
    public void notificaObservers(String messaggio)
    {
        for(Observer o: observers)
        {
            o.aggiorna(messaggio);
        }
    }

    public void rilevaMovimento()
    {
        System.out.println("Attenzione! Movimento rilevato ");
        notificaObservers("Movimento rilevato!!");
    }
}

//luci,osservatore
class Luce implements Observer
{
    public void aggiorna(String messaggio)
    {
        System.out.println("Accensione luci : " + messaggio);
    }
}

//allarme,osservatore
class Allarme implements Observer
{
    public void aggiorna(String messaggio)
    {
        System.out.println("Attivazione allarme: " + messaggio);
    }
}

//dispositivo da adattare all'observer
class DispositivoEsterno
{
    public void riceviSegnale(String segnale)
    {
        System.out.println("Dispositivo esterno : " + segnale);
    }
}

//adattamento del dispositivo esterno all'interfaccia observer
class DispositivoEsternoAdapter implements Observer
{
    private DispositivoEsterno esterno;
    //costruttore
    public DispositivoEsternoAdapter(DispositivoEsterno esterno)
    {
        this.esterno= esterno;
    }

    public void aggiorna (String messaggio)
    {
        esterno.riceviSegnale(messaggio);//adattamento
    }
}