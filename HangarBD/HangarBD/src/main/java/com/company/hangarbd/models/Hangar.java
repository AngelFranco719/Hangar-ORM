package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Hangar")
public class Hangar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Hangar")
    private Long ID_Hangar;
    private int han_capacidad;
    private String han_nombre;
    private String han_ubicacion;
    private String han_descripcion;
    private String han_codigo;

    @OneToMany(mappedBy = "nav_han", fetch = FetchType.EAGER)
    public Set<Nave> han_nav = new HashSet<>();

    public Hangar() {
    }

    public Hangar(int han_capacidad, String han_nombre, String han_ubicacion, String han_descripcion, String han_codigo) {
        this.han_capacidad = han_capacidad;
        this.han_nombre = han_nombre;
        this.han_ubicacion = han_ubicacion;
        this.han_descripcion = han_descripcion;
        this.han_codigo = han_codigo;
    }

    public Hangar(Long ID, int han_capacidad, String han_nombre, String han_ubicacion, String han_descripcion, String han_codigo) {
        this.ID_Hangar = ID;
        this.han_capacidad = han_capacidad;
        this.han_nombre = han_nombre;
        this.han_ubicacion = han_ubicacion;
        this.han_descripcion = han_descripcion;
        this.han_codigo = han_codigo;
    }

    public Long getID_Hangar() {
        return ID_Hangar;
    }

    public void setID_Hangar(Long ID_Hangar) {
        this.ID_Hangar = ID_Hangar;
    }

    public Set<Nave> getHan_nav() {
        return han_nav;
    }

    public void setHan_nav(Set<Nave> han_nav) {
        this.han_nav = han_nav;
    }

    public int getHan_capacidad() {
        return han_capacidad;
    }

    public void setHan_capacidad(int han_capacidad) {
        this.han_capacidad = han_capacidad;
    }

    public String getHan_nombre() {
        return han_nombre;
    }

    public void setHan_nombre(String han_nombre) {
        this.han_nombre = han_nombre;
    }

    public String getHan_ubicacion() {
        return han_ubicacion;
    }

    public void setHan_ubicacion(String han_ubicacion) {
        this.han_ubicacion = han_ubicacion;
    }

    public String getHan_descripcion() {
        return han_descripcion;
    }

    public void setHan_descripcion(String han_descripcion) {
        this.han_descripcion = han_descripcion;
    }

    public String getHan_codigo() {
        return han_codigo;
    }

    public void setHan_codigo(String han_codigo) {
        this.han_codigo = han_codigo;
    }

    @Override
    public String toString() {
        return this.getHan_nombre();
    }
}
