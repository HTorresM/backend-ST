package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.entity.Encuentro;

import java.util.List;

public interface EncuentroApp {

    public List<Encuentro> findAll();

    public Encuentro findOne(Long id);

    public void save(Encuentro encuentro);

}
