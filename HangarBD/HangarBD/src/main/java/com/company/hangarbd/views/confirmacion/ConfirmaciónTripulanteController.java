package com.company.hangarbd.views.confirmacion;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.controller.PersonaController;
import com.company.hangarbd.controller.TripulanteController;
import com.company.hangarbd.controller.VueloController;
import com.company.hangarbd.models.Cargo;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConfirmaciónTripulanteController implements Initializable {

    Stage stage;

    Long ID;
    String Vuelo;
    Cargo.cargos Cargo;
    String Persona;
    boolean isUpdate = false;

    TripulanteController tripulanteController;
    VueloController vueloController;
    CargoController cargoController;
    PersonaController personaController;

    @FXML
    TextField ID_Tripulante;
    @FXML
    TableView<List<String>> Table_Vuelo;
    @FXML
    TextField tri_vuelo;
    @FXML
    TableView<List<String>> Table_Cargo;
    @FXML
    TextField tri_cargo;
    @FXML
    TableView<List<String>> Table_Persona;
    @FXML
    TextField tri_persona;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void getAttributes(Long ID, String Vuelo, Cargo.cargos Cargo, String Persona) {
        this.ID = ID;
        this.Vuelo = Vuelo;
        this.Cargo = Cargo;
        this.Persona = Persona;
        this.initializeForm();
    }

    public void initializeForm() {
        this.ID_Tripulante.setText(this.ID.toString());
        this.tri_vuelo.setText(this.Vuelo);
        this.tri_cargo.setText(this.Cargo.toString());
        this.tri_persona.setText(this.Persona);
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
                tripulanteController = new TripulanteController(emf);
                cargoController = new CargoController(emf);
                vueloController = new VueloController(emf);
                personaController = new PersonaController(emf);

                Long ID_Cargo = cargoController.getIdByColumn("car_nombre", this.Cargo);
                Long ID_Vuelo = vueloController.getIdByColumn("vue_codigo", this.Vuelo);
                Long ID_Persona = personaController.getIdByColumn("per_nombre", this.Persona);

                if (!isUpdate) {
                    tripulanteController.createTripulante(ID_Vuelo, ID_Cargo, ID_Persona);
                } else {
                    tripulanteController.updateTripulante(ID, ID_Vuelo, ID_Cargo, ID_Persona);
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
