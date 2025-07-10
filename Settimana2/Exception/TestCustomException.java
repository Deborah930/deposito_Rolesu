import java.util.Scanner;

public class TestCustomException {
    public static void main(String[] args) {
        try(Scanner scanner= new Scanner(System.in)) 
        {
            System.out.println("Inserire un nome: ");
            String nome= scanner.nextLine();
            StringValidator.check(nome);
            System.out.println("Nome corretto");
            
        } 
        catch(TooShortStringException e )
        {
            System.out.println(e.getMessage());
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
