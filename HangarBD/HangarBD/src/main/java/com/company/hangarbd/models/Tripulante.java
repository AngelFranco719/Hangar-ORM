package com.company.hangarbd.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tripulante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Tripulante;

    @ManyToOne
    @JoinColumn(name = "tri_vue")
    public Vuelo tri_vue;

    @ManyToOne
    @JoinColumn(name = "tri_car")
    public Cargo tri_car;

    @ManyToOne
    @JoinColumn(name = "tri_per")
    public Persona tri_per;

    public Tripulante() {
    }

    public Tripulante(Vuelo tri_vue, Cargo tri_car, Persona tri_per) {
        this.tri_vue = tri_vue;
        this.tri_car = tri_car;
        this.tri_per = tri_per;
    }

    public Tripulante(Long ID, Vuelo tri_vue, Cargo tri_car, Persona tri_per) {
        this.ID_Tripulante = ID;
        this.tri_vue = tri_vue;
        this.tri_car = tri_car;
        this.tri_per = tri_per;
    }

    public Long getID_Tripulante() {
        return ID_Tripulante;
    }

    public void setID_Tripulante(Long ID_Tripulante) {
        this.ID_Tripulante = ID_Tripulante;
    }

    public Vuelo getTri_Vue() {
        return tri_vue;
    }

    public void setTri_Vue(Vuelo tri_Vue) {
        this.tri_vue = tri_Vue;
    }

    public Cargo getTri_Car() {
        return tri_car;
    }

    public void setTri_Car(Cargo tri_Car) {
        this.tri_car = tri_Car;
    }

    public Persona getTri_Per() {
        return tri_per;
    }

    public void setTri_Per(Persona tri_Per) {
        this.tri_per = tri_Per;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getID_Tripulante());
    }
}
