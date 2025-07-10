public class EsercizioDecorator1 {
    public static void main(String[] args) {
        //messaggio di base
        Messaggio messaggio= new MessaggioBase();
        System.out.println(messaggio.getContenuto());
       
      
        //decorazione del messaggio con lettere in maiuscolo
        Messaggio messaggioDecorato= new MessaggioDecorato(messaggio);
       System.out.println( messaggioDecorato.getContenuto());

    }

    //creazione interfaccia messaggio che avrà il metodo per leggere il contenuto
    //creazione della classe concreta per creare un messaggio di base
    //creazione di un Decorator astratto che implementa messaggio
    //creazione di un Decorator concreto che andrà a cambiare il messaggio di base in maiuscolo
}
interface Messaggio
{
    String getContenuto();
}

//classe concreta
class MessaggioBase implements Messaggio
{
    private String contenuto;
   
    public String getContenuto()
    {
        return "Messaggio di base";
    }

}
//Decorator astratto
 abstract class Decoratore implements Messaggio {
    protected Messaggio messaggio;
    
    public Decoratore(Messaggio messaggio) {
        this.messaggio = messaggio;
    }
    public String getContenuto()
    {
       return messaggio.getContenuto();
    }

    
}

//Decorator concreto
class MessaggioDecorato extends Decoratore
{
public MessaggioDecorato (Messaggio messaggio)
{
 super(messaggio);
}
public String getContenuto()
{
    return messaggio.getContenuto().toUpperCase();
}
}