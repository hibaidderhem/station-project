package com.example.model;

import java.io.Serializable;
import java.util.Objects;

public class HistoCarbId implements Serializable {
    private String station;
    private String carburant;
    private String date;

    public HistoCarbId() {}
    public HistoCarbId(String station, String carburant, String date) {
        this.station = station;
        this.carburant = carburant;
        this.date = date;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HistoCarbId)) return false;
        HistoCarbId that = (HistoCarbId) o;
        return Objects.equals(station, that.station) &&
                Objects.equals(carburant, that.carburant) &&
                Objects.equals(date, that.date);
    }
    @Override
    public int hashCode() {
        return Objects.hash(station, carburant, date);
    }
}