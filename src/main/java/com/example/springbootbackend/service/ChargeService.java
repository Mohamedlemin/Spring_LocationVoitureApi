package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Charge;
import com.example.springbootbackend.model.Voiture;

import java.util.List;

public interface ChargeService {
    float SumMontantCharge();
    Charge saveCharge(Charge charge);
    List<Charge> getAllCharge();
    Charge getChargeById(long id);
    Charge UpdateCharge(Charge charge,long id);
    void DeleteCharge (long id);
}
