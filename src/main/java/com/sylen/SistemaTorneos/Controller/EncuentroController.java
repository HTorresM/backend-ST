package com.sylen.SistemaTorneos.Controller;

import com.sylen.SistemaTorneos.Model.entity.Encuentro;
import com.sylen.SistemaTorneos.Service.EncuentroApp;
import com.sylen.SistemaTorneos.utils.Constantes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(Constantes.URL_BASE_API)
public class EncuentroController {

    @Autowired
    private EncuentroApp encuentroApp;

    @GetMapping(Constantes.LISTA_ENCUENTROS)
    public ResponseEntity<?> getAllEncuentros(){
        return ResponseEntity.ok(encuentroApp.findAll());
    }

    @GetMapping(Constantes.ENCUENTRO_DETALLE)
    public ResponseEntity<?> getOneEncuentro (
            @PathVariable(name = "id", required = true)
            @Positive(message = "El id tiene que ser positivo")
            Long id ){
        Encuentro encuentro = encuentroApp.findOne(id);
        if (encuentro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encuentro);
    }

    @PostMapping(Constantes.CREA_ENCUENTRO)
    // TODO: Validaciones a Priori
    public ResponseEntity<?> saveOneEncuentro (@RequestBody @Valid Encuentro encuentro){
        encuentroApp.save(encuentro);
        return ResponseEntity.noContent().build();
    }

}
