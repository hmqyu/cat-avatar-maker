package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.cat.Cat;
import model.cat.CatCollection;
import persistence.SaveDataReader;

import java.io.File;
import java.io.IOException;

public class LoadPanel {
    public static final int WIDTH = 650;
    public static final int HEIGHT = 500;

    private static final String CAT_COLLECTION = "./data/CatCollection.txt";
    private CatCollection userCollection;

    private Stage currentStage;
    private StackPane loadScreen;
    private Button newButton;
    private Button loadButton;
    private Button helpButton;
    private Button quitButton;

    public LoadPanel(Stage stage, CatCollection collection) {
        loadScreen = new StackPane();
        userCollection = collection;
        //loadMenuButtons();
        loadScreen.setStyle("-fx-background-color: #f5efed");
        currentStage = stage;
        currentStage.setScene(new Scene(loadScreen, WIDTH, HEIGHT));
        currentStage.show();
    }

}
