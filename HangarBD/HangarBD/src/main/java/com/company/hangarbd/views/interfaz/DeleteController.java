package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.Controller;
import com.company.hangarbd.models.Cargo;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteController {
    
    Controller controlador;
    List<String> SelectedRow;
    String Entity;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hangar");
    
    public DeleteController(List<String> SelectedRow, String Entity) {
        this.SelectedRow = SelectedRow;
        this.Entity = Entity;
    }
    
    public void DeleteElement() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setHeaderText("¿Desea eliminar el registro?");
        alerta.setContentText("Esta acción no se puede revertir");
        alerta.setTitle("Eliminar un Registro");
        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            controlador = new Controller();
            controlador.deleteElementByTuple(SelectedRow, emf, Entity);
        }
    }
    
}
