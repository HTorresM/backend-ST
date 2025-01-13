package com.sylen.SistemaTorneos.Config;

import com.sylen.SistemaTorneos.Model.entity.Encuentro;
import com.sylen.SistemaTorneos.Model.entity.Equipo;
import com.sylen.SistemaTorneos.Model.entity.Torneo;
import com.sylen.SistemaTorneos.Service.EncuentroApp;
import com.sylen.SistemaTorneos.Service.EquipoApp;
import com.sylen.SistemaTorneos.Service.TorneoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class EncuentrosConfig {
    @Autowired
    private EquipoApp equipoApp;
    @Autowired
    private TorneoApp torneoApp;
    @Autowired
    private EncuentroApp encuentroApp;

    @Scheduled(cron = "0 0 0 * * ?") // Ejecuta todos los días a medianoche
    public void generarEncuentros() {
        List<Torneo> torneosCerrados = torneoApp.findAllCaducados(new Date());
        List<List<Equipo>> torneosRegistrados = new ArrayList<>();
        // TRAER LISTA DE EQUIPOS RELACIONADOS CON TORNEO
        for (Torneo torneo : torneosCerrados){
            torneosRegistrados.add(equipoApp.findAll(torneo.getIdTorneo()));
        }
        // DAR DE ALTA ENCUENTROS A SUS RESPECTIVOS TORNEOS
        for ( List<Equipo> torneo : torneosRegistrados ){
            // CONTAR NUMERO DE EQUIPOS (PAR O IMPAR) PARA CALCULAR LAS JORNADAS
            Integer numeroEquipos = torneo.size();
            Integer numeroJornadas = numeroEquipos - 1;
            Integer numeroEncuentros = numeroEquipos * numeroJornadas / 2;
            Integer numeroPartidosJornada = numeroEquipos / 2;
            //DETERMINAMOS EL PIVOTE
            Integer equipoPivote = torneo.get(0).getIdEquipo();
            // VERIFICAR NUMERO DE EQUIPOS (PAR O IMPAR) PARA DETERMINAR SI ASIGNAREMOS DESCANSO
            Encuentro encuentro;
            if(numeroEquipos % 2 == 1){
                // MEZCLAR TODOS CONTRA TODOS INCLUYENDO DESCANSO = NULL
                //ANADIMOS A LA LISTA DE EQUIPOS UN EQUIPO NULL PARA QUE SE MEZCLE CON LOS DEMAS
                torneosRegistrados.add(null);

            } //else {
                // MEZCLAR TODOS CONTRA TODOS SIN DESCANSO
            for(int jornada = 0 ; jornada < numeroJornadas ; jornada ++ ){
                for (int partido = 0 ; partido < numeroPartidosJornada ; partido ++) {
                    Integer local = ( jornada + partido ) % (numeroJornadas); 
                    Integer visitante = (numeroEquipos - 1 + jornada + partido) % (numeroJornadas);
                    
                    //Con esto mantenemos que el ultimo equipo se quede fijo
                     if (partido == 0){
                        visitante = numeroEquipos - 1;
                    }

                    encuentro = new Encuentro(new Torneo(1),torneo.get(local),torneo.get(visitante));

                        //encuentro = new Encuentro(
                          //      new Date(),"Generica",
                            //    new Torneo(1),
                             //   new Equipo(torneo.get(i).getIdEquipo()),
                              //  new Equipo(torneo.get(j).getIdEquipo()));
                    //}
                }
            }
        }


    }
}