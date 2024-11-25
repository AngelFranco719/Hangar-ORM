package com.company.hangarbd.controller;

import com.company.hangarbd.models.Empresa;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/// Toda clase EntityController ayuda a adaptar a cada Entidad
/// para personalizar su funcionamiento con Controller.
//  Además, todas heredan a Controller.
public class EmpresaController extends Controller<Empresa> {

    EntityManagerFactory emf;
    
    /// Inicializa un EntityManagerFactory
    public EmpresaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /// Adapta el método de createElement.
    /// Recibe toda la información necesaria para crear una empresa.
    /// Llama al método createElement de Controller
    public void createEmpresa(String emp_nombre, String emp_ubicacion) {
        Empresa newEmpresa = new Empresa(emp_nombre, emp_ubicacion);
        this.createElement(newEmpresa, emf);
    }

    ///Retorna el ID de una Empresa.
    public Empresa getEmpresaByID(Long ID) {
        return this.getElementByID(ID, emf, Empresa.class);
    }

    /// Retorna los valores de una Columna en específico.
    public <T> List<T> getColumnsFromEmpresa(String Column) {
        return this.getAllByColumn(Column, emf, "Empresa");
    }

    /// Actualiza los valores de un registro.
    public void updateEmpresa(Long ID, String emp_nombre, String emp_ubicacion) {
        Empresa updatedEmpresa = new Empresa(ID, emp_nombre, emp_ubicacion);
        this.updateElement(updatedEmpresa, emf);
    }

    /// Elimina un registro de Empresa
    public void deleteEmpresaByID(Long ID) {
        this.deleteElementByID(ID, emf, Empresa.class);
    }

    /// Obtiene el último ID de Empresa.
    public Long getLastID_Empresa() {
        return this.getLastID(emf, "Empresa");
    }

    /// Obtiene el ID de un registro según una columna y un valor obtenidos.
    public <T> Long getIdByColumn(String Column, T Value) {
        return this.getIdByColumnValue(emf, Column, Value, "Empresa");
    }

    /// Obtiene las Columnas de Empresa.
    public List<String> getColumnsFromEmpresa() {
        return this.getColumns(emf, Empresa.class, 3);
    }

}
