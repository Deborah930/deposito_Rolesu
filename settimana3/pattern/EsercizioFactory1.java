import java.util.Scanner;

public class EsercizioFactory1 {
    public static void main(String[] args) {
        Scanner inputS= new Scanner(System.in);
        boolean continua= true;
        //menù per scegliere quale veicolo creare 
        //ogni volta che entro in un case viene creato quel tipo di veicolo 
        //quando viene creato il veicolo vengono richiamati i metodi avvia e mostraTipo di quel veicolo
        while(continua)
        {
            System.out.println("\n--- Menù Veicoli ---");
            System.out.println("1. Crea Auto");
            System.out.println("2. Crea Moto");
            System.out.println("3. Crea Camion");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            String scelta= inputS.nextLine();
            IVeicolo veicolo= null;

            switch(scelta)
            {
                case "1":
                veicolo= VeicoloFactory.creaVeicolo("auto");
                break;
                case "2" :
                veicolo= VeicoloFactory.creaVeicolo("moto");
                break;
                case "3" :
                veicolo= VeicoloFactory.creaVeicolo("camion");
                break;
                case "4":
                System.out.println("Esci");
                continua=false;
                continue;
                default:
                System.out.println("Scelta non valida");
                continue;
            }
            if(veicolo!=null)
            {
                veicolo.avvia();
                veicolo.mostraTipo();
            }
        }
    }
}

//interfaccia comune per tutti i veicoli
interface IVeicolo
{
    void avvia();
    void mostraTipo();
}


// classe auto che implementa i metodi di veicolo
class Auto implements IVeicolo
{
    public void avvia()
    {
        System.out.println("Avvio dell'auto ");
    }

    public void mostraTipo()
    {
        System.out.println("Tipo: Auto ");
    }
}

// classe della moto che implementa i metodi di veicolo
class Moto implements IVeicolo
{
    public void avvia()
    {
       System.out.println("Avvio della moto "); 
    }
    public void mostraTipo()
    {
        System.out.println("Tipo: Moto ");
    }
}

//classe del camion che implementa i metodi di veicolo
class Camion implements IVeicolo
{
    public void avvia()
    {
       System.out.println("Avvio del camion "); 
    }
    public void mostraTipo()
    {
        System.out.println("Tipo: Camion ");
    }
}

//Factory con la creazione dei 3 veicoli
class VeicoloFactory
{
    //cambia il tipo di oggetto che viene creato
    public static IVeicolo creaVeicolo(String tipo)
    {
        switch (tipo) {
            case "auto":
                return new Auto();
            case "moto":
                 return new Moto();
            case "camion":
                return new Camion();     
            default:
            System.out.println("Tipo di veicolo non presente");
               return null;
        }
        
    }
}


