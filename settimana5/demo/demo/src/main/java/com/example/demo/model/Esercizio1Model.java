package com.example.demo.model;

public class Esercizio1Model
 {
    /*aggiungere numeri a un array con la post,
     vedere la lista di numeri, vedere la somma totale dei numeri, 
     rimuovere dei numeri */
     private Long id;
     private int numero;
     private int somma;
     //costruttore vuoto
     Esercizio1Model(){}
     Esercizio1Model(Long id, int numero,int somma)
    {
        this.id=id;
        this.numero=numero;
        this.somma= somma;
    }
    //getter e setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getNumero(){return numero;}
    public void setNumero(int numero){this.numero=numero;}
    public int getSomma(){return somma;}
    public void setSomma(int somma){this.somma=somma;}
    


}
