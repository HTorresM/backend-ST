package com.sylen.SistemaTorneos.Model.DAO;

import com.sylen.SistemaTorneos.Model.entity.Torneo;

import java.util.Date;
import java.util.List;

public interface ITorneoDAO {

    /**
     * Método que regresa una lista con todos los torneos
     * @return Lista de torneos
     */
    public List<Torneo> findAll();

    /**
     * Método que regresa una lista con todos los torneos
     * @return Lista de torneos
     */
    public List<Torneo> findAllCaducados(Date fechaActual);

    /**
     * Método que guarda la información de un torneo
     * @param torneo con la información a guardar
     */
    public void save( Torneo torneo );

    /**
     * Método que regresa la información de un registro
     * en específico
     * @param id identificador del torneo a buscar
     * @return Torneo objeto con su información
     */
    public Torneo findOne( Long id );

}
