package com.sylen.SistemaTorneos.Controller;

import com.sylen.SistemaTorneos.Model.entity.Evento;
import com.sylen.SistemaTorneos.Service.EventoApp;
import com.sylen.SistemaTorneos.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(Constantes.URL_BASE_API)
@SessionAttributes("evento")
public class EventoController {

    @Autowired
    private EventoApp eventoApp;

    @GetMapping(Constantes.LISTA_EVENTOS)
    public ResponseEntity<?> getAllEventos (){
        return ResponseEntity.ok(eventoApp.findAll());
    }

    @GetMapping(Constantes.EVENTO_DETALLE)
    public ResponseEntity<?> getOneEvento (@PathVariable(name = "id") Long idEvento){
        return ResponseEntity.ok(eventoApp.findOne(idEvento));
    }

    @PostMapping(Constantes.CREA_EVENTO)
    public ResponseEntity<?> saveOneEvento (@RequestBody Evento evento){
        eventoApp.save(evento);
        return ResponseEntity.noContent().build();
    }
}
