package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.entity.Persona;

import java.util.List;

public interface PersonaApp {

    public List<Persona> findAll();

    public Persona findOne( Long id );

    public void saveOne ( Persona persona );
}
