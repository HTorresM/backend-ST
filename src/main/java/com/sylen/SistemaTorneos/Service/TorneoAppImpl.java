package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.DAO.ITorneoDAO;
import com.sylen.SistemaTorneos.Model.entity.Torneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoAppImpl implements TorneoApp{

    @Autowired
    private ITorneoDAO torneoDAO;

    @Override
    public List<Torneo> findAll() {
        return torneoDAO.findAll();
    }

    @Override
    public Torneo findOne(Long id) {
        return torneoDAO.findOne(id);
    }

    @Override
    public void save(Torneo torneo) {
        // TODO: Validaciones a Posteriori
        torneoDAO.save(torneo);
    }
}
