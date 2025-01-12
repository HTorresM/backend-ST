package com.sylen.SistemaTorneos.Repository;

import com.sylen.SistemaTorneos.Model.DAO.ITorneoDAO;
import com.sylen.SistemaTorneos.Model.entity.Torneo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public class TorneoRepository implements ITorneoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Torneo> findAll() {
        return em.createQuery("from Torneo").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Torneo> findAllCaducados(Date fechaActual) {
        return em.createQuery(
                        "SELECT t FROM Torneo t WHERE t.fechaLimiteIncripcion <= :fechaActual",
                        Torneo.class)
                .setParameter("fechaCaducada", fechaActual)
                .getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Torneo findOne(Long id) {
        return em.find(Torneo.class, id);
    }

    @Override
    @Transactional
    public void save(Torneo torneo) {
        if ( torneo.getIdTorneo() != null && torneo.getIdTorneo() != 0 ){
            // Actualizar
            em.merge(torneo);
        } else {
            // Nuevo ingreso
            em.persist(torneo);
        }
    }

}
