package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.DAO.IParticipanteDAO;
import com.sylen.SistemaTorneos.Model.entity.Participante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteAppImpl implements ParticipanteApp{

    @Autowired
    private IParticipanteDAO participanteDAO;

    @Override
    public List<Participante> findAll() {
        return participanteDAO.findAll();
    }

    @Override
    public Participante findOne(Long id) {
        return participanteDAO.findOne(id);
    }

    @Override
    public void save(Participante participante) {
        //TODO: Validaciones a Posteriori
        participanteDAO.save(participante);
    }
}
