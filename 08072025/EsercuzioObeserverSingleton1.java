import java.util.ArrayList;
import java.util.List;

public class EsercuzioObeserverSingleton1 {
    public static void main(String[] args) {
        //Creazione dell'oggetto agenzia che richiama il getIstanza del singleton AgenziaBorsa
        //creazione oggetti investitore privato e investitore bancario
        //aggiungo i due investitori 
        //aggiunta dei valori aggiornati
        AgenziaBorsa agenzia= AgenziaBorsa.getIstanza();
        Investitore privato= new InvestitorePrivato("Pippo");
        Investitore bancario= new InvestitoreBancario("Intesa");
        agenzia.aggiungiInvestitore(privato);
        agenzia.aggiungiInvestitore(bancario);
        agenzia.aggiornaValoreAzione("BO", 100.0);
        agenzia.aggiornaValoreAzione("BU", 150.0);
    }
}
interface Investitore
{
    void notifica(String azione,double valore);
}
//singleton su agenzia borsa dove controllo che l'istanza non sia nulla e aggiungo un'istanza
class AgenziaBorsa
{
    private static AgenziaBorsa istanza;
    private List<Investitore> registro= new ArrayList<>();
    private String azione;
    private double valore;

    public static AgenziaBorsa getIstanza() {
        if (istanza == null) {
            istanza = new AgenziaBorsa();
        }
        return istanza;
    }

    public void aggiungiInvestitore(Investitore i) {
        registro.add(i);
    }

    public void removeInvestitore(Investitore i) {
        registro.remove(i);
    }
    public void notificaInvestitore() {
        for (Investitore i : registro) {
            i.notifica(azione,valore);
        }

    }
    public void aggiornaValoreAzione(String azione, double valore) {
        this.azione=azione;
        this.valore=valore;
        System.err.println("Aggiornamento: " + azione + " valore = " + valore);
        notificaInvestitore();
    }
    
    

}
//classe investitore privato che implementa l'interfaccia investitore dove riporterà la notifica
class InvestitorePrivato implements Investitore
{
    InvestitorePrivato(String nome)
    {
        this.nome=nome;
    }
    private String nome;
    
    public void notifica(String azione, double valore)
    {
        System.out.println("Investitore privato:" + nome + " Azione aggiornata " + azione + " Valore aggiornato " + valore);
    }
}

//classe investitore bancario che implementa l'interfaccia investitore dove riporterà la notifica
class InvestitoreBancario implements Investitore
{
    
    private String nome;
    InvestitoreBancario(String nome)
    {
        this.nome=nome;
    }
   
   public void notifica(String azione, double valore)
    {
        System.out.println("Investitore bancario :" + nome + " Azione aggiornata " + azione + " Valore aggiornato " + valore);
    } 
}

