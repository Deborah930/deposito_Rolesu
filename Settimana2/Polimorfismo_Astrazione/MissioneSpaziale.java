/*import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MissioneSpaziale {
    public static void main(String[] args) {
       
        Scanner inputS= new Scanner(System.in);
        String ruolo=inputS.nextLine();
       
        for (int i = 0; i < ruolo.length(); i++) {
          System.out.println("Qual'è il tuo pianeta preferito?");
         
          if(ruolo.equals("astronauta")){
           
            String tipo = inputS.nextLine();
            System.out.println("Nome: ");
            String nome=inputS.nextLine();
            System.out.println("Email: ");
            String email= inputS.nextLine();
            System.out.println("Credito ossigeno: ");
            
          }

        
       


       // Astronauta astronauta= new Astronauta("Luca", "astronautaLuca@gmail.com", 0);
      //  astronauta.login();
        StazioneSpaziale stazione= new StazioneSpaziale("Piante", 4);
        Scienziato scienziato= new Scienziato("Paolo", "scienziatoPaolo@gmail.com", 0);
        scienziato.addEsperimento(stazione, "fioritura");
        Ispettore ispettore= new Ispettore("Ispettore", null, 0);
        ispettore.addValutazione(stazione, 0);

    } 
}
class Astronauta
{//attributi
   protected String nome;
   protected String email;
   protected float creditoOssigeno;
   //costruttore
    Astronauta(String nome, String email, float creditoOssigeno)
    {
      this.nome=nome;
      this.email=email;
      this.creditoOssigeno=creditoOssigeno;
    }
    public String getNome()// get
    {
        return this.nome;
    }
    public void setNome(String nome)
    {
        this.nome=nome;
    }

    public String getEmail()
    {
        return this.email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public float getCreditoOssigeno()
    {
        return this.creditoOssigeno;
    }
    public void setCreditoOssigeno(float creditoOssigeno)
    {
        this.creditoOssigeno=creditoOssigeno;
    }
//metodo di login
    public void login()
    {
        Random random= new Random();
        creditoOssigeno=random.nextFloat()*100;//inserimento random 
        System.out.println("Login effettuato");
    }

    public void stampaDati()//metodo per stampare i dati
    {
        System.out.println("nome: " + nome);
        System.out.println("email: " + email);
        System.out.println("Credito ossigeno: " + creditoOssigeno);
    }
}







class StazioneSpaziale
{//attributi
     ArrayList<String> esperimenti= new ArrayList<>();
     ArrayList <Integer> valutazioni= new ArrayList<>();
     //costruttore
    StazioneSpaziale(String esperimenti, int valutazioni)
    {
        this.esperimenti=new ArrayList<>();
        this.valutazioni= new ArrayList<>();
    }
    public void addEsperimento(String nome)//metodo per aggiungere gli esperimenti
    {
        esperimenti.add(nome);
        System.out.println("Esperimento aggiunto: " + nome);
    }
    public void addValutazione(int voto)// metodo per aggiungere le valutazioni QUALCOSA DI ERRATO (OUTPUT SEMPRE FUORI RANGE)
    {
        if(voto>=1 && voto<=5)//controllo delle valutazioni se sono maggiori di 1 e minori di 5
        {
            valutazioni.add(voto);
            System.out.println("Valutazione aggiuntaL: " + voto);
        }
        else
        {
            System.out.println("Valutazione fuori range");
        }
    }
    public void printEsperimenti()//stampa della lista esperimenti
    {
        System.out.println("Esperimenti: ");
        for(String e : esperimenti)
        {
            System.out.println("-> " + e);
        }
    }
    public void printValutazioni()//stampa della lista valutazioni
    {
        System.out.println("Valutazioni: ");
        for(Integer v: valutazioni)
        {
            System.out.println("-> " + v);
        }
    }
}

 class Scienziato extends Astronauta {
    //contatore per le azioni
    private int contatore= 0;
   
// costruttore
    public Scienziato(String nome, String email,float creditoOssigeno) 
    {
        super(nome, email,creditoOssigeno);
    }
    //metodo per aggiungere un esperimento alla stazione
    
     public void addEsperimento(StazioneSpaziale stazione, String nomeEsperimento) 
     {
        stazione.addEsperimento(nomeEsperimento);
        
     }
   public void evoluzione()//evoluzione della classe ????????
   {
    if(contatore>3)
    {

    }
   }
}
class Ispettore extends Astronauta
{
    int contatore=0;
 // costruttore
 Ispettore (String nome, String email, float creditoOssigeno)
 {
    super(nome, email, creditoOssigeno);
 }
 //metodo per aggiungere una valutazione alla stazione
 public void addValutazione(StazioneSpaziale stazione, int voto) 
     {
        stazione.addValutazione(voto);
        
     }
    }
}*/
