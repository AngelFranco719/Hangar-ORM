package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.views.confirmacion.ConfirmaciónTallerController;
import com.company.hangarbd.controller.HangarController;
import com.company.hangarbd.controller.TallerController;
import com.company.hangarbd.models.Hangar;
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

public class FormularioTallerController implements Initializable {

    Stage stage;

    Long ID;
    String Nombre;
    String Descripcion;
    String HangarName;
    TallerController tallerController;
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
        this.getLastID();
        this.initializeTable();
    }

    public void initializeTable() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hangar");
        TableController hangarTable = new TableController(emf, Table_Hangar, Hangar.class, "Hangar", 6, this.tall_hangar, 2);
        hangarTable.initializeTable();
    }

    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            tallerController = new TallerController(emf);
            this.ID = tallerController.getLastID_Taller() + 1;
            this.ID_Taller.setText(this.ID.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAttributes() {
        this.Nombre = this.tall_nombre.getText();
        this.Descripcion = this.tall_descripcion.getText();
        this.HangarName = this.tall_hangar.getText();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleEnviarClicked() throws Exception {
        this.getAttributes();
        URL FXMLUrl = getClass().getResource("/fxml/ConfirmaciónTaller.fxml");
        FXMLLoader loader = new FXMLLoader(FXMLUrl);

        AnchorPane anchorPane = loader.load();

        ConfirmaciónTallerController confirmacionController = loader.getController();
        confirmacionController.getAttributes(ID, Nombre, Descripcion, HangarName);

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
        this.ID_Taller.setText(Tupla.get(0));
        this.tall_nombre.setText(Tupla.get(1));
        this.tall_descripcion.setText(Tupla.get(2));
        this.tall_hangar.setText(Tupla.get(3));
        this.ID = Long.valueOf(this.ID_Taller.getText());
        this.isUpdate = true;
    }

}
