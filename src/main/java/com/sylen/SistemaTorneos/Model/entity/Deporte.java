package com.sylen.SistemaTorneos.Model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

@Entity
@Table( name = "deportes" )
public class Deporte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDeporte;

    @Column
    @NotBlank
    private String nombre;

    //@OneToOne( mappedBy = "deporte" )
    //private Torneo torneo;

    public Deporte(String nombre) {
        this.idDeporte = null;
        this.nombre = nombre;
    }

    public Deporte () {
        super();
        this.idDeporte = 0;
        this.nombre = "";
    }

    public Integer getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(Integer idDeporte) {
        this.idDeporte = idDeporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //public Torneo getTorneo() { return torneo; }

    //public void setTorneo(Torneo torneo) { this.torneo = torneo; }
}
