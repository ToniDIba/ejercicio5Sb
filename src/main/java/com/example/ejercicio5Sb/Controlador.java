package com.example.ejercicio5Sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


@RestController
public class Controlador {

/*
    @Autowired
    private PersonaService personaService; */

    @Bean
    @Qualifier("bean1")
    PersonaService bean1() {
        PersonaService pers1 = new PersonaServiceImpl();
        pers1.setNombre("Carlos");
        return pers1;
    }


    @Bean
    @Qualifier("bean2")
    PersonaService bean2() {
        PersonaService pers2 = new PersonaServiceImpl();
        pers2.setNombre("Andrés");
        return pers2;
    }


    @Bean
    @Qualifier("bean3")
    PersonaService bean3() {
        PersonaService pers3 = new PersonaServiceImpl();
        pers3.setNombre("Fernando");
        return pers3;
    }


    //http://localhost:8080/controlador/bean/?nombreBean=bean1
    @GetMapping("/controlador/bean")
      public PersonaService controlador(@RequestParam String nombreBean) {

        switch (nombreBean.toLowerCase(Locale.ROOT).trim()) {
            case "bean1":
                return bean1();

            case "bean2":
                return bean2();

            case "bean3":
                return bean3();

            default:
                throw new IllegalArgumentException("Este @Bean no existe: " + nombreBean);
        }

    }

}