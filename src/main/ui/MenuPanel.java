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
    private static final String CAT_COLLECTION = "./data/CatCollection.txt";   // text file to store the cat collection
    private CatCollection collection;   // the user's current cat collection
    private Cat userCat;   // the user's current cat

    private Stage currentStage;     // the current stage
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
        loadCollection();
        loadMenuButtons();
        menuScreen.setStyle("-fx-background-color: #f5efed");
        currentStage = stage;
        currentStage.setScene(new Scene(menuScreen, MakerPanel.WIDTH, MakerPanel.HEIGHT));
        currentStage.show();
    }

    // MODIFIES: this
    // EFFECTS: loads the new, load, help, and quit buttons, and the header image on menuScreen
    private void loadMenuButtons() {
        makeNewButton();
        makeLoadButton();
        makeHelpButton();
        makeQuitButton();
        ImageView title = new ImageView();
        title.setImage(new Image("ui/images/system/CatAvatarMakerTitle.png"));
        setPositions(title);
    }

    // MODIFIES: this
    // EFFECTS: creates a new button to lead the user to MakerPanel
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

    // MODIFIES: this
    // EFFECTS: creates a load button to lead the user to LoadPanel
    private void makeLoadButton() {
        ImageView loadButtonImage = new ImageView();
        loadButtonImage.setImage(new Image("ui/images/system/LoadButton.png"));
        loadButton = new Button("", loadButtonImage);
        loadButton.setStyle("-fx-background-color: transparent;");
        loadButton.setOnAction(event -> new LoadPanel(currentStage, collection, userCat));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        loadButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> loadButton.setEffect(shadow));
        loadButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> loadButton.setEffect(null));
    }

    // MODIFIES: this
    // EFFECTS: creates a help button to lead the user to HelpPanel
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

    // MODIFIES: this
    // EFFECTS: creates a new button that lets the user quit the application
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

    // MODIFIES: this
    // EFFECTS: adds the buttons and title to menuScreen at static locations
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
