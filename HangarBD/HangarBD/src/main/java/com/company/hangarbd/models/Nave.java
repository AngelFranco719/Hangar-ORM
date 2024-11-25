package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Nave implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Nave;
    private String nav_codigo;
    private float nav_peso;
    private String nav_estado;
    private String nav_descripcion;
    private int nav_capacidad;

    /// En las relaciones ManyToOne es donde se obtiene la Llave Foránea,
    /// por lo tanto, es necesario usar JoinColumn para declarár qué
    /// columna usará la llave foránea.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nav_emp")
    public Empresa nav_emp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nav_han")
    public Hangar nav_han = new Hangar();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nav_mod")
    public Modelo nav_mod;

    @OneToMany(mappedBy = "ser_nav", fetch = FetchType.EAGER)
    public Set<Servicio> nav_ser = new HashSet<>();

    @OneToMany(mappedBy = "vue_nav", fetch = FetchType.EAGER)
    public Set<Vuelo> nav_vue = new HashSet<>();

    public Nave() {
    }

    public Nave(String nav_codigo, float nav_peso, String nav_estado, String nav_descripcion, int nav_capacidad, Empresa nav_emp, Hangar nav_han, Modelo nav_mod) {
        this.nav_codigo = nav_codigo;
        this.nav_peso = nav_peso;
        this.nav_estado = nav_estado;
        this.nav_descripcion = nav_descripcion;
        this.nav_capacidad = nav_capacidad;
        this.nav_emp = nav_emp;
        this.nav_han = nav_han;
        this.nav_mod = nav_mod;
    }

    public Nave(Long ID, String nav_codigo, float nav_peso, String nav_estado, String nav_descripcion, int nav_capacidad, Empresa nav_emp, Hangar nav_han, Modelo nav_mod) {
        this.ID_Nave = ID;
        this.nav_codigo = nav_codigo;
        this.nav_peso = nav_peso;
        this.nav_estado = nav_estado;
        this.nav_descripcion = nav_descripcion;
        this.nav_capacidad = nav_capacidad;
        this.nav_emp = nav_emp;
        this.nav_han = nav_han;
        this.nav_mod = nav_mod;
    }

    public String getNav_codigo() {
        return nav_codigo;
    }

    public void setNav_codigo(String nav_codigo) {
        this.nav_codigo = nav_codigo;
    }

    public Set<Servicio> getNav_ser() {
        return nav_ser;
    }

    public void setNav_ser(Set<Servicio> nav_ser) {
        this.nav_ser = nav_ser;
    }

    public Set<Vuelo> getNav_vue() {
        return nav_vue;
    }

    public void setNav_vue(Set<Vuelo> nav_vue) {
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

    @Override
    public String toString() {
        return this.getNav_codigo();
    }

}
