package com.sylen.SistemaTorneos.Repository;

import com.sylen.SistemaTorneos.Model.DAO.IParticipanteDAO;
import com.sylen.SistemaTorneos.Model.entity.Participante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ParticipanteRepository implements IParticipanteDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Participante> findAll() {
        return em.createQuery("from Participante").getResultList();
    }

    @Override
    @Transactional
    public void save(Participante participante) {
        if ( participante.getIdParticipante() != null && participante.getIdParticipante() != 0 ){
            // Actualizar
            em.merge(participante);
        } else {
            // Nuevo ingreso
            em.persist(participante);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Participante findOne(Long id) {
        return em.find(Participante.class, id);
    }
}
