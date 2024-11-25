package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.EmpresaController;
import com.company.hangarbd.views.confirmacion.ConfirmaciónEmpresaController;
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

public class FormularioEmpresaController implements Initializable {

    Stage stage;
    Long ID;
    String Nombre;
    String Ubicacion;
    EmpresaController empresaController;
    boolean isUpdate = false;

    @FXML
    TextField ID_Empresa;
    @FXML
    TextField emp_nombre;
    @FXML
    TextField emp_ubicacion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.getLastID();
    }

    @FXML
    private void handleEnviarClicked() throws Exception {
        this.getAttributes();

        URL FXMLUrl = getClass().getResource("/fxml/ConfirmaciónEmpresa.fxml");
        FXMLLoader loader = new FXMLLoader(FXMLUrl);

        AnchorPane anchorPane = loader.load();

        ConfirmaciónEmpresaController empresaController = loader.getController();
        empresaController.getAttributes(ID, Nombre, Ubicacion);

        Scene scene = new Scene(anchorPane);
        Stage stageChild = new Stage();

        stageChild.setOnCloseRequest(event -> {
            this.stage.close();
        });

        if (isUpdate) {
            empresaController.setIsUpdate();
        }

        stageChild.setScene(scene);
        empresaController.getStage(stageChild);
        stageChild.showAndWait();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            empresaController = new EmpresaController(emf);
            this.ID = empresaController.getLastID_Empresa() + 1;
            this.ID_Empresa.setText(this.ID.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAttributes() {
        this.ID = Long.valueOf(this.ID_Empresa.getText());
        this.Nombre = this.emp_nombre.getText();
        this.Ubicacion = this.emp_ubicacion.getText();
    }

    public void setAttributes(List<String> Tupla) {
        this.ID_Empresa.setText(Tupla.get(0));
        this.emp_nombre.setText(Tupla.get(1));
        this.emp_ubicacion.setText(Tupla.get(2));
        this.isUpdate = true;
        this.ID = Long.valueOf(this.ID_Empresa.getText());
        this.isUpdate = true;
    }

}
