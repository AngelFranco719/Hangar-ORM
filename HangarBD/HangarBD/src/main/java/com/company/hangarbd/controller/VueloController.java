package com.company.hangarbd.controller;

import com.company.hangarbd.models.Nave;
import com.company.hangarbd.models.Vuelo;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class VueloController extends Controller<Vuelo> {

    private final EntityManagerFactory emf;

    public VueloController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createVuelo(String vue_codigo, String vue_Origen, String vue_Destino, Date vue_fechaInicio, Date vue_fechaFin, String vue_Distancia, String vue_Duracion, float vuel_AltitudPromedio, int vue_Pasajeros, Nave vue_nav) {
        Vuelo newVuelo = new Vuelo(vue_codigo, vue_Origen, vue_Destino, vue_fechaInicio, vue_fechaFin, vue_Distancia, vue_Duracion, vuel_AltitudPromedio, vue_Pasajeros, vue_nav);
        this.createElement(newVuelo, emf);
    }
//    public List<List<String>> getAllFromVuelo() {
//        List<Vuelo> Vuelo = this.getAllFrom("Vuelo", emf);
//        List<List<String>> vueloToString = this.mapEntitiesToString(Vuelo, 12);
//        return vueloToString;
//    }

    public Vuelo getVueloByID(Long ID) {
        return this.getElementByID(ID, emf, Vuelo.class);
    }

    public <T> List<T> getColumnsFromVuelo(String Column) {
        return this.getAllByColumn(Column, emf, "Vuelo");
    }

    public void updateVuelo(String vue_codigo, String vue_Origen, String vue_Destino, Date vue_fechaInicio, Date vue_fechaFin, String vue_Distancia, String vue_Duracion, float vuel_AltitudPromedio, int vue_Pasajeros, Nave vue_nav) {
        Vuelo updatedVuelo = new Vuelo(vue_codigo, vue_Origen, vue_Destino, vue_fechaInicio, vue_fechaFin, vue_Distancia, vue_Duracion, vuel_AltitudPromedio, vue_Pasajeros, vue_nav);
        this.updateElement(updatedVuelo, emf);
    }

    public void deleteVueloByID(Long ID) {
        this.deleteElementByID(ID, emf, Vuelo.class);
    }

    public Long getLastID_Vuelo() {
        return this.getLastID(emf, "Vuelo");
    }

    public <T> Long getIdByColumn(String Column, T Value) {
        return this.getIdByColumnValue(emf, Column, Value, "Vuelo");
    }

    public List<String> getColumnsFromVuelo() {
        return this.getColumns(emf, Vuelo.class, 10);
    }

}
