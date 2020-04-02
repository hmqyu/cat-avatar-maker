package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.cat.Cat;

// Represents a help screen to guide the user on how to use the application
public class HelpPanel {
    private Stage currentStage;     // the current stage
    private StackPane helpScreen;   // the help screen
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
        currentStage.setScene(new Scene(helpScreen, MenuPanel.WIDTH, MenuPanel.HEIGHT));
        currentStage.show();
    }

    // MODIFIES: this
    // EFFECTS: creates and loads the back button onto helpScreen
    private void loadBackButton() {
        Button backButton = (new ButtonVisuals("system/BackButton")).getButton();
        backButton.setOnAction(event -> new MenuPanel(currentStage, userCat));
        helpScreen.getChildren().add(backButton);
        backButton.setTranslateX(185);
        backButton.setTranslateY(155);
    }

}
