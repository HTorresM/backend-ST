package com.sylen.SistemaTorneos.Model.DAO;

import com.sylen.SistemaTorneos.Model.entity.Deporte;

import java.util.List;

public interface IDeporteDAO {

    /**
     * Método utilizado para retornar todos los registros de la base de datos
     *
     * @return Lista de registros
     */
    public List<Deporte> findAll();

    /**
     * Método que se utiliza para guardar SOLO UN registro
     *
     * @param deporte objeto con información requerida para la creacion del deporte
     */
    public void save( Deporte deporte );

    /**
     * Método que regresa un registro conociendo su ID
     * @param id identificador del objeto Deporte
     * @return objeto de Deporte con toda su información
     */
    public Deporte findOne( Long id );

}
