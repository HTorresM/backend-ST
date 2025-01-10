package com.sylen.SistemaTorneos.Model.DAO;

import com.sylen.SistemaTorneos.Model.entity.Participante;

import java.util.List;

public interface IParticipanteDAO {

    /**
     * Método que regresa una lista de Participantes
     * @return Lista con participantes
     */
    public List<Participante> findAll();

    /**
     * Método para guardar un Participante
     * @param participante Objeto con datos a guardar
     */
    public void save( Participante participante );

    /**
     * Método que regresa un registro en específico
     * conociendo su identificador
     * @param id identificador del participante a buscar
     * @return Participante con toda la información
     */
    public Participante findOne( Long id );

}
