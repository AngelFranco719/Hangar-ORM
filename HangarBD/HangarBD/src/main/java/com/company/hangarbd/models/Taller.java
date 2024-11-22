package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.HashSet;
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
    private String tall_nombre;
    private String tall_descripcion;

    @OneToMany(mappedBy = "ser_tall", fetch = FetchType.EAGER)
    public Set<Servicio> tall_ser = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "tall_han")
    public Hangar tall_han;

    public Taller() {
    }

    public Taller(String tall_nombre, String tal_Descripcion, Hangar tall_han) {
        this.tall_nombre = tall_nombre;
        this.tall_descripcion = tal_Descripcion;
        this.tall_han = tall_han;
    }

    public Long getID_Taller() {
        return ID_Taller;
    }

    public void setID_Taller(Long ID_Taller) {
        this.ID_Taller = ID_Taller;
    }

    public String getTall_nombre() {
        return tall_nombre;
    }

    public void setTall_nombre(String tall_nombre) {
        this.tall_nombre = tall_nombre;
    }

    public String getTall_descripcion() {
        return tall_descripcion;
    }

    public void setTall_descripcion(String tall_descripcion) {
        this.tall_descripcion = tall_descripcion;
    }

    public Set<Servicio> getTall_ser() {
        return tall_ser;
    }

    public void setTall_ser(Set<Servicio> tall_ser) {
        this.tall_ser = tall_ser;
    }

    public Hangar getTall_han() {
        return tall_han;
    }

    public void setTall_han(Hangar tall_han) {
        this.tall_han = tall_han;
    }

    @Override
    public String toString() {
        return this.getTall_nombre();
    }

}
