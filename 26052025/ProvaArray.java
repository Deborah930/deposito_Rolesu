public class ProvaArray {
    public static void main(String[] args)

    {
        // Dichiarazione e inizializzazione
        int[] numeri = new int[5];
        // Array di dimensione 5

        int[] valori = {1,2,3,4,5};
        // Inizializzazione diretta


        //stampa il primo numero(indice zero)
        System.out.println("Primo numero :"+ valori[0] );

        
        for (int i=0;i < numeri.length;i++)
        {

         numeri[i]=i+1;

        }


        for(int i=0;i<numeri.length;i++)
        {
            System.out.print(numeri[i]+ " ");
        }


        //matrici
        //Array 2D
        int [] [] matrice= new int[3] [3];// prima parentesi quadra quale riga   seconda quadra quale colonna

        //Inizializzazione diretta
        int [] [] matricePredefinita= {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println("Elemento centrale: " + matrice[1][1]); //stampa il 5 si parte sempre da 0 sia per colonne che per righe
        // riempimento della matrice con numeri progressivi
        int valore=1;
        for (int i=0;i < matrice.length;i++)
        {
              for(int j=0; j < matrice[i].length;i++)
              {
                matrice [i][j]= valore++;
              }
        }
        //Stampa della matrice
        System.out.println("Matrice 3x3:");
        for (int i=0;i< matrice[i].length; i++)
        {
          for(int j=0; j < matrice [i].length;j++ )
          {
            System.out.println(matrice [i][j] + "\t");
          }
          System.out.println();// nuova riga per formattare la matrice
        }

    }

}
