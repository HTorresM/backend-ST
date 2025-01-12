package com.sylen.SistemaTorneos.Model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table( name = "equipo" )
public class Equipo implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer idEquipo;

    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn( name = "torneo_id", nullable = false)
    private Torneo torneo;

    @Column
    private String logo;

    @Column
    private Integer puntuacion;

    @OneToMany(mappedBy = "equipoParticipante")
    private List<Participante> participantes;

    @OneToOne( mappedBy = "equipoLocal" )
    private Encuentro encuentroLocal;

    @OneToOne( mappedBy = "equipoVisitante" )
    private Encuentro encuentroVisitante;

    public Equipo() { super(); }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(String nombre, String logo, Torneo torneo) {
        idEquipo = null;
        this.nombre = nombre;
        this.logo = logo;
        this.torneo = torneo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipante(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public Encuentro getEncuentroLocal() {
        return encuentroLocal;
    }

    public void setEncuentroLocal(Encuentro encuentroLocal) {
        this.encuentroLocal = encuentroLocal;
    }

    public Encuentro getEncuentroVisitante() {
        return encuentroVisitante;
    }

    public void setEncuentroVisitante(Encuentro encuentroVisitante) {
        this.encuentroVisitante = encuentroVisitante;
    }

}
