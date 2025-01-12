package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.DAO.IEncuentroDAO;
import com.sylen.SistemaTorneos.Model.entity.Encuentro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncuentroAppImpl implements EncuentroApp{

    @Autowired
    private IEncuentroDAO encuentroDAO;

    @Override
    public List<Encuentro> findAll() {
        return encuentroDAO.findAll();
    }

    @Override
    public Encuentro findOne(Long id) {
        return encuentroDAO.findOne(id);
    }

    @Override
    public void save(Encuentro encuentro) {
        //TODO: Validaciones a Posteriori
        encuentroDAO.save(encuentro);
    }
}
