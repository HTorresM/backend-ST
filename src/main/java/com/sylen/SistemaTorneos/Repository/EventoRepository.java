package com.sylen.SistemaTorneos.Repository;

import com.sylen.SistemaTorneos.Model.DAO.IEventoDAO;
import com.sylen.SistemaTorneos.Model.entity.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EventoRepository implements IEventoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Evento> findAll() {
        return em.createQuery("from Evento").getResultList();
    }

    @Override
    @Transactional
    public void save(Evento evento) {
        if ( evento.getIdEvento() != null && evento.getIdEvento() != 0 ){
            // Actualizar
            em.merge(evento);
        } else {
            // Agregar nuevo
            em.persist(evento);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Evento findOne(Long id) {
        return em.find(Evento.class, id);
    }
}
