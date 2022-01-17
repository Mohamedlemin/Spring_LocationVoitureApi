package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.Voiture;
import com.example.springbootbackend.service.VoitureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Voiture")
public class VoitureController {
   private VoitureService voitureService;

    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }
    @GetMapping("/Count")
    public long CountVoiture(){
        return voitureService.CountVoiture();
    }
    //Build Add Voiture REST API
    @PostMapping()
    public ResponseEntity<Voiture> saveVoiture(@RequestBody Voiture voiture){
        return new ResponseEntity<Voiture>(voitureService.saveVoiture(voiture), HttpStatus.CREATED);
    }

    //Build Get all Voiture REST API
    @GetMapping()
    public List<Voiture> GetAllVoiture(){
        return voitureService.getAllVoiture();
    }

    //Build findVoitureById restApi
    @GetMapping("{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable("id") long id){
        return new ResponseEntity<Voiture>(voitureService.getVoitureById(id),HttpStatus.OK);
    }

    //Buil update Api
    @PutMapping("{id}")
    public ResponseEntity<Voiture> UpdateVoiture(@PathVariable("id") long id,@RequestBody Voiture voiture){
        return new ResponseEntity<Voiture>(voitureService.UpdateVoiture(voiture,id),HttpStatus.OK);
    }

    //Buid delete Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteVoiture(@PathVariable("id") long id){
        voitureService.DeleteVoiture(id);
        return new ResponseEntity<String>("Voiture deleted Successfuly",HttpStatus.OK);

    }

}
