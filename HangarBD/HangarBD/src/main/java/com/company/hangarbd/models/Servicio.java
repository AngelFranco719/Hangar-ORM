package com.company.hangarbd.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.*;

@Entity
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_servicio;
    private String ser_Diagnostico;
    private String ser_Acciones;
    private String Responsable;

    @ManyToOne
    @JoinColumn(name = "tall_ser")
    private Taller ser_tall;

    @ManyToOne
    @JoinColumn(name = "nav_ser")
    private Nave ser_nav;

    public Servicio() {
    }

    public Servicio(int ID_servicio, String ser_Diagnostico, String ser_Acciones, String Responsable, Taller ser_tall, Nave ser_nav) {
        this.ID_servicio = ID_servicio;
        this.ser_Diagnostico = ser_Diagnostico;
        this.ser_Acciones = ser_Acciones;
        this.Responsable = Responsable;
        this.ser_tall = ser_tall;
        this.ser_nav = ser_nav;
    }

    public int getID_servicio() {
        return ID_servicio;
    }

    public void setID_servicio(int ID_servicio) {
        this.ID_servicio = ID_servicio;
    }

    public String getSer_Diagnostico() {
        return ser_Diagnostico;
    }

    public void setSer_Diagnostico(String ser_Diagnostico) {
        this.ser_Diagnostico = ser_Diagnostico;
    }

    public String getSer_Acciones() {
        return ser_Acciones;
    }

    public void setSer_Acciones(String ser_Acciones) {
        this.ser_Acciones = ser_Acciones;
    }

    public String getResponsable() {
        return Responsable;
    }

    public void setResponsable(String Responsable) {
        this.Responsable = Responsable;
    }

    public Taller getSer_tall() {
        return ser_tall;
    }

    public void setSer_tall(Taller ser_tall) {
        this.ser_tall = ser_tall;
    }

    public Nave getSer_nav() {
        return ser_nav;
    }

    public void setSer_nav(Nave ser_nav) {
        this.ser_nav = ser_nav;
    }
}
