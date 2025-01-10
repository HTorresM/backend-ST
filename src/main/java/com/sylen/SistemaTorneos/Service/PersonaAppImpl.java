package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.DAO.IPersonaDAO;
import com.sylen.SistemaTorneos.Model.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaAppImpl implements PersonaApp{

    @Autowired
    private IPersonaDAO personaDAO;

    @Override
    public List<Persona> findAll() {
        return personaDAO.findAll();
    }

    @Override
    public Persona findOne(Long id) {
        return personaDAO.findOne(id);
    }

    @Override
    public void saveOne(Persona persona) {
        // TODO: Validaciones a Posteriori
        personaDAO.save( persona );
    }
}
