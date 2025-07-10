import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EsercizioBankAccount {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Luca Neri");
    
        account.displayBalance();
        account.deposit(250);
        account.withdraw(100);
        account.displayBalance();
       /* EXTRA NON RIUSCITO
        ArrayList<BankAccount> listAccount = new ArrayList<>();
        String name = input.nextLine();
        System.out.println("Inserisci il nome: " + name);
        String password= input.nextLine();
        for (BankAccount nome : listAccount) {
            System.out.println();
        }*/

    }
}

class BankAccount {


    String accountHolderName;
    double balance;

    public BankAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.balance = new Random().nextDouble() * 1000;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposito di euro:" + amount);
        } else {
            System.out.println("Importo non valido");
        }
    }

    void withdraw(double amount) {
        if (balance > 0) {
            balance -= amount;
            System.out.println("Prelievo di euro: " + amount);
        } else {
            System.out.println("Prelievo non possibile");

        }
    }

    void displayBalance() {

        System.out.println("Saldo disponibile: " + balance);
    }

}
