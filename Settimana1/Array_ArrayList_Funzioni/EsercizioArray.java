import java.util.Scanner;
//slide 110
public class EsercizioArray {
    public static void main(String[] args)
    {
       Scanner input= new Scanner(System.in);
// richiesta all'utente della quantità dei dolci da ordinare che sono massimo 10
       System.out.println("Quanti dolci vuoi ordinare? (Max10)");
       int num = input.nextInt();
       //controllo che il numero inserito non sia minore di 1 o maggiore di 10
       while(num<1 || num>10)
       {
        System.out.println("Errore quantita");
        num=input.nextInt();
       }
       // creo due array uno per i nomi, uno per la quantità
       String[] nomeDolce= new String[num];
       int []  quantitaDolci = new int [num];
   // inserimento dei dati
      for(int i=0; i<num;i++)
      {
        System.out.println("Nome del dolce: " + (i+1) + " ");// inserisco il nome del dolce
        nomeDolce[i]= input.next();
       int quantita;
       do{
        System.out.println("Inserire la quantita" + nomeDolce[i] + " : ");// inserisco la quantità dei dolci 
        quantita= input.nextInt();
        if(quantita<0) // check che la quantità non sia minore di 10
        {
          System.out.println("Quantità <0");// nel caso di <10 ripetere domanda
        }
       }while(quantita<0);
       quantitaDolci[i]=quantita;// aggiunta della quantià all'array

       

       }
       //stampa quantità totale degli ordini
        int totale= 0;
        for(int i=0; i<num;i++)
        {
       totale+=quantitaDolci[i];
        System.out.println("Totale dolci ordinati: " + totale);// esce due volte ?? errato!!!!!
        }      
       



      

     
    
    }
}

