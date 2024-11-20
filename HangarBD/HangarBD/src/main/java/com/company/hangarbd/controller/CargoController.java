package com.company.hangarbd.controller;

import com.company.hangarbd.models.Cargo;
import com.company.hangarbd.models.Cargo.cargos;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class CargoController extends Controller<Cargo> {

    private EntityManagerFactory emf;

    public CargoController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void createCargo(cargos car_nombre, String car_descripcion) {
        Cargo newCargo = new Cargo(car_nombre, car_descripcion);
        this.createElement(newCargo, emf);
    }

    public Cargo getCargoByID(Long ID) {
        return this.getElementByID(ID, emf, Cargo.class);
    }

    public List<List<String>> getAllFromHangar() {
        List<Cargo> Cargos = this.getAllFrom("Cargo", emf);
        List<List<String>> cargoToString = this.mapEntitiesToString(Cargos, 3);
        return cargoToString;
    }

    public void updateCargo(cargos car_nombre, String car_descripcion) {
        Cargo updatedCargo = new Cargo(car_nombre, car_descripcion);
        this.updateElement(updatedCargo, emf);
    }

    public void deleteCargoByID(Long ID) {
        this.deleteElementByID(ID, emf, Cargo.class);
    }

    public Long getLastID_Cargo() {
        return (this.getLastID(emf, "Cargo"));
    }

}
