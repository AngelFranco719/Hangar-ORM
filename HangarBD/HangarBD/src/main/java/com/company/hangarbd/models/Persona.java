package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Persona;
    private String per_nombre;
    private String per_licencia;
    private int per_horasVuelo;

    @OneToMany
    @JoinColumn(name = "tri_per")
    public Set<Tripulante> per_tri;

    @OneToMany(mappedBy = "pil_per")
    public Set<Piloto> per_pil;

    public Persona() {
    }

    public Persona(String per_nombre, String per_licencia, int per_horasVuelo) {
        this.per_nombre = per_nombre;
        this.per_licencia = per_licencia;
        this.per_horasVuelo = per_horasVuelo;
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

    public Long getID_Persona() {
        return ID_Persona;
    }

    public void setID_Persona(Long ID_Persona) {
        this.ID_Persona = ID_Persona;
    }

    public String getPer_licencia() {
        return per_licencia;
    }

    public void setPer_licencia(String per_licencia) {
        this.per_licencia = per_licencia;
    }

    public int getPer_horasVuelo() {
        return per_horasVuelo;
    }

    public void setPer_horasVuelo(int per_horasVuelo) {
        this.per_horasVuelo = per_horasVuelo;
    }

    public Set<Tripulante> getPer_tri() {
        return per_tri;
    }

    public void setPer_tri(Set<Tripulante> per_tri) {
        this.per_tri = per_tri;
    }

    public Set<Piloto> getPer_pil() {
        return per_pil;
    }

    public void setPer_pil(Set<Piloto> per_pil) {
        this.per_pil = per_pil;
    }

}
