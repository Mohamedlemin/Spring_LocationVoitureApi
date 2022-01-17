package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Voiture;

import java.util.List;

public interface VoitureService {
    long CountVoiture();
    Voiture saveVoiture (Voiture voiture);
    List<Voiture> getAllVoiture();
    Voiture getVoitureById(long id);
    Voiture UpdateVoiture(Voiture voiture,long id);
    void DeleteVoiture (long id);

}
