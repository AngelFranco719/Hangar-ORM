package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.CargoController;
import com.company.hangarbd.controller.PersonaController;
import com.company.hangarbd.controller.TripulanteController;
import com.company.hangarbd.controller.VueloController;
import com.company.hangarbd.models.Cargo;
import com.company.hangarbd.models.Persona;
import com.company.hangarbd.models.Vuelo;
import com.company.hangarbd.views.confirmacion.ConfirmaciónTripulanteController;
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

public class FormularioTripulanteController implements Initializable {

    Stage stage;

    Long ID;
    String Vuelo;
    Cargo.cargos Cargo;
    String Persona;
    boolean isUpdate = false;

    TripulanteController tripulanteController;

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
        this.getLastID();
        this.initializeTables();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initializeTables() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hangar");
        TableController vueloTable = new TableController(emf, Table_Vuelo, Vuelo.class, "Vuelo", 11, tri_vuelo, 1);
        vueloTable.initializeTable();

        TableController cargoTable = new TableController(emf, Table_Cargo, Cargo.class, "Cargo", 3, tri_cargo, 1);
        cargoTable.initializeTable();

        TableController personaTable = new TableController(emf, Table_Persona, Persona.class, "Persona", 4, tri_persona, 1);
        personaTable.initializeTable();
    }

    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            tripulanteController = new TripulanteController(emf);
            ID = tripulanteController.getLastID_Tripulante() + 1;
            this.ID_Tripulante.setText(ID.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAttributes() {
        this.ID = Long.valueOf(this.ID_Tripulante.getText());
        this.Vuelo = this.tri_vuelo.getText();
        switch (this.tri_cargo.getText()) {
            case "INGENIERO":
                this.Cargo = Cargo.INGENIERO;
                break;
            case "PILOTO":
                this.Cargo = Cargo.PILOTO;
                break;
            case "COPILOTO":
                this.Cargo = Cargo.COPILOTO;
                break;
            case "AUXILIAR":
                this.Cargo = Cargo.AUXILIAR;
                break;
        }
        this.Persona = this.tri_persona.getText();
    }

    @FXML
    public void handleEnviarClicked() throws Exception {
        this.getAttributes();
        URL FXMLUrl = getClass().getResource("/fxml/ConfirmaciónTripulante.fxml");
        FXMLLoader loader = new FXMLLoader(FXMLUrl);

        AnchorPane anchorPane = loader.load();

        ConfirmaciónTripulanteController confirmacionController = loader.getController();
        confirmacionController.getAttributes(ID, Vuelo, Cargo, Persona);

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
        this.ID_Tripulante.setText(Tupla.get(0));
        this.tri_vuelo.setText(Tupla.get(1));
        this.tri_cargo.setText(Tupla.get(2));
        this.tri_persona.setText(Tupla.get(3));
        this.ID = Long.valueOf(this.ID_Tripulante.getText());
        this.isUpdate = true;
    }

}
