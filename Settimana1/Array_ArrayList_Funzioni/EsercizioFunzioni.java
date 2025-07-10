public class EsercizioFunzioni {
    
    public static int numero(int base, int esponente) //calcolo elevazione
    {
        return base*esponente;
    }
   
    public static int calcoloLettere(String a)//extra
    {
        return a.length();
    }

    public static void main(String[] args) 
    {
       
       System.out.println(numero(10, 2));//output del risultato
       System.out.println(calcoloLettere("Ciao"));// output lunghezza stringa
      
       

    }
}
