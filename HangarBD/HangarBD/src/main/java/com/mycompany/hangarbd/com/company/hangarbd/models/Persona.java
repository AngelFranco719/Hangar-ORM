
package com.mycompany.hangarbd.com.company.hangarbd.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "persona")
public class Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Persona;
    private String per_nombre;
    private String per_fabricante;
    private String per_anio;

    public Persona() {
    }

    public Persona(Long ID_Persona, String per_nombre, String per_fabricante, String per_anio) {
        this.ID_Persona = ID_Persona;
        this.per_nombre = per_nombre;
        this.per_fabricante = per_fabricante;
        this.per_anio = per_anio;
    }

    public Long getID_Modelo() {
        return ID_Persona;
    }

    public void setID_Modelo(Long ID_Persona) {
        this.ID_Persona = ID_Persona;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getPer_fabricante() {
        return per_fabricante;
    }

    public void setPer_fabricante(String per_fabricante) {
        this.per_fabricante = per_fabricante;
    }

    public String getPer_anio() {
        return per_anio;
    }

    public void setMod_anio(String per_anio) {
        this.per_anio = per_anio;
    }
    
        
}
