package com.company.hangarbd.controller;

import com.company.hangarbd.models.Modelo;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ModeloController extends Controller<Modelo> {

    private EntityManagerFactory emf;

    public ModeloController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createModelo(String mod_nombre, String mod_fabricante, String mod_anio) {
        Modelo newModelo = new Modelo(mod_nombre, mod_fabricante, mod_anio);
        this.createElement(newModelo, emf);
    }

    public Modelo getModeloByID(Long ID) {
        return this.getElementByID(ID, emf, Modelo.class);
    }

//    public List<List<String>> getAllFromModelo() {
//        List<Modelo> modelos = this.getAllFrom("Modelo", emf);
//        List<List<String>> modelosToString = this.mapEntitiesToString(modelos, 6);
//        return modelosToString;
//    }

    public void updateModelo(String mod_nombre, String mod_fabricante, String mod_anio) {
        Modelo updatedModelo = new Modelo(mod_nombre, mod_fabricante, mod_anio);
        this.updateElement(updatedModelo, emf);
    }

    public void deleteModeloByID(Long ID) {
        this.deleteElementByID(ID, emf, Modelo.class);
    }

    public Long getLastID_Modelo() {
        return this.getLastID(emf, "Modelo");
    }

    public <T> List<T> getColumnsFromModelo(String Column) {
        return this.getAllByColumn(Column, emf, "Modelo");
    }

    public <T> Long getIdByColumn(String Column, T Value) {
        return this.getIdByColumnValue(emf, Column, Value, "Modelo");
    }

}
