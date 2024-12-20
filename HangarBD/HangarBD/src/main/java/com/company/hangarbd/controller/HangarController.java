package com.company.hangarbd.controller;

import com.company.hangarbd.models.Hangar;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class HangarController extends Controller<Hangar> {

    private EntityManagerFactory emf;

    public HangarController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createHangar(int han_Capacidad, String han_Nombre, String han_Ubicacion, String han_Descripcion, String han_Codigo) {
        Hangar newHangar = new Hangar(han_Capacidad, han_Nombre, han_Ubicacion, han_Descripcion, han_Codigo);
        this.createElement(newHangar, emf);
    }

    public Hangar getHangarByID(Long ID) {
        return this.getElementByID(ID, emf, Hangar.class);
    }

    public <T> List<T> getColumnsFromHangar(String Column) {
        return this.getAllByColumn(Column, emf, "Hangar");
    }

    public void updateHangar(Long ID, int han_Capacidad, String han_Nombre, String han_Ubicacion, String han_Descripcion, String han_Codigo) {
        Hangar updatedHangar = new Hangar(ID, han_Capacidad, han_Nombre, han_Ubicacion, han_Descripcion, han_Codigo);
        this.updateElement(updatedHangar, emf);
    }

    public void deleteHangarByID(Long ID) {
        this.deleteElementByID(ID, emf, Hangar.class);
    }

    public Long getLastID_Hangar() {
        return this.getLastID(emf, "Hangar");
    }

    public <T> Long getIdByColumn(String Column, T Value) {
        return this.getIdByColumnValue(emf, Column, Value, "Hangar");
    }

    public List<String> getColumnsFromHangar() {
        return this.getColumns(emf, Hangar.class, 6);
    }

}
