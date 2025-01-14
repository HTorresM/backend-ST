package com.sylen.SistemaTorneos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sylen.SistemaTorneos.Model.DAO.IAdministradorDAO;
import com.sylen.SistemaTorneos.Model.entity.Administrador;

import org.springframework.stereotype.Service;

@Service
public class AdministradorAppImpl implements AdministradorApp{

    @Autowired
    private IAdministradorDAO administradorDAO;

    @Override
    public List<Administrador> findAll() {
        return administradorDAO.findAll();
    }

    @Override
    public Administrador findOne( Long id ) {
        return administradorDAO.findOne(id);
    }

    @Override
    public void save(Administrador administrador) {
        administradorDAO.save(administrador);
    }

}
