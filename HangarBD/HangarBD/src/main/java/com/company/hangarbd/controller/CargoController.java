package com.company.hangarbd.controller;

import com.company.hangarbd.models.Cargo;
import com.company.hangarbd.models.Cargo.cargos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CargoController {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_HangarBD_jar_1.0-SNAPSHOTPU");

    public void createCargo(cargos car_nombre, String car_descripcion) {
        Cargo newCargo = new Cargo(car_nombre, car_descripcion);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(newCargo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Cargo getCargoByID(Long ID) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cargo.class, ID);
        } finally {
            em.close();
        }
    }

    public void updateCargo(cargos car_nombre, String car_descripcion) {
        Cargo updatedCargo = new Cargo(car_nombre, car_descripcion);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(updatedCargo);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleteCargoByID(Long ID) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Cargo selectedCargo = em.find(Cargo.class, ID); 
            if(selectedCargo!=null){
                em.remove(selectedCargo);
            }
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }
    }

}
