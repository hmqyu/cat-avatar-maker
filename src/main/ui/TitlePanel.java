package ui;

import javafx.application.Platform;
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
import model.cat.CatCollection;
import persistence.SaveDataReader;

import java.io.File;
import java.io.IOException;

public class TitlePanel {
    public static final int WIDTH = 650;
    public static final int HEIGHT = 500;

    private static final String CAT_COLLECTION = "./data/CatCollection.txt";
    private CatCollection collection;

    private Stage currentStage;
    private StackPane titleScreen;
    private Button newButton;
    private Button loadButton;
    private Button helpButton;
    private Button quitButton;

    public TitlePanel(Stage stage) {
        titleScreen = new StackPane();
        loadTitleButtons();
        titleScreen.setStyle("-fx-background-color: #f5efed");
        currentStage = stage;
        currentStage.setScene(new Scene(titleScreen, WIDTH, HEIGHT));
        currentStage.show();
    }

    private void loadTitleButtons() {
        makeNewButton();
        makeLoadButton();
        makeHelpButton();
        makeQuitButton();
        ImageView title = new ImageView();
        title.setImage(new Image("ui/images/CatAvatarMakerTitle.png"));
        setPositions(newButton, loadButton, helpButton, quitButton, title);
    }

    private void makeNewButton() {
        ImageView newButtonImage = new ImageView();
        newButtonImage.setImage(new Image("ui/images/NewButton.png"));
        newButton = new Button("", newButtonImage);
        newButton.setStyle("-fx-background-color: transparent;");
        newButton.setOnAction(event -> System.out.println("Creating new cat!"));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        newButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> newButton.setEffect(shadow));
        newButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> newButton.setEffect(null));
    }

    private void makeLoadButton() {
        ImageView loadButtonImage = new ImageView();
        loadButtonImage.setImage(new Image("ui/images/LoadButton.png"));
        loadButton = new Button("", loadButtonImage);
        loadButton.setStyle("-fx-background-color: transparent;");
        loadButton.setOnAction(event -> loadCollection());
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        loadButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> loadButton.setEffect(shadow));
        loadButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> loadButton.setEffect(null));
    }

    private void makeHelpButton() {
        ImageView helpButtonImage = new ImageView();
        helpButtonImage.setImage(new Image("ui/images/HelpButton.png"));
        helpButton = new Button("", helpButtonImage);
        helpButton.setStyle("-fx-background-color: transparent;");
        helpButton.setOnAction(event -> new HelpPanel(currentStage));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        helpButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> helpButton.setEffect(shadow));
        helpButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> helpButton.setEffect(null));
    }

    private void makeQuitButton() {
        ImageView quitButtonImage = new ImageView();
        quitButtonImage.setImage(new Image("ui/images/QuitButton.png"));
        quitButton = new Button("", quitButtonImage);
        quitButton.setStyle("-fx-background-color: transparent;");
        quitButton.setOnAction(event -> quitCatMaker());
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        quitButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> quitButton.setEffect(shadow));
        quitButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> quitButton.setEffect(null));
    }

    private void setPositions(Button btn1, Button btn2, Button btn3, Button btn4, ImageView title) {
        VBox buttonBox = new VBox();
        buttonBox.getChildren().addAll(btn1, btn2, btn3, btn4);
        buttonBox.setAlignment(Pos.CENTER);
        VBox titleBox = new VBox(20);
        titleBox.setPadding(new Insets(50, 0, 0, 0));
        titleBox.getChildren().addAll(title, buttonBox);
        titleBox.setAlignment(Pos.TOP_CENTER);
        titleScreen.getChildren().add(titleBox);
    }

    private void quitCatMaker() {
        Platform.exit();
        System.exit(0);
    }

    private void loadCollection() {
        try {
            collection = SaveDataReader.readCollection(new File(CAT_COLLECTION));
        } catch (IOException e) {
            System.out.println("No collection found. Creating new collection...");
            collection = new CatCollection();
        }
    }
}
