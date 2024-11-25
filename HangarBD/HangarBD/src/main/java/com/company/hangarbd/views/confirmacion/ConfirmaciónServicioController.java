package com.company.hangarbd.views.confirmacion;

import com.company.hangarbd.controller.NaveController;
import com.company.hangarbd.controller.ServicioController;
import com.company.hangarbd.controller.TallerController;
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

public class ConfirmaciónServicioController implements Initializable {

    Stage stage;

    Long ID;
    String Diagnostico;
    String Acciones;
    String Responsable;
    String Taller;
    String Nave;
    boolean isUpdate = false;

    ServicioController servicioController;
    TallerController tallerController;
    NaveController naveController;

    @FXML
    TextField ID_Servicio;
    @FXML
    TextArea ser_diagnostico;
    @FXML
    TextArea ser_acciones;
    @FXML
    TextField ser_responsable;
    @FXML
    TextField ser_nave;
    @FXML
    TextField ser_taller;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initializeForm() {
        this.ID_Servicio.setText(ID.toString());
        this.ser_diagnostico.setText(Diagnostico);
        this.ser_acciones.setText(Acciones);
        this.ser_responsable.setText(Responsable);
        this.ser_taller.setText(Taller);
        this.ser_nave.setText(Nave);
    }

    public void getAttributes(Long ID, String Diagnostico, String Acciones, String Responsable, String Taller, String Nave) {
        this.ID = ID;
        this.Diagnostico = Diagnostico;
        this.Acciones = Acciones;
        this.Responsable = Responsable;
        this.Taller = Taller;
        this.Nave = Nave;
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
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Enviar a la Base de Datos:");
        alerta.setHeaderText("¿Desea Guardar en la Base de Datos?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            EntityManagerFactory emf = null;
            try {
                emf = Persistence.createEntityManagerFactory("hangar");
                servicioController = new ServicioController(emf);
                tallerController = new TallerController(emf);
                naveController = new NaveController(emf);
                Long ID_Taller = tallerController.getIdByColumn("tall_nombre", Taller);
                Long ID_Nave = naveController.getIdByColumn("nav_codigo", Nave);
                if (!isUpdate) {
                    servicioController.createServicio(Diagnostico, Acciones, Responsable, ID_Taller, ID_Nave);
                } else {
                    servicioController.updateServicio(ID, Diagnostico, Acciones, Responsable, ID_Taller, ID_Nave);
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
