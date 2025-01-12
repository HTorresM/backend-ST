package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.DAO.IEquipoDAO;
import com.sylen.SistemaTorneos.Model.entity.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoAppImpl implements EquipoApp{

    @Autowired
    private IEquipoDAO equipoDAO;

    @Override
    public List<Equipo> findAll(Integer idTorneo) {
        return equipoDAO.findAll(idTorneo);
    }

    @Override
    public Equipo findOne(Long id) {
        return equipoDAO.findOne(id);
    }

    @Override
    public void save(Equipo equipo) {
        //TODO: Validaciones a Posteriori
        equipoDAO.save(equipo);
    }
}
