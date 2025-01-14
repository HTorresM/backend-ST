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
import java.util.Calendar;
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
        List<Equipo> torneoRegistrado;
        // TRAER LISTA DE EQUIPOS RELACIONADOS CON TORNEO
        for (Torneo torneo : torneosCerrados){
            torneoRegistrado = equipoApp.findAll(torneo.getIdTorneo());
            // CONTAR NUMERO DE EQUIPOS (PAR O IMPAR) PARA CALCULAR LAS JORNADAS
            Integer numeroEquipos = torneoRegistrado.size();
            Integer numeroJornadas = numeroEquipos - 1;
            Integer numeroEncuentros = numeroEquipos * numeroJornadas / 2;
            Integer numeroPartidosJornada = numeroEquipos / 2;
            // VERIFICAR NUMERO DE EQUIPOS (PAR O IMPAR) PARA DETERMINAR SI ASIGNAREMOS DESCANSO
            Encuentro encuentro;
            if(numeroEquipos % 2 == 1){
                torneoRegistrado.add(null);
            }
            // MEZCLAR TODOS CONTRA TODOS SIN DESCANSO
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(torneo.getFechaInicio());
            calendario.set(Calendar.HOUR_OF_DAY, 10); // Hora inicial de los partidos
            calendario.set(Calendar.MINUTE, 0);
            calendario.set(Calendar.SECOND, 0);


            for(int jornada = 0 ; jornada < numeroJornadas ; jornada ++ ){
                for (int partido = 0 ; partido < numeroPartidosJornada ; partido ++) {
                    Integer local = ( jornada + partido ) % (numeroJornadas);
                    Integer visitante = (numeroEquipos - 1 + jornada + partido) % (numeroJornadas);

                    //Con esto mantenemos que el ultimo equipo se quede fijo
                    if (partido == 0){
                        visitante = numeroEquipos - 1;
                    }
                    //Verificar si la fecha es fin de semana
                    encuentro = new Encuentro(evitarFinDeSemana(calendario),torneo,torneoRegistrado.get(local),torneoRegistrado.get(visitante));
                    encuentroApp.save(encuentro);
                    calendario.add(Calendar.HOUR_OF_DAY, 2); // Incrementar hora para el siguiente partido

                }
                calendario.add(Calendar.DAY_OF_MONTH, 1); // Pasar a la siguiente jornada
                calendario.set(Calendar.HOUR_OF_DAY, 10); // Reiniciar la hora para la próxima jornada
            }
        }
    }

    // Método auxiliar para evitar fines de semana
    private Date evitarFinDeSemana(Calendar calendario) {
        // Verificar si la fecha actual es sábado o domingo
        while (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendario.add(Calendar.DAY_OF_MONTH, 1); // Avanzar al siguiente día
        }
        return calendario.getTime();
    }

}