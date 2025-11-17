package com.example.cv_builder;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class FormController {

    @FXML
    private TextField fullName;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    private TextField address;

    @FXML
    private TextField education;

    @FXML
    private TextField skills;

    @FXML
    private TextField experience;

    @FXML
    private TextField projects;

    @FXML
    private void handleSubmit() {
        String fullNameVal = fullName.getText().trim();
        String emailVal = email.getText().trim();
        String phoneVal = phone.getText().trim();
        String addressVal = address.getText().trim();
        String educationVal = education.getText().trim();
        String skillsVal = skills.getText().trim();
        String experienceVal = experience.getText().trim();
        String projectsVal = projects.getText().trim();

        if(fullNameVal.isEmpty() || emailVal.isEmpty() || phoneVal.isEmpty() || addressVal.isEmpty() || educationVal.isEmpty() || skillsVal.isEmpty() || experienceVal.isEmpty() || projectsVal.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Form");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields before submitting.");
            alert.showAndWait();

            return;
        }
        try {
//            System.out.println(fullName.getText());
//            System.out.println(phone.getText());
//            System.out.println(email.getText());
//            System.out.println(address.getText());
//            System.out.println(education.getText());
//            System.out.println(skills.getText());
//            System.out.println(experience.getText());
//            System.out.println(projects.getText());

            CVData data = new CVData(
                    fullNameVal,
                    emailVal,
                    phoneVal,
                    addressVal,
                    educationVal,
                    skillsVal,
                    experienceVal,
                    projectsVal
            );

            HelloApplication.showPreview(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
