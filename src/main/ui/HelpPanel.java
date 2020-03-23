package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.cat.Cat;

// Represents a help screen to guide the user on how to use the application
public class HelpPanel {
    public static final int WIDTH = 650;    // width of the stage
    public static final int HEIGHT = 500;   // height of the stage

    private Stage currentStage;     // the current stage
    private StackPane helpScreen;   // the help screen
    private Button backButton;      // the back button
    private Cat userCat;            // the user's current cat

    // EFFECTS: creates an interactive help screen with a back button
    //          stage becomes the currentStage
    //          cat becomes the user's current cat (userCat)
    public HelpPanel(Stage stage, Cat cat) {
        helpScreen = new StackPane();
        userCat = cat;
        // Background code from: https://stackoverflow.com/questions/9738146/javafx-how-to-set-scene-background-image
        BackgroundImage helpScreenBackground = new BackgroundImage(new Image("ui/images/system/HelpScreen.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        loadBackButton();
        helpScreen.setBackground(new Background(helpScreenBackground));
        currentStage = stage;
        currentStage.setScene(new Scene(helpScreen, WIDTH, HEIGHT));
        currentStage.show();
    }

    // MODIFIES: this
    // EFFECTS: loads the back button onto helpScreen
    private void loadBackButton() {
        makeBackButton();
        helpScreen.getChildren().add(backButton);
        backButton.setTranslateX(185);
        backButton.setTranslateY(155);
    }

    // MODIFIES: this
    // EFFECTS: creates a back button that allows the user to go back to MenuPanel
    private void makeBackButton() {
        ImageView quitButtonImage = new ImageView();
        quitButtonImage.setImage(new Image("ui/images/system/BackButton.png"));
        backButton = new Button("", quitButtonImage);
        backButton.setStyle("-fx-background-color: transparent;");
        backButton.setOnAction(event -> new MenuPanel(currentStage, userCat));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        backButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> backButton.setEffect(shadow));
        backButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> backButton.setEffect(null));
    }
}
