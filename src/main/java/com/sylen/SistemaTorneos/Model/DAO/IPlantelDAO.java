package com.sylen.SistemaTorneos.Model.DAO;

import com.sylen.SistemaTorneos.Model.entity.Plantel;

import java.util.List;

public interface IPlantelDAO {

    /**
     * Método que regresa una lista de planteles
     * @return Lista de planteles
     */
    public List<Plantel> findAll();

    /**
     * Método que guarda un registro de Plantel
     * @param plantel objeto con su respectiva información
     */
    public void save( Plantel plantel );

    /**
     * Método que regresa un registro en específico
     * @param id identificador del plantel
     * @return objeto Plantel con la información
     */
    public Plantel findOne( Long id );

}
