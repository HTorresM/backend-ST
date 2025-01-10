package com.sylen.SistemaTorneos.Controller;

import com.sylen.SistemaTorneos.Model.DAO.IPlantelDAO;
import com.sylen.SistemaTorneos.Model.entity.Plantel;
import com.sylen.SistemaTorneos.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constantes.URL_BASE_API)
public class PlantelController {

    @Autowired
    private IPlantelDAO plantelDAO;

    @GetMapping(Constantes.LISTA_PLANTELES)
    public ResponseEntity<?> getAllPlanteles(){
        List<Plantel> planteles = plantelDAO.findAll();
        return ResponseEntity.ok(planteles);
    }

    @GetMapping(Constantes.PLANTEL_DETALLE)
    public ResponseEntity<?> getOnePlantel(@PathVariable(name = "id") Long id){
        Plantel plantel = plantelDAO.findOne(id);
        return ResponseEntity.ok(plantel);
    }

    @PostMapping(Constantes.CREA_PLANTEL)
    public ResponseEntity<?> saveOnePlantel(@RequestBody Plantel plantel){
        // TODO: Validaciones a Posteriori
        plantelDAO.save(plantel);
        return ResponseEntity.noContent().build();
    }
}
