   import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MainFactory3 {
   

    public static void main(String[] args) {
        Scanner inputS= new Scanner(System.in);
        ShapeCreator creator= new ConcreteShapeCreator1();
        creator.addObserver(new ControlloObserver() );
     
        
      
        boolean continua= true;
        while(continua)
        {
            System.out.println("\n--- Menù Shape---");
            System.out.println("1. Disegna un cerchio");
            System.out.println("2. Disegna un quadrato");
            System.out.println("3. Uscita");
            System.out.print("Scelta: ");
            String scelta= inputS.nextLine();
            
            switch(scelta)
            {
                case "cerchio":
               IShape circle= creator.createShape("circle");
               circle.draw();
               creator.aggiornamento(scelta);;
                break;
                case "quadrato" :
               IShape square= creator.createShape("square");
               square.draw();
               creator.aggiornamento(scelta);
                break;
                case "3" :
                System.out.println("Esci");
                continua=false;
                continue;
                default:
                System.out.println("Scelta non valida");
                continue;
            }
            
        }
       
        
    }
}

