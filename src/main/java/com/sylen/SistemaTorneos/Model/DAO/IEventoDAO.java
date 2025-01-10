package com.sylen.SistemaTorneos.Model.DAO;

import com.sylen.SistemaTorneos.Model.entity.Evento;

import java.util.List;

public interface IEventoDAO {

    /**
     * Método que regresa una lista de objetos con su
     * respectiva información
     * @return Lista de eventos
     */
    public List<Evento> findAll();

    /**
     * Método que se utiliza para guardar un registro
     * @param evento objeto con la información a guardar
     */
    public void save( Evento evento );

    /**
     * Método que se utiliza para recuperar UN SOLO
     * registro conociendo su identificador
     * @param id identificador de evento
     * @return objeto Evento con la información del evento
     */
    public Evento findOne( Long id );
}
