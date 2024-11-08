
package com.mycompany.hangarbd.com.company.hangarbd.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity(name = "Taller")
public class Taller implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int ID_taller;
    private String tal_Descripcion;
    
    @OneToMany
        @JoinColumn (name = "ser_tall", nullable = false)
        private List<Servicio> tall_ser=new ArrayList<Servicio>();
    
    @OneToMany
        @JoinColumn (name = "han_tall", nullable = false)
        private List<Hangar> tall_han=new ArrayList<Hangar>();

    public Taller() {
    }

    public Taller(int ID_taller, String tal_Descripcion) {
        this.ID_taller = ID_taller;
        this.tal_Descripcion = tal_Descripcion;
    }

    public int getID_taller() {
        return ID_taller;
    }

    public void setID_taller(int ID_taller) {
        this.ID_taller = ID_taller;
    }

    public String getTal_Descripcion() {
        return tal_Descripcion;
    }

    public void setTal_Descripcion(String tal_Descripcion) {
        this.tal_Descripcion = tal_Descripcion;
    }
    
    
}
