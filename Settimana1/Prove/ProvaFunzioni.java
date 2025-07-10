public class ProvaFunzioni {
    static void saluta() 
    {
        System.out.println("Ciao, Java!");
    }
    static int somma(int a, int b)
    {
        return a+b;
    }
    static void mostra(int numero)
    {
        System.out.println("Numero:"+ 10 + numero);
    }
    static void mostra(String testo)
    {
        System.out.println("Testo: " + testo);
    }

    public static void main(String[] args) 
    {
        saluta();// Chiamata del metodo
        System.out.println(somma(10,20));// Output:30
        mostra(10); // Chiama mostra(int)
        mostra("Ciao"); //Chiama mostra(String)
    }
}
