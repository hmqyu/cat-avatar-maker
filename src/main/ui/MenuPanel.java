package ui;

import exceptions.SaveDataException;
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

// Represents the "intro" menu screen for the Cat Maker
public class MenuPanel {
    public static final int WIDTH = 650;                                       // width of the stage
    public static final int HEIGHT = 500;                                      // height of the stage
    public static final int BUTTON_X_POS = 390;                                // x-coordinate of the menu buttons
    public static final String BG_COLOUR = "#f5efed";                          // background colour of the scene
    private static final String CAT_COLLECTION = "./data/CatCollection.txt";   // text file to store the cat collection
    private CatCollection collection;                                          // the user's current cat collection
    private Cat userCat;                                                       // the user's current cat
    private Stage currentStage;                                                // the current stage

    private StackPane menuScreen;   // the menu screen
    private Button newButton;       // the new button
    private Button loadButton;      // the load button
    private Button helpButton;      // the help button
    private Button quitButton;      // the quit button

    // EFFECTS: creates an interactive menu screen with new, load, help, and quit buttons
    //          stage becomes the currentStage
    //          cat becomes the user's current cat (userCat)
    public MenuPanel(Stage stage, Cat cat) {
        userCat = cat;
        menuScreen = new StackPane();
        menuScreen.setStyle("-fx-background-color: " + BG_COLOUR);
        loadCollection();
        loadMenuButtons();
        currentStage = stage;
        currentStage.setScene(new Scene(menuScreen, WIDTH, HEIGHT));
        currentStage.show();
    }

    // MODIFIES: this
    // EFFECTS: creates and loads the new, load, help, and quit buttons, and the header image on menuScreen
    private void loadMenuButtons() {
        newButton = (new ButtonVisualsMaker("system/NewButton")).getButton();
        newButton.setOnAction(event -> new MakerPanel(currentStage, userCat, collection));
        loadButton = (new ButtonVisualsMaker("system/LoadButton")).getButton();
        loadButton.setOnAction(event -> new LoadPanel(currentStage, collection, userCat));
        helpButton = (new ButtonVisualsMaker("system/HelpButton")).getButton();
        helpButton.setOnAction(event -> new HelpPanel(currentStage, userCat));
        quitButton = (new ButtonVisualsMaker("system/QuitButton")).getButton();
        quitButton.setOnAction(event -> System.exit(0));
        ImageView title = new ImageView();
        title.setImage(new Image("ui/images/system/CatAvatarMakerTitle.png"));
        setPositions(title);
    }

    // MODIFIES: this
    // EFFECTS: adds MenuPanel buttons and title to menuScreen at static locations
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

    // MODIFIES: this
    // EFFECTS: loads a CatCollection from the file CAT_COLLECTION
    private void loadCollection() {
        try {
            collection = SaveDataReader.readCollection(new File(CAT_COLLECTION));
        } catch (IOException e) {
            System.out.println("No collection found. Creating new collection...");
            collection = new CatCollection();
        } catch (SaveDataException e) {
            System.out.println("Corrupt save file found - new collection must be created. Creating new collection...");
            collection = new CatCollection();
        }
    }
}
