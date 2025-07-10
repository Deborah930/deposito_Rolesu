public class EsempioDivisione {
    public static int divisioneChecked(int a, int b)throws Exception //eccezione controllata
    {
        if(b == 0)
        {
            throw new Exception();
        }
        return a/b;
    }

    public static int divisioneUnChecked(int a, int b)// eccezione non controllata
    {
        if(b == 0)
        {
            throw new  RuntimeException("Il secondo operando non può essere 0 ");
        }
        return a/b;
    }
    public static int divisione3(int a,int b)
    {
        try {
            return a/b;
        } catch (Exception e) {
            throw new RuntimeException("Il secondo operando non può essere 0 ", e );
        }
    }
}
