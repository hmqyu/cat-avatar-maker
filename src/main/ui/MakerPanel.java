package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.cat.Cat;

public class MakerPanel {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    private Stage currentStage;
    private StackPane makerScreen;
    private CatModel catModel;
    private Button baseButton;
    private Button patternButton;
    private Button eyesButton;
    private Button noseButton;
    private Button directionButton;
    private Button accessoriesButton;
    private Button backgroundButton;
    private Button saveButton;
    private Button menuButton;

    public MakerPanel(Stage stage, Cat cat) {
        makerScreen = new StackPane();
        catModel = new CatModel(makerScreen, cat);
        loadMakerButtons();
        makerScreen.setStyle("-fx-background-color: #f5efed");
        currentStage = stage;
        currentStage.setScene(new Scene(makerScreen, WIDTH, HEIGHT));
        currentStage.show();
    }

    private void loadMakerButtons() {

    }

}
