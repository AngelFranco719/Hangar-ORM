
package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Vuelo")
public class Vuelo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_Vuelo;
    private String vue_Origen;
    private String vue_Destino;
    private Date vue_Fecha_Inicio;
    private Date vue_Fecha_Fin;
    private float vue_Distancia;
    private float vue_Duracion;
    private float vuel_AltitudPromedio;
    private int vue_Pasajeros;
     @ManyToOne
    public Nave vueNave;

    public Long getId_Vuelo() {
        return Id_Vuelo;
    }

    public void setId_Vuelo(Long Id_Vuelo) {
        this.Id_Vuelo = Id_Vuelo;
    }

    public String getVue_Origen() {
        return vue_Origen;
    }

    public void setVue_Origen(String vue_Origen) {
        this.vue_Origen = vue_Origen;
    }

    public String getVue_Destino() {
        return vue_Destino;
    }

    public void setVue_Destino(String vue_Destino) {
        this.vue_Destino = vue_Destino;
    }

    public Date getVue_Fecha_Inicio() {
        return vue_Fecha_Inicio;
    }

    public void setVue_Fecha_Inicio(Date vue_Fecha_Inicio) {
        this.vue_Fecha_Inicio = vue_Fecha_Inicio;
    }

    public Date getVue_Fecha_Fin() {
        return vue_Fecha_Fin;
    }

    public void setVue_Fecha_Fin(Date vue_Fecha_Fin) {
        this.vue_Fecha_Fin = vue_Fecha_Fin;
    }

    public float getVue_Distancia() {
        return vue_Distancia;
    }

    public void setVue_Distancia(float vue_Distancia) {
        this.vue_Distancia = vue_Distancia;
    }

    public float getVue_Duracion() {
        return vue_Duracion;
    }

    public void setVue_Duracion(float vue_Duracion) {
        this.vue_Duracion = vue_Duracion;
    }

    public float getVuel_AltitudPromedio() {
        return vuel_AltitudPromedio;
    }

    public void setVuel_AltitudPromedio(float vuel_AltitudPromedio) {
        this.vuel_AltitudPromedio = vuel_AltitudPromedio;
    }

    public int getVue_Pasajeros() {
        return vue_Pasajeros;
    }

    public void setVue_Pasajeros(int vue_Pasajeros) {
        this.vue_Pasajeros = vue_Pasajeros;
    }

  
}

