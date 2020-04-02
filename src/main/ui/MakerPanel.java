package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
    public static final int BUTTON_X_POS = MenuPanel.BUTTON_X_POS;             // x-coordinate of the menu buttons
    private static final String CAT_COLLECTION = "./data/CatCollection.txt";   // text file to store the cat collection

    private Stage currentStage;                                                // the current stage
    private StackPane makerScreen;                                             // the maker screen
    private Cat userCat;                                                       // the user's current cat
    private CatCollection userCollection;                                      // the user's current cat collection
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
        makerScreen.setStyle("-fx-background-color: " + MenuPanel.BG_COLOUR);
        new CatModel(currentStage, makerScreen, cat);
        userCat = cat;
        userCollection = collection;
        loadMakerButtons();
        currentStage = stage;
        currentStage.setScene(new Scene(makerScreen, MenuPanel.WIDTH, MenuPanel.HEIGHT));
        currentStage.show();
    }

    // MODIFIES: this
    // EFFECTS: creates and loads the base, pattern, eyes, skin, flip, accessories, background, save, and menu buttons,
    //          as well as the divider to separate buttons based on functionality
    private void loadMakerButtons() {
        baseButton = (new ButtonVisualsMaker("system/BaseColour")).getButton();
        patternButton = (new ButtonVisualsMaker("system/CoatPattern")).getButton();
        eyesButton = (new ButtonVisualsMaker("system/EyeColour")).getButton();
        skinButton = (new ButtonVisualsMaker("system/SkinColour")).getButton();
        accessoriesButton = (new ButtonVisualsMaker("system/Accessories")).getButton();
        backgroundButton = (new ButtonVisualsMaker("system/Background")).getButton();
        flipButton = (new ButtonVisualsMaker("system/FlipDirection")).getButton();
        saveButton = (new ButtonVisualsMaker("system/SaveCat")).getButton();
        menuButton = (new ButtonVisualsMaker("system/MenuScreen")).getButton();
        divider = new ImageView();
        divider.setImage(new Image("ui/images/system/Divider.png"));
        setButtonActions();
        setPositions();
    }

    // MODIFIES: this
    // EFFECTS: sets respective on click action events for all buttons in MakerPanel
    private void setButtonActions() {
        baseButton.setOnAction(event -> {
            removeMakerButtons();
            new BaseAction(currentStage, makerScreen, userCat, userCollection); });
        patternButton.setOnAction(event -> {
            removeMakerButtons();
            new PatternAction(currentStage, makerScreen, userCat, userCollection); });
        eyesButton.setOnAction(event -> {
            removeMakerButtons();
            new EyesAction(currentStage, makerScreen, userCat, userCollection); });
        skinButton.setOnAction(event -> {
            removeMakerButtons();
            new SkinAction(currentStage, makerScreen, userCat, userCollection); });
        accessoriesButton.setOnAction(event -> {
            removeMakerButtons();
            new AccessoriesAction(currentStage, makerScreen, userCat, userCollection); });
        backgroundButton.setOnAction(event -> {
            removeMakerButtons();
            new BackgroundAction(currentStage, makerScreen, userCat, userCollection); });
        flipButton.setOnAction(event -> flipAction());
        saveButton.setOnAction(event -> saveAction());
        menuButton.setOnAction(event -> new MenuPanel(currentStage, userCat));
    }

    // MODIFIES: this
    // EFFECTS: removes all MakerPanel buttons and the divider from the MakerPanel
    private void removeMakerButtons() {
        makerScreen.getChildren().removeAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
    }

    // MODIFIES: this
    // EFFECTS: adds all MakerPanel buttons and divider to makerScreen at static locations
    private void setPositions() {
        makerScreen.getChildren().addAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        baseButton.setTranslateX(BUTTON_X_POS);
        baseButton.setTranslateY(-225);
        patternButton.setTranslateX(BUTTON_X_POS);
        patternButton.setTranslateY(-175);
        eyesButton.setTranslateX(BUTTON_X_POS);
        eyesButton.setTranslateY(-125);
        skinButton.setTranslateX(BUTTON_X_POS);
        skinButton.setTranslateY(-75);
        accessoriesButton.setTranslateX(BUTTON_X_POS);
        accessoriesButton.setTranslateY(-25);
        backgroundButton.setTranslateX(BUTTON_X_POS);
        backgroundButton.setTranslateY(25);
        flipButton.setTranslateX(BUTTON_X_POS);
        flipButton.setTranslateY(75);
        divider.setTranslateX(BUTTON_X_POS + 10);
        divider.setTranslateY(125);
        saveButton.setTranslateX(BUTTON_X_POS);
        saveButton.setTranslateY(175);
        menuButton.setTranslateX(BUTTON_X_POS);
        menuButton.setTranslateY(225);
    }

    // MODIFIES: this
    // EFFECTS: flips the current cat's direction and updates the model
    private void flipAction() {
        userCat.flipDirection();
        new CatModel(currentStage, makerScreen, userCat);
    }

    // MODIFIES: this
    // EFFECTS: removes the buttons and divider; allows the user to name and thus save their cat
    private void saveAction() {
        removeMakerButtons();
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
        finishedSavingCommand();
    }

    // MODIFIES: this
    // EFFECTS: displays a saved image and button to let the user know that the cat has been successfully saved
    private void finishedSavingCommand() {
        ImageView savedImage = new ImageView();
        savedImage.setImage(new Image("ui/images/system/Saved.png"));
        Button button = (new ButtonVisualsMaker("system/SmallerOkayButton")).getButton();
        button.setOnAction(event -> new MakerPanel(currentStage, userCat, userCollection));
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
        for (int i = 0; i < oldCat.getAccessories().size(); i++) {
            newCat.addAccessory(oldCat.getAccessories().get(i));
        }
        if (oldCat.getDirection().equals("right")) {
            newCat.flipDirection();
        }
        return newCat;
    }

}
