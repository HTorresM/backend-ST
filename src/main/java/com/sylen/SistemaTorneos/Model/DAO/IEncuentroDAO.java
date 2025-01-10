package com.sylen.SistemaTorneos.Model.DAO;

import com.sylen.SistemaTorneos.Model.entity.Encuentro;

import java.util.List;

public interface IEncuentroDAO {

    /**
     * Método que regresa Lista de encuentros
     *
     * @return Lista con objetos de encuentro
     */
    public List<Encuentro> findAll();

    /**
     * Método que guarda un encuentro con un objeto de encuentro
     *
     * @param encuentro con la información requerida
     */
    public void save( Encuentro encuentro );

    /**
     * Método que regresa un encuentro conociendo su ID
     * @param id identificador del encuentro
     * @return un objeto de tipo Encuentro con toda la información guardada
     */
    public Encuentro findOne( Long id );
}
