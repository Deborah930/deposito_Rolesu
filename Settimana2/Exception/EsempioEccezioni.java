

public class EsempioEccezioni {
    public static void main(String[] args) {
        try
        {
            int a=5;
            int b=0;
            int c = a/b;
            System.out.println(c);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            int d=3/0;
            System.err.println(d);
        }
        finally
        {
         System.err.println("Finally");
        }
        System.err.println("Programma terminato");
    }
}
