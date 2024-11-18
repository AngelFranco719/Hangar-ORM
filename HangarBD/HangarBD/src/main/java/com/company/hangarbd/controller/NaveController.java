package com.company.hangarbd.controller;

import com.company.hangarbd.models.Empresa;
import com.company.hangarbd.models.Hangar;
import com.company.hangarbd.models.Modelo;
import com.company.hangarbd.models.Nave;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NaveController extends Controller<Nave> {

    private EntityManagerFactory emf;

    public NaveController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createNave(float nav_peso, String nav_estado, String nav_descripcion, int nav_capacidad, Empresa nav_emp, Hangar nav_han, Modelo nav_mod) {
        Nave newNave = new Nave(nav_peso, nav_estado, nav_descripcion, nav_capacidad, nav_emp, nav_han, nav_mod);
        this.createElement(newNave, emf);
    }

    public Nave getNaveByID(Long ID) {
        return this.getElementByID(ID, emf, Nave.class);
    }

    public void updateNave(float nav_peso, String nav_estado, String nav_descripcion, int nav_capacidad, Empresa nav_emp, Hangar nav_han, Modelo nav_mod) {
        Nave updatedNave = new Nave(nav_peso, nav_estado, nav_descripcion, nav_capacidad, nav_emp, nav_han, nav_mod);
        this.updateElement(updatedNave, emf);
    }

    public void deleteNaveByID(Long ID) {
        this.deleteElementByID(ID, emf, Nave.class);
    }

}
