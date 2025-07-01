import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioIncapsulamento {
    public static void main(String[] args) {
        Scanner inputS= new Scanner(System.in);//scanner per stringhe
        Scanner inputI= new Scanner(System.in);// scanner per int
        System.out.println("Inserisci il nome dello studente: ");
        String nome=inputS.nextLine();//inserimento manuale per il nome
        System.out.println("Inserisci il voto iniziale dello studente: ");
        int votoIniziale=inputI.nextInt();//inserimento manuale per il voto
       
        int id = 0;
        Studente studente= new Studente(nome,votoIniziale,id);
        studente.setVoto();//change voto iniziale
        System.out.println("Nome studente : " + studente.getNome() + "voto valido :  " + studente.getVoto());
        studente.setVoto();
        //Lista di array non stampa da verificare
        ArrayList<Studente> listaStudenti= new ArrayList<>();
        for(Studente studenti : listaStudenti)
        {
          studente.listStudenti();
          System.out.println("Lista studenti: " + listaStudenti);
        }
    }
}
class Studente
{
   private String nome;
   private int voto;
   private int id;
   private static int idContatore=0;
    //costruttore della classe studente
    Studente(String nome, int voto, int id)
    {
        this.nome=nome;
        this.voto=voto;
        this.id=++idContatore;
    }
    public String getNome()// get
    {
        return this.nome;
    }
    public int getVoto()
    {
        return this.voto;
    }
    private boolean verificaVoto()
    {
        return this.voto>=0 && this.voto<=10;
    }
    public void setVoto()
    {
      if(verificaVoto())
      {
        this.voto=voto;
    
      }else{
        System.out.println("Errore! Voto fuori range");
      }
    }
    
    void listStudenti()
    {
        System.out.println(this.nome + this.voto + this.id);
    }
}
