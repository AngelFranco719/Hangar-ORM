package com.company.hangarbd.controller;

import com.company.hangarbd.models.Empresa;
import com.company.hangarbd.models.Hangar;
import com.company.hangarbd.models.Modelo;
import com.company.hangarbd.models.Nave;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class NaveController extends Controller<Nave> {

    private EntityManagerFactory emf;
    private EmpresaController empresaController;
    private ModeloController modeloController;
    private HangarController hangarController;

    public NaveController(EntityManagerFactory emf) {
        this.emf = emf;
        empresaController = new EmpresaController(emf);
        modeloController = new ModeloController(emf);
        hangarController = new HangarController(emf);
    }

    public void createNave(String nav_codigo, float nav_peso, String nav_estado, String nav_descripcion, int nav_capacidad, Long nav_emp, Long nav_han, Long nav_mod) {
        Empresa empresa = empresaController.getEmpresaByID(nav_emp);
        Modelo modelo = modeloController.getModeloByID(nav_mod);
        Hangar hangar = hangarController.getHangarByID(nav_han);
        Nave newNave = new Nave(nav_codigo, nav_peso, nav_estado, nav_descripcion, nav_capacidad, empresa, hangar, modelo);
        this.createElement(newNave, emf);
    }

    public Nave getNaveByID(Long ID) {
        return this.getElementByID(ID, emf, Nave.class);
    }

    public <T> List<T> getColumnsFromNave(String Column) {
        return this.getAllByColumn(Column, emf, "Nave");
    }

    public void updateNave(String nav_codigo, float nav_peso, String nav_estado, String nav_descripcion, int nav_capacidad, Empresa nav_emp, Hangar nav_han, Modelo nav_mod) {
        Nave updatedNave = new Nave(nav_codigo, nav_peso, nav_estado, nav_descripcion, nav_capacidad, nav_emp, nav_han, nav_mod);
        this.updateElement(updatedNave, emf);
    }

    public void deleteNaveByID(Long ID) {
        this.deleteElementByID(ID, emf, Nave.class);
    }

    public Long getLastID_Nave() {
        return this.getLastID(emf, "Nave");
    }

    public <T> Long getIdByColumn(String Column, T Value) {
        return this.getIdByColumnValue(emf, Column, Value, "Nave");
    }

}
