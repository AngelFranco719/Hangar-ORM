package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.NaveController;
import com.company.hangarbd.controller.ServicioController;
import com.company.hangarbd.controller.TallerController;
import com.company.hangarbd.models.Nave;
import com.company.hangarbd.models.Taller;
import com.company.hangarbd.views.confirmacion.ConfirmaciónServicioController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FormularioServicioController implements Initializable {

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
    @FXML
    TableView<List<String>> Table_Taller;
    @FXML
    TableView<List<String>> Table_Nave;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.getLastID();
        this.initializeTables();
    }

    public void getAttributes() {
        this.Diagnostico = this.ser_diagnostico.getText();
        this.Acciones = this.ser_acciones.getText();
        this.Responsable = this.ser_responsable.getText();
        this.Taller = this.ser_taller.getText();
        this.Nave = this.ser_nave.getText();
    }

    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            servicioController = new ServicioController(emf);
            ID = servicioController.getLastID_Servicio() + 1;
            this.ID_Servicio.setText(this.ID.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeTables() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hangar");
        TableController tallerTable = new TableController(emf, Table_Taller, Taller.class, "Taller", 4, this.ser_taller, 1);
        tallerTable.initializeTable();

        TableController naveController = new TableController(emf, Table_Nave, Nave.class, "Nave", 9, this.ser_nave, 1);
        naveController.initializeTable();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleEnviarClicked() throws Exception {
        this.getAttributes();
        URL FXMLUrl = getClass().getResource("/fxml/ConfirmaciónServicio.fxml");
        FXMLLoader loader = new FXMLLoader(FXMLUrl);

        AnchorPane anchorPane = loader.load();

        ConfirmaciónServicioController confirmacionController = loader.getController();
        confirmacionController.getAttributes(ID, Diagnostico, Acciones, Responsable, Taller, Nave);

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
        this.ID_Servicio.setText(Tupla.get(0));
        this.ser_diagnostico.setText(Tupla.get(1));
        this.ser_acciones.setText(Tupla.get(2));
        this.ser_responsable.setText(Tupla.get(3));
        this.ser_taller.setText(Tupla.get(4));
        this.ser_nave.setText(Tupla.get(5));
        this.ID = Long.valueOf(this.ID_Servicio.getText());
        this.isUpdate = true;
    }

}
