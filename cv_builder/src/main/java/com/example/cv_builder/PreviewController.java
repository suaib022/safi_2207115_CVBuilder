package com.example.cv_builder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javax.swing.*;

public class PreviewController {

    @FXML private Label name;
    @FXML private Label email;
    @FXML private Label phone;
    @FXML private Label address;

    @FXML private Label education;
    @FXML private Label skills;
    @FXML private Label experiences;
    @FXML private Label projects;

    public void setData(CVData data) {

        name.setText(data.getFullName());
        email.setText(data.getEmail());
        phone.setText(data.getPhone());
        address.setText(data.getAddress());
        education.setText(data.getEducation());
        skills.setText(data.getSkills());
        experiences.setText(data.getExperience());
        projects.setText(data.getProjects());
    }

    private void addTextToBox(VBox box, String text) {
        Label label = new Label(text);
        label.setWrapText(true);
        box.getChildren().add(label);
    }

    @FXML
    private void handleBack() {
        try {
            HelloApplication.changeScene("form.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
