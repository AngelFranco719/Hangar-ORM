package com.company.hangarbd.views.confirmacion;

import com.company.hangarbd.controller.HangarController;
import com.company.hangarbd.controller.TallerController;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConfirmaciónTallerController implements Initializable {

    Stage stage;

    Long ID;
    String Nombre;
    String Descripcion;
    String Hangar;
    TallerController tallerController;
    HangarController hangarController;

    boolean isUpdate = false;

    @FXML
    TextField ID_Taller;
    @FXML
    TextField tall_nombre;
    @FXML
    TextArea tall_descripcion;
    @FXML
    TableView<List<String>> Table_Hangar;
    @FXML
    TextField tall_hangar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void getAttributes(Long ID, String Nombre, String Descripcion, String Hangar) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Hangar = Hangar;
        this.initializeForm();
    }

    public void initializeForm() {
        this.ID_Taller.setText(this.ID.toString());
        this.tall_nombre.setText(this.Nombre);
        this.tall_descripcion.setText(this.Descripcion);
        this.tall_hangar.setText(Hangar);
    }

    public void setIsUpdate() {
        this.isUpdate = true;
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
        EntityManagerFactory emf = null;
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Enviar a la Base de Datos:");
        alerta.setHeaderText("¿Desea Guardar en la Base de Datos?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            try {
                emf = Persistence.createEntityManagerFactory("hangar");
                tallerController = new TallerController(emf);
                hangarController = new HangarController(emf);

                Long ID_Hangar = hangarController.getIdByColumn("han_nombre", Hangar);

                if (!isUpdate) {
                    tallerController.createTaller(Nombre, Descripcion, ID_Hangar);
                } else {
                    tallerController.updateTaller(ID, Nombre, Descripcion, ID_Hangar);
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
}
