package com.sylen.SistemaTorneos.Controller;

import com.sylen.SistemaTorneos.Model.entity.Participante;
import com.sylen.SistemaTorneos.Service.ParticipanteApp;
import com.sylen.SistemaTorneos.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(Constantes.URL_BASE_API)
public class ParticipanteController {

    @Autowired
    private ParticipanteApp participanteApp;

    // TODO: Limitar por id de un equipo o hacer otro endpoint
    @GetMapping(Constantes.LISTA_PARTICIPANTES)
    public ResponseEntity<?> getAllParticipantes (){
        return ResponseEntity.ok(participanteApp.findAll());
    }

    @GetMapping(Constantes.PARTICIPANTE_DETALLE)
    public ResponseEntity<?> getOneParticipante (@PathVariable(name = "id") Long idParticipante){
        return ResponseEntity.ok(participanteApp.findOne(idParticipante));
    }

    @PostMapping(Constantes.CREA_PARTICIPANTE)
    public ResponseEntity<?> saveOneParticipante (@RequestBody Participante participante){
        participanteApp.save(participante);
        return ResponseEntity.noContent().build();
    }
}
