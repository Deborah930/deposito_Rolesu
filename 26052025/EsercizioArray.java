import java.util.Scanner;
//slide 110
public class EsercizioArray {
    public static void main(String[] args)
    {
       Scanner input= new Scanner(System.in);
       System.out.println("Quanti dolci vuoi ordinare?: ");
       int TotaleDolci= input.nextInt();

       String [] nome_dolce = new String[10];
       int [] quantitaOrdine= new int [10];

       for( int i=0; i<nome_dolce.length;i++)//inizializzazione variabile nome_dolce
       {
         nome_dolce[i] = "Cannolo " ;
         nome_dolce[i] = "Americana ";
         nome_dolce[i] = "Tiramisu ";
         nome_dolce[i] = "Ciambella ";
         nome_dolce[i] = "Croissant ";
        System.out.println("nome dei dolci: " + nome_dolce[i]);

       }
       for(int i=0; i<quantitaOrdine.length;i++)
       {
         quantitaOrdine[i]=i+1;
        System.out.println("nome dei dolci: " + quantitaOrdine[i]);
       }
       
       
       if(quantitaOrdine[0]>1)
       {
        System.out.println(" dolce:" + nome_dolce  + " quantita:" + quantitaOrdine);

       }
       if(quantitaOrdine[0]<0)
       {
         System.out.println("Errore");
       }

// Da correggere e rivedere BENE
    
    }
}
