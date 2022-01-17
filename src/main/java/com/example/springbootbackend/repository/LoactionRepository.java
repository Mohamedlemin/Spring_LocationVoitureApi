package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LoactionRepository extends JpaRepository<Location,Long>{
    @Query("SELECT SUM(m.Prix) FROM Location m")
    Float SumMontantLocation();

}
