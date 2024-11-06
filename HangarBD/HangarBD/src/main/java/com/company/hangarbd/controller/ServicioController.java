package com.company.hangarbd.controller;

import com.company.hangarbd.models.Nave;
import com.company.hangarbd.models.Servicio;
import com.company.hangarbd.models.Taller;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServicioController extends Controller<Servicio> {

    final private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_HangarBD_jar_1.0-SNAPSHOTPU");

    public void createServicio(String ser_Diagnostico, String ser_Acciones, String Responsable, Taller ser_tall, Nave ser_nav) {
        Servicio newServicio = new Servicio(ser_Diagnostico, ser_Acciones, Responsable, ser_tall, ser_nav);
        this.createElement(newServicio, emf);
    }

    public Servicio getServicioByID(Long ID) {
        return this.getElementByID(ID, emf, Servicio.class);
    }

    public void updateServicio(String ser_Diagnostico, String ser_Acciones, String Responsable, Taller ser_tall, Nave ser_nav) {
        Servicio updatedServicio = new Servicio(ser_Diagnostico, ser_Acciones, Responsable, ser_tall, ser_nav);
        this.updateElement(updatedServicio, emf);
    }

    public void deleteServicio(Long ID) {
        deleteElementByID(ID, emf, Servicio.class);
    }

}
