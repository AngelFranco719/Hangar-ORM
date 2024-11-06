package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "Hangar")
public class Hangar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Hangar;
    private int han_Capacidad;
    private String han_Nombre;
    private String han_Ubicacion;
    private String han_Descripcion;
    private String han_Codigo;

    @OneToOne
    @JoinColumn(name = "nav_han")
    public Set<Nave> han_nav;

    @OneToMany
    @JoinColumn(name = "tall_han")
    public Taller han_tal;

    public Hangar(int han_Capacidad, String han_Nombre, String han_Ubicacion, String han_Descripcion, String han_Codigo) {
        this.han_Capacidad = han_Capacidad;
        this.han_Nombre = han_Nombre;
        this.han_Ubicacion = han_Ubicacion;
        this.han_Descripcion = han_Descripcion;
        this.han_Codigo = han_Codigo;
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

    public Taller getHan_tal() {
        return han_tal;
    }

    public void setHan_tal(Taller han_tal) {
        this.han_tal = han_tal;
    }

    public int getHan_Capacidad() {
        return han_Capacidad;
    }

    public void setHan_Capacidad(int han_Capacidad) {
        this.han_Capacidad = han_Capacidad;
    }

    public String getHan_Nombre() {
        return han_Nombre;
    }

    public void setHan_Nombre(String han_Nombre) {
        this.han_Nombre = han_Nombre;
    }

    public String getHan_Ubicacion() {
        return han_Ubicacion;
    }

    public void setHan_Ubicacion(String han_Ubicacion) {
        this.han_Ubicacion = han_Ubicacion;
    }

    public String getHan_Descripcion() {
        return han_Descripcion;
    }

    public void setHan_Descripcion(String han_Descripcion) {
        this.han_Descripcion = han_Descripcion;
    }

    public String getHan_Codigo() {
        return han_Codigo;
    }

    public void setHan_Codigo(String han_Codigo) {
        this.han_Codigo = han_Codigo;
    }

}
