package com.example.cv_builder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;

public class HelloApplication extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double desktopWidth = screenBounds.getWidth();
        double desktopHeight = screenBounds.getHeight();

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(loader.load(), desktopWidth, desktopHeight);

        stage.setTitle("CV Builder");
        stage.setScene(scene);

        stage.setMaximized(true);


        stage.show();
    }

    public static void changeScene(String fxmlFile) throws Exception {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));

        double currentWidth = primaryStage.getScene().getWidth();
        double currentHeight = primaryStage.getScene().getHeight();

        Scene scene = new Scene(loader.load(), currentWidth, currentHeight);
        primaryStage.setScene(scene);
    }

    public static void changeScene(javafx.scene.Parent root) {
        double currentWidth = primaryStage.getScene().getWidth();
        double currentHeight = primaryStage.getScene().getHeight();
        
        Scene scene = new Scene(root, currentWidth, currentHeight);
        primaryStage.setScene(scene);
    }

    public static void showPreview(CVData data) throws Exception {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("preview.fxml"));

        double currentWidth = primaryStage.getScene().getWidth();
        double currentHeight = primaryStage.getScene().getHeight();

        Scene scene = new Scene(loader.load(), currentWidth, currentHeight);

        PreviewController controller = loader.getController();
        controller.setData(data);

        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}