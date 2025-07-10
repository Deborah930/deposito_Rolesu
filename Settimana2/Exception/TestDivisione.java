public class TestDivisione {
    public static void main(String[] args) // da non usare nel main throws Exception
    {
        try {
            EsempioDivisione.divisioneChecked(4, 2);
            try{
                EsempioDivisione.divisioneUnChecked(4, 1);
            }catch(Exception ex){
                ex.printStackTrace();
                String message= ex.getMessage();
                System.out.println(message);
            }
            try {
                EsempioDivisione.divisione3(1, 0);
            } catch (Exception e) {
                String message= e.getMessage();
                System.out.println(message);
                Throwable causa= e.getCause();
                e.printStackTrace();
                causa.printStackTrace();
            }
            System.out.println("Ciao");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Programma terminato");
    }
}
