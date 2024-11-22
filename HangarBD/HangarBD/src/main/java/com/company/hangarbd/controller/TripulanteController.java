package com.company.hangarbd.controller;

import com.company.hangarbd.models.Cargo;
import com.company.hangarbd.models.Empresa;
import com.company.hangarbd.models.Persona;
import com.company.hangarbd.models.Tripulante;
import com.company.hangarbd.models.Vuelo;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class TripulanteController extends Controller<Tripulante> {

    final private EntityManagerFactory emf;
    private VueloController vueloController;
    private PersonaController personaController;
    private CargoController cargoController;

    public TripulanteController(EntityManagerFactory emf) {
        this.emf = emf;
        vueloController = new VueloController(emf);
        personaController = new PersonaController(emf);
        cargoController = new CargoController(emf);
    }

    public void createTripulante(Long tri_vue, Long tri_car, Long tri_per) {
        Vuelo vuelo = vueloController.getVueloByID(tri_vue);
        Cargo cargo = cargoController.getCargoByID(tri_car);
        Persona persona = personaController.getPersonaByID(tri_per);
        Tripulante newTripulante = new Tripulante(vuelo, cargo, persona);
        this.createElement(newTripulante, emf);
    }

    public Tripulante getTripulanteByID(Long ID) {
        return this.getElementByID(ID, emf, Tripulante.class);
    }

    public <T> List<T> getColumnsFromTripulante(String Column) {
        return this.getAllByColumn(Column, emf, "Tripulante");
    }

    public void updateTripulante(Long ID, Long tri_vue, Long tri_car, Long tri_per) {
        Vuelo vuelo = vueloController.getVueloByID(tri_vue);
        Cargo cargo = cargoController.getCargoByID(tri_car);
        Persona persona = personaController.getPersonaByID(tri_per);
        Tripulante updatedTripulante = new Tripulante(ID, vuelo, cargo, persona);
        System.out.println(updatedTripulante);
        this.updateElement(updatedTripulante, emf);
    }

    public void deleteTripulanteByID(Long ID) {
        this.deleteElementByID(ID, emf, Tripulante.class);
    }

    public Long getLastID_Tripulante() {
        return this.getLastID(emf, "Tripulante");
    }

    public <T> Long getIdByColumn(String Column, T Value) {
        return this.getIdByColumnValue(emf, Column, Value, "Tripulante");
    }

    public List<String> getColumnsFromTripulante() {
        return this.getColumns(emf, Tripulante.class, 4);
    }

}
