package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.entity.Participante;

import java.util.List;

public interface ParticipanteApp {

    List<Participante> findAll();

    Participante findOne(Long id);

    void save(Participante participante);

}
