package com.sylen.SistemaTorneos.Service;

import com.sylen.SistemaTorneos.Model.entity.Deporte;

import java.util.List;

/**
 * Interfaz para declarar las funciones a utilizar para un CRUD
 */

public interface DeporteApp {

    List<Deporte> getAllDeportes();

    Deporte getOneDeporte( Long id );

    void save( Deporte deporte );

}
