package com.company.hangarbd.controller;

import com.company.hangarbd.models.Persona;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonaController extends Controller<Persona> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_HangarBD_jar_1.0-SNAPSHOTPU");

    public void createPersona(String per_nombre, String per_fabricante, String per_anio) {
        Persona newPersona = new Persona(per_nombre, per_fabricante, per_anio);
        this.createElement(newPersona, emf);
    }

    public Persona getPersonaByID(Long ID) {
        return this.getElementByID(ID, emf, Persona.class);
    }

    public void updatePersona(String per_nombre, String per_fabricante, String per_anio) {
        Persona updatedPersona = new Persona(per_nombre, per_fabricante, per_anio);
        this.updateElement(updatedPersona, emf);
    }

    public void deletePersonaByID(Long ID) {
        this.deleteElementByID(ID, emf, Persona.class);
    }

}
