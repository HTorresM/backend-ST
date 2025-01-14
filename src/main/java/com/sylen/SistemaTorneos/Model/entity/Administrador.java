package com.sylen.SistemaTorneos.Model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;


@Entity
@Table( name = "administrador" )
public class Administrador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador")
    private Integer idAdministrador;

    @Column
    @NotBlank
    private String username;

    @Column
    @NotBlank
    private String lastname;

    @Column
    @NotBlank
    private String secondLastname;

    @Column
    private String correo;

    @Column
    private String contrasena;

    @Column(name = "numero_cuenta")
    private Integer numeroCuenta;

    @Column
    private String alergias;

    @Column(name = "telefono")
    private String telefono;

    @OneToOne
    @JoinColumn( name = "plantel" , nullable = false )
    private Plantel plantel;

    public Administrador (){super ();}

    public Administrador (Integer idAministrador){
        this.idAdministrador = idAdministrador;
    }

    public Administrador(@NotBlank String username, @NotBlank String lastname, @NotBlank String secondLastname,
            String correo, String contrasena, Integer numeroCuenta, String alergias, String telefono, Plantel plantel) {
        this.idAdministrador = null;
        this.username = username;
        this.lastname = lastname;
        this.secondLastname = secondLastname;
        this.correo = correo;
        this.contrasena = contrasena;
        this.numeroCuenta = numeroCuenta;
        this.alergias = alergias;
        this.telefono = telefono;
        this.plantel = plantel;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

}
