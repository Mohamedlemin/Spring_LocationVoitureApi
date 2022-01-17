package com.example.springbootbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Data

public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @ManyToOne
//    private Location locateurInfo;
//    @OneToOne
//    private Voiture voiture;

    private String Nom_Internaute;
    private int Tel;
    private Double Prix;
    private Date Date_d;
    private Date Date_F;
}
