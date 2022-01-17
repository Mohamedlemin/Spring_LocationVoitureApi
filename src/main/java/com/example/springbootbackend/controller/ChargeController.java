package com.example.springbootbackend.controller;

import com.example.springbootbackend.model.Charge;
import com.example.springbootbackend.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Charge")

public class ChargeController {
    private ChargeService chargeService;


    public ChargeController(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    //Sum
    @GetMapping("/Sum")
    public ResponseEntity<Float> SumMontantCharge(){
        return new ResponseEntity<Float>(chargeService.SumMontantCharge(),HttpStatus.OK);
    }
    // Add
    @PostMapping()
    public ResponseEntity<Charge> saveCharge(@RequestBody Charge charge){
        return new ResponseEntity<>(chargeService.saveCharge(charge),HttpStatus.CREATED);
    }
    // List
    @GetMapping()
    public List<Charge> getAllCharge(){
      return   chargeService.getAllCharge();
    }

    // GetById
    @GetMapping("{id}")
    public ResponseEntity<Charge> getChargeByID(@PathVariable("id") long id){
        return new ResponseEntity<Charge>(chargeService.getChargeById(id),HttpStatus.OK);

    }
    //Update
    @PutMapping("{id}")
    public ResponseEntity<Charge> UpdateChargeByID(@PathVariable("id") long id,@RequestBody Charge charge){
        return new ResponseEntity<Charge>(chargeService.UpdateCharge(charge,id),HttpStatus.OK);
    }


    //Delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteCharge(@PathVariable("id") long id){
        chargeService.DeleteCharge(id);
        return new ResponseEntity<String>("Charge deleted Successfuly",HttpStatus.OK);
    }
}
