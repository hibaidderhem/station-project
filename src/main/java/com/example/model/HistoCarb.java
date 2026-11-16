package com.example.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "histo_carb")
@IdClass(HistoCarbId.class)
public class HistoCarb implements Serializable {
    @Id
    @Column(name = "station_nom")
    private String station;

    @Id
    @Column(name = "carburant_nom")
    private String carburant;

    @Id
    private String date;

    private double prix;

    public HistoCarb() {}
    public HistoCarb(String station, String carburant, String date, double prix) {
        this.station = station;
        this.carburant = carburant;
        this.date = date;
        this.prix = prix;
    }
    // Getters and Setters
    public String getStation() { return station; }
    public void setStation(String station) { this.station = station; }
    public String getCarburant() { return carburant; }
    public void setCarburant(String carburant) { this.carburant = carburant; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
}