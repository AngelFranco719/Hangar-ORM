package com.mycompany.hangarbd.com.company.hangarbd.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "Hangar")
public class Nave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Nave; 
    private float nav_peso;
    private String nav_estado;
    private String nav_descripcion;
    private int nav_capacidad;

    public Long getID_Nave() {
        return ID_Nave;
    }

    public void setID_Nave(Long ID_Nave) {
        this.ID_Nave = ID_Nave;
    }

    public float getNav_peso() {
        return nav_peso;
    }

    public void setNav_peso(float nav_peso) {
        this.nav_peso = nav_peso;
    }

    public String getNav_estado() {
        return nav_estado;
    }

    public void setNav_estado(String nav_estado) {
        this.nav_estado = nav_estado;
    }

    public String getNav_descripcion() {
        return nav_descripcion;
    }

    public void setNav_descripcion(String nav_descripcion) {
        this.nav_descripcion = nav_descripcion;
    }

    public int getNav_capacidad() {
        return nav_capacidad;
    }

    public void setNav_capacidad(int nav_capacidad) {
        this.nav_capacidad = nav_capacidad;
    }
    
    
}
