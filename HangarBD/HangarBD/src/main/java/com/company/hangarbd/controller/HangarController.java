package com.company.hangarbd.controller;

import com.company.hangarbd.models.Hangar;
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

    public void updateHangar(int han_Capacidad, String han_Nombre, String han_Ubicacion, String han_Descripcion, String han_Codigo) {
        Hangar updatedHangar = new Hangar(han_Capacidad, han_Nombre, han_Ubicacion, han_Descripcion, han_Codigo);
        this.updateElement(updatedHangar, emf);
    }

    public void deleteHangarByID(Long ID) {
        this.deleteElementByID(ID, emf, Hangar.class);
    }

}
