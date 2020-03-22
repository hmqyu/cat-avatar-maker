package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.cat.Cat;
import model.cat.CatCollection;
import persistence.SaveDataWriter;
import ui.actions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class MakerPanel {
    public static final int WIDTH = 650;
    public static final int HEIGHT = 500;
    private static final int BUTTON_X_COORD = 390;

    private static final String CAT_COLLECTION = "./data/CatCollection.txt";
    private CatCollection userCollection;

    private Stage currentStage;
    private StackPane makerScreen;
    private Cat userCat;
    private Button baseButton;
    private Button patternButton;
    private Button eyesButton;
    private Button skinButton;
    private Button flipButton;
    private Button accessoriesButton;
    private Button backgroundButton;
    private ImageView divider;
    private Button saveButton;
    private Button menuButton;

    public MakerPanel(Stage stage, Cat cat, CatCollection collection) {
        currentStage = stage;
        makerScreen = new StackPane();
        new CatModel(currentStage, makerScreen, cat);
        userCat = cat;
        userCollection = collection;
        loadMakerButtons();
        makerScreen.setStyle("-fx-background-color: #f5efed");
        currentStage = stage;
        currentStage.setScene(new Scene(makerScreen, WIDTH, HEIGHT));
        currentStage.show();
    }

    private void loadMakerButtons() {
        makeBaseButton();
        makePatternButton();
        makeEyesButton();
        makeSkinButton();
        makeAccessoriesButton();
        makeBackgroundButton();
        makeFlipButton();
        makeSaveButton();
        makeMenuButton();
        divider = new ImageView();
        divider.setImage(new Image("ui/images/system/Divider.png"));
        setPositions();
    }

    private void makeBaseButton() {
        ImageView baseButtonImage = new ImageView();
        baseButtonImage.setImage(new Image("ui/images/system/BaseColour.png"));
        baseButton = new Button("", baseButtonImage);
        baseButton.setStyle("-fx-background-color: transparent;");
        baseButton.setOnAction(event -> colourAction());
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        baseButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> baseButton.setEffect(shadow));
        baseButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> baseButton.setEffect(null));
    }

    private void makePatternButton() {
        ImageView patternButtonImage = new ImageView();
        patternButtonImage.setImage(new Image("ui/images/system/CoatPattern.png"));
        patternButton = new Button("", patternButtonImage);
        patternButton.setStyle("-fx-background-color: transparent;");
        patternButton.setOnAction(event -> patternAction());
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        patternButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> patternButton.setEffect(shadow));
        patternButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> patternButton.setEffect(null));
    }

    private void makeEyesButton() {
        ImageView eyesButtonImage = new ImageView();
        eyesButtonImage.setImage(new Image("ui/images/system/EyeColour.png"));
        eyesButton = new Button("", eyesButtonImage);
        eyesButton.setStyle("-fx-background-color: transparent;");
        eyesButton.setOnAction(event -> eyesAction());
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        eyesButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> eyesButton.setEffect(shadow));
        eyesButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> eyesButton.setEffect(null));
    }

    private void makeSkinButton() {
        ImageView skinButtonImage = new ImageView();
        skinButtonImage.setImage(new Image("ui/images/system/SkinColour.png"));
        skinButton = new Button("", skinButtonImage);
        skinButton.setStyle("-fx-background-color: transparent;");
        skinButton.setOnAction(event -> skinAction());
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        skinButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> skinButton.setEffect(shadow));
        skinButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> skinButton.setEffect(null));
    }

    private void makeAccessoriesButton() {
        ImageView accessoryButtonImage = new ImageView();
        accessoryButtonImage.setImage(new Image("ui/images/system/Accessories.png"));
        accessoriesButton = new Button("", accessoryButtonImage);
        accessoriesButton.setStyle("-fx-background-color: transparent;");
        accessoriesButton.setOnAction(event -> accessoriesAction());
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        accessoriesButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> accessoriesButton.setEffect(shadow));
        accessoriesButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> accessoriesButton.setEffect(null));
    }

    private void makeBackgroundButton() {
        ImageView backgroundButtonImage = new ImageView();
        backgroundButtonImage.setImage(new Image("ui/images/system/Background.png"));
        backgroundButton = new Button("", backgroundButtonImage);
        backgroundButton.setStyle("-fx-background-color: transparent;");
        backgroundButton.setOnAction(event -> backgroundAction());
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        backgroundButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> backgroundButton.setEffect(shadow));
        backgroundButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> backgroundButton.setEffect(null));
    }

    private void makeFlipButton() {
        ImageView flipButtonImage = new ImageView();
        flipButtonImage.setImage(new Image("ui/images/system/FlipDirection.png"));
        flipButton = new Button("", flipButtonImage);
        flipButton.setStyle("-fx-background-color: transparent;");
        flipButton.setOnAction(event -> flipAction());
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        flipButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> flipButton.setEffect(shadow));
        flipButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> flipButton.setEffect(null));
    }

    private void makeSaveButton() {
        ImageView saveButtonImage = new ImageView();
        saveButtonImage.setImage(new Image("ui/images/system/SaveCat.png"));
        saveButton = new Button("", saveButtonImage);
        saveButton.setStyle("-fx-background-color: transparent;");
        saveButton.setOnAction(event -> saveAction());
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        saveButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> saveButton.setEffect(shadow));
        saveButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> saveButton.setEffect(null));
    }

    private void makeMenuButton() {
        ImageView menuButtonImage = new ImageView();
        menuButtonImage.setImage(new Image("ui/images/system/MenuScreen.png"));
        menuButton = new Button("", menuButtonImage);
        menuButton.setStyle("-fx-background-color: transparent;");
        menuButton.setOnAction(event -> new MenuPanel(currentStage, userCat));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        menuButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> menuButton.setEffect(shadow));
        menuButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> menuButton.setEffect(null));
    }

    private void setPositions() {
        makerScreen.getChildren().addAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        baseButton.setTranslateX(BUTTON_X_COORD);
        baseButton.setTranslateY(-225);
        patternButton.setTranslateX(BUTTON_X_COORD);
        patternButton.setTranslateY(-175);
        eyesButton.setTranslateX(BUTTON_X_COORD);
        eyesButton.setTranslateY(-125);
        skinButton.setTranslateX(BUTTON_X_COORD);
        skinButton.setTranslateY(-75);
        accessoriesButton.setTranslateX(BUTTON_X_COORD);
        accessoriesButton.setTranslateY(-25);
        backgroundButton.setTranslateX(BUTTON_X_COORD);
        backgroundButton.setTranslateY(25);
        flipButton.setTranslateX(BUTTON_X_COORD);
        flipButton.setTranslateY(75);
        divider.setTranslateX(BUTTON_X_COORD + 10);
        divider.setTranslateY(125);
        saveButton.setTranslateX(BUTTON_X_COORD);
        saveButton.setTranslateY(175);
        menuButton.setTranslateX(BUTTON_X_COORD);
        menuButton.setTranslateY(225);
    }

    private void colourAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new BaseAction(currentStage, makerScreen, userCat, userCollection);
    }

    private void patternAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new PatternAction(currentStage, makerScreen, userCat, userCollection);
    }

    private void eyesAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new EyesAction(currentStage, makerScreen, userCat, userCollection);
    }

    private void skinAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new SkinAction(currentStage, makerScreen, userCat, userCollection);
    }

    private void accessoriesAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new AccessoriesAction(currentStage, makerScreen, userCat, userCollection);
    }

    private void backgroundAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new BackgroundAction(currentStage, makerScreen, userCat, userCollection);
    }

    private void flipAction() {
        userCat.flipDirection();
        new CatModel(currentStage, makerScreen, userCat);
    }

    private void saveAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        ImageView nameImage = new ImageView();
        nameImage.setImage(new Image("ui/images/system/NameTheCat.png"));
        TextField textField = new TextField();
        textField.setMaxWidth(230);
        VBox textBox = new VBox();
        textBox.setPadding(new Insets(0, 10, 0, 10));
        textBox.getChildren().add(textField);
        textBox.setAlignment(Pos.CENTER_RIGHT);
        VBox saveBox = new VBox(20);
        saveBox.getChildren().addAll(nameImage, textBox);
        saveBox.setAlignment(Pos.CENTER_RIGHT);
        makerScreen.getChildren().add(saveBox);
        textField.setOnAction(event -> saveCommand(textField.getText(), saveBox));
    }

    private void saveCommand(String name, VBox saveBox) {
        makerScreen.getChildren().remove(saveBox);
        userCat.changeName(name);
        try {
            SaveDataWriter writer = new SaveDataWriter(new File(CAT_COLLECTION));
            userCollection.addToCollection(userCat);
            writer.write(userCollection);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found - unable to save cat to " + CAT_COLLECTION);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        savedCommand();
    }

    private void savedCommand() {
        ImageView savedImage = new ImageView();
        savedImage.setImage(new Image("ui/images/system/Saved.png"));
        ImageView buttonImage = new ImageView();
        buttonImage.setImage(new Image("ui/images/system/SmallerOkayButton.png"));
        Button button = new Button("", buttonImage);
        button.setStyle("-fx-background-color: transparent;");
        button.setOnAction(event -> new MakerPanel(currentStage, userCat, userCollection));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> button.setEffect(shadow));
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> button.setEffect(null));
        VBox savedBox = new VBox(10);
        savedBox.getChildren().addAll(savedImage, button);
        savedBox.setAlignment(Pos.CENTER_RIGHT);
        makerScreen.getChildren().addAll(savedBox);
    }
}
