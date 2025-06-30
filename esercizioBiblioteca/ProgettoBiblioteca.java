package esercizioBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgettoBiblioteca {
    public static void main(String[] args) {
        Book libro = new Book();// ho creato un istanza della classe Book
        Library book = new Library();
        libro.diplayBookInfo();// ho richiamato il metodo della classe Book
       
        book.addBook(libro);//aggiunta del libro
        book.displayBooks();
       

    }

}

class Book {
    // dichiarazione di variabili
    String title;
    String author;
    boolean isAvailable = true;

    public Book() {// creazione del costruttore
        // Chiedo in input tutte le informazioni
        Scanner inputString = new Scanner(System.in);
        System.out.println("Qual'è il titolo del libro? : ");
        title = inputString.nextLine();
        System.out.println("Qual'è l'autore del libro? : ");
        author = inputString.nextLine();
        Scanner inputBool = new Scanner(System.in);
        System.out.println("Il libro è disponibile? :");
        isAvailable = inputBool.nextBoolean();

    }

    // creo un metodo che faccia vedere le informazioni,in output,del libro
    // richiesto
    void diplayBookInfo() {
        if (isAvailable == true) {
            System.out.println("Libro disponibile: " + title + " - " + author);
        } else {
            System.out.println("Libro non disponibile");
        }

    }
    //per poter visualizzare in displayBooks i libri dentro l'array 
     public String toString (String title, String author, Boolean isAvailable) {
    return "Titolo: " + title + ", Autore: " + author + ", Disponibile: " + isAvailable;
}
}
//creazione della classe Library
class Library {
    
    //creazione della lista per i libri
    ArrayList<Book> books = new ArrayList<>();
 //costruttore
    public Library() {
        Scanner inputArray = new Scanner(System.in);
        String book = inputArray.nextLine();

    }
    //metodo per aggiungere un libro
    void addBook(Book book) {
        books.add(book);
        System.out.println("Libro aggiunto correttamente ");
    }
    //creazione metodo per vedere i libri dentro l'arrayList
    void displayBooks()
    {
        if(books.isEmpty())//controllo arrayList se è vuota 
        {
            System.out.println("Libri non presenti nella libreria");
        }
        else{
         int full=1;//contatore
         for(Book book : books)   
         {
            
            System.out.println("Libro presente:" + book );
            full++;
         }
        }
    }
}
