package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.entity.Equipo;

import java.util.List;

public interface EquipoApp {

    public List<Equipo> findAll( Integer idTorneo );

    public Equipo findOne(Long id);

    public void save(Equipo equipo);

}
