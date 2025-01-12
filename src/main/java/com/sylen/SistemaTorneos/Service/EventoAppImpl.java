package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.DAO.IEventoDAO;
import com.sylen.SistemaTorneos.Model.entity.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoAppImpl implements EventoApp{

    @Autowired
    private IEventoDAO eventoDAO;

    // TODO: SOLO TRAER EVENTOS VIGENTES
    @Override
    public List<Evento> findAll() {
        return eventoDAO.findAll();
    }

    @Override
    public Evento findOne(Long idEvento) {
        return eventoDAO.findOne( idEvento );
    }

    @Override
    public void save(Evento evento) {
        // TODO: Validaciones a Posteriori
        eventoDAO.save( evento );
    }
}
