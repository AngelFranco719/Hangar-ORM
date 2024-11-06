package com.company.hangarbd.controller;

import com.company.hangarbd.models.Modelo;
import com.company.hangarbd.models.Persona;
import com.company.hangarbd.models.Piloto;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PilotoController extends Controller<Piloto> {

    final private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_HangarBD_jar_1.0-SNAPSHOTPU");

    public void createPiloto(int pil_horasVuelo, Persona pil_per, Modelo pil_mod) {
        Piloto newPiloto = new Piloto(pil_horasVuelo, pil_per, pil_mod);
        this.createElement(newPiloto, emf);
    }

    public Piloto getPilotoByID(Long ID) {
        return this.getElementByID(ID, emf, Piloto.class);
    }

    public void updatePiloto(int pil_horasVuelo, Persona pil_per, Modelo pil_mod) {
        Piloto updatedPiloto = new Piloto(pil_horasVuelo, pil_per, pil_mod);
        this.updateElement(updatedPiloto, emf);
    }

    public void deletePilotoByID(Long ID) {
        this.deleteElementByID(ID, emf, Piloto.class);
    }

}
