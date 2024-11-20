package com.company.hangarbd.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import org.datanucleus.enhancement.StateManager;

public abstract class Controller<T> {

    protected void createElement(T element, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(element);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Se ha subido a la Base de Datos", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    protected List<T> getAllFrom(String Entity, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            List<T> tuples = em.createQuery("SELECT p FROM " + Entity + " p").getResultList();
            return tuples;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected List<List<String>> mapEntitiesToString(List<T> Tuples, int AttributesNumber) {
        List<List<String>> Result = new ArrayList();
        for (T tuple : Tuples) {
            int index = 0;
            List<String> Attributes = new ArrayList();
            for (Field field : tuple.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    if (index >= AttributesNumber) {
                        break;
                    }
                    String attribute = String.valueOf(field.get(tuple));
                    Attributes.add(attribute);
                    index++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Result.add(Attributes);
        }
        return Result;
    }

    protected T getElementByID(Long ID, EntityManagerFactory emf, Class<T> type) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(type, ID);
        } finally {
            em.close();
        }
    }

    protected <T> List<T> getAllByColumn(String Column, EntityManagerFactory emf, String Entity) {
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("SELECT p." + Column + " FROM" + "Entity" + " p");
            List<T> Lista = em.createQuery("SELECT p." + Column + " FROM " + Entity + " p").getResultList();
            return Lista;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
            if (lastID > 0 && lastID != null) {
                return lastID;
            } else {
                return 0l;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return 0l;
    }

    protected <I> Long getIdByColumnValue(EntityManagerFactory emf, String Column, I Value, String Entity) {
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("SELECT p.ID_" + Entity + " FROM " + Entity + " p WHERE " + Column + "=" + "'" + Value + "'");
            Long ID = em.createQuery("SELECT p.ID_" + Entity + " FROM " + Entity + " p WHERE " + Column + "=" + "'" + Value + "'", Long.class).getSingleResult();
            return ID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
