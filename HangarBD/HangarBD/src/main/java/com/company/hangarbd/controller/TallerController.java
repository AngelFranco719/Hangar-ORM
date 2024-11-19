package com.company.hangarbd.controller;

import com.company.hangarbd.models.Hangar;
import com.company.hangarbd.models.Taller;
import javax.persistence.EntityManagerFactory;

public class TallerController extends Controller<Taller> {

    final private EntityManagerFactory emf;
    private HangarController hangarController;

    public TallerController(EntityManagerFactory emf) {
        this.emf = emf;
        hangarController = new HangarController(emf);
    }

    public void createTaller(String tal_Descripcion, Long tall_han) {
        Hangar selectedHangar = hangarController.getHangarByID(tall_han);
        Taller newTaller = new Taller(tal_Descripcion, selectedHangar);
        this.createElement(newTaller, emf);
    }

    public Taller getTallerByID(Long ID) {
        return this.getElementByID(ID, emf, Taller.class);
    }

    public void updateTaller(String tal_Descripcion, Hangar tall_han) {
        Taller updatedTaller = new Taller(tal_Descripcion, tall_han);
        this.updateElement(updatedTaller, emf);
    }

    public void deleteTallerByID(Long ID) {
        this.deleteElementByID(ID, emf, Taller.class);
    }

    public Long getLastID_Taller() {
        return this.getLastID(emf, "Taller");
    }

}
