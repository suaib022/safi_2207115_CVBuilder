package com.example.cv_builder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CVDetailsController {

    @FXML private Label name;
    @FXML private Label email;
    @FXML private Label phone;
    @FXML private Label address;

    @FXML private Label education;
    @FXML private Label skills;
    @FXML private Label experiences;
    @FXML private Label projects;

    @FXML private ImageView profileImage;

    public void initData(int id) {
        CVData data = DatabaseHandler.getCVById(id);
        if (data != null) {
            setData(data);
        }
    }

    public void setData(CVData cvData) {
        name.setText(cvData.getFullName());
        email.setText(cvData.getEmail());
        phone.setText(cvData.getPhone());
        address.setText(cvData.getAddress());
        education.setText(cvData.getEducation());
        skills.setText(cvData.getSkills());
        experiences.setText(cvData.getExperience());
        projects.setText(cvData.getProjects());

        if (cvData.getImagePath() != null && !cvData.getImagePath().isEmpty()) {
            try {
                profileImage.setImage(new Image(cvData.getImagePath()));
                
                // Apply circular clip
                javafx.scene.shape.Circle clip = new javafx.scene.shape.Circle(75, 75, 75); // Radius 75 for 150x150 image
                profileImage.setClip(clip);
                
            } catch (Exception e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        }
    }

    @FXML
    private void handleBack() {
        try {
            HelloApplication.changeScene("cv-list-view.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
