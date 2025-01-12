package com.sylen.SistemaTorneos.Repository;

import com.sylen.SistemaTorneos.Model.DAO.IEquipoDAO;
import com.sylen.SistemaTorneos.Model.entity.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EquipoRepository implements IEquipoDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Equipo> findAll(Integer idTorneo) {
        String jpql = "SELECT e FROM Equipo e WHERE e.torneo.id = :idTorneo";
        return em.createQuery(jpql, Equipo.class)
                .setParameter("idTorneo", idTorneo)
                .getResultList();
    }

    @Override
    @Transactional
    public void save(Equipo equipo) {
        if ( equipo.getIdEquipo() != null && equipo.getIdEquipo() != 0 ){
            // Actualizar
            em.merge(equipo);
        } else {
            // Nuevo ingreso
            em.persist(equipo);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Equipo findOne(Long id) {
        return em.find(Equipo.class, id);
    }
}
