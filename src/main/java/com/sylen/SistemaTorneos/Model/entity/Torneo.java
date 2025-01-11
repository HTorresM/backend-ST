package com.sylen.SistemaTorneos.Model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "torneo")
public class Torneo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTorneo;

    @Column
    private String nombre;

    @Column
    private String tipo;

    @Column
    private String reglamento;

    @Column
    private String imagen;

    @OneToOne
    @JoinColumn( name = "evento_id")
    private Evento evento;

    @OneToOne
    @JoinColumn(name = "deporte_id")
    private Deporte deporte;

    @OneToMany(mappedBy = "torneoInscrito")
    private List<Equipo> equipos = new ArrayList<Equipo>();

    @OneToOne
    @JoinColumn(name = "ganador_id")
    private Equipo equipoGanador;

    @OneToMany(mappedBy = "torneo")
    private List<Encuentro> encuentros;

    public Torneo() {
        super();
    }

    public Torneo(String nombre, String tipo, String reglamento, String imagen, Evento evento, Deporte deporte) {
        this.idTorneo = null;
        this.nombre = nombre;
        this.tipo = tipo;
        this.reglamento = reglamento;
        this.imagen = imagen;
        this.evento = evento;
        this.deporte = deporte;
    }

    public Integer getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReglamento() {
        return reglamento;
    }

    public void setReglamento(String reglamento) {
        this.reglamento = reglamento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Encuentro> getEncuentros() {
        return encuentros;
    }

    public void setEncuentros(List<Encuentro> encuentros) {
        this.encuentros = encuentros;
    }
}
