
package com.mycompany.hangarbd.com.company.hangarbd.models;

import java.io.Serializable;
import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "empresa")
public class Empresa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Empresa;
    private String emp_nombre;
    private String emp_ubicacion;

    public Empresa(Long ID_Empresa, String emp_nombre, String emp_ubicacion) {
        this.ID_Empresa = ID_Empresa;
        this.emp_nombre = emp_nombre;
        this.emp_ubicacion = emp_ubicacion;
    }

    public Empresa() {
    }

    public Long getID_Empresa() {
        return ID_Empresa;
    }

    public void setID_Empresa(Long ID_Empresa) {
        this.ID_Empresa = ID_Empresa;
    }

    public String getEmp_nombre() {
        return emp_nombre;
    }

    public void setEmp_nombre(String emp_nombre) {
        this.emp_nombre = emp_nombre;
    }

    public String getEmp_ubicacion() {
        return emp_ubicacion;
    }

    public void setEmp_ubicacion(String emp_ubicacion) {
        this.emp_ubicacion = emp_ubicacion;
    }
    
}
