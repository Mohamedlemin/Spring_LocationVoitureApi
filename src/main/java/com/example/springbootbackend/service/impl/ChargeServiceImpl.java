package com.example.springbootbackend.service.impl;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Charge;

import com.example.springbootbackend.repository.ChargeRepository;
import com.example.springbootbackend.service.ChargeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeServiceImpl implements ChargeService {
    ChargeRepository chargeRepository;

    public ChargeServiceImpl(ChargeRepository chargeRepository) {
        this.chargeRepository = chargeRepository;
    }

    @Override
    public float SumMontantCharge() {
        return chargeRepository.SumMontantCharge();
    }

    @Override
    public Charge saveCharge(Charge charge) {
        return chargeRepository.save(charge);
    }

    @Override
    public List<Charge> getAllCharge() {
        return chargeRepository.findAll();
    }

    @Override
    public Charge getChargeById(long idCharge) {
       return chargeRepository.findById(idCharge).orElseThrow(
                ()-> new ResourceNotFoundException("Charge","ID",idCharge)
        );
    }


    @Override
    public Charge UpdateCharge(Charge charge, long id) {
        Charge ExsitingCharge = chargeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Charge","id",id)
        );
        ExsitingCharge.setDate(charge.getDate());
        ExsitingCharge.setDescription(charge.getDescription());
        ExsitingCharge.setMontant(charge.getMontant());
        chargeRepository.save(ExsitingCharge);
        return ExsitingCharge;
    }

    @Override
    public void DeleteCharge(long id) {
        chargeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Charge","Id",id)
        );
        chargeRepository.deleteById(id);

    }
}
