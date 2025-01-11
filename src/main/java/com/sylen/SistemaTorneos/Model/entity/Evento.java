package com.sylen.SistemaTorneos.Model.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "evento")
public class Evento implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    @Column
    private String titulo;

    @Column
    private String descripcion;

    @Column( name = "fecha_inicial", nullable = false )
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicial;

    @Column( name = "fecha_final" , nullable = false )
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFinal;

    @Column( name = "tipo_evento" )
    private Integer tipoEvento;

    @OneToOne
    @JoinColumn( name = "responsable_id" , nullable = false )
    private Persona persona;

    @ManyToOne
    @JoinColumn( name = "plantel_id" , nullable = false )
    private Plantel plantel;

    @OneToOne( mappedBy = "evento" )
    private Torneo torneo;

    public Evento (){ super(); }

    
    public Evento(String titulo, String descripcion, Date fechaInicial, Date fechaFinal, Integer tipoEvento, Persona persona, Plantel plantel, Torneo torneo) {
        this.idEvento = null;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.tipoEvento = tipoEvento;
        this.persona = persona;
        this.plantel = plantel;
        this.torneo = torneo;
    }


    public Integer getIdEventoM() {
        return idEvento;
    }

    public void setIdEventoM(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Integer getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(Integer tipoEvento) { this.tipoEvento = tipoEvento; }

    public Persona getPersona() { return persona; }

    public void setPersona(Persona persona) { this.persona = persona; }

    public Plantel getPlantel() { return plantel; }

    public void setPlantel(Plantel plantel) { this.plantel = plantel; }

    public Integer getIdEvento() { return idEvento; }

    public void setIdEvento(Integer idEvento) { this.idEvento = idEvento; }

    public Torneo getTorneo() { return torneo; }

    public void setTorneo(Torneo torneo) { this.torneo = torneo; }
}
