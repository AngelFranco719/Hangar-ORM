package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.ModeloController;
import com.company.hangarbd.controller.PersonaController;
import com.company.hangarbd.controller.PilotoController;
import com.company.hangarbd.models.Modelo;
import com.company.hangarbd.models.Persona;
import com.company.hangarbd.views.confirmacion.ConfirmaciónPilotoController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FormularioPilotoController implements Initializable {

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
    @FXML
    TableView<List<String>> Table_Modelo;
    @FXML
    TableView<List<String>> Table_Persona;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.getLastID();
        this.initializeTables();
    }

    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            pilotoController = new PilotoController(emf);
            this.ID = pilotoController.getLastID_Piloto() + 1;
            this.ID_Piloto.setText(ID.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeTables() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hangar");

        TableController modeloTable = new TableController(emf, Table_Modelo, Modelo.class, "Modelo", 4, this.pil_modelo, 1);
        modeloTable.initializeTable();

        TableController personaTable = new TableController(emf, Table_Persona, Persona.class, "Persona", 4, this.pil_persona, 1);
        personaTable.initializeTable();
    }

    public void getAttributes() {
        this.Horas = Integer.parseInt(this.pil_horasVuelo.getText());
        this.Persona = this.pil_persona.getText();
        this.Modelo = this.pil_modelo.getText();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void handleEnviarClicked() throws Exception {
        this.getAttributes();
        URL FXMLUrl = getClass().getResource("/fxml/ConfirmaciónPiloto.fxml");
        FXMLLoader loader = new FXMLLoader(FXMLUrl);

        AnchorPane anchorPane = loader.load();

        ConfirmaciónPilotoController confirmacionController = loader.getController();
        confirmacionController.getAttribute(ID, Horas, Persona, Modelo);

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
        this.ID_Piloto.setText(Tupla.get(0));
        this.pil_horasVuelo.setText(Tupla.get(1));
        this.pil_persona.setText(Tupla.get(2));
        this.pil_modelo.setText(Tupla.get(3));
        this.ID = Long.valueOf(this.ID_Piloto.getText());
        this.isUpdate = true;
    }

}
