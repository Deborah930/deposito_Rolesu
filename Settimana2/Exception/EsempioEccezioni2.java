import java.util.Scanner;

public class EsempioEccezioni2 {
    public static void main(String[] args) {
        Scanner scanner = null;

        try {
            scanner=new Scanner(System.in);
            System.err.println("Inserire un numero: ");
            int input= scanner.nextInt();
            System.err.println("Inserito: " + input);
            int x=input/ 0;
            System.err.println("x = " + x );
        } catch (Exception ex) {
           ex.printStackTrace();
        } finally{
            scanner.close();
        }
    }
}
