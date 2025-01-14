package com.sylen.SistemaTorneos.Config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sylen.SistemaTorneos.Model.entity.Equipo;
import com.sylen.SistemaTorneos.Service.EncuentroApp;
import com.sylen.SistemaTorneos.Service.EquipoApp;
import com.sylen.SistemaTorneos.Service.TorneoApp;

@Component
public class EquipoConfig {

    @Autowired
    private TorneoApp torneoApp;
    @Autowired
    private EncuentroApp encuentroApp;
    @Autowired 
    private EquipoApp equipoApp;

    public void LLevarpuntuacion(String respuesta){
        Integer puntuacionLocal;
        Integer puntuacionVisitante;

        ObjectMapper mapper = new ObjectMapper();
        //List<Equipo> resultados = mapper.readValue(respuesta, Equipo.class);


        //if(puntuacionLocal > puntuacionVisitante){
            

        //}

    }

}
