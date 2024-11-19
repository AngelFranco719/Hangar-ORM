package com.company.hangarbd.controller;

import com.company.hangarbd.models.Empresa;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class EmpresaController extends Controller<Empresa> {

    EntityManagerFactory emf;

    public EmpresaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createEmpresa(String emp_nombre, String emp_ubicacion) {
        Empresa newEmpresa = new Empresa(emp_nombre, emp_ubicacion);
        this.createElement(newEmpresa, emf);

    }

    public Empresa getEmpresaByID(Long ID) {
        return this.getElementByID(ID, emf, Empresa.class);
    }

    public <T> List<T> getColumnsFromEmpresa(String Column) {
        return this.getAllByColumn(Column, emf, "Empresa");
    }

    public void updateCargo(String emp_nombre, String emp_ubicacion) {
        Empresa updatedEmpresa = new Empresa(emp_nombre, emp_ubicacion);
        this.updateElement(updatedEmpresa, emf);
    }

    public void deleteEmpresaByID(Long ID) {
        this.deleteElementByID(ID, emf, Empresa.class);
    }

    public Long getLastID_Empresa() {
        return this.getLastID(emf, "Empresa");
    }

    public <T> Long getIdByColumn(String Column, T Value) {
        return this.getIdByColumnValue(emf, Column, Value, "Empresa");
    }

}
