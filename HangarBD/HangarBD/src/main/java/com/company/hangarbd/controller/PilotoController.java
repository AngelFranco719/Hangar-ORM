package com.company.hangarbd.controller;

import com.company.hangarbd.models.Modelo;
import com.company.hangarbd.models.Persona;
import com.company.hangarbd.models.Piloto;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PilotoController extends Controller<Piloto> {

    private EntityManagerFactory emf;
    PersonaController personaController;
    ModeloController modeloController;

    public PilotoController(EntityManagerFactory emf) {
        this.emf = emf;
        personaController = new PersonaController(emf);
        modeloController = new ModeloController(emf);
    }

    public void createPiloto(int pil_horasVuelo, Long pil_per, Long pil_mod) {
        Persona persona = personaController.getPersonaByID(pil_per);
        Modelo modelo = modeloController.getModeloByID(pil_mod);
        Piloto newPiloto = new Piloto(pil_horasVuelo, persona, modelo);
        this.createElement(newPiloto, emf);
    }

    public <T> List<T> getColumnsFromPersona(String Column) {
        return this.getAllByColumn(Column, emf, "Piloto");
    }

    public Piloto getPilotoByID(Long ID) {
        return this.getElementByID(ID, emf, Piloto.class);
    }
    
//    public List<List<String>> getAllFromPiloto() {
//        List<Piloto> pilotos = this.getAllFrom("Piloto", emf);
//        List<List<String>> pilotosToString = this.mapEntitiesToString(pilotos, 4);
//        return pilotosToString;
//    }

    public void updatePiloto(int pil_horasVuelo, Persona pil_per, Modelo pil_mod) {
        Piloto updatedPiloto = new Piloto(pil_horasVuelo, pil_per, pil_mod);
        this.updateElement(updatedPiloto, emf);
    }

    public void deletePilotoByID(Long ID) {
        this.deleteElementByID(ID, emf, Piloto.class);
    }

    public Long getLastID_Piloto() {
        return this.getLastID(emf, "Piloto");
    }

    public <T> Long getIdByColumn(String Column, T Value) {
        return this.getIdByColumnValue(emf, Column, Value, "Piloto");
    }

}
