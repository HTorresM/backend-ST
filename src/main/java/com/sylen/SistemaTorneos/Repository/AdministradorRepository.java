package com.sylen.SistemaTorneos.Repository;

import java.util.List;
import com.sylen.SistemaTorneos.Model.DAO.IAdministradorDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sylen.SistemaTorneos.Model.entity.Administrador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AdministradorRepository implements IAdministradorDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Administrador> findAll() {
        return em.createQuery("from Administrador").getResultList();
    }

    @Override
    @Transactional
    public void save(Administrador administrador) {
        if ( administrador.getIdAdministrador() != null && administrador.getIdAdministrador() != 0 ){
            // Actualizar
            em.merge(administrador);
        } else {
            // Nuevo ingreso
            em.persist(administrador);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Administrador findOne(Long id) {
        return em.find(Administrador.class, id);
    }

}
