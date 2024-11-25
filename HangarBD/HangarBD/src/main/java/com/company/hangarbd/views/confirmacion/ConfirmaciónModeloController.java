package com.company.hangarbd.views.confirmacion;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.controller.ModeloController;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConfirmaciónModeloController implements Initializable {

    Stage stage;

    @FXML
    TextField ID_Modelo;
    @FXML
    TextField mod_nombre;
    @FXML
    TextField mod_fabricante;
    @FXML
    TextField mod_año;

    Long ID;
    String Nombre;
    String Fabricante;
    String Año;
    ModeloController modeloController;
    boolean isUpdate = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void getAttributes(Long ID, String Nombre, String Fabricante, String Año) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Fabricante = Fabricante;
        this.Año = Año;
        this.initializeForm();
    }

    public void initializeForm() {
        this.ID_Modelo.setText(ID.toString());
        this.mod_nombre.setText(Nombre);
        this.mod_fabricante.setText(Fabricante);
        this.mod_año.setText(Año);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void handleCancelarClicked() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Cancelar");
        alerta.setHeaderText("¿Seguro que desea cancelar la acción?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            this.stage.close();
        }
    }

    public void handleEnviarClicked() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Enviar a la Base de Datos:");
        alerta.setHeaderText("¿Desea Guardar en la Base de Datos?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            EntityManagerFactory emf = null;
            try {
                emf = Persistence.createEntityManagerFactory("hangar");
                modeloController = new ModeloController(emf);
                if (!isUpdate) {
                    modeloController.createModelo(Nombre, Fabricante, Año);
                } else {

                    modeloController.updateModelo(ID, Nombre, Fabricante, Año);
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
