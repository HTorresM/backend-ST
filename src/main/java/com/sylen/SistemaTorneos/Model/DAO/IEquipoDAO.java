package com.sylen.SistemaTorneos.Model.DAO;

import com.sylen.SistemaTorneos.Model.entity.Equipo;

import java.util.List;

public interface IEquipoDAO {

    /**
     * Método que regresa una lista de los equipos
     *
     * @return Lista de equipos
     */
    public List<Equipo> findAll();

    /**
     * Método que guarda un registro de la tabla de equipo
     * @param equipo con información requerida
     */
    public void save( Equipo equipo );

    /**
     * Método que regresa un registro con toda la información
     * guardada en la BD conociendo su ID
     * @param id identificador del equipo a solicitar
     * @return un objeto de equipo con la información solicitada
     */
    public Equipo findOne( Long id );
    
}
