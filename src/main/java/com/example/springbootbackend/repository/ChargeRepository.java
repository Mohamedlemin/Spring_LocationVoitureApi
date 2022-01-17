package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface ChargeRepository extends JpaRepository<Charge,Long > {
    @Query("SELECT SUM(m.Montant) FROM Charge m")
    Float SumMontantCharge();



}
