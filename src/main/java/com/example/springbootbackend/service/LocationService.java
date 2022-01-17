package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;
public interface LocationService {
    Float SumMontantLocation();
    Location saveLoaction (Location location);
    List<Location> getAllLocation();
    Location getLocationById(long id);
    Location UpdateLoaction(Location location,long id);
    void DeleteLocation (long id);
}
