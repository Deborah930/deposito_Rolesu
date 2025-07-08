import java.util.ArrayList;
import java.util.List;

public class EsercizioObserver1 {
    public static void main(String[] args) {
// creazione di un oggetto della stazione meteo 
//creazione dei due display uno console e l'altro mobile 
//aggiunta alla stazione dei due display con le loro temperature
//rimozione di un display 
//nuovo aggiornamento della temperatura
        StazioneMeteo stazione = new StazioneMeteo();

Display display1 = new DisplayConsole();
Display display2 = new DisplayMobile();
stazione.addDisplay(display1);
stazione.addDisplay(display2);
stazione.setTemperatura(30.4f);
stazione.setTemperatura(22.4f);

stazione.removeDisplay(display2);
stazione.setTemperatura(29.1f);
}
}
// interfaccia di display che ha l'aggiornamento della temperatura 
 interface Display  {
void update(float temperatura);
    
}
// classe della stazione meteo che aggiunge, rimuove, notifica e setta la temperatura 
class StazioneMeteo {

    private List<Display> registro = new ArrayList<>();
    private float temperatura;

    public void addDisplay(Display d) {
        registro.add(d);
    }

    public void removeDisplay(Display d) {
        registro.remove(d);
    }

    public void notificaDisplay() {
        for (Display d : registro) {
            d.update(temperatura);
        }

    }

    public void setTemperatura(float t) {
        this.temperatura = t;
        notificaDisplay();
    }

}
//classe di display console che implementa l'interfaccia display dove mostrerà l'aggiornamento effettuato della temperatura del display console
class DisplayConsole implements Display {

    public void update(float temperatura) {
        System.out.println("temperatura aggiornata DisplayConsole " + temperatura);
    }
}

// classe di display mobile che implementa l'interfaccia display dove mostrerà
// l'aggiornamento effettuato della temperatura del display mobile
class DisplayMobile implements Display {

    public void update(float temperatura) {
        System.out.println("temperatura aggiornata DisplayMobile " + temperatura);
    }
}
