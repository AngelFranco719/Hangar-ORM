package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.ModeloController;
import com.company.hangarbd.views.confirmacion.ConfirmaciónModeloController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FormularioModeloController implements Initializable {

    Long ID;
    String Nombre;
    String Fabricante;
    String Año;
    ModeloController modeloController;
    boolean isUpdate = false;

    Stage stage;

    @FXML
    TextField ID_Modelo;
    @FXML
    TextField mod_nombre;
    @FXML
    TextField mod_fabricante;
    @FXML
    TextField mod_año;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.getLastID();
    }

    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            modeloController = new ModeloController(emf);
            ID = modeloController.getLastID_Modelo() + 1;
            this.ID_Modelo.setText(ID.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAttributes() {
        this.Nombre = this.mod_nombre.getText();
        this.Fabricante = this.mod_fabricante.getText();
        this.Año = this.mod_año.getText();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleEnviarClicked() throws Exception {
        this.getAttributes();
        URL FXMLUrl = getClass().getResource("/fxml/ConfirmaciónModelo.fxml");
        FXMLLoader loader = new FXMLLoader(FXMLUrl);

        AnchorPane anchorPane = loader.load();

        ConfirmaciónModeloController confirmacionController = loader.getController();
        confirmacionController.getAttributes(ID, Nombre, Fabricante, Año);

        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();

        stage.setOnCloseRequest(event -> {
            this.stage.close();
        });

        if (isUpdate) {
            confirmacionController.setIsUpdate();
        }

        stage.setScene(scene);
        stage.setTitle("Confirmación del Envío");
        stage.show();

        confirmacionController.setStage(stage);
    }

    public void setAttributes(List<String> Tupla) {
        this.ID_Modelo.setText(Tupla.get(0));
        this.mod_nombre.setText(Tupla.get(1));
        this.mod_fabricante.setText(Tupla.get(2));
        this.mod_año.setText(Tupla.get(3));
        this.ID = Long.valueOf(this.ID_Modelo.getText());
        this.isUpdate = true;
    }

}
