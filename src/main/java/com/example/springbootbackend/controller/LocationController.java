package com.example.springbootbackend.controller;


import com.example.springbootbackend.model.Location;
import com.example.springbootbackend.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Location")
public class LocationController {
    private LocationService locationService;



    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @PostMapping()
    public ResponseEntity<Location> saveLocation(@RequestBody Location location){
        return new ResponseEntity<>(locationService.saveLoaction(location), HttpStatus.CREATED);
    }

    @GetMapping("/Sum")
    public ResponseEntity<Float> SumMontantLocation(){
        return new ResponseEntity<Float>(locationService.SumMontantLocation(),HttpStatus.OK);
    }

    @GetMapping()
    public List<Location> getAllLocation(){
        return   locationService.getAllLocation();
    }

    @GetMapping("{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") long id){
        return new ResponseEntity<Location>(locationService.getLocationById(id),HttpStatus.OK);

    }
    @PutMapping("{id}")
    public ResponseEntity<Location> UpdateLoaction(@PathVariable("id") long id,@RequestBody Location location){
        return new ResponseEntity<Location>(locationService.UpdateLoaction(location,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteLocation(@PathVariable("id") long id){
        locationService.DeleteLocation(id);
        return new ResponseEntity<String>("location Info deleted Successfuly",HttpStatus.OK);
    }
}
