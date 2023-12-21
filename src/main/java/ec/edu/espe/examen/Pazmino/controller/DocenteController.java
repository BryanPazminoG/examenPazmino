package ec.edu.espe.examen.Pazmino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.examen.Pazmino.domain.Docente;
import ec.edu.espe.examen.Pazmino.service.DocenteService;



@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @PostMapping("/crear")
    public ResponseEntity<Docente> Guardar(@RequestBody Docente docente) {
        return new ResponseEntity<>(docenteService.crearDocente(docente), HttpStatus.OK);
    }

    
}
