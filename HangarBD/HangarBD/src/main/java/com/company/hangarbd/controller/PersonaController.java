package com.company.hangarbd.controller;

import com.company.hangarbd.models.Persona;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class PersonaController extends Controller<Persona> {

    private EntityManagerFactory emf;

    public PersonaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createPersona(String per_nombre, String per_licencia, int per_horasVuelo) {
        Persona newPersona = new Persona(per_nombre, per_licencia, per_horasVuelo);
        this.createElement(newPersona, emf);
    }

    public <T> List<T> getColumnsFromPersona(String Column) {
        return this.getAllByColumn(Column, emf, "Persona");
    }

    public Persona getPersonaByID(Long ID) {
        return this.getElementByID(ID, emf, Persona.class);
    }

    public void updatePersona(Long ID, String per_nombre, String per_licencia, int per_horasVuelo) {
        Persona updatedPersona = new Persona(ID, per_nombre, per_licencia, per_horasVuelo);
        this.updateElement(updatedPersona, emf);
    }

    public void deletePersonaByID(Long ID) {
        this.deleteElementByID(ID, emf, Persona.class);
    }

    public Long getLastID_Persona() {
        return this.getLastID(emf, "Persona");
    }

    public <T> Long getIdByColumn(String Column, T Value) {
        return this.getIdByColumnValue(emf, Column, Value, "Persona");
    }

    public List<String> getColumnsFromPersona() {
        return this.getColumns(emf, Persona.class, 4);
    }

}
