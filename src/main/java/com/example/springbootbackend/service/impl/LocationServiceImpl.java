package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Location;

import com.example.springbootbackend.repository.LoactionRepository;
import com.example.springbootbackend.service.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {
    LoactionRepository loactionRepository;

    @Override
    public Float SumMontantLocation() {
        return loactionRepository.SumMontantLocation();
    }

    @Override
    public Location saveLoaction(Location location) {
        return loactionRepository.save(location);
    }

    @Override
    public List<Location> getAllLocation() {
        return loactionRepository.findAll();
    }

    @Override
    @GetMapping("{id}")
    public Location getLocationById(@PathVariable("id") long id) {
       return loactionRepository.findById(id).orElseThrow(
                ()->   new   ResourceNotFoundException("Location","id",id)
        );

    }

    @Override
    @GetMapping("{id}")
    public Location UpdateLoaction(Location location, long id) {

        Location ExsistingLocation= loactionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("location","id",id)
        );
        ExsistingLocation.setPrix(location.getPrix());
        ExsistingLocation.setDate_d(location.getDate_d());
        ExsistingLocation.setDate_F(location.getDate_F());
        ExsistingLocation.setTel(location.getTel());
        ExsistingLocation.setNom_Internaute(location.getNom_Internaute());

        loactionRepository.save(ExsistingLocation);
        return ExsistingLocation;
    }

    @Override
    public void DeleteLocation(long id) {
        loactionRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("location","id",id)
        );
        loactionRepository.deleteById(id);

    }
}
