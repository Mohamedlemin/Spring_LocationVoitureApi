package com.example.springbootbackend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Voiture")
public class Voiture implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
//    @ManyToOne
//    private Locateur locateurVoiture;
//    @OneToOne(mappedBy = "voiture")
//    private Location location;

    private String Nom;
    private int Annee;
    private String Type_car;
    private String Type_gasoil;
    private String Clim;
    private String Status;

}
