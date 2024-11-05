package com.company.hangarbd.controller;

import com.company.hangarbd.models.Empresa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmpresaController extends Controller<Empresa> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_HangarBD_jar_1.0-SNAPSHOTPU");

    public void createEmpresa(String emp_nombre, String emp_ubicacion) {
        Empresa newEmpresa = new Empresa(emp_nombre, emp_ubicacion);
        this.createElement(newEmpresa, emf);

    }

    public Empresa getEmpresaByID(Long ID) {
        return this.getElementByID(ID, emf, Empresa.class);
    }

    public void updateCargo(String emp_nombre, String emp_ubicacion) {
        Empresa updatedEmpresa = new Empresa(emp_nombre, emp_ubicacion);
        this.updateElement(updatedEmpresa, emf);
    }

    public void deleteEmpresaByID(Long ID) {
       this.deleteElementByID(ID, emf, Empresa.class);
    }

}
