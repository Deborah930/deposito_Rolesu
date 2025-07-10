public class StringValidator {
    public static void check(String s) throws TooShortStringException
    {
        if(s.length()<8)
        {
            throw new TooShortStringException(" Il nome è più corto di 8 caratteri", null);
        }
    }
}
