package com.example.cv_builder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("CV Builder");
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene(String fxmlFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(loader.load(), 600, 400);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}
