package com.example.cv_builder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PreviewController {

    @FXML private Label name;
    @FXML private Label email;
    @FXML private Label phone;
    @FXML private Label address;

    @FXML private Label education;
    @FXML private Label skills;
    @FXML private Label experiences;
    @FXML private Label projects;

    @FXML
    private ImageView profileImage;

    public void setData(CVData data) {

        name.setText(data.getFullName());
        email.setText(data.getEmail());
        phone.setText(data.getPhone());
        address.setText(data.getAddress());
        education.setText(data.getEducation());
        skills.setText(data.getSkills());
        experiences.setText(data.getExperience());
        projects.setText(data.getProjects());

        if (data.getImagePath() != null && !data.getImagePath().isEmpty()) {
            try {
                profileImage.setImage(new Image(data.getImagePath()));
                
                // Make image rounded
                double radius = Math.min(profileImage.getFitWidth(), profileImage.getFitHeight()) / 2;
                javafx.scene.shape.Circle clip = new javafx.scene.shape.Circle(
                    profileImage.getFitWidth() / 2,
                    profileImage.getFitHeight() / 2,
                    radius
                );
                profileImage.setClip(clip);
                
            } catch (Exception e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        }
    }

    @FXML
    private void handleBack() {
        try {
            HelloApplication.changeScene("hello-view.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewAll() {
        try {
            HelloApplication.changeScene("cv-list-view.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
