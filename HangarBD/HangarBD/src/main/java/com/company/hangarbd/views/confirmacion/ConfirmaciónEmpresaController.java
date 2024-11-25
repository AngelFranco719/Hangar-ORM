package com.company.hangarbd.views.confirmacion;

import com.company.hangarbd.controller.EmpresaController;
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

public class ConfirmaciónEmpresaController implements Initializable {

    Stage stage;

    Long ID;
    String Nombre;
    String Ubicación;
    EmpresaController empresaController;
    boolean isUpdate = false;

    @FXML
    TextField ID_Empresa;
    @FXML
    TextField emp_nombre;
    @FXML
    TextField emp_ubicacion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void getStage(Stage stage) {
        this.stage = stage;
    }

    public void getAttributes(Long ID, String Nombre, String Ubicacion) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Ubicación = Ubicacion;
        this.initializeForms();
    }

    public void initializeForms() {
        this.ID_Empresa.setText(ID.toString());
        this.emp_nombre.setText(Nombre);
        this.emp_ubicacion.setText(Ubicación);
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
                empresaController = new EmpresaController(emf);
                if (!isUpdate) {
                    empresaController.createEmpresa(this.Nombre, this.Ubicación);
                } else {
                    empresaController.updateEmpresa(ID, this.Nombre, this.Ubicación);
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
