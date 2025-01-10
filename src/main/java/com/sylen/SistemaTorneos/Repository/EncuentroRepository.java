package com.sylen.SistemaTorneos.Repository;

import com.sylen.SistemaTorneos.Model.DAO.IEncuentroDAO;
import com.sylen.SistemaTorneos.Model.entity.Encuentro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EncuentroRepository implements IEncuentroDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Encuentro> findAll() {
        return em.createQuery("from Encuentro").getResultList();
    }

    @Override
    @Transactional
    public void save(Encuentro encuentro) {
        if ( encuentro.getIdEncuentro() != null && encuentro.getIdEncuentro() != 0 ){
            // Actualizar
            em.merge(encuentro);
        } else {
            // Guardar nuevo
            em.persist(encuentro);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Encuentro findOne(Long id) {
        return em.find(Encuentro.class, id);
    }
}
