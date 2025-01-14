package com.sylen.SistemaTorneos.Model.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @Column
    private String nombre;

    @Column
    private String tipo;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column
    private String celular;

    @Column
    private String correo;
    

    @Column
    private String licenciatura;

    @OneToOne
    private Evento evento;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        super();
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String tipo, String numeroCuenta, String celular, String correo, String licenciatura) {
        this.idPersona = null;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numeroCuenta = numeroCuenta;
        this.celular = celular;
        this.correo = correo;
        this.licenciatura = licenciatura;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
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

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    //public Evento getEvento() { return evento; }

    //public void setEvento(Evento evento) { this.evento = evento; }
}
