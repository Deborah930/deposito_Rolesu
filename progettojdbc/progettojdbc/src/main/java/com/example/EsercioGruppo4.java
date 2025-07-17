package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//non parte il menù
public class EsercioGruppo4 {
    static final String URL = "jdbc:mysql://localhost:3306/sakila";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Scanner inputS = new Scanner(System.in);
        Scanner inputI = new Scanner(System.in);
        int scelta = inputS.nextInt();
        boolean continua = true;
        do {
            System.out.println("Menù Utenti:");
            System.out.println("1.Inserisci utente");
            System.out.println("2.Visualizza tutti gli utenti");
            System.out.println("3.Aggiorna nome");
            System.out.println("4.Cancella nome");
            System.out.println("0. Esci");

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci nome utente:");
                    String nome = inputS.nextLine();
                    System.out.println("Inserisci email:");
                    String email = inputS.nextLine();
                    insertUtente(nome, email);
                    break;
                case 2:
                    System.out.println("Lista degli Utenti:");
                    visualizzaUtenti();
                    break;
                case 3:
                    System.out.println("Inserisci il nome da aggiornare: ");
                    nome = inputS.nextLine();
                    System.out.println("Inserisci l'id del nome da cambiare:");
                    int id = inputI.nextInt();
                    aggiornaNomeUtente(nome, id);
                    break;
                case 4:
                    System.out.println("Inserisci l'id per la cancellazione");
                    id = inputI.nextInt();
                    cancellaUtente(id);
                    break;
                case 0:
                    System.out.println("Esci!");
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida!");
                    
            }
        } while (continua);
        inputS.close();
        inputI.close();
    }

    // CREATE
    // metodo per creare un utente
    public static void insertUtente(String nome, String email) {
        // Query SQL con parametri placeholder
        String sql = "INSERT INTO utenti (nome, email) VALUES (?, ?)";
        // apre connessione e PreparedStatement (si chiudono automaticamente)
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Sostituisce il primo ? con il valore di nome
            stmt.setString(1, nome);
            // Sostituisce il secondo ? con il valore di email
            stmt.setString(2, email);
            // Esegue la query di INSERT
            stmt.executeUpdate();
            System.out.println("Utente inserito.");// visualizzazione conferma

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // visualizzazione degli utenti
    // metodo per visualizzare gli utenti
    public static void visualizzaUtenti() {
        // Query SQL per selezionare tutti i record dalla tabella 'utenti'
        String sql = "SELECT * FROM utenti";
        // apro connessione, statement e result set
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            System.out.println("ID | Nome | Email");
            System.out.println("--------------------------");

            // Scorre tutte le righe restituite dalla query con result
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                System.out.println(id + " | " + nome + " | " + email);
            }

        } catch (SQLException e) {
            System.out.println("Errore durante la visualizzazione degli utenti.");
            e.printStackTrace();
        }
    }

    // aggiornamento utenti
    // metodo per aggiornare il nome dell'utente
    public static void aggiornaNomeUtente(String nuovoNome, int id) {
        String sql = "UPDATE utenti SET nome = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Sostituisce il primo ? con il nuovo nome
            stmt.setString(1, nuovoNome);
            // Sostituisce il secondo ? con l'id
            stmt.setInt(2, id);
            // Esegue l'UPDATE
            int righeAggiornate = stmt.executeUpdate();
            // Se almeno una riga è stata modificata, "Nome utente aggiornato con successo!"
            if (righeAggiornate > 0) {
                System.out.println("Nome utente aggiornato con successo!");
            } else {
                System.out.println("Nessun utente trovato con ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Errore durante l'aggiornamento del nome.");
            e.printStackTrace();
        }
    }

    // eliminazione utenti
    // metodo per l'eliminazione di un utente
    public static void cancellaUtente(int id) {
        // query per eliminare un utente in base all'id
        String sql = "DELETE FROM utenti WHERE id = ?";
        // apertura connessione e preparedStatement
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Sostituisce il ? con l'ID
            stmt.setInt(1, id);
            // esecuzione della query
            int righeCancellate = stmt.executeUpdate();
            // controllo se è stata cancellata una riga
            if (righeCancellate > 0) {
                System.out.println("Utente con ID " + id + " cancellato con successo.");
            } else {
                System.out.println("Nessun utente trovato con ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Errore durante la cancellazione dell'utente.");
            e.printStackTrace();
        }
    }

}
