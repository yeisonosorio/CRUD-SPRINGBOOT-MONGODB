package com.proyectopersona.Mongo.controller;

import com.proyectopersona.Mongo.documentos.Persona;
import com.proyectopersona.Mongo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Persona")
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepo;

    @PostMapping
    public ResponseEntity<?> guardarPersona(@RequestBody Persona persona) {
        try {
          Persona personaSave = personaRepo.save(persona);
            return new ResponseEntity<Persona>(personaSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping
    public ResponseEntity<?> obtenerPersona() {
        try {
            List<Persona> persona  = personaRepo.findAll();
            return new ResponseEntity<List<Persona>>(persona , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping
    public ResponseEntity<?> actualizarPersona(@RequestBody Persona persona) {
        try {
            Persona guardarPersona  = personaRepo.save(persona);
            return new ResponseEntity<Persona>(guardarPersona , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable("id") long id) {
        try {
            personaRepo.deleteById(id);
            return new ResponseEntity<String>("persona eliminada" , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getCause().toString(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
