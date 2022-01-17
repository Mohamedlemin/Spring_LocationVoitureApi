package com.example.springbootbackend.controller;

import com.example.springbootbackend.service.ChargeService;
import com.example.springbootbackend.service.LocationService;
import com.example.springbootbackend.service.VoitureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Api/Satistiques")
public class StatistiquesController {
    private ChargeService chargeService;
    private LocationService locationService;
    private VoitureService voitureService;

}
