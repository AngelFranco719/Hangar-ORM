package com.company.hangarbd.models;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Empresa;
    private String emp_nombre;
    private String emp_ubicacion;

    @OneToMany(mappedBy = "nav_emp", fetch = FetchType.EAGER)
    public Set<Nave> emp_nav = new HashSet<>();

    public Empresa(String emp_nombre, String emp_ubicacion) {
        this.emp_nombre = emp_nombre;
        this.emp_ubicacion = emp_ubicacion;
    }

    public Empresa(Long ID, String emp_nombre, String emp_ubicacion) {
        this.ID_Empresa = ID;
        this.emp_nombre = emp_nombre;
        this.emp_ubicacion = emp_ubicacion;
    }

    public Empresa() {
    }

    public Set<Nave> getEmp_nav() {
        return emp_nav;
    }

    public void setEmp_nav(Set<Nave> emp_nav) {
        this.emp_nav = emp_nav;
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

    /*@Override
    public String toString() {
        return "Empresa{" + "ID_Empresa=" + ID_Empresa + ", emp_nombre=" + emp_nombre + ", emp_ubicacion=" + emp_ubicacion + '}';
    }*/
    @Override
    public String toString() {
        return this.getEmp_nombre();
    }
}
