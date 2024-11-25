package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.controller.EmpresaController;
import com.company.hangarbd.controller.HangarController;
import com.company.hangarbd.controller.ModeloController;
import com.company.hangarbd.controller.NaveController;
import com.company.hangarbd.models.Empresa;
import com.company.hangarbd.models.Hangar;
import com.company.hangarbd.models.Modelo;
import com.company.hangarbd.views.confirmacion.ConfirmaciónNaveController;
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

public class FormularioNaveController implements Initializable {

    Stage stage;

    Long ID;
    String Codigo;
    int Capacidad;
    float Peso;
    String Estado;
    String Descripcion;
    String Empresa;
    String Modelo;
    String Hangar;

    NaveController naveController;
    EmpresaController empresaController;
    ModeloController modeloController;
    HangarController hangarController;
    boolean isUpdate = false;

    @FXML
    TextField ID_Nave;
    @FXML
    TextField nav_hangar;
    @FXML
    TextField nav_empresa;
    @FXML
    TextField nav_modelo;
    @FXML
    TextField nav_codigo;
    @FXML
    TextField nav_capacidad;
    @FXML
    TextField nav_peso;
    @FXML
    TextField nav_estado;
    @FXML
    TextArea nav_descripcion;
    @FXML
    TableView<String> Table_Empresa;
    @FXML
    TableView<String> Table_Modelo;
    @FXML
    TableView<List<String>> Table_Hangar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.getLastID();
        this.initializeTables();
    }

    public void getLastID() {
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("hangar");
            naveController = new NaveController(emf);
            this.ID = naveController.getLastID_Nave() + 1;
            this.ID_Nave.setText(ID.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAttributes() {
        System.out.println(this.nav_empresa.getText());
        this.Codigo = this.nav_codigo.getText();
        this.Capacidad = Integer.parseInt(this.nav_capacidad.getText());
        this.Peso = Float.parseFloat(this.nav_peso.getText());
        this.Estado = this.nav_estado.getText();
        this.Descripcion = this.nav_descripcion.getText();
        this.Empresa = this.nav_empresa.getText();
        this.Modelo = this.nav_modelo.getText();
        this.Hangar = this.nav_hangar.getText();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initializeTables() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hangar");
        TableController tableEmpresaController = new TableController(emf, Table_Empresa, Empresa.class, "Empresa", 4, this.nav_empresa, 1);
        tableEmpresaController.initializeTable();

        TableController tableModeloController = new TableController(emf, Table_Modelo, Modelo.class, "Modelo", 6, this.nav_modelo, 1);
        tableModeloController.initializeTable();

        TableController tableHangarController = new TableController(emf, Table_Hangar, Hangar.class, "Hangar", 7, this.nav_hangar, 2);
        tableHangarController.initializeTable();
    }

    public void handleEnviarClicked() throws Exception {
        this.getAttributes();
        URL FXMLUrl = getClass().getResource("/fxml/ConfirmaciónNave.fxml");
        FXMLLoader loader = new FXMLLoader(FXMLUrl);

        AnchorPane anchorPane = loader.load();

        ConfirmaciónNaveController confirmacionController = loader.getController();
        confirmacionController.getAttributes(ID, Codigo, Capacidad, this.Peso, Estado, Descripcion, Empresa, Modelo, Hangar);

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
        this.ID_Nave.setText(Tupla.get(0));
        this.nav_codigo.setText(Tupla.get(1));
        this.nav_peso.setText(Tupla.get(2));
        this.nav_estado.setText(Tupla.get(3));
        this.nav_descripcion.setText(Tupla.get(4));
        this.nav_capacidad.setText(Tupla.get(5));
        this.nav_empresa.setText(Tupla.get(6));
        this.nav_hangar.setText(Tupla.get(7));
        this.nav_modelo.setText(Tupla.get(8));
        this.ID = Long.valueOf(this.ID_Nave.getText());

        this.isUpdate = true;
    }

}
