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
    private void handleSubmit() {
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
                    fullName.getText(),
                    email.getText(),
                    phone.getText(),
                    address.getText(),
                    education.getText(),
                    skills.getText(),
                    experience.getText(),
                    projects.getText()
            );

//            HelloApplication.showPreview(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
