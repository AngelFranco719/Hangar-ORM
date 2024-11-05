package com.company.hangarbd.controller;

import com.company.hangarbd.models.Modelo;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ModeloController extends Controller<Modelo> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_HangarBD_jar_1.0-SNAPSHOTPU");

    public void createModelo(String mod_nombre, String mod_fabricante, String mod_anio) {
        Modelo newModelo = new Modelo(mod_nombre, mod_fabricante, mod_anio);
        this.createElement(newModelo, emf);
    }

    public Modelo getModeloByID(Long ID) {
        return this.getElementByID(ID, emf, Modelo.class);
    }
    
    public void updateModelo(String mod_nombre, String mod_fabricante, String mod_anio){
        Modelo updatedModelo = new Modelo(mod_nombre, mod_fabricante, mod_anio); 
        this.updateElement(updatedModelo, emf);
    }
    
    public void deleteModeloByID(Long ID){
        this.deleteElementByID(ID, emf, Modelo.class);
    }
    
}
