import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Adapter_11072025 {
        public static void main(String[] args) {
        Scanner inputS= new Scanner(System.in);
         UserManagementFacade facade= new UserManagementFacade();//uso il facade
        boolean continua= true;
        while (continua) {
            System.out.println("\nScegli un'opzione:");
            System.out.println("1. Registra utente");
            System.out.println("2. Cerca utente");
            System.out.println("3. Rimuovi utente");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            String scelta= inputS.nextLine();
            switch (scelta) {
                case "1":
                    System.out.print("Inserisci username da registrare: ");
                    String nuovoUtente = inputS.nextLine();
                    facade.registerUser(nuovoUtente);
                    break;
                case "2":
                    System.out.print("Inserisci username da cercare: ");
                    String utenteDaCercare = inputS.nextLine();
                    facade.ricercaUser(utenteDaCercare);
                    break;
                case "3":
                    System.out.print("Inserisci username da rimuovere: ");
                    String utenteDaRimuovere = inputS.nextLine();
                    facade.removeUser(utenteDaRimuovere);
                    break;
                case "0":
                    System.out.println("Uscita dal sistema.");
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
    
   
}
//interface con metodi usati nell'adapter
interface UserManagement
{
    void createUser(String username);
    void deleteUser(String username);
    void findUser(String username);
}
//Sistema legacy
class LegacyUserSystem
{
    
    public void addUser(String user)
{
    System.out.println("Aggiunto utente: " + user);
}


public void removeUser(String user)
{
    System.out.println("Rimosso utente: " + user);
}

public void searchUser(String user)
{
    System.out.println("Utente trovato: " + user);
}
}

//Adapter
class UserManagementAdapter implements UserManagement
{
    private LegacyUserSystem legacyUserSystem;

    public UserManagementAdapter(LegacyUserSystem legacyUserSystem)
    {
        this.legacyUserSystem= legacyUserSystem;
    }

    public void createUser(String username)
    {
        legacyUserSystem.addUser(username);
    }
    public void deleteUser( String username)
    {
        legacyUserSystem.removeUser(username);
    }
    public void findUser(String username)
    {
        legacyUserSystem.searchUser(username);
    }
}

//Facade 
class UserManagementFacade
{
    private UserManagement userManagement;
    public UserManagementFacade()
    {
        this.userManagement=new UserManagementAdapter(new LegacyUserSystem());
    }
    //quando creo un nuovo user aggiunge registrazione utente
    public void registerUser(String username)
    {
        System.out.println("Registrazione utente!");
        userManagement.createUser(username);
    }
    //quando rimuovo un nuovo user aggiunge rimozione dell'utente
    public void removeUser(String username)
    {
        System.out.println("Rimozione dell'utente...");
        userManagement.deleteUser(username);
    }
    //quando cerco un user aggiungo ricerca utente
    public void ricercaUser(String username)
    {
        System.out.println("Ricerca utente...");
        userManagement.findUser(username);
        
    }
}
//decorator ?? da aggiungere

