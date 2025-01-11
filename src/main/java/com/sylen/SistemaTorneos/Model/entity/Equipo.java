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
    @JoinColumn( name = "torneo_id" )
    private Torneo torneoInscrito;

    @Column
    private String logo;

    @Column
    private Integer puntuacion;

    @OneToOne( mappedBy = "equipoGanador" )
    private Torneo torneoGanador;

    @OneToMany(mappedBy = "equipoParticipante")
    private List<Participante> participantes;

    @OneToOne( mappedBy = "equipoLocal" )
    private Encuentro encuentroLocal;

    @OneToOne( mappedBy = "equipoVisitante" )
    private Encuentro encuentroVisitante;

    public Equipo() { super(); }

    public Equipo(String nombre, String logo, Integer puntuacion, Torneo torneoInscrito, Torneo torneoGanador, List<Participante> participantes, Encuentro encuentro) { 
        idEquipo = null;
        this.nombre = nombre;
        this.logo = logo;
        this. torneoInscrito = torneoInscrito;
        this.participantes = participantes;
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

    public Torneo getTorneoInscrito() {
        return torneoInscrito;
    }

    public void setTorneoInscrito(Torneo torneoInscrito) {
        this.torneoInscrito = torneoInscrito;
    }

    public Torneo getTorneoGanador() {
        return torneoGanador;
    }

    public void setTorneoGanador(Torneo torneoGanador) {
        this.torneoGanador = torneoGanador;
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
