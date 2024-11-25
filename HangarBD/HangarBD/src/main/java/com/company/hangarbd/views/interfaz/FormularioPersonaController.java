package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.controller.PersonaController;
import com.company.hangarbd.views.confirmacion.ConfirmaciónCargoController;
import com.company.hangarbd.views.confirmacion.ConfirmaciónPersonaController;
import java.io.IOException;
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

public class FormularioPersonaController implements Initializable {

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
        this.getLastID();
    }

    public void getAttributes() {
        this.Nombre = this.per_nombre.getText();
        this.Licencia = this.per_licencia.getText();
        this.Horas = Integer.parseInt(this.per_horasTotal.getText());
    }

    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            personaController = new PersonaController(emf);
            ID = personaController.getLastID_Persona() + 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.ID_Persona.setText(String.valueOf(ID));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void handleEnviarClicked() throws Exception {
        this.getAttributes();
        URL FXMLUrl = getClass().getResource("/fxml/ConfirmaciónPersona.fxml");
        FXMLLoader loader = new FXMLLoader(FXMLUrl);

        AnchorPane anchorPane = loader.load();

        ConfirmaciónPersonaController confirmacionController = loader.getController();
        confirmacionController.getAttributes(ID, Nombre, Licencia, Horas);

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
        this.ID_Persona.setText(Tupla.get(0));
        this.per_nombre.setText(Tupla.get(1));
        this.per_licencia.setText(Tupla.get(2));
        this.per_horasTotal.setText(Tupla.get(3));
        this.ID = Long.valueOf(this.ID_Persona.getText());
        this.isUpdate = true;
    }

}
