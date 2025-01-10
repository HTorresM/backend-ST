package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.entity.Evento;

import java.util.List;

public interface EventoApp {

    public List<Evento> findAll();

    public Evento findOne( Long idEvento );

    public void save ( Evento evento );

}
