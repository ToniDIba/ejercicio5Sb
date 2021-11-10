package com.example.ejercicio5Sb;

import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {


    Persona persona = new Persona();


    @Override
    public String getNombre() {
        return persona.getNombre();
    }

    @Override
    public void setNombre(String nombreIn) {
       persona.setNombre(nombreIn);

    }
}
