
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

@Entity(name = "Piloto")
public class Piloto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Piloto;
    private int pil_horasVuelo;
    
    @ManyToOne
    @JoinColumn(name = "per_pil")
    public Persona pil_per;
    
    @ManyToOne
    @JoinColumn(name = " mod_pil")
    public Modelo pil_mod;

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
    
    
}
