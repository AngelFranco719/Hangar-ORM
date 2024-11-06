
package com.company.hangarbd.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity (name = "tripulante")
public class Tripulante implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Tripulante;
    
    @ManyToOne
    @JoinColumn(name = "vue_tri")
    public Vuelo tri_vue;
    
    @ManyToOne
    @JoinColumn(name = "car_tri")
    public Cargo tri_car;
    
    @ManyToOne
    @JoinColumn(name = "per_tri")
    public Persona tri_per; 

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

    
    
    
}
