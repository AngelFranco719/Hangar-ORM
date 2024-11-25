package com.company.hangarbd.views.confirmacion;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.models.Cargo;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConfirmaciónCargoController implements Initializable {

    Stage stage;
    Long ID;
    Cargo.cargos nombre;
    String Descripcion;
    CargoController cargoController;
    boolean isUpdate = false;

    @FXML
    TextField ID_Cargo;
    @FXML
    TextField car_nombre;
    @FXML
    TextArea car_descripcion;
    @FXML
    Button B_Cancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void handleCancelClicked() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Cancelar");
        alerta.setHeaderText("¿Seguro que desea cancelar la acción?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            this.stage.close();
        }
    }

    @FXML
    public void handleAceptarClicked() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Enviar a la Base de Datos:");
        alerta.setHeaderText("¿Desea Guardar en la Base de Datos?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            EntityManagerFactory emf = null;
            try {
                emf = Persistence.createEntityManagerFactory("hangar");
                cargoController = new CargoController(emf);
                if (!isUpdate) {
                    cargoController.createCargo(this.nombre, this.Descripcion);
                } else {
                    cargoController.updateCargo(ID, nombre, Descripcion);
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

    public void getAttributes(Long ID, Cargo.cargos nombre, String Descripcion) {
        this.ID = ID;
        this.nombre = nombre;
        this.Descripcion = Descripcion;

        this.ID_Cargo.setText(ID.toString());
        this.car_nombre.setText(nombre.toString());
        this.car_descripcion.setText(Descripcion);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setIsUpdate() {
        this.isUpdate = true;
    }

}
