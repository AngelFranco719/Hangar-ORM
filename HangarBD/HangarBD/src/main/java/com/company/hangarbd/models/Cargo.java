package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/// Los Modelos ayudan a mapear las entidades a través
/// del Java Persistence Unit.

@Entity
public class Cargo implements Serializable {

    /// Declara el ID y lo marca como AutoIncrementable.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Cargo;

    public enum cargos {
        PILOTO, COPILOTO, INGENIERO, AUXILIAR
    };
    private cargos car_nombre;
    private String car_descripcion;

    /// Declara una relación Uno a Muchos
    /// Marca la referencia de la relación en donde se encuentra
    /// la llave Foránea.
    /// Marca la búsqueda a "Ansiosa" para obtener las relaciones 
    /// en cualquier momento de la ejecución.
    @OneToMany(mappedBy = "tri_car", fetch = FetchType.EAGER)
    private Set<Tripulante> car_tri = new HashSet<>();

    
    /// Se declaran 3 constructores.
    /// Constructor vacío.
    public Cargo() {
    }

    /// Constructor para crear un nuevo registro. 
    /// (No se necesita obtener el ID.
    public Cargo(cargos car_nombre, String car_descripcion) {
        this.car_nombre = car_nombre;
        this.car_descripcion = car_descripcion;
    }

    /// Constructor para actualizar un registro.
    /// (Es necesario obtener el ID).
    public Cargo(Long ID, cargos car_nombre, String car_descripcion) {
        this.ID_Cargo = ID;
        this.car_nombre = car_nombre;
        this.car_descripcion = car_descripcion;
    }

    /// Métodos Getters y Setters.
    public Set<Tripulante> getCar_tri() {
        return car_tri;
    }

    public void setCar_tri(Set<Tripulante> car_tri) {
        this.car_tri = car_tri;
    }

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

    @Override
    public String toString() {
        return this.getCar_nombre().toString();
    }

}
