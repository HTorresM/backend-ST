package com.sylen.SistemaTorneos.Config;

import com.sylen.SistemaTorneos.Model.DAO.IDeporteDAO;
import com.sylen.SistemaTorneos.Model.DAO.IPersonaDAO;
import com.sylen.SistemaTorneos.Model.DAO.IPlantelDAO;
import com.sylen.SistemaTorneos.Model.entity.Deporte;
import com.sylen.SistemaTorneos.Model.entity.Persona;
import com.sylen.SistemaTorneos.Model.entity.Plantel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private IDeporteDAO deporteDAO;
    @Autowired
    private IPersonaDAO personaDAO;
    @Autowired
    private IPlantelDAO plantelDAO;

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

        for ( Deporte deporte : deportes ){
            deporteDAO.save(deporte);
        }

        for ( Persona persona : personas ){
            personaDAO.save(persona);
        }

        for (Plantel plantel : planteles){
            plantelDAO.save(plantel);
        }
    }
}
