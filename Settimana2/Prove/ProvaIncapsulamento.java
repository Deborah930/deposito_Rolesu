public class ProvaIncapsulamento {
    public static void main(String[] args) {
        Person myObj=new Person();
        myObj.setName("Pippo"); // Settiamo il valore name="pippo"
        System.out.println(myObj.getName());
    }
}
class Person
{
    private String name; // private

    public String getName() //Getter
{
    return name;
}
public void setName(String newName)//Setter
{
    this.name=newName;
}
}
class Persona
{
    //Campi privati(incapsulamento)
    private String nome;
    private int eta;


    //Costruttore pubblico
    public Persona(String nome, int eta)
    {
        this.nome=nome;
        this.eta=eta;
    }

    //Metodo privato utilizzato dalla classe
    private boolean verificaMaggiorenne()
    {
        return this.eta>=18;
    }

    //Metodo pubblico che fa uso del metodo privato
    public void stampaStatus()
    {
        if(verificaMaggiorenne())
        {
            System.out.println(this.nome + "è maggiorenne");
        }else{
            System.out.println(this.nome+ " mpm è maggiorenne");
        }
    }
}

