package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.models.Cargo;
import com.company.hangarbd.views.confirmacion.ConfirmaciónCargoController;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FormularioCargoController implements Initializable {

    Long ID;
    Cargo.cargos nombre;
    String Descripcion;
    CargoController cargoController;
    boolean isUpdate = false;
    Stage stage;

    @FXML
    TextField ID_Cargo;
    @FXML
    ComboBox car_nombre;
    @FXML
    TextArea car_descripcion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.getLastID();
        this.InitializeCombo();
    }

    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            cargoController = new CargoController(emf);
            ID = cargoController.getLastID_Cargo() + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ID_Cargo.setText(String.valueOf(ID));
    }

    public void InitializeCombo() {
        Collection<String> opciones = Arrays.asList("PILOTO", "COPILOTO", "INGENIERO", "AUXILIAR");
        this.car_nombre.getItems().addAll(opciones);
        this.car_nombre.getSelectionModel().select("PILOTO");
    }

    public void getAttributes() {
        this.nombre = (Cargo.cargos.valueOf(this.car_nombre.getSelectionModel().getSelectedItem().toString()));
        this.Descripcion = this.car_descripcion.getText();
    }

    @FXML
    public void PrevisualizationClicked() throws Exception {
        this.getAttributes();
        URL FXMLUrl = getClass().getResource("/fxml/ConfirmaciónCargo.fxml");
        FXMLLoader loader = new FXMLLoader(FXMLUrl);

        AnchorPane anchorPane = loader.load();

        ConfirmaciónCargoController confirmacionController = loader.getController();
        confirmacionController.getAttributes(ID, nombre, Descripcion);

        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();

        stage.setOnCloseRequest(event -> {
            this.stage.close();
        });

        stage.setScene(scene);
        stage.setTitle("Confirmación del Envío");
        stage.show();

        confirmacionController.setStage(stage);

        if (isUpdate) {
            confirmacionController.setIsUpdate();
        }

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setAttributes(List<String> Tupla) {
        this.ID_Cargo.setText(Tupla.get(0));
        this.ID = Long.valueOf(Tupla.get(0));
        this.isUpdate = true;
        switch (Tupla.get(1)) {
            case "PILOTO":
                this.car_nombre.getSelectionModel().select("PILOTO");
                break;
            case "COPILOTO":
                this.car_nombre.getSelectionModel().select("COPILOTO");
                break;
            case "INGENIERO":
                this.car_nombre.getSelectionModel().select("INGENIERO");
                break;
            case "AUXILIAR":
                this.car_nombre.getSelectionModel().select("AUXILIAR");
                break;
        }
        this.car_descripcion.setText(Tupla.get(2));
    }

}
