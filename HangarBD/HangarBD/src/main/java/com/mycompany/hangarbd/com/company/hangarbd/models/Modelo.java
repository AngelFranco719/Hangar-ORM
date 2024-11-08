
package com.mycompany.hangarbd.com.company.hangarbd.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "modelo")
public class Modelo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Modelo;
    private String mod_nombre;
    private String mod_fabricante;
    private String mod_anio;

    public Modelo() {
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
