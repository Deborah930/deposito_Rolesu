package com.example;
import java.sql.*;
import java.util.Scanner;

public class Esercizio2 {
    
}


 class Main {
 

    static final String URL = "jdbc:mysql://localhost:3306/sakila";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n===== MENU CLIENTI =====");
            System.out.println("1. Clienti con nome che inizia per A");
            System.out.println("2. Numero clienti per città");
            System.out.println("3. 5 clienti più recenti");
            System.out.println("4. Tutti i clienti ordinati per data di registrazione");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1 -> clientiPerLettera('A');
                case 2 -> contaClientiPerCitta();
                case 3 -> clientiPiuRecenti();
                case 4 -> clientiOrdinatiPerData();
                case 0 -> System.out.println("Uscita dal programma.");
                default -> System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);
        scanner.close();
    }

    // 1. Clienti il cui nome inizia con una lettera
    public static void clientiPerLettera(char lettera) {//Recupera tutti i clienti il cui nome inizia con una lettera specifica.
        String sql = "SELECT first_name, last_name FROM customer WHERE first_name LIKE ?";//Prepara una query SQL con un parametro (?) per cercare i nomi che iniziano con una lettera.
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);// Apre la connessione al DB.
             PreparedStatement stmt = conn.prepareStatement(sql)) {//Crea un PreparedStatement con la query SQL.
            //1 = il primo (e unico) segnaposto ? nella query.lettera + "%" = il valore che verrà sostituito al ?.
            //Se lettera = 'A', il valore diventa "A%".
            stmt.setString(1, lettera + "%");//Imposta il parametro ? con il valore, ad esempio se lettera = 'A' → diventa "A%"Il simbolo % significa qualsiasi sequenza di caratteri (operatore LIKE).
            ResultSet rs = stmt.executeQuery();//Esegue la query e ottiene il risultato

            System.out.println("\nClienti con nome che inizia per " + lettera + ":");
            while (rs.next()) {
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));//Scorre i risultati e stampa nome e cognome.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. Conta clienti per città
    public static void contaClientiPerCitta() {
        /*Query per contare i clienti raggruppati per città.
          Usa JOIN per unire customer → address → city.
          GROUP BY ci.city per raggruppare.
          ORDER BY numero_clienti DESC per ordinare dal più al meno. 
          */
        String sql = """
            SELECT ci.city, COUNT(c.customer_id) AS numero_clienti
            FROM customer c
            JOIN address a ON c.address_id = a.address_id
            JOIN city ci ON a.city_id = ci.city_id
            GROUP BY ci.city
            ORDER BY numero_clienti DESC
            """;
            // apre/chiude automaticamente connessione, statement e result set.
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\nNumero clienti per città:");
            while (rs.next()) {
                System.out.printf("%-20s %d\n", rs.getString("city"), rs.getInt("numero_clienti"));//Stampa in formato tabellare: città e numero di clienti.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Mostra i 5 clienti più recenti
    public static void clientiPiuRecenti() {
        //Ordina i clienti per data di creazione in ordine decrescente.
        //LIMIT 5 → mostra solo i primi 5.
        String sql = "SELECT first_name, last_name, create_date FROM customer ORDER BY create_date DESC LIMIT 5";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            //Stampa nome, cognome e data di registrazione.
            System.out.println("\n5 clienti più recenti:");
            while (rs.next()) {
                System.out.printf("%s %s - %s\n",//usa il metodo printf per stampare testo formattato.%s indica che, nel punto in cui compare, verrà inserito un valore convertito in stringa.
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getTimestamp("create_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 4. Mostra tutti i clienti ordinati per data
    public static void clientiOrdinatiPerData() {//Mostra tutti i clienti ordinati per data crescente.
        //Ordina i clienti per data di creazione in ordine crescente.
        //LIMIT 5 → mostra solo i primi 5.
        String sql = "SELECT first_name, last_name, create_date FROM customer ORDER BY create_date ASC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\nClienti ordinati per data di registrazione:");
            while (rs.next()) {
                System.out.printf("%s %s - %s\n",
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getTimestamp("create_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
