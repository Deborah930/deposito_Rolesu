

import java.util.Scanner;

public class esercizioWhile {
    public static void main(String[] args) {
        String password_corretta= "java123";
       Scanner input = new Scanner(System.in);
               System.out.println("Inserisci la password: ");
               String password = input.nextLine();

       
        int tentativo = 0;
        while (tentativo <3) {
            if (password_corretta == password) {
                System.out.println("Accesso riuscito.");
                break;
            }
            else
            {
            System.out.println("Password non corretta");
            tentativo ++;
            }
        }
    }
}
                  //String conferma;// con il char da errore nell'input
                /*do {
                    Scanner input1 = new Scanner(System.in);
                   System.out.println("Vuoi accedere al sistema?");}*/
            
                    
                   
                
            
           
            
        
    

