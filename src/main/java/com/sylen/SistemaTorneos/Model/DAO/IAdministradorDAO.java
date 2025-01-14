package com.sylen.SistemaTorneos.Model.DAO;

import java.util.List;

import com.sylen.SistemaTorneos.Model.entity.Administrador;


public interface IAdministradorDAO {

    /**
     * Método que regresa una lista de personas
     * @return Lista de personas
     */
    List<Administrador> findAll();

    /**
     * Método que guarda una administrador
     * @param administrador objeto con su información a guardar
     */
    void save( Administrador administrador );

    /**
     * Método que encuentra un administrador conociendo su ID
     * @param id identificador del administrador
     * @return Objeto administrador con su respectiva información
     */
    Administrador findOne( Long id );

}
