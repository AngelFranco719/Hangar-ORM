package com.company.hangarbd.controller;

import com.company.hangarbd.models.Cargo;
import com.company.hangarbd.models.Persona;
import com.company.hangarbd.models.Tripulante;
import com.company.hangarbd.models.Vuelo;
import javax.persistence.EntityManagerFactory;

public class TripulanteController extends Controller<Tripulante> {

    final private EntityManagerFactory emf;

    public TripulanteController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createTripulante(Vuelo tri_vue, Cargo tri_car, Persona tri_per) {
        Tripulante newTripulante = new Tripulante(tri_vue, tri_car, tri_per);
        this.createElement(newTripulante, emf);
    }

    public Tripulante getTripulanteByID(Long ID) {
        return this.getElementByID(ID, emf, Tripulante.class);
    }

    public void updateTripulante(Vuelo tri_vue, Cargo tri_car, Persona tri_per) {
        Tripulante updatedTripulante = new Tripulante(tri_vue, tri_car, tri_per);
        this.updateElement(updatedTripulante, emf);
    }

    public void deleteTripulanteByID(Long ID) {
        this.deleteElementByID(ID, emf, Tripulante.class);
    }

}