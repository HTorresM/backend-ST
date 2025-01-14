package com.sylen.SistemaTorneos.Controller;

import java.util.List;

import com.sylen.SistemaTorneos.Model.entity.Administrador;
import com.sylen.SistemaTorneos.Service.AdministradorApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sylen.SistemaTorneos.utils.Constantes;


@RestController
@RequestMapping(Constantes.URL_BASE_API)
public class AdministradorController {

    @Autowired
    private AdministradorApp administradorApp;

    @GetMapping(Constantes.LISTA_ADMINISTRADORES)
    public ResponseEntity<?> getAllAdministradores(){
        List<Administrador> personas = administradorApp.findAll();
        return ResponseEntity.ok(personas);
    }

    @GetMapping(Constantes.ADMINISTRADOR_DETALLE)
    public ResponseEntity<?> getOneAdministrador(@PathVariable(name = "id") Long id){
        Administrador administrador = administradorApp.findOne(id);
        return ResponseEntity.ok(administrador);
    }

    @PostMapping(Constantes.CREA_ADMINISTRADOR)
    public ResponseEntity<?> saveOneAdministrador(@RequestBody Administrador administrador){
        // TODO: Validaciones a Posteriori
        administradorApp.save(administrador);
        return ResponseEntity.noContent().build();
    }

}
