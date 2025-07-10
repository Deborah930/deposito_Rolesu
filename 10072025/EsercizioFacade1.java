
//Abbiamo due classi con funzionalità distinte
//Invece di accenderle una per una  usiamo un'unica classe semplificata che le raggruppa.
// cosi nel main invece di chiamare i metodi di ogni classe chiamiamo un unico metodo che richiama i metodi delle due classi


public class EsercizioFacade1 {
    public static void main(String[] args) {
        // creazione di un'istanza per gestire le due classi
        GestioneLuciFacade gestioneLuci = new GestioneLuciFacade();
        gestioneLuci.accendiTutte();// metodo per accendere entrambe le luci
    }
}
//classe che con il metodo accendi accende solo la luce della camera
class LuceCamera {
    public void accendi() {
        System.out.println("Luce della camera accesa");
    }
}

//classe che con il metodo accendi accende solo la luce della cucina
class LuceCucina {
    public void accendi() {
        System.out.println("Luce della cucina accesa");
    }
}
//classe per gestire l'accensione delle luci della cucina e della camera
class GestioneLuciFacade
{
    //creo gli attributi con il tipo della classe di interesse
    private LuceCamera luceCamera;
    private LuceCucina luceCucina;

    //costruttore dove creo le istanze delle due classi 
    GestioneLuciFacade()
    {
        this.luceCamera= new LuceCamera();
        this.luceCucina= new LuceCucina();
    }
    //metodo che richiama i metodi delle altre due classi in modo che si accendano contemporaneamente
    public void accendiTutte() {
        luceCamera.accendi();
        luceCucina.accendi();
    }
}