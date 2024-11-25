package com.mycompany.hangarbd;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HangarBD extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlURL = getClass().getResource("/fxml/FormularioPrueba.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlURL);
        System.out.println(fxmlURL.toString());
        if (loader.getLocation() == null) {
            System.out.println("No se encontró el archivo FXML.");
            return;
        }

        AnchorPane root = loader.load();

        Scene scene = new Scene(root, 1080, 720);
        stage.setTitle("CRUD de Hangar");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
