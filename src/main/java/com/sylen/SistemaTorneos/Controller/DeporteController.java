package com.sylen.SistemaTorneos.Controller;

import com.sylen.SistemaTorneos.Model.entity.Deporte;
import com.sylen.SistemaTorneos.Service.DeporteApp;
import com.sylen.SistemaTorneos.utils.Constantes;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(Constantes.URL_BASE_API)
@SessionAttributes("deporte")
public class DeporteController {

    @Autowired
    private DeporteApp deporteApp;

    @GetMapping(Constantes.LISTA_DEPORTES)
    public ResponseEntity<?> getAllDeportes(){
        List<Deporte> deportes = deporteApp.getAllDeportes();
        return ResponseEntity.ok(deportes);
    }

    @GetMapping(Constantes.DEPORTE_DETALLE)
    public ResponseEntity<?> getOneDeporte (
            @PathVariable(name = "id", required = true)
            @Positive(message = "El id tiene que ser positivo")
            Long id ){
        Deporte deporte = deporteApp.getOneDeporte(id);
        if (deporte == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deporte);
    }

    @PostMapping(Constantes.CREA_DEPORTE)
    // TODO: Validaciones a Priori
    public ResponseEntity<?> saveOneDeporte (@RequestBody @Valid Deporte deporte){
        deporteApp.save(deporte);
        return ResponseEntity.ok().build();
    }

}
