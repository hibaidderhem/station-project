package com.example.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "carburant")
public class Carburant implements Serializable {
    @Id
    private String nom;
    private String description;

    @OneToMany(mappedBy = "carburant", cascade = CascadeType.ALL)
    private List<HistoCarb> histoCarbs;

    public Carburant() {}
    public Carburant(String nom, String description) {
        this.nom = nom; this.description = description;
    }
    // Getters and Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}