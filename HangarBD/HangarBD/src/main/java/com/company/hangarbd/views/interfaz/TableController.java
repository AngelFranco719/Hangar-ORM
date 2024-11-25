package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.Controller;
import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.persistence.EntityManagerFactory;

public class TableController<T> {

    private TableView<List<String>> Table_Data;
    private Class<T> type;
    private String Entity;
    private EntityManagerFactory emf;
    private int NumAttributes;
    public List<String> SelectedRow;
    private TextField textField;

    private boolean isDelete = false;

    public TableController() {

    }

    public TableController(EntityManagerFactory emf, TableView Table, Class<T> type, String Entity, int NumAttributes) {
        this.Table_Data = Table;
        this.type = type;
        this.Entity = Entity;
        this.emf = emf;
        this.NumAttributes = NumAttributes;
    }

    /// Para actualizar un TextField.
    public TableController(EntityManagerFactory emf, TableView Table, Class<T> type,
            String Entity, int NumAttributes, TextField textField, int index) {
        this.Table_Data = Table;
        this.type = type;
        this.Entity = Entity;
        this.emf = emf;
        this.NumAttributes = NumAttributes;
        this.textField = textField;
        this.initializeSelectionModelEvents(index);
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public List<String> getSelectedRow() {
        return this.SelectedRow;
    }

    public void initializeTable() {
        try {
            Controller<T> controlador = new Controller<>();
            controlador.initializeTable(Entity, emf, Table_Data, type, NumAttributes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeSelectionModelEvents(int index) {
        Table_Data.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            SelectedRow = newSelection;
            if (textField != null) {
                try {
                    textField.setText(SelectedRow.get(index));
                } catch (Exception e) {}
            }
        });
    }
}
