package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity(name = "Taller")
public class Taller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_taller;
    private String tal_Descripcion;

    @OneToMany
    @JoinColumn(name = "ser_tall")
    public Set<Servicio> tall_ser;

    @OneToOne
    @JoinColumn(name = "han_tall")
    public Hangar tall_han;

    public Taller() {
    }

    public Taller(String tal_Descripcion, Hangar tall_han) {
        this.tal_Descripcion = tal_Descripcion;
        this.tall_han=tall_han; 
    }

    public int getID_taller() {
        return ID_taller;
    }

    public void setID_taller(int ID_taller) {
        this.ID_taller = ID_taller;
    }

    public String getTal_Descripcion() {
        return tal_Descripcion;
    }

    public void setTal_Descripcion(String tal_Descripcion) {
        this.tal_Descripcion = tal_Descripcion;
    }

}
