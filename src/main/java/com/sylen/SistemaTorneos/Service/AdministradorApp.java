package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.entity.Administrador;

import java.util.List;

public interface AdministradorApp {

    public List<Administrador> findAll();

    public Administrador findOne( Long id );

    public void save( Administrador administrador );

}
