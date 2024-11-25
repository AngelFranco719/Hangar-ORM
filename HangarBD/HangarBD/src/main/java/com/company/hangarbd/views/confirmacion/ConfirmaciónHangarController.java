package com.company.hangarbd.views.confirmacion;

import com.company.hangarbd.controller.HangarController;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConfirmaciónHangarController implements Initializable {

    Stage stage;

    @FXML
    TextField ID_Hangar;
    @FXML
    TextField han_capacidad;
    @FXML
    TextField han_codigo;
    @FXML
    TextField han_nombre;
    @FXML
    TextField han_ubicacion;
    @FXML
    TextArea han_descripcion;

    Long ID;
    int capacidad;
    String nombre;
    String ubicacion;
    String descripcion;
    String codigo;
    HangarController hangarController;
    boolean isUpdate = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void getAttributes(Long ID, int capacidad, String nombre, String ubicacion, String descripcion, String codigo) {
        this.ID = ID;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.rellenarFormulario();
    }

    public void rellenarFormulario() {
        this.ID_Hangar.setText(String.valueOf(ID));
        this.han_capacidad.setText(String.valueOf(capacidad));
        this.han_ubicacion.setText(ubicacion);
        this.han_nombre.setText(nombre);
        this.han_descripcion.setText(descripcion);
        this.han_codigo.setText(codigo);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleCancelarClicked() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Cancelar");
        alerta.setHeaderText("¿Seguro que desea cancelar la acción?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            this.stage.close();
        }
    }

    @FXML
    public void handleEnviarClicked() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Enviar a la Base de Datos:");
        alerta.setHeaderText("¿Desea Guardar en la Base de Datos?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            EntityManagerFactory emf = null;
            try {
                emf = Persistence.createEntityManagerFactory("hangar");
                hangarController = new HangarController(emf);
                if (!isUpdate) {
                    hangarController.createHangar(capacidad, nombre, ubicacion, descripcion, codigo);
                } else {
                    hangarController.updateHangar(ID, capacidad, nombre, ubicacion, descripcion, codigo);
                }
            } catch (Exception e) {
                Alert alerta_error = new Alert(Alert.AlertType.ERROR);
                alerta_error.setTitle("Error");
                alerta_error.setHeaderText("Error en la Persistencia.");
                alerta_error.showAndWait();
            }
            this.stage.close();
        }

    }

    public void setIsUpdate() {
        this.isUpdate = true;
    }
}
