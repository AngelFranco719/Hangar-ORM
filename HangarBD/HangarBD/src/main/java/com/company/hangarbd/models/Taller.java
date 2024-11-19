package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class Taller implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Taller;
    private String tall_Descripcion;

    @OneToMany
    @JoinColumn(name = "ser_tall")
    public Set<Servicio> tall_ser;

    @OneToOne
    @JoinColumn(name = "tall_han")
    public Hangar tall_han;

    public Taller() {
    }

    public Taller(String tal_Descripcion, Hangar tall_han) {
        this.tall_Descripcion = tal_Descripcion;
        this.tall_han = tall_han;
    }

    public Long getID_taller() {
        return ID_Taller;
    }

    public void setID_taller(Long ID_taller) {
        this.ID_Taller = ID_taller;
    }

    public String getTal_Descripcion() {
        return tall_Descripcion;
    }

    public void setTal_Descripcion(String tal_Descripcion) {
        this.tall_Descripcion = tal_Descripcion;
    }

}
