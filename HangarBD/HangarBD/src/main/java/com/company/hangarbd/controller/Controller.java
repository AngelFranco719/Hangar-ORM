package com.company.hangarbd.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

public abstract class Controller<T> {

    protected void createElement(T element, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(element);
            tx.commit();
            JOptionPane.showMessageDialog(null,"Se ha subido a la Base de Datos", "Operación Exitosa",0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    protected T getElementByID(Long ID, EntityManagerFactory emf, Class<T> type) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(type, ID);
        } finally {
            em.close();
        }
    }

    protected void updateElement(T updatedElement, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(updatedElement);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    protected void deleteElementByID(Long ID, EntityManagerFactory emf, Class<T> type) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            T selectedElement = em.find(type, ID);
            if (selectedElement != null) {
                em.remove(selectedElement);
            }
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    protected Long getLastID(EntityManagerFactory emf, String Entity) {
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("SELECT MAX(e.ID_" + Entity + ") FROM " + Entity + " e");
            Long lastID = em.createQuery("SELECT MAX(e.ID_" + Entity + ") FROM " + Entity + " e", Long.class).getSingleResult();
            return lastID;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return 0l; 
    }

}
