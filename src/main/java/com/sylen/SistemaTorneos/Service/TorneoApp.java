package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.entity.Torneo;

import java.util.Date;
import java.util.List;

public interface TorneoApp {

    List<Torneo> findAll();

    List<Torneo> findAllCaducados(Date fechaActual);

    Torneo findOne(Long id);

    void save(Torneo torneo);

}
