package com.sylen.SistemaTorneos.Model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "participante")
public class Participante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParticipante;

    @Column
    private String nombre;

    @Column(name = "numero_cuenta")
    private Integer numeroCuenta;

    @Column
    private String celular;

    @Column(name = "telefono_emergencia")
    private String telefonoEmergencia;

    @Column(name = "tipo_sangre")
    private String tipoSangre;

    @Column
    private String alergias;

    @Column(name = "numero_seguro")
    private String numeroSeguro;

    @Column
    private String correo;

    @Column
    private String licenciatura;

    @Column(name = "tipo_persona")
    private String tipoPersona;

    @Column(name = "es_capitan")
    private Boolean esCapitan;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipoParticipante;

    public Participante (){ super(); }
    

    public Participante(String nombre, Integer numeroCuenta, String celular, String telefonoEmergencia, String tipoSangre, String alergias, String numeroSeguro, String correo, String licenciatura, String tipoPersona, Boolean esCapitan, Equipo equipoParticipante) {
        this.idParticipante = null;
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.celular = celular;
        this.telefonoEmergencia = telefonoEmergencia;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
        this.numeroSeguro = numeroSeguro;
        this.correo = correo;
        this.licenciatura = licenciatura;
        this.tipoPersona = tipoPersona;
        this.esCapitan = esCapitan;
        this.equipoParticipante = equipoParticipante;
    }


    public Integer getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(String numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLicenciatura() {
        return licenciatura;
    }

    public void setLicenciatura(String licenciatura) {
        this.licenciatura = licenciatura;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Boolean getEsCapitan() {
        return esCapitan;
    }

    public void setEsCapitan(Boolean esCapitan) {
        this.esCapitan = esCapitan;
    }
}
