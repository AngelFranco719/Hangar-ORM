package com.company.hangarbd.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Cargo")
public class Cargo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Cargo;

    public enum cargos {
        PILOTO, COPILOTO, INGENIERO, AUXILIAR
    };
    private cargos car_nombre;
    private String car_descripcion;

    public Long getID_Cargo() {
        return ID_Cargo;
    }

    public cargos getCar_nombre() {
        return car_nombre;
    }

    public void setCar_nombre(cargos car_nombre) {
        this.car_nombre = car_nombre;
    }

    public void setID_Cargo(Long ID_Cargo) {
        this.ID_Cargo = ID_Cargo;
    }

    public String getCar_descripcion() {
        return car_descripcion;
    }

    public void setCar_descripcion(String car_descripcion) {
        this.car_descripcion = car_descripcion;
    }

}
