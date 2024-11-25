package com.company.hangarbd.views.interfaz;

import com.company.hangarbd.models.Cargo;
import com.company.hangarbd.models.Empresa;
import com.company.hangarbd.models.Hangar;
import com.company.hangarbd.models.Modelo;
import com.company.hangarbd.models.Nave;
import com.company.hangarbd.models.Persona;
import com.company.hangarbd.models.Piloto;
import com.company.hangarbd.models.Servicio;
import com.company.hangarbd.models.Taller;
import com.company.hangarbd.models.Tripulante;
import com.company.hangarbd.models.Vuelo;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FormularioPruebaController implements Initializable {

    TableController tableController1 = null;
    TableController tableController2 = null;

    @FXML
    private ChoiceBox<String> Cb_Entidades;
    @FXML
    private TableView<List<String>> Table_Data;
    @FXML
    private TableView<List<String>> Table_Data1;
    @FXML
    private TableView<List<String>> Table_Data2;
    @FXML
    private TextField TF_Selected;
    @FXML
    private TextField TF_Selected1;
    @FXML
    private Button B_Insertar;
    @FXML
    private ChoiceBox<String> Cb_Entidades1;
    @FXML
    private ChoiceBox<String> Cb_Entidades2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.initializeChoiceBox();
    }

    public void initializeChoiceBox() {
        Cb_Entidades.setItems(FXCollections.observableArrayList(
                "Cargo", "Empresa", "Hangar",
                "Modelo", "Nave", "Persona",
                "Piloto", "Servicio", "Taller",
                "Tripulante", "Vuelo"
        ));
        Cb_Entidades.getSelectionModel().selectFirst();
        Cb_Entidades1.setItems(FXCollections.observableArrayList(
                "Cargo", "Empresa", "Hangar",
                "Modelo", "Nave", "Persona",
                "Piloto", "Servicio", "Taller",
                "Tripulante", "Vuelo"
        ));
        Cb_Entidades1.getSelectionModel().selectFirst();
        Cb_Entidades2.setItems(FXCollections.observableArrayList(
                "Cargo", "Empresa", "Hangar",
                "Modelo", "Nave", "Persona",
                "Piloto", "Servicio", "Taller",
                "Tripulante", "Vuelo"
        ));
        Cb_Entidades2.getSelectionModel().selectFirst();
    }

    public void setStageToChild(String Entidad, FXMLLoader load, Stage stage) {
        switch (Entidad) {
            case "Cargo":
                FormularioCargoController cargoController = load.getController();
                cargoController.setStage(stage);
                break;
            case "Empresa":
                FormularioEmpresaController empresaController = load.getController();
                empresaController.setStage(stage);
                break;
            case "Hangar":
                FormularioHangarController hangarController = load.getController();
                hangarController.setStage(stage);
                break;
            case "Modelo":
                FormularioModeloController modeloController = load.getController();
                modeloController.setStage(stage);
                break;
            case "Nave":
                FormularioNaveController naveController = load.getController();
                naveController.setStage(stage);
                break;
            case "Persona":
                FormularioPersonaController personaController = load.getController();
                personaController.setStage(stage);
                break;
            case "Piloto":
                FormularioPilotoController pilotoController = load.getController();
                pilotoController.setStage(stage);
                break;
            case "Servicio":
                FormularioServicioController servicioController = load.getController();
                servicioController.setStage(stage);
                break;
            case "Taller":
                FormularioTallerController tallerController = load.getController();
                tallerController.setStage(stage);
                break;
            case "Tripulante":
                FormularioTripulanteController tripulanteController = load.getController();
                tripulanteController.setStage(stage);
                break;
            case "Vuelo":

                break;
        }
    }

    public void setStageToChild(String Entidad, FXMLLoader load, Stage stage, List<String> SelectedRow) {
        switch (Entidad) {
            case "Cargo":
                FormularioCargoController cargoController = load.getController();
                cargoController.setStage(stage);
                cargoController.setAttributes(SelectedRow);
                break;
            case "Empresa":
                FormularioEmpresaController empresaController = load.getController();
                empresaController.setStage(stage);
                empresaController.setAttributes(SelectedRow);
                break;
            case "Hangar":
                FormularioHangarController hangarController = load.getController();
                hangarController.setStage(stage);
                hangarController.setAttributes(SelectedRow);
                break;
            case "Modelo":
                FormularioModeloController modeloController = load.getController();
                modeloController.setStage(stage);
                modeloController.setAttributes(SelectedRow);
                break;
            case "Nave":
                FormularioNaveController naveController = load.getController();
                naveController.setStage(stage);
                naveController.setAttributes(SelectedRow);
                break;
            case "Persona":
                FormularioPersonaController personaController = load.getController();
                personaController.setStage(stage);
                personaController.setAttributes(SelectedRow);
                break;
            case "Piloto":
                FormularioPilotoController pilotoController = load.getController();
                pilotoController.setStage(stage);
                pilotoController.setAttributes(SelectedRow);
                break;
            case "Servicio":
                FormularioServicioController servicioController = load.getController();
                servicioController.setStage(stage);
                servicioController.setAttributes(SelectedRow);
                break;
            case "Taller":
                FormularioTallerController tallerController = load.getController();
                tallerController.setStage(stage);
                tallerController.setAttributes(SelectedRow);
                break;
            case "Tripulante":
                FormularioTripulanteController tripulanteController = load.getController();
                tripulanteController.setStage(stage);
                tripulanteController.setAttributes(SelectedRow);
                break;
            case "Vuelo":

                break;
        }
    }

    @FXML
    private void handleOnChangeEntidades() {
        String entidadSeleccionada = Cb_Entidades.getSelectionModel().getSelectedItem();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hangar");
        TableController tableController = null;
        switch (entidadSeleccionada) {
            case "Cargo":
                tableController = new TableController(emf, Table_Data, Cargo.class, entidadSeleccionada, 3);
                break;
            case "Empresa":
                tableController = new TableController(emf, Table_Data, Empresa.class, entidadSeleccionada, 4);
                break;
            case "Hangar":
                tableController = new TableController(emf, Table_Data, Hangar.class, entidadSeleccionada, 7);
                break;
            case "Modelo":
                tableController = new TableController(emf, Table_Data, Modelo.class, entidadSeleccionada, 6);
                break;
            case "Nave":
                tableController = new TableController(emf, Table_Data, Nave.class, entidadSeleccionada, 9);
                break;
            case "Persona":
                tableController = new TableController(emf, Table_Data, Persona.class, entidadSeleccionada, 4);
                break;
            case "Piloto":
                tableController = new TableController(emf, Table_Data, Piloto.class, entidadSeleccionada, 4);
                break;
            case "Servicio":
                tableController = new TableController(emf, Table_Data, Servicio.class, entidadSeleccionada, 6);
                break;
            case "Taller":
                tableController = new TableController(emf, Table_Data, Taller.class, entidadSeleccionada, 4);
                break;
            case "Tripulante":
                tableController = new TableController(emf, Table_Data, Tripulante.class, entidadSeleccionada, 4);
                break;
            case "Vuelo":
                tableController = new TableController(emf, Table_Data, Vuelo.class, entidadSeleccionada, 11);
                break;
        }
        tableController.initializeTable();
    }

    @FXML
    private void handleOnChangeEntidades1() {
        String entidadSeleccionada = Cb_Entidades1.getSelectionModel().getSelectedItem();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hangar");
        switch (entidadSeleccionada) {
            case "Cargo":
                tableController1 = new TableController(emf, Table_Data1, Cargo.class, entidadSeleccionada, 3, TF_Selected, 0);
                break;
            case "Empresa":
                tableController1 = new TableController(emf, Table_Data1, Empresa.class, entidadSeleccionada, 4, TF_Selected, 0);
                break;
            case "Hangar":
                tableController1 = new TableController(emf, Table_Data1, Hangar.class, entidadSeleccionada, 7, TF_Selected, 0);
                break;
            case "Modelo":
                tableController1 = new TableController(emf, Table_Data1, Modelo.class, entidadSeleccionada, 6, TF_Selected, 0);
                break;
            case "Nave":
                tableController1 = new TableController(emf, Table_Data1, Nave.class, entidadSeleccionada, 9, TF_Selected, 0);
                break;
            case "Persona":
                tableController1 = new TableController(emf, Table_Data1, Persona.class, entidadSeleccionada, 4, TF_Selected, 0);
                break;
            case "Piloto":
                tableController1 = new TableController(emf, Table_Data1, Piloto.class, entidadSeleccionada, 4, TF_Selected, 0);
                break;
            case "Servicio":
                tableController1 = new TableController(emf, Table_Data1, Servicio.class, entidadSeleccionada, 6, TF_Selected, 0);
                break;
            case "Taller":
                tableController1 = new TableController(emf, Table_Data1, Taller.class, entidadSeleccionada, 4, TF_Selected, 0);
                break;
            case "Tripulante":
                tableController1 = new TableController(emf, Table_Data1, Tripulante.class, entidadSeleccionada, 4, TF_Selected, 0);
                break;
            case "Vuelo":
                tableController1 = new TableController(emf, Table_Data1, Vuelo.class, entidadSeleccionada, 11, TF_Selected, 0);
                break;
        }
        tableController1.initializeTable();
    }

    @FXML
    private void handleOnChangeEntidades2() {
        String entidadSeleccionada = Cb_Entidades2.getSelectionModel().getSelectedItem();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hangar");
        switch (entidadSeleccionada) {
            case "Cargo":
                tableController2 = new TableController(emf, Table_Data2, Cargo.class, entidadSeleccionada, 3, TF_Selected1, 0);
                break;
            case "Empresa":
                tableController2 = new TableController(emf, Table_Data2, Empresa.class, entidadSeleccionada, 4, TF_Selected1, 0);
                break;
            case "Hangar":
                tableController2 = new TableController(emf, Table_Data2, Hangar.class, entidadSeleccionada, 7, TF_Selected1, 0);
                break;
            case "Modelo":
                tableController2 = new TableController(emf, Table_Data2, Modelo.class, entidadSeleccionada, 6, TF_Selected1, 0);
                break;
            case "Nave":
                tableController2 = new TableController(emf, Table_Data2, Nave.class, entidadSeleccionada, 9, TF_Selected1, 0);
                break;
            case "Persona":
                tableController2 = new TableController(emf, Table_Data2, Persona.class, entidadSeleccionada, 4, TF_Selected1, 0);
                break;
            case "Piloto":
                tableController2 = new TableController(emf, Table_Data2, Piloto.class, entidadSeleccionada, 4, TF_Selected1, 0);
                break;
            case "Servicio":
                tableController2 = new TableController(emf, Table_Data2, Servicio.class, entidadSeleccionada, 6, TF_Selected1, 0);
                break;
            case "Taller":
                tableController2 = new TableController(emf, Table_Data2, Taller.class, entidadSeleccionada, 4, TF_Selected1, 0);
                break;
            case "Tripulante":
                tableController2 = new TableController(emf, Table_Data2, Tripulante.class, entidadSeleccionada, 4, TF_Selected1, 0);
                break;
            case "Vuelo":
                tableController2 = new TableController(emf, Table_Data2, Vuelo.class, entidadSeleccionada, 11, TF_Selected1, 0);
                break;
        }
        tableController2.initializeTable();
    }

    @FXML
    public void handleDeleteClicked() {
        String SelectedEntity = Cb_Entidades1.getSelectionModel().getSelectedItem();
        List<String> SelectedRow = tableController1.getSelectedRow();
        DeleteController deleteController = new DeleteController(SelectedRow, SelectedEntity);
        try {
            deleteController.DeleteElement();
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("No se pudo borrar el registro.");
            alerta.setTitle("Error");
            alerta.showAndWait();
        }
        this.handleOnChangeEntidades1();
    }

    @FXML
    public void handleInsertClicked() throws Exception {
        String entidadSeleccionada = Cb_Entidades.getSelectionModel().getSelectedItem();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hangar");
        URL FXMLURL = getClass().getResource("/fxml/Formulario" + entidadSeleccionada + ".fxml");
        FXMLLoader loader = new FXMLLoader(FXMLURL);
        if (loader == null) {
            System.out.println("No se encontró el archivo FXML.");
            return;
        }
        AnchorPane anchorPane = loader.load();

        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();

        stage.setOnCloseRequest(event -> {
            this.handleOnChangeEntidades();
        });

        this.setStageToChild(entidadSeleccionada, loader, stage);

        stage.setScene(scene);
        stage.setTitle("Formulario de " + entidadSeleccionada);
        stage.showAndWait();
    }

    @FXML
    private void handleActualizarClicked() throws Exception {
        String entidadSeleccionada = Cb_Entidades2.getSelectionModel().getSelectedItem();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hangar");
        URL FXMLURL = getClass().getResource("/fxml/Formulario" + entidadSeleccionada + ".fxml");
        FXMLLoader loader = new FXMLLoader(FXMLURL);
        if (loader == null) {
            System.out.println("No se encontró el archivo FXML.");
            return;
        }
        AnchorPane anchorPane = loader.load();

        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();

        stage.setOnCloseRequest(event -> {
            this.handleOnChangeEntidades2();
        });

        System.out.println("Actualizando");

        List<String> SelectedRow = this.tableController2.getSelectedRow();
        this.setStageToChild(entidadSeleccionada, loader, stage, SelectedRow);

        stage.setScene(scene);
        stage.setTitle("Formulario de " + entidadSeleccionada);
        stage.showAndWait();
    }

}
