package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
import persistence.SaveDataWriter;
import ui.actions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

// Represents an interactive cat avatar maker
public class MakerPanel {
    public static final int WIDTH = 650;                                       // width of the stage
    public static final int HEIGHT = 500;                                      // height of the stage
    private static final int BUTTON_X_COORD = 390;                             // x-coordinate of the menu buttons

    private static final String CAT_COLLECTION = "./data/CatCollection.txt";   // text file to store the cat collection
    private CatCollection userCollection;                                      // the user's current cat collection

    private Stage currentStage;                                                // the current stage
    private StackPane makerScreen;                                             // the maker screen
    private Cat userCat;                                                       // the user's current cat
    private Button baseButton;                                                 // the base colour button
    private Button patternButton;                                              // the coat pattern button
    private Button eyesButton;                                                 // the eye colour button
    private Button skinButton;                                                 // the skin colour button
    private Button flipButton;                                                 // the flip direction button
    private Button accessoriesButton;                                          // the accessories button
    private Button backgroundButton;                                           // the backgrounds button
    private ImageView divider;                                                 // a divider image for the menu
    private Button saveButton;                                                 // the save cat button
    private Button menuButton;                                                 // the return to menu button

    // EFFECTS: creates an interactive maker screen with base, pattern, eyes, skin, flip, accessories, background,
    //          save, and menu buttons, as well as a divider and a cat avatar that can be modified
    //          stage becomes the currentStage
    //          cat becomes the user's current cat (userCat)
    //          collection becomes the user's current cat collection (userCollection)
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

    // MODIFIES: this
    // EFFECTS: loads the base, pattern, eyes, skin, flip, accessories, background, save, and menu buttons, as well as
    //          the divider
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

    // MODIFIES: this
    // EFFECTS: creates a base button that lets the user modify the cat's base colour
    private void makeBaseButton() {
        ImageView baseButtonImage = new ImageView();
        baseButtonImage.setImage(new Image("ui/images/system/BaseColour.png"));
        baseButton = new Button("", baseButtonImage);
        baseButton.setStyle("-fx-background-color: transparent;");
        baseButton.setOnAction(event -> baseAction());
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        baseButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> baseButton.setEffect(shadow));
        baseButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> baseButton.setEffect(null));
    }

    // MODIFIES: this
    // EFFECTS: creates a pattern button that lets the user modify the cat's coat pattern
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

    // MODIFIES: this
    // EFFECTS: creates an eyes button that lets the user modify the cat's eye colours
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

    // MODIFIES: this
    // EFFECTS: creates a skin button that lets the user modify the cat's skin colour
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

    // MODIFIES: this
    // EFFECTS: creates an accessories button that lets the user modify the cat's accessories
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

    // MODIFIES: this
    // EFFECTS: creates a background button that lets the user modify the cat's background
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

    // MODIFIES: this
    // EFFECTS: creates a flip button that lets the user flip the cat from left to right, and vice versa
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

    // MODIFIES: this
    // EFFECTS: creates a save button that lets the user save the current cat to the current cat colletion file
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

    // MODIFIES: this
    // EFFECTS: creates a menu button that lets the user return to MenuPanel
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

    // MODIFIES: this
    // EFFECTS: adds the buttons and divider to makerScreen at static locations
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

    // MODIFIES: this
    // EFFECTS: removes the buttons and divider and replaces them with BaseAction
    private void baseAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new BaseAction(currentStage, makerScreen, userCat, userCollection);
    }

    // MODIFIES: this
    // EFFECTS: removes the buttons and divider and replaces them with PatternAction
    private void patternAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new PatternAction(currentStage, makerScreen, userCat, userCollection);
    }

    // MODIFIES: this
    // EFFECTS: removes the buttons and divider and replaces them with EyesAction
    private void eyesAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new EyesAction(currentStage, makerScreen, userCat, userCollection);
    }

    // MODIFIES: this
    // EFFECTS: removes the buttons and divider and replaces them with SkinAction
    private void skinAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new SkinAction(currentStage, makerScreen, userCat, userCollection);
    }

    // MODIFIES: this
    // EFFECTS: removes the buttons and divider and replaces them with AccessoriesAction
    private void accessoriesAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new AccessoriesAction(currentStage, makerScreen, userCat, userCollection);
    }

    // MODIFIES: this
    // EFFECTS: removes the buttons and divider and replaces them with BackgroundAction
    private void backgroundAction() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        new BackgroundAction(currentStage, makerScreen, userCat, userCollection);
    }

    // MODIFIES: this
    // EFFECTS: removes the buttons and divider and replaces them with FlipAction
    private void flipAction() {
        userCat.flipDirection();
        new CatModel(currentStage, makerScreen, userCat);
    }

    // MODIFIES: this
    // EFFECTS: removes the buttons and divider and replaces them with SaveAction
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

    // MODIFIES: this
    // EFFECTS: saves the current userCat to CAT_COLLECTION
    private void saveCommand(String name, VBox saveBox) {
        makerScreen.getChildren().remove(saveBox);
        userCat = updateCat(userCat);
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

    // MODIFIES: this
    // EFFECTS: displays a saved image and button to let the user know that the cat has been successfully saved
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

    // EFFECTS: updates oldCat into a new Cat called newCat
    private Cat updateCat(Cat oldCat) {
        Cat newCat = new Cat();
        newCat.changeName(oldCat.getName());
        newCat.changeBase(oldCat.getBase());
        newCat.changePattern(oldCat.getPattern());
        newCat.changeLeftEye(oldCat.getLeftEye());
        newCat.changeRightEye(oldCat.getRightEye());
        newCat.changeSkin(oldCat.getSkin());
        newCat.changeBackground(oldCat.getBackground());
        for (int i = 0; i < oldCat.getAccessoriesList().size(); i++) {
            newCat.addAccessory(oldCat.getAccessoriesList().get(i));
        }
        return newCat;
    }
}
