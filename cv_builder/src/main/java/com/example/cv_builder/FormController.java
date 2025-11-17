package com.example.cv_builder;

import javafx.fxml.FXML;
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
    private void handlePreview() {
        try {
            CVData data = new CVData(
                    fullName.getText(),
                    email.getText(),
                    phone.getText(),
                    address.getText(),
                    education.getText(),
                    skills.getText(),
                    experience.getText(),
                    projects.getText()
            );

            HelloApplication.showPreview(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
