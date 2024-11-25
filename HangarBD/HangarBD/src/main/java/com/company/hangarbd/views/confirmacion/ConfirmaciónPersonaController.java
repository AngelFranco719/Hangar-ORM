package com.company.hangarbd.views.confirmacion;

import com.company.hangarbd.controller.PersonaController;
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

public class ConfirmaciónPersonaController implements Initializable {

    Stage stage;

    Long ID;
    String Nombre;
    String Licencia;
    int Horas;
    PersonaController personaController;
    boolean isUpdate = false;

    @FXML
    TextField ID_Persona;
    @FXML
    TextField per_nombre;
    @FXML
    TextField per_licencia;
    @FXML
    TextField per_horasTotal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void getAttributes(Long ID, String Nombre, String Licencia, int Horas) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Licencia = Licencia;
        this.Horas = Horas;
        this.initializeForm();
    }

    public void initializeForm() {
        this.ID_Persona.setText(ID.toString());
        this.per_nombre.setText(Nombre);
        this.per_licencia.setText(Licencia);
        this.per_horasTotal.setText(String.valueOf(Horas));
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
        EntityManagerFactory emf = null;
        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            try {
                emf = Persistence.createEntityManagerFactory("hangar");
                personaController = new PersonaController(emf);
                if (!isUpdate) {
                    personaController.createPersona(Nombre, Licencia, Horas);
                } else {
                    personaController.updatePersona(ID, Nombre, Licencia, Horas);
                }
            } catch (Exception e) {
                Alert alerta_error = new Alert(Alert.AlertType.ERROR);
                alerta_error.setTitle("Error");
                alerta_error.setHeaderText("Error en la Persistencia.");
                alerta_error.showAndWait();
            }
        }
        this.stage.close();
    }

    public void setIsUpdate() {
        this.isUpdate = true;
    }

}
