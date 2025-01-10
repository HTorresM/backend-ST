package com.sylen.SistemaTorneos.Repository;

import com.sylen.SistemaTorneos.Model.DAO.IPersonaDAO;
import com.sylen.SistemaTorneos.Model.entity.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonaRepository implements IPersonaDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return em.createQuery("from Persona").getResultList();
    }

    @Override
    @Transactional
    public void save(Persona persona) {
        if ( persona.getIdPersona() != null && persona.getIdPersona() != 0 ){
            // Actualizar
            em.merge(persona);
        } else {
            // Nuevo ingreso
            em.persist(persona);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findOne(Long id) {
        return em.find(Persona.class, id);
    }

}
