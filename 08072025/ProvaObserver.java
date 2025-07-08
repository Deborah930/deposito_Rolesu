import java.util.ArrayList;
import java.util.List;

public class ProvaObserver 
{
    public static void main(String[] args) {
        
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver("Mario");
        Observer observer2 = new ConcreteObserver("Lucia");
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.setState("Nuovo messaggio: aggiornamento 1");
        subject.removeObserver(observer1);
        subject.setState("Nuovo messaggio: aggiornamento 2");
    }
}
interface Observer {
    void update(String message);
}

// Interfaccia Subject
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// ConcreteSubject
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(state);
        }
    }
}

// ConcreteObserver
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " ha ricevuto aggiornamento: " + message);
    }
}
