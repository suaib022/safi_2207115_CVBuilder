package com.example.cv_builder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Callback;

public class CVListController {

    @FXML private TableView<CVData> cvTable;
    @FXML private TableColumn<CVData, Integer> idColumn;
    @FXML private TableColumn<CVData, CVData> imageColumn;
    @FXML private TableColumn<CVData, String> nameColumn;
    @FXML private TableColumn<CVData, String> emailColumn;
    @FXML private TableColumn<CVData, Void> actionColumn;

    @FXML
    public void initialize() {
        // ID Column
        idColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("id"));
        idColumn.setStyle("-fx-alignment: CENTER;");

        // Image Column
        imageColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue()));
        imageColumn.setCellFactory(col -> new TableCell<CVData, CVData>() {
            @Override
            protected void updateItem(CVData item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    ImageView imageView = new ImageView();
                    imageView.setFitWidth(40);
                    imageView.setFitHeight(40);
                    imageView.setPreserveRatio(false); // Ensure it fills the circle
                    
                    if (item.getImagePath() != null && !item.getImagePath().isEmpty()) {
                        try {
                            imageView.setImage(new Image(item.getImagePath()));
                            Circle clip = new Circle(20, 20, 20);
                            imageView.setClip(clip);
                        } catch (Exception e) {
                            // Fallback
                        }
                    }
                    setGraphic(imageView);
                    setAlignment(Pos.CENTER);
                }
            }
        });

        // Name Column
        nameColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("fullName"));
        nameColumn.setCellFactory(col -> new TableCell<CVData, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                    setStyle("-fx-font-weight: bold; -fx-alignment: CENTER-LEFT;");
                }
            }
        });

        // Email Column
        emailColumn.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("email"));
        emailColumn.setStyle("-fx-alignment: CENTER-LEFT;");

        addButtonToTable();
        loadData();
    }

    private void loadData() {
        java.util.List<CVData> cvList = DatabaseHandler.getAllCVs();
        ObservableList<CVData> data = FXCollections.observableArrayList(cvList);
        cvTable.setItems(data);
    }

    private void addButtonToTable() {
        Callback<TableColumn<CVData, Void>, TableCell<CVData, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<CVData, Void> call(final TableColumn<CVData, Void> param) {
                final TableCell<CVData, Void> cell = new TableCell<>() {

                    private final Button btn = new Button("View CV");

                    {
                        btn.getStyleClass().add("details-button");
                        btn.setOnAction((event) -> {
                            CVData data = getTableView().getItems().get(getIndex());
                            handleViewCV(data.getId());
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        actionColumn.setCellFactory(cellFactory);
    }

    private void handleViewCV(int id) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(HelloApplication.class.getResource("cv-details-view.fxml"));
            javafx.scene.Parent root = loader.load();
            
            CVDetailsController controller = loader.getController();
            controller.initData(id);
            
            HelloApplication.changeScene(root);
            
        } catch (Exception e) {
            e.printStackTrace();
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
}
