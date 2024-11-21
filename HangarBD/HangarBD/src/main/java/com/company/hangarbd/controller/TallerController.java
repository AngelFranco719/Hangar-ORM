package com.company.hangarbd.controller;

import com.company.hangarbd.models.Hangar;
import com.company.hangarbd.models.Taller;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class TallerController extends Controller<Taller> {

    final private EntityManagerFactory emf;
    private HangarController hangarController;

    public TallerController(EntityManagerFactory emf) {
        this.emf = emf;
        hangarController = new HangarController(emf);
    }

    public void createTaller(String tall_nombre, String tal_Descripcion, Long tall_han) {
        Hangar selectedHangar = hangarController.getHangarByID(tall_han);
        Taller newTaller = new Taller(tall_nombre, tal_Descripcion, selectedHangar);
        this.createElement(newTaller, emf);
    }

    public Taller getTallerByID(Long ID) {
        return this.getElementByID(ID, emf, Taller.class);
    }
//    public List<List<String>> getAllFromTaller() {
//        List<Taller> Taller = this.getAllFrom("Taller", emf);
//        List<List<String>> tallerToString = this.mapEntitiesToString(Taller, 4);
//        return tallerToString;
//    }
    
    public <T> List<T> getColumnsFromTaller(String Column) {
        return this.getAllByColumn(Column, emf, "Taller");
    }

    public void updateTaller(String tall_nombre, String tal_Descripcion, Hangar tall_han) {
        Taller updatedTaller = new Taller(tall_nombre, tal_Descripcion, tall_han
        );
        this.updateElement(updatedTaller, emf);
    }

    public void deleteTallerByID(Long ID) {
        this.deleteElementByID(ID, emf, Taller.class);
    }

    public Long getLastID_Taller() {
        return this.getLastID(emf, "Taller");
    }

    public <T> Long getIdByColumn(String Column, T Value) {
        return this.getIdByColumnValue(emf, Column, Value, "Taller");
    }

}
