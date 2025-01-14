package com.sylen.SistemaTorneos.Config;

import com.sylen.SistemaTorneos.Model.DAO.*;
import com.sylen.SistemaTorneos.Model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private IDeporteDAO deporteDAO;
    @Autowired
    private IPersonaDAO personaDAO;
    @Autowired
    private IPlantelDAO plantelDAO;
    @Autowired
    private IEventoDAO eventoDAO;
    @Autowired
    private ITorneoDAO torneoDAO;
    @Autowired
    private IEquipoDAO equipoDAO;
    @Autowired
    private IParticipanteDAO participanteDAO;
    @Autowired IAdministradorDAO administradorDAO;

    @Override
    public void run(String... args) throws Exception {
        List<Deporte> deportes = List.of(
                new Deporte( "Football" ),
                new Deporte( "Baloncesto" ),
                new Deporte( "Tenis" ),
                new Deporte( "Golf" ),
                new Deporte( "Rugby" ),
                new Deporte( "Baseball" ),
                new Deporte( "BrakeDance" ),
                new Deporte( "Swimming" )
        );
        List<Persona> personas = List.of(
            new Persona("Hugo Torres Morales", "Student","1720054","7291239863","htorresm001@alumno.uaemex.mx", "ICO"),
            new Persona("Christian Torres Estrada", "Student","1143054","7221524014","ctorrese123@alumno.uaemex.mx", "ICO"),
            new Persona("Alan Torres Estrada", "Student","1234567","7291513852","atorrese001@alumno.uaemex.mx", "IQG"),
            new Persona("Aaron Torres Morales", "Student","1324072","7228026866","atorresm001@alumno.uaemex.mx", "ICO"),
            new Persona("Pablo Elias Colin Velazquez", "Student","1495392","7228833610","pcolinv123@alumno.uaemex.mx", "ICO"),
            new Persona("Carmen Iveth Alvarez Garcia", "Student","1604399","7225170756","calvarezg321@alumno.uaemex.mx", "ICO"),
            new Persona("Cesar Villanueva Mercado", "Student","1123123","7295466453","cvillanuevam643@alumno.uaemex.mx", "ICO")
        );
        List<Plantel> planteles = List.of(
                new Plantel("Lic. Adolfo López Mateos"),
                new Plantel("Nezahualcóyotl"),
                new Plantel("Cuauhtémoc"),
                new Plantel("Ignacio Ramírez Calzada"),
                new Plantel("Dr. Ángel Ma. Gribay Kintana"),
                new Plantel("Dr. Pablo González Casanova"),
                new Plantel("Texcoco"),
                new Plantel("Sor Juana Inés de la Cruz"),
                new Plantel("Isidro Fabela Alfaro")
        );
        List<Evento> eventos = List.of(
                new Evento("Velada","Velada del anio",
                        new Date(125, Calendar.JANUARY,11),
                        new Date(125, Calendar.JANUARY,30),
                        1,new Persona(1),1),
                new Evento("JonyFest","Cumpleanios de Jonny 2025",
                        new Date(125, Calendar.JANUARY,11),
                        new Date(125, Calendar.JANUARY,30),
                        1,new Persona(2), 1),
                new Evento("Potrocrush","Potrocupidos te invita...",
                        new Date(125, Calendar.JANUARY,11),
                        new Date(125, Calendar.JANUARY,30),
                        1,new Persona(3), 1),
                new Evento("X-force","Chisme de senioras con devs",
                        new Date(125, Calendar.JANUARY,11),
                        new Date(125, Calendar.JANUARY,30),
                        1,new Persona(4), 1)
        );
        List<Torneo> torneos = List.of(
                new Torneo("Copa Piston","Simple","Reglamento.pdf","Imagen.png",new Evento(1),1),
                new Torneo("Torneo del Poder","Simple","Reglamento.pdf","Imagen.png",new Evento(2),1),
                new Torneo("Liga MX","Simple","Reglamento.pdf","Imagen.png",new Evento(3),1),
                new Torneo("Mundial LOL","Simple","Reglamento.pdf","Imagen.png",new Evento(4),1)
                //new Torneo("Manolos","Simple","Reglamento.pdf","Imagen.png",new Evento(1),1)
        );
        List<Participante> participantes = List.of(
                new Participante("HUGO",new Equipo(1)),
                new Participante("PABLO",new Equipo(1)),
                new Participante("ELIAS",new Equipo(1)),
                new Participante("CARMEN",new Equipo(1)),
                new Participante("IVETH",new Equipo(1)),
                new Participante("CEBOLLIN",new Equipo(1)),
                new Participante("NITZIA",new Equipo(1)),
                new Participante("LUIS",new Equipo(1)),
                new Participante("FERNANDO",new Equipo(1))

        );
        for ( Deporte deporte : deportes ){
            deporteDAO.save(deporte);
        }
        for ( Persona persona : personas ){
            personaDAO.save(persona);
        }
        for (Plantel plantel : planteles){
            plantelDAO.save(plantel);
        }
        for (Evento evento : eventos){
            eventoDAO.save(evento);
        }
        for (Torneo torneo : torneos){
            torneoDAO.save(torneo);
        }
        Administrador administrador = new Administrador("Promotor", "Promotores", "Deportivo", "promotor@deportivo.com", "Promotor1", 1234567, "Ninguna", "7222222222",new Plantel(1));
        administradorDAO.save(administrador);
        
        equipoDAO.save(new Equipo("PinHeads","Logo",new Torneo(1)));
        for (Participante participante : participantes){
            participanteDAO.save(participante);
        }

    }
}
