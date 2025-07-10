import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class ProvaArrayList {
    public static void main(String[] args) 
    {
       ArrayList<Integer> numeri = new ArrayList <>();
       numeri.add(10);
       numeri.add(20);
       numeri.add(30);


       ArrayList <String> nomi= new ArrayList <>();
       nomi.add("Alice");
       nomi.add("Bob");
       nomi.add("Carlo");

       System.out.println("Primo nome: " + nomi.get(0));

       // Aggiunta di 10 numeri casuali
       for (int i=0; i <10; i++)
       {
        numeri.add((int) (Math.random() * 100) +1 );
       }

       //stampa della lista originale
       System.out.println("Lista originale:" + numeri);

       //Ordinamento della lista
       Collections.sort(numeri);

       //Stampa della lista ordinata
       System.out.println("Lista ordinata: " + numeri);

       //prova metodi list
        numeri.reversed();
        numeri.size();
        



    }
}
