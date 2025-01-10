package com.sylen.SistemaTorneos.Model.DAO;

import com.sylen.SistemaTorneos.Model.entity.Persona;

import java.util.List;

public interface IPersonaDAO {

    /**
     * Método que regresa una lista de personas
     * @return Lista de personas
     */
    List<Persona> findAll();

    /**
     * Método que guarda una persona
     * @param persona objeto con su información a guardar
     */
    void save( Persona persona );

    /**
     * Método que encuentra una persona conociendo su ID
     * @param id identificador de la persona
     * @return Objeto persona con su respectiva información
     */
    Persona findOne( Long id );

}
