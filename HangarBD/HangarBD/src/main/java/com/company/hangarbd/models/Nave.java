package com.company.hangarbd.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity(name = "Nave")
public class Nave implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Nave;
    private float nav_peso;
    private String nav_estado;
    private String nav_descripcion;
    private int nav_capacidad;

    @ManyToOne
    @JoinColumn(name = "emp_nav")
    public Empresa nav_emp;

    @ManyToOne
    @JoinColumn(name = "han_nav")
    public Hangar nav_han;

    @ManyToOne
    @JoinColumn(name = "mod_nav")
    public Modelo nav_mod;

    @ManyToOne
    @JoinColumn(name = "ser_nav")
    public Servicio nav_ser;

    @ManyToOne
    @JoinColumn(name = "vue_nav")
    public Vuelo nav_vue;

    public Servicio getNav_ser() {
        return nav_ser;
    }

    public void setNav_ser(Servicio nav_ser) {
        this.nav_ser = nav_ser;
    }

    public Vuelo getNav_vue() {
        return nav_vue;
    }

    public void setNav_vue(Vuelo nav_vue) {
        this.nav_vue = nav_vue;
    }

    public Empresa getNav_emp() {
        return nav_emp;
    }

    public void setNav_emp(Empresa nav_emp) {
        this.nav_emp = nav_emp;
    }

    public Hangar getNav_han() {
        return nav_han;
    }

    public void setNav_han(Hangar nav_han) {
        this.nav_han = nav_han;
    }

    public Modelo getNav_mod() {
        return nav_mod;
    }

    public void setNav_mod(Modelo nav_mod) {
        this.nav_mod = nav_mod;
    }

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
