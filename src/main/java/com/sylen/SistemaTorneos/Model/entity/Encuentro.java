package com.sylen.SistemaTorneos.Model.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "encuentro" )
public class Encuentro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEncuentro;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEncuentro;

    @Column
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "id_torneo")
    private Torneo torneo;

    @OneToOne
    @JoinColumn( name = "equipo_local_id" )
    private Equipo equipoLocal;

    @OneToOne
    @JoinColumn( name = "equipo_visitante_id" )
    private Equipo equipoVisitante;

    public Encuentro () {
        super();
    }

    public Encuentro(Date fechaEncuentro, String ubicacion, Torneo torneo, Equipo equipoLocal, Equipo equipoVisitante) {
        this.idEncuentro = null;
        this.fechaEncuentro = fechaEncuentro;
        this.ubicacion = ubicacion;
        this.torneo = torneo;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante; 
    }

    public Encuentro(Torneo torneo, Equipo equipoLocal, Equipo equipoVisitante) {
        this.idEncuentro = null;
        this.torneo = torneo;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante; 
    }

    public Integer getIdEncuentro() {
        return idEncuentro;
    }

    public void setIdEncuentro(Integer idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public Date getFechaEncuentro() {
        return fechaEncuentro;
    }

    public void setFechaEncuentro(Date fechaEncuentro) {
        this.fechaEncuentro = fechaEncuentro;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

}
