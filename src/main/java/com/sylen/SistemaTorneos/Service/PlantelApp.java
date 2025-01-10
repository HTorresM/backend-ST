package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.entity.Plantel;

import java.util.List;

/**
 * Interfaz para declarar las funciones a utilizar para un CRUD
 */

public interface PlantelApp {

    public List<Plantel> findAll();

    public Plantel findOne( Long id );

}
