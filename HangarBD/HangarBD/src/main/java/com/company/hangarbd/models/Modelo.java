package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "modelo")
public class Modelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Modelo;
    private String mod_nombre;
    private String mod_fabricante;
    private String mod_anio;

    @OneToMany
    @JoinColumn(name = "nav_mod")
    public Set<Nave> mod_nav;

    @OneToMany
    @JoinColumn(name = "pil_mod")
    public Set<Piloto> mod_pil;

    public Modelo() {
    }

    public Modelo(String mod_nombre, String mod_fabricante, String mod_anio) {
        this.mod_nombre = mod_nombre;
        this.mod_fabricante = mod_fabricante;
        this.mod_anio = mod_anio;
    }

    public Set<Nave> getModeloNave() {
        return mod_nav;
    }

    public void setModeloNave(Set<Nave> modeloNave) {
        this.mod_nav = modeloNave;
    }

    public Modelo(Long ID_Modelo, String mod_nombre, String mod_fabricante, String mod_anio) {
        this.ID_Modelo = ID_Modelo;
        this.mod_nombre = mod_nombre;
        this.mod_fabricante = mod_fabricante;
        this.mod_anio = mod_anio;
    }

    public Long getID_Modelo() {
        return ID_Modelo;
    }

    public void setID_Modelo(Long ID_Modelo) {
        this.ID_Modelo = ID_Modelo;
    }

    public String getMod_nombre() {
        return mod_nombre;
    }

    public void setMod_nombre(String mod_nombre) {
        this.mod_nombre = mod_nombre;
    }

    public String getMod_fabricante() {
        return mod_fabricante;
    }

    public void setMod_fabricante(String mod_fabricante) {
        this.mod_fabricante = mod_fabricante;
    }

    public String getMod_anio() {
        return mod_anio;
    }

    public void setMod_anio(String mod_anio) {
        this.mod_anio = mod_anio;
    }

}
