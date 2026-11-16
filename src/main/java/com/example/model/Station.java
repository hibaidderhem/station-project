package com.example.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "station")
public class Station implements Serializable {
    @Id
    private String nom;
    private String ville;
    private String adresse;

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
    private List<HistoCarb> histoCarbs;

    public Station() {}
    public Station(String nom, String ville, String adresse) {
        this.nom = nom; this.ville = ville; this.adresse = adresse;
    }
    // Getters and Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
}