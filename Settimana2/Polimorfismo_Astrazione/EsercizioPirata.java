public class EsercizioPirata {
    public static void main(String[] args) {
       Persona p1 = new Persona("Alice");
        Persona p2 = new Persona("Bob");
     Pirata pirata = new Pirata("Jack Sparrow");
      p1.saluta();       
      p2.saluta();
      pirata.saluta(); 
    }
}

class Persona {
    protected String nome;

    // costruttore
    Persona(String nome) {
        this.nome = nome;
    }

    void saluta() {
        System.out.println("Ciao.. sono " + nome);
    }
}

class Pirata extends Persona {
   

    // costruttore
    Pirata(String nome) {
        super(nome);
    }
   @Override
   public void saluta() {
        System.out.println("Ciao sono un pirata! E mi chiamo " + nome );
    }
}