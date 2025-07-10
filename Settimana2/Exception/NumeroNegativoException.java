public class NumeroNegativoException extends Exception 
{
    public NumeroNegativoException(String message, Throwable cause)
    {
        super(message,cause);
    }
}
class NumeroZeroException extends RuntimeException
{
     public NumeroZeroException( String message, Throwable cause)
     {
      super(message,cause);
     }
}
class Controller
{
    public static void checkPositive(int n) throws NumeroNegativoException
    {
        if(n<0)
        {
            throw new NumeroNegativoException(n+"Non è un numero positivo ",null);
                
        }
        
    }
    public static void checkNoZero( int n) throws NumeroZeroException
        {
            if(n==0)
            {
                throw new NumeroZeroException("Il numero è zero",null);
                
            }
        }
}
