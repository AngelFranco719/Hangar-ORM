package com.company.hangarbd.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "Piloto")
public class Piloto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Piloto;
    private int pil_horasVuelo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pil_per")
    public Persona pil_per;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "pil_mod")
    public Modelo pil_mod;

    public Piloto() {
    }

    public Piloto(int pil_horasVuelo, Persona pil_per, Modelo pil_mod) {
        this.pil_horasVuelo = pil_horasVuelo;
        this.pil_per = pil_per;
        this.pil_mod = pil_mod;
    }

    public Long getID_Piloto() {
        return ID_Piloto;
    }

    public void setID_Piloto(Long ID_Piloto) {
        this.ID_Piloto = ID_Piloto;
    }

    public int getPil_horasVuelo() {
        return pil_horasVuelo;
    }

    public void setPil_horasVuelo(int pil_horasVuelo) {
        this.pil_horasVuelo = pil_horasVuelo;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getID_Piloto());
    }

}
