package com.company.hangarbd.controller;

import com.company.hangarbd.models.Nave;
import com.company.hangarbd.models.Vuelo;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VueloController extends Controller<Vuelo> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_HangarBD_jar_1.0-SNAPSHOTPU");

    public void createVuelo(String vue_Origen, String vue_Destino, Date vue_fechaInicio, Date vue_fechaFin, float vue_Distancia, float vue_Duracion, float vuel_AltitudPromedio, int vue_Pasajeros, Nave vue_nav) {
        Vuelo newVuelo = new Vuelo(vue_Origen, vue_Destino, vue_fechaInicio, vue_fechaFin, vue_Distancia, vue_Duracion, vuel_AltitudPromedio, vue_Pasajeros, vue_nav);
        this.createElement(newVuelo, emf);
    }

    public Vuelo getVueloByID(Long ID) {
        return this.getElementByID(ID, emf, Vuelo.class);
    }

    public void updateVuelo(String vue_Origen, String vue_Destino, Date vue_fechaInicio, Date vue_fechaFin, float vue_Distancia, float vue_Duracion, float vuel_AltitudPromedio, int vue_Pasajeros, Nave vue_nav) {
        Vuelo updatedVuelo = new Vuelo(vue_Origen, vue_Destino, vue_fechaInicio, vue_fechaFin, vue_Distancia, vue_Duracion, vuel_AltitudPromedio, vue_Pasajeros, vue_nav);
        this.updateElement(updatedVuelo, emf);
    }

    public void deleteVueloByID(Long ID) {
        this.deleteElementByID(ID, emf, Vuelo.class);
    }
}
