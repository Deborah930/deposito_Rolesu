import java.util.ArrayList;

public class ProvaPolimorfismo {
    ArrayList<X> insiemeX=new ArrayList<>();
    void azionatore(X obj)
    {
        obj.azione();
    }
}

 public static void main(String[] args) {
        
        

    }




 class X {
   
    void azione(){
        System.out.println("azione generica");
    }
    

}

 class X2 extends X {
   
    void azione(){
        System.out.println("azione x2");
    }

}

 class X1 extends X {
   
     void azione(){
        System.out.println("azione x1");
    }
   
}