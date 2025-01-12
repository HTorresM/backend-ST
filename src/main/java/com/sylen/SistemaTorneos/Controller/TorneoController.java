package com.sylen.SistemaTorneos.Controller;

import com.sylen.SistemaTorneos.Model.DAO.ITorneoDAO;
import com.sylen.SistemaTorneos.Model.entity.Torneo;
import com.sylen.SistemaTorneos.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(Constantes.URL_BASE_API)
public class TorneoController {

    @Autowired
    private ITorneoDAO torneoDAO;

    @GetMapping(Constantes.LISTA_TORNEOS)
    public ResponseEntity<?> getAllTorneos(){
        return ResponseEntity.ok(torneoDAO.findAll());
    }

    @GetMapping(Constantes.TORNEO_DETALLE)
    public ResponseEntity<?> getOneTorneo( @PathVariable(value = "id") Long idTorneo){
        return ResponseEntity.ok(torneoDAO.findOne(idTorneo));
    }


    @PostMapping(Constantes.CREA_TORNEO)
    public ResponseEntity<?> saveOneTorneo(@RequestBody Torneo torneo){
        torneoDAO.save(torneo);
        return ResponseEntity.noContent().build();
    }
}
