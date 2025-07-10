public class EsercizioFacade2 {
    public static void main(String[] args) {
        ComputerFacade computer= new ComputerFacade();//creazione dell'istanza che ha tutti i  metodi
        computer.accendiComputer(); // richiamo di un metodo che contiene tutti i metodi delle classi
        computer.update("Computer avviato");// aggiornamenti per gli observer
    }
}

//classe bios
class Bios
{
    //metodi per l'avvio del bios
    public void inizializza()
    {
        System.out.println("Inizializzazione Bios");
    }

    public void carica()
    {
        System.out.println("Caricamento Bios");
    }

    public void avvia()
    {
        System.out.println("Avvio del Bios");
    }
}


//classe hardisk
class HarDisk
{
    //metodi per l'avvio dell'hardisk
  public void inizializza()
    {
        System.out.println("Inizializzazione Hardisk");
    }  

    public void carica()
    {
        System.out.println("Caricamento Hardisk");
    }
    
    public void avvia()
    {
        System.out.println("Avvio dell' Hardisk");
    }

}


// singleton del sistema operativo 
class SistemaOperativo
{
    private static SistemaOperativo istanza;//creazione dell'istanza 
    //costruttore
    private SistemaOperativo()
    {

    }
    //restituisce sempre la stessa istanza
    public static SistemaOperativo getIstance()
    {
         if (istanza == null) {//controllo che non ci siano altre istanze
            istanza = new SistemaOperativo();
        }
        return istanza;
    }
//metodi per avviare il sistema operativo
   public void inizializza()
    {
        System.out.println("Inizializzazione Sistema operativo");
    }

    public void carica()
    {
        System.out.println("Caricamento Sistema operativo");
    }

    public void avvia()
    {
        System.out.println("Avvio del Sistema operativo");
    } 
}

//observer
interface Observer{
    void update(String stato);
}

//implementazione di aggiornamento con observer dove viene notificato che il computer si è avviato con successo
class ComputerFacade implements Observer
{
    private Bios bios;
    private HarDisk hardisk;
    private SistemaOperativo sistemaOperativo;
    
    ComputerFacade()
    {
        
        this.bios= new Bios();
        this.hardisk= new HarDisk();
        this.sistemaOperativo= sistemaOperativo.getIstance();//richiamo istanza del sistema operativo
    }
    public void update(String stato)
    {
        System.out.println("Computer avviato con successo!");
    }
    //richiamo di tutti i metodi delle classi hardisk,bios e sistema operativo
    public void accendiComputer()
    {
        hardisk.carica();
        hardisk.inizializza();
        hardisk.avvia();
        bios.carica();
        bios.inizializza();
        bios.avvia();
        sistemaOperativo.carica();
        sistemaOperativo.inizializza();
        sistemaOperativo.avvia();
        
    }
}
