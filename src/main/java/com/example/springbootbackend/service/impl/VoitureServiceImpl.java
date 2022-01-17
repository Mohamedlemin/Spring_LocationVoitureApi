package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Voiture;
import com.example.springbootbackend.repository.VoitureRepository;
import com.example.springbootbackend.service.VoitureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureServiceImpl implements VoitureService {
    private VoitureRepository voitureRepository;


    public VoitureServiceImpl(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    @Override
    public long CountVoiture() {
        return voitureRepository.count();
    }

    @Override
    public Voiture saveVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @Override
    public List<Voiture> getAllVoiture() {
        return voitureRepository.findAll();
    }

    @Override
    public Voiture getVoitureById(long idVoiture) {
//        Optional<Voiture> VoitureById= voitureRepository.findById(idVoiture);
//        if (VoitureById.isPresent()){
//            return VoitureById.get();
//        }else {
//            throw new ResourceNotFoundException("Voiture","Id",idVoiture);
//        }
        //Lamda expresion
        return voitureRepository
                .findById(idVoiture).
                        orElseThrow(
                                () -> new ResourceNotFoundException("Voiture","Id",idVoiture)
                        );

    }

    @Override
    public Voiture UpdateVoiture(Voiture voiture,long id) {
        Voiture ExsistingVoiture= voitureRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("voiture","id",id)
        );
        ExsistingVoiture.setAnnee(voiture.getAnnee());
        ExsistingVoiture.setClim(voiture.getClim());
        ExsistingVoiture.setNom(voiture.getNom());
        ExsistingVoiture.setStatus(voiture.getStatus());
        ExsistingVoiture.setType_car(voiture.getType_car());
        ExsistingVoiture.setType_gasoil(voiture.getType_gasoil());

        voitureRepository.save(ExsistingVoiture);
        return ExsistingVoiture;
    }

    @Override
    public void DeleteVoiture(long id){
        voitureRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Voiture","id",id)
        );
        voitureRepository.deleteById(id);
    }
}
