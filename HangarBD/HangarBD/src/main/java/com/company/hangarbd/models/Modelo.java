package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Modelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Modelo;
    private String mod_nombre;
    private String mod_fabricante;
    @Column(name = "mod_año")
    private String mod_año;

    @OneToMany(mappedBy = "nav_mod", fetch = FetchType.EAGER)
    public Set<Nave> mod_nav = new HashSet<>();

    @OneToMany(mappedBy = "pil_mod", fetch = FetchType.EAGER)
    public Set<Piloto> mod_pil = new HashSet<>();

    public Modelo() {
    }

    public Modelo(String mod_nombre, String mod_fabricante, String mod_anio) {
        this.mod_nombre = mod_nombre;
        this.mod_fabricante = mod_fabricante;
        this.mod_año = mod_anio;
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
        this.mod_año = mod_anio;
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
        return mod_año;
    }

    public void setMod_anio(String mod_anio) {
        this.mod_año = mod_anio;
    }

}
