public class ProvaDecorator {
    public static void main(String[] args) {
           // Creiamo il componente di base
        Component componenteBase = new ConcreteComponent();

        // Decoriamo il componente con ConcreteDecoratorA
        Component componenteDecorato = new ConcreteDecoratorA(componenteBase);
     
        // Chiama operation() sul componente decorato, che eseguirà la logica del componente base e aggiungerà quella del decorator.
        componenteDecorato.operation();
    }
}

// Interfaccia Component
 interface Component {
    void operation();
}

// Componente Concreto
class ConcreteComponent implements Component {
    public void operation() {
        System.out.println("Operazione base");
    }
}

// Decorator astratto
 abstract class Decorator implements Component {
    protected Component component;
    
    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

// Decoratore Concreto
 class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        System.out.println("Aggiunta funzionalità A");
    }
}