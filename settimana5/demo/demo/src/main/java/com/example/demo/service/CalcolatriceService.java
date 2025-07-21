package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CalcolatriceService {
    @GetMapping("/somma")
    public int somma( int a,  int b)
    {
        return a+b;
    }
}
