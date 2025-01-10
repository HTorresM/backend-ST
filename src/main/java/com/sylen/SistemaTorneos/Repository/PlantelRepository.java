package com.sylen.SistemaTorneos.Repository;

import com.sylen.SistemaTorneos.Model.DAO.IPlantelDAO;
import com.sylen.SistemaTorneos.Model.entity.Plantel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PlantelRepository implements IPlantelDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Plantel> findAll() {
        return em.createQuery("from Plantel").getResultList();
    }

    @Override
    @Transactional
    public void save(Plantel plantel) {
        if ( plantel.getIdPlantel() != null && plantel.getIdPlantel() != 0 ){
            // Actualizar
            em.merge(plantel);
        } else {
            // Nuevo ingreso
            em.persist(plantel);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Plantel findOne(Long id) {
        return em.find(Plantel.class, id);
    }
}
