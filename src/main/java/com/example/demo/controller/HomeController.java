package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/alumno")
    public String alumno() {
        return "alumno";
    }

    @GetMapping("/docente")
    public String docente() {
        return "docente";
    }

    @GetMapping("/tema")
    public String tema() {
        return "tema";
    }

    @GetMapping("/curso")
    public String curso() {
        return "curso";
    }

}
