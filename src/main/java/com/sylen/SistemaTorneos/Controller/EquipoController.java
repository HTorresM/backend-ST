package com.sylen.SistemaTorneos.Controller;

import com.sylen.SistemaTorneos.Model.entity.Equipo;
import com.sylen.SistemaTorneos.Service.EquipoApp;
import com.sylen.SistemaTorneos.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(Constantes.URL_BASE_API)
public class EquipoController {

    @Autowired
    private EquipoApp equipoApp;

    @GetMapping(Constantes.LISTA_EQUIPOS)
    public ResponseEntity<?> getAllEquipos (){
        return ResponseEntity.ok(equipoApp.findAll());
    }

    @GetMapping(Constantes.EQUIPO_DETALLE)
    public ResponseEntity<?> getOneEquipo (@PathVariable(name = "id") Long idEquipo){
        return ResponseEntity.ok(equipoApp.findOne(idEquipo));
    }

    public ResponseEntity<?> saveOneEquipo (@RequestBody Equipo equipo){
        equipoApp.save(equipo);
        return ResponseEntity.noContent().build();
    }

}
