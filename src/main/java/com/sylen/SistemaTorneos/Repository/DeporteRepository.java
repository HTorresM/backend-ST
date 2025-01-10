package com.sylen.SistemaTorneos.Repository;

import com.sylen.SistemaTorneos.Model.DAO.IDeporteDAO;
import com.sylen.SistemaTorneos.Model.entity.Deporte;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DeporteRepository implements IDeporteDAO {

    @PersistenceContext
    private EntityManager em ;

    @Override
    @Transactional(readOnly = true)
    public List<Deporte> findAll() {
        return em.createQuery("from Deporte").getResultList();
    }

    @Override
    @Transactional
    public void save(Deporte deporte) {
        if ( deporte.getIdDeporte() != null && deporte.getIdDeporte() != 0){
            // Actualizar
            em.merge(deporte);
        } else {
            // Nuevo ingreso
            em.persist(deporte);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Deporte findOne(Long id) {
        return em.find(Deporte.class, id);
    }

}
