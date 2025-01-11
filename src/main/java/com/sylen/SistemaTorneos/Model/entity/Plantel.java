package com.sylen.SistemaTorneos.Model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "plantel")
public class Plantel implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idPlantel;

    @Column
    @NotBlank
    private String nombre;

    @OneToMany( mappedBy = "plantel" )
    private List<Evento> eventos;

    public Plantel(String nombre) {
        this.idPlantel = null;
        this.nombre = nombre;
    }

    public Plantel() {
        super();
    }

    public Integer getIdPlantel() {
        return idPlantel;
    }

    public void setIdPlantel(Integer idPlantel) {
        this.idPlantel = idPlantel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
