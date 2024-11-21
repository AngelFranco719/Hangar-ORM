package com.company.hangarbd.controller;

import com.company.hangarbd.models.Cargo;
import com.company.hangarbd.models.Nave;
import com.company.hangarbd.models.Servicio;
import com.company.hangarbd.models.Taller;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public class ServicioController extends Controller<Servicio> {

    private EntityManagerFactory emf;
    private TallerController tallerController;
    private NaveController naveController;

    public ServicioController(EntityManagerFactory emf) {
        this.emf = emf;
        tallerController = new TallerController(emf);
        naveController = new NaveController(emf);
    }

    public void createServicio(String ser_Diagnostico, String ser_Acciones, String Responsable, Long ser_tall, Long ser_nav) {
        Taller taller = tallerController.getTallerByID(ser_tall);
        Nave nave = naveController.getNaveByID(ser_nav);
        Servicio newServicio = new Servicio(ser_Diagnostico, ser_Acciones, Responsable, taller, nave);
        this.createElement(newServicio, emf);
    }

    public Servicio getServicioByID(Long ID) {
        return this.getElementByID(ID, emf, Servicio.class);
    }

    public <T> List<T> getColumnsFromServicio(String Column) {
        return this.getAllByColumn(Column, emf, "Servicio");
    }
    
    public List<List<String>> getAllFromServicio() {
        List<Servicio> Servicio = this.getAllFrom("Servicio", emf);
        List<List<String>> servicioToString = this.mapEntitiesToString(Servicio, 6);
        return servicioToString;
    }


    public void updateServicio(String ser_Diagnostico, String ser_Acciones, String Responsable, Taller ser_tall, Nave ser_nav) {
        Servicio updatedServicio = new Servicio(ser_Diagnostico, ser_Acciones, Responsable, ser_tall, ser_nav);
        this.updateElement(updatedServicio, emf);
    }

    public void deleteServicio(Long ID) {
        deleteElementByID(ID, emf, Servicio.class);
    }

    public Long getLastID_Servicio() {
        return this.getLastID(emf, "Servicio");
    }

    public <T> Long getIdByColumn(String Column, T Value) {
        return this.getIdByColumnValue(emf, Column, Value, "Servicio");
    }

}
