package com.sylen.SistemaTorneos.Controller;

import com.sylen.SistemaTorneos.Model.entity.Persona;
import com.sylen.SistemaTorneos.Service.PersonaApp;
import com.sylen.SistemaTorneos.utils.Constantes;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constantes.URL_BASE_API)
public class PersonaController {

    @Autowired
    private PersonaApp personaApp;

    @GetMapping(Constantes.LISTA_PERSONAS)
    public ResponseEntity<?> getAllPersonas(){
        List<Persona> personas = personaApp.findAll();
        return ResponseEntity.ok(personas);
    }

    @GetMapping(Constantes.PERSONA_DETALLE)
    public ResponseEntity<?> getOnePersona(@PathVariable(name = "id") Long id){
        Persona persona = personaApp.findOne(id);
        return ResponseEntity.ok(persona);
    }

    @PostMapping(Constantes.CREA_PERSONA)
    public ResponseEntity<?> saveOnePersona(@RequestBody Persona persona){
        // TODO: Validaciones a Posteriori
        personaApp.saveOne(persona);
        return ResponseEntity.noContent().build();
    }
}
