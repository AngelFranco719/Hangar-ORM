package com.company.hangarbd.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import org.datanucleus.enhancement.StateManager;

/// Clase Padre que es heredada por todos los Controladores
/// Ayuda a no repetir código y compartir métodos entre las clases.
public class Controller<T> {

    /// Método para lograr la persistencia de Datos.
    /// Recibe un Objeto T y lo hace persistente en la Base de Datos.
    protected void createElement(T element, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(element);
            tx.commit();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Exito");
            alerta.setHeaderText("Se guardó el registro con exito.");
            alerta.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /// Método que selecciona todos los registros de una Tabla.
    /// Obtiene un String que guarda el nombre de la Entidad
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

    /// Método auxiliar que convierte una lista de tuplas de tipo T
    /// a una Lista de Tuplas de tipo String.
    public List<List<String>> mapEntitiesToString(String Entity, EntityManagerFactory emf, int AttributesNumber) {
        List<T> Tuples = this.getAllFrom(Entity, emf);
        List<List<String>> Result = new ArrayList();
        for (T tuple : Tuples) {
            int index = 1;
            List<String> Attributes = new ArrayList();
            for (Field field : tuple.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    if (index > AttributesNumber) {
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

    /// Método que obtiene las columnas de una tabla.
    /// Se usa para graficar la Tabla de Datos.
    protected List<String> getColumns(EntityManagerFactory enf, Class<T> type, int AttributesNumber) {
        List<String> Columns = new ArrayList();
        int index = 1;
        for (Field field : type.getDeclaredFields()) {
            if (index > AttributesNumber) {
                break;
            }
            try {
                Columns.add(field.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            index++;
        }
        return Columns;
    }

    /// Método que sirve para encontrar un registro según su ID.
    protected T getElementByID(Long ID, EntityManagerFactory emf, Class<T> type) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(type, ID);
        } finally {
            em.close();
        }
    }

    ///Obtiene todos los valores de una Tabla según cierta columna.
    /// Recibe un String de la Columna a buscar y un String con el
    /// nombre de la entidad.
    protected <T> List<T> getAllByColumn(String Column, EntityManagerFactory emf, String Entity) {
        EntityManager em = emf.createEntityManager();
        try {
            System.out.println("SELECT p." + Column + " FROM" + Entity + " p");
            List<T> Lista = em.createQuery("SELECT p." + Column + " FROM " + Entity + " p").getResultList();
            return Lista;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /// Método que actualiza un registro en la Base de Datos.
    /// Obtiene un Objeto tipo T que DEBE compartir el ID 
    /// del registro que se desea actualizar.
    protected void updateElement(T updatedElement, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        System.out.println(updatedElement.toString());
        try {
            tx.begin();
            em.merge(updatedElement);
            tx.commit();
            JOptionPane.showMessageDialog(null, "Actualización Exitosa", "Se Actualizó el Campo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /// Elimina un registro por su ID.
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

    ///Elimina un elemento obteniendo toda su información.
    public void deleteElementByTuple(List<String> Tuple, EntityManagerFactory emf, String Entity) {
        EntityManager em = emf.createEntityManager();
        try {
            String query = "DELETE FROM " + Entity + " p WHERE p.ID_" + Entity + " = :id";
            em.createQuery(query).setParameter("id", Long.valueOf(Tuple.getFirst())).executeUpdate();
            JOptionPane.showMessageDialog(null, "Se Borró el Registro", "Borrado con Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /// Método que obtiene el último ID registrado en una tabla.
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

    /// Método que obtiene el ID de un registro según un criterio
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

    public void initializeTable(String Entity, EntityManagerFactory emf, TableView<List<String>> table, Class type, int AttributesNum) {
        try {
            table.getColumns().clear();
            List<String> Columnas = this.getColumns(emf, type, AttributesNum);
            List<List<String>> data = this.mapEntitiesToString(Entity, emf, AttributesNum);
            System.out.println(data.toString());

            int index = 0;
            for (String Columna : Columnas) {
                TableColumn<List<String>, String> columna = new TableColumn<>(Columna);
                int i = index;
                columna.setCellValueFactory(cellData -> {
                    List<String> row = cellData.getValue();
                    return new SimpleStringProperty(row.get(i));
                });
                table.getColumns().add(columna);
                index++;
            }

            ObservableList<List<String>> dataCollection = FXCollections.observableList(data);
            table.setItems(dataCollection);
            table.refresh();
        } catch (Exception e) {

        }

    }

}
