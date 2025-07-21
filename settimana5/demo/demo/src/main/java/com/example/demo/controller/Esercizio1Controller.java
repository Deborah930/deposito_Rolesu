package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Esercizio1Model;
import com.example.demo.model.Prodotto;


@RestController
@RequestMapping("/numeri")
public class Esercizio1Controller {
    private List<Esercizio1Model> numeri = new ArrayList<>();
    private Long idCounter = 1L;


    @GetMapping
    public List<Esercizio1Model> getAll() {
        return numeri;
    }
    
    @PostMapping
    public Esercizio1Model crea(@RequestBody Esercizio1Model nuovo) {
        nuovo.setId(idCounter++);
        numeri.add(nuovo);// aggiunge l’oggetto alla lista.
        return nuovo;
    }

    @GetMapping("/{id}")// pathvariabile si utilizza quando si hanno cose piccole
    public Esercizio1Model getById(@PathVariable Long id) {
        return numeri.stream()//cerca nell’elenco l’oggetto con lo stesso id
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
   
   
//Serve per aggiornare un numero già esistente.
     @PutMapping("/{id}")// sovrascrivere un valore
    public Esercizio1Model aggiorna(@PathVariable Long id, @RequestBody Esercizio1Model modificato) {
        for (Esercizio1Model n : numeri) {
            if (n.getId().equals(id)) {
                n.setNumero(modificato.getNumero());//cambia il valore del numero con quello ricevuto.
                aggiornaSomma();//dopo la modifica, ricalcola la somma totale.
                return n;
            }
        }
        return null;
    }

     @GetMapping("/somma")//ogni slash un get
    public int sommaTotale() {
        return numeri.stream()
                     .mapToInt(Esercizio1Model::getNumero)//prende solo il valore numero di ogni elemento.
                     .sum();//somma tutti i numeri e restituisce un int.
    }

    // Metodo privato per aggiornare il campo somma di tutti gli oggetti
    private void aggiornaSomma() {
        int sommaTotale = numeri.stream()
                                .mapToInt(Esercizio1Model::getNumero)//prende solo il valore numero di ogni elemento.
                                .sum();//somma tutti i numeri e restituisce un int.
        for (Esercizio1Model n : numeri) {
            n.setSomma(sommaTotale);
        }
    }


    @DeleteMapping("/{id}")
    public String elimina(@PathVariable Long id) {
        numeri.removeIf(n -> n.getId().equals(id));
        return "Numero eliminato con successo.";
    }
}
    
   
