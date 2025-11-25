package com.example.cv_builder;

import javafx.fxml.FXML;

public class HelloController {

    @FXML
    public void handleNavigateToCreateCV() {
        try {
            HelloApplication.changeScene("form.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleNavigateToViewAllCVs() {
        try {
            HelloApplication.changeScene("cv-list-view.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
