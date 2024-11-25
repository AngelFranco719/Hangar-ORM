package com.company.hangarbd.views.confirmacion;

import com.company.hangarbd.controller.ModeloController;
import com.company.hangarbd.controller.PersonaController;
import com.company.hangarbd.controller.PilotoController;
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

public class ConfirmaciónPilotoController implements Initializable {

    Stage stage;

    Long ID;
    int Horas;
    String Persona;
    String Modelo;
    boolean isUpdate = false;

    PilotoController pilotoController;
    PersonaController personaController;
    ModeloController modeloController;

    @FXML
    TextField ID_Piloto;
    @FXML
    TextField pil_persona;
    @FXML
    TextField pil_modelo;
    @FXML
    TextField pil_horasVuelo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initializeForm() {
        this.ID_Piloto.setText(ID.toString());
        this.pil_horasVuelo.setText(String.valueOf(Horas));
        this.pil_persona.setText(Persona);
        this.pil_modelo.setText(Modelo);
    }

    public void getAttribute(Long ID, int Horas, String Persona, String Modelo) {
        this.ID = ID;
        this.Horas = Horas;
        this.Persona = Persona;
        this.Modelo = Modelo;
        this.initializeForm();
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
        EntityManagerFactory emf = null;
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Enviar a la Base de Datos:");
        alerta.setHeaderText("¿Desea Guardar en la Base de Datos?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            try {
                emf = Persistence.createEntityManagerFactory("hangar");
                pilotoController = new PilotoController(emf);
                personaController = new PersonaController(emf);
                modeloController = new ModeloController(emf);

                Long ID_Persona = personaController.getIdByColumn("per_nombre", Persona);
                Long ID_Modelo = modeloController.getIdByColumn("mod_nombre", Modelo);
                if (!isUpdate) {
                    pilotoController.createPiloto(Horas, ID_Persona, ID_Modelo);
                } else {
                    pilotoController.updatePiloto(ID, Horas, ID_Persona, ID_Modelo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.stage.close();
        }
    }

    public void setIsUpdate() {
        this.isUpdate = true;
    }

}
