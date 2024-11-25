package com.company.hangarbd.views.confirmacion;

import com.company.hangarbd.controller.EmpresaController;
import com.company.hangarbd.controller.HangarController;
import com.company.hangarbd.controller.ModeloController;
import com.company.hangarbd.controller.NaveController;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConfirmaciónNaveController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void getAttributes(Long ID, String Codigo, int Capacidad, float Peso, String Estado, String Descripcion, String Empresa, String Modelo, String Hangar) {
        this.ID = ID;
        this.Codigo = Codigo;
        this.Capacidad = Capacidad;
        this.Peso = Peso;
        this.Estado = Estado;
        this.Descripcion = Descripcion;
        this.Empresa = Empresa;
        this.Modelo = Modelo;
        this.Hangar = Hangar;
        this.initializeForms();
    }

    public void initializeForms() {
        this.ID_Nave.setText(ID.toString());
        this.nav_codigo.setText(this.Codigo);
        this.nav_capacidad.setText(String.valueOf(this.Capacidad));
        this.nav_estado.setText(Estado);
        this.nav_descripcion.setText(Descripcion);
        this.nav_empresa.setText(Empresa);
        this.nav_modelo.setText(Modelo);
        this.nav_peso.setText(String.valueOf(Peso));
        this.nav_hangar.setText(Hangar);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void handleCancelarClicked() {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Cancelar");
        alerta.setHeaderText("¿Seguro que desea cancelar la acción?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            this.stage.close();
        }
    }

    @FXML
    public void handleEnviarClicked() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Enviar a la Base de Datos:");
        alerta.setHeaderText("¿Desea Guardar en la Base de Datos?");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            EntityManagerFactory emf = null;
            try {
                emf = Persistence.createEntityManagerFactory("hangar");
                empresaController = new EmpresaController(emf);
                naveController = new NaveController(emf);
                modeloController = new ModeloController(emf);
                hangarController = new HangarController(emf);
                Long ID_Empresa = empresaController.getIdByColumn("emp_nombre", this.Empresa);
                Long ID_Modelo = modeloController.getIdByColumn("mod_nombre", this.Modelo);
                Long ID_Hangar = hangarController.getIdByColumn("han_nombre", this.Hangar);
                if (!isUpdate) {
                    naveController.createNave(Codigo, Peso, Estado, Descripcion, Capacidad, ID_Empresa, ID_Hangar, ID_Modelo);
                } else {
                    naveController.updateNave(ID, Codigo, 0, Estado, Descripcion, Capacidad, ID_Empresa, ID_Hangar, ID_Modelo);
                }
            } catch (Exception e) {
                Alert alerta_error = new Alert(Alert.AlertType.ERROR);
                alerta_error.setTitle("Error");
                alerta_error.setHeaderText("Error en la Persistencia.");
                alerta_error.showAndWait();
            }
            this.stage.close();
        }
    }

    public void setIsUpdate() {
        this.isUpdate = true;
    }

}
