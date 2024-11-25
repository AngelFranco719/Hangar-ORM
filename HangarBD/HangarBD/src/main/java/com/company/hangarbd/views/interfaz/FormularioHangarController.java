package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.HangarController;
import com.company.hangarbd.views.confirmacion.ConfirmaciónHangarController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FormularioHangarController implements Initializable {

    Stage stage;

    Long ID;
    int capacidad;
    String nombre;
    String ubicacion;
    String codigo;
    String descripcion;
    HangarController hangarController;
    boolean isUpdate = false;

    @FXML
    TextField ID_Hangar;
    @FXML
    TextField han_capacidad;
    @FXML
    TextField han_codigo;
    @FXML
    TextField han_nombre;
    @FXML
    TextField han_ubicacion;
    @FXML
    TextArea han_descripcion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.getLastID();
    }

    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            hangarController = new HangarController(emf);
            ID = hangarController.getLastID_Hangar() + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ID_Hangar.setText(String.valueOf(ID));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void getAttributes() {
        capacidad = Integer.parseInt(this.han_capacidad.getText());
        nombre = han_nombre.getText();
        ubicacion = han_ubicacion.getText();
        codigo = han_codigo.getText();
        descripcion = han_descripcion.getText();
    }

    public void handleEnviarClicked() throws Exception {
        this.getAttributes();

        URL FXMLUrl = getClass().getResource("/fxml/ConfirmaciónHangar.fxml");
        FXMLLoader loader = new FXMLLoader(FXMLUrl);

        AnchorPane anchorPane = loader.load();
        ConfirmaciónHangarController confirmacionController = loader.getController();
        confirmacionController.getAttributes(ID, capacidad, nombre, ubicacion, descripcion, codigo);

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
        this.ID_Hangar.setText(Tupla.get(0));
        this.han_capacidad.setText(Tupla.get(1));
        this.han_nombre.setText(Tupla.get(2));
        this.han_ubicacion.setText(Tupla.get(3));
        this.han_codigo.setText(Tupla.get(5));
        this.han_descripcion.setText(Tupla.get(4));
        this.ID = Long.valueOf(this.ID_Hangar.getText());
        this.isUpdate = true;
    }

}
