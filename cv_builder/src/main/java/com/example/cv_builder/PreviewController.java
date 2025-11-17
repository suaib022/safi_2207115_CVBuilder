package com.example.cv_builder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
        name.setText("Name: " + data.getFullName());
        email.setText("Email: " + data.getEmail());
        phone.setText("Phone: " + data.getPhone());
        address.setText("Address: " + data.getAddress());
        education.setText("Education: " + data.getEducation());
        skills.setText("Skills: " + data.getSkills());
        experiences.setText("Experience: " + data.getExperience());
        projects.setText("Projects: " + data.getProjects());
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
