package com.example.springbootbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Data
@Entity
@Table(name = "Charge")
public class Charge implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@ManyToOne
   // private Locateur locateurCharge;
    private String Description;
    private Double Montant;
    private java.sql.Date Date;


}
