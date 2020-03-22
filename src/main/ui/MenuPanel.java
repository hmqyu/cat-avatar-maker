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

public class MenuPanel {
    public static final int WIDTH = 650;
    public static final int HEIGHT = 500;

    private static final String CAT_COLLECTION = "./data/CatCollection.txt";
    private CatCollection collection;
    private Cat userCat;

    private Stage currentStage;
    private StackPane menuScreen;
    private Button newButton;
    private Button loadButton;
    private Button helpButton;
    private Button quitButton;

    public MenuPanel(Stage stage) {
        userCat = new Cat();
        menuScreen = new StackPane();
        loadCollection();
        loadMenuButtons();
        menuScreen.setStyle("-fx-background-color: #f5efed");
        currentStage = stage;
        currentStage.setScene(new Scene(menuScreen, WIDTH, HEIGHT));
        currentStage.show();
    }

    public MenuPanel(Stage stage, Cat cat) {
        userCat = cat;
        menuScreen = new StackPane();
        loadMenuButtons();
        menuScreen.setStyle("-fx-background-color: #f5efed");
        currentStage = stage;
        currentStage.setScene(new Scene(menuScreen, WIDTH, HEIGHT));
        currentStage.show();
    }

    private void loadMenuButtons() {
        makeNewButton();
        makeLoadButton();
        makeHelpButton();
        makeQuitButton();
        ImageView title = new ImageView();
        title.setImage(new Image("ui/images/system/CatAvatarMakerTitle.png"));
        setPositions(title);
    }

    private void makeNewButton() {
        ImageView newButtonImage = new ImageView();
        newButtonImage.setImage(new Image("ui/images/system/NewButton.png"));
        newButton = new Button("", newButtonImage);
        newButton.setStyle("-fx-background-color: transparent;");
        newButton.setOnAction(event -> new MakerPanel(currentStage, userCat, collection));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        newButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> newButton.setEffect(shadow));
        newButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> newButton.setEffect(null));
    }

    private void makeLoadButton() {
        ImageView loadButtonImage = new ImageView();
        loadButtonImage.setImage(new Image("ui/images/system/LoadButton.png"));
        loadButton = new Button("", loadButtonImage);
        loadButton.setStyle("-fx-background-color: transparent;");
        loadButton.setOnAction(event -> new LoadPanel(currentStage, collection));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        loadButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> loadButton.setEffect(shadow));
        loadButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> loadButton.setEffect(null));
    }

    private void makeHelpButton() {
        ImageView helpButtonImage = new ImageView();
        helpButtonImage.setImage(new Image("ui/images/system/HelpButton.png"));
        helpButton = new Button("", helpButtonImage);
        helpButton.setStyle("-fx-background-color: transparent;");
        helpButton.setOnAction(event -> new HelpPanel(currentStage, userCat));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        helpButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> helpButton.setEffect(shadow));
        helpButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> helpButton.setEffect(null));
    }

    private void makeQuitButton() {
        ImageView quitButtonImage = new ImageView();
        quitButtonImage.setImage(new Image("ui/images/system/QuitButton.png"));
        quitButton = new Button("", quitButtonImage);
        quitButton.setStyle("-fx-background-color: transparent;");
        quitButton.setOnAction(event -> System.exit(0));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        quitButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> quitButton.setEffect(shadow));
        quitButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> quitButton.setEffect(null));
    }

    private void setPositions(ImageView title) {
        VBox buttonBox = new VBox();
        buttonBox.getChildren().addAll(newButton, loadButton, helpButton, quitButton);
        buttonBox.setAlignment(Pos.CENTER);
        VBox titleBox = new VBox(20);
        titleBox.setPadding(new Insets(50, 0, 0, 0));
        titleBox.getChildren().addAll(title, buttonBox);
        titleBox.setAlignment(Pos.TOP_CENTER);
        menuScreen.getChildren().add(titleBox);
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
