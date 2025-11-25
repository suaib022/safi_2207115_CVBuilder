package com.example.cv_builder;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;

public class FormController {

    @FXML
    private TextField fullName;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    private TextArea address;

    @FXML
    private TextArea education;

    @FXML
    private TextArea skills;

    @FXML
    private TextArea experience;

    @FXML
    private TextArea projects;

    @FXML
    private Label imagePathLabel;

    private String selectedImagePath = null;

    @FXML
    private void handleImageUpload() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Profile Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            selectedImagePath = selectedFile.toURI().toString();
            imagePathLabel.setText(selectedFile.getName());
        }
    }

    @FXML
    protected void handleSubmit() {
        if (fullName.getText().isEmpty() || email.getText().isEmpty() || phone.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all required fields (Name, Email, Phone).");
            alert.showAndWait();
            return;
        }

        CVData data = new CVData(
                fullName.getText(),
                email.getText(),
                phone.getText(),
                address.getText(),
                education.getText(),
                skills.getText(),
                experience.getText(),
                projects.getText(),
                selectedImagePath
        );

        // Save to Database
        DatabaseHandler.createTable(); // Ensure table exists
        try {
            DatabaseHandler.insertCV(data);
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to save CV to database: " + e.getMessage());
            alert.showAndWait();
            return; // Stop if DB save fails
        }

        try {
            HelloApplication.showPreview(data);
            
            // Show Success Alert AFTER successful navigation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Your CV has been stored succesfully");
            alert.showAndWait();
            
        } catch (Exception e) {
            e.printStackTrace();
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("Navigation Error");
            errorAlert.setContentText("Could not load preview page: " + e.getMessage());
            errorAlert.showAndWait();
        }
    }
}
