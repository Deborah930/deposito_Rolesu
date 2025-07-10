import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EsercizioFactory3 {
    //IL DECORATOR NON è CONCLUSO E NON è FINITO
}

    

//interfaccia per avere un metodo per le classi cerchio e quadrato comune
interface IShape
{
    void draw();
}

//decorator astratto
abstract class DecoratorShape implements IShape
{
    protected IShape decoratoreShape;

    public DecoratorShape(IShape decoratoreShape)
    {
        this.decoratoreShape=decoratoreShape;
    }
    public void draw()
    {
        decoratoreShape.draw();
    }
}

//decorator concreto
class DecoratoreBordo extends DecoratorShape
{
    public DecoratoreBordo(IShape decoratoreShape)
    {
        super(decoratoreShape);
    }

    public void draw()
    {
        decoratoreShape.draw();
        setBordo();
    }
    private void setBordo()
    {
        System.out.println("aggiunto bordo giallo");
    }
}

//classe concreta Circle
class Circle implements IShape{
public void draw()
{
    System.out.println("Disegno di un cerchio");
}
}

//classe concreta quadrato
class Square implements IShape
{
    public void draw()
    {
        System.out.println("Disegno di un quadrato");
    }
}

// observer interfaccia
interface ObserverShape
{
    void notifica(String type);
}
//controllo degli osservatori
class ControlloObserver implements ObserverShape
{
    public void notifica(String type)
    {
        System.out.println("Aggiornamento! è stato creato un: " + type );
    }
}

abstract class ShapeCreator
{
    public abstract IShape createShape(String type);
    private List<ObserverShape> observers= new ArrayList<>();//lista per aggiungere gli osservatori

    public void addObserver(ObserverShape observer)//aggiunta degli osservatori
    {
        observers.add(observer);
    }
    void aggiornamento(String type)//aggiornamento degli osservatori
    {
        for(ObserverShape os: observers)
        {
            os.notifica(type);
        }
    }
        
    
   
}




//Factory 1
class ConcreteShapeCreator1 extends ShapeCreator
{
public IShape createShape(String type)
{
    if(type.equalsIgnoreCase("circle"))
    {
        return new Circle();
    }else if(type.equalsIgnoreCase("square"))
    {
            return new Square();
    }else{
        System.out.println("Tipo non esistente");
        return null;
    }
}
}
//Factory 
class ConcreteShapeCreator2 extends ShapeCreator
{
    public IShape createShape(String type)
    {
        switch(type)
        {
            case "circle" :
            return new Circle();
            case "square" :
            return new Square();
            default:
            System.out.println("Tipo non esistente");
            return null;

        }
    }
}




