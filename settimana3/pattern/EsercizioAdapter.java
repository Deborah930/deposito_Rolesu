public class EsercizioAdapter {
   public static void main(String[] args) {
    AmericanSocket americanSocket= new AmericanSocket();
   EuropeanSocket adapter= new SocketAdapter(americanSocket);
   americanSocket.provideEletricity();
   } 
}

//interfaccia target
interface EuropeanSocket
{
   void giveElectricity();
}

class AmericanSocket
{
 public void provideEletricity()
    {
        System.out.println("Elettricità Americana");
    }
}

class SocketAdapter implements EuropeanSocket
{
    private AmericanSocket americanSocket;
    public SocketAdapter(AmericanSocket americanSocket)
    {
        this.americanSocket=americanSocket;
    }
    public void giveElectricity(){
        americanSocket.provideEletricity();
    }
}

