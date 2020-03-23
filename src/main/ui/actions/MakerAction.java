package ui.actions;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.cat.Cat;
import model.cat.CatCollection;
import ui.MakerPanel;

// Represents a base action panel for all maker buttons
public class MakerAction {
    public static final String[] COLOURS = {"Black", "Brown", "Tortoiseshell", "Red", "Cream", "Blue", "Silver",
            "White"};   // all available colours for a cat's images
    protected static final int BUTTON_X_COORD = 390;   // location of the buttons' x-coordinate
    protected Stage currentStage;   // the current stage
    protected StackPane makerScreen;   // the maker screen
    protected Cat userCat;   // the user's current cat
    protected CatCollection userCollection;   // the user's current cat collection

    // EFFECTS: creates an interactive action panel with an okay button
    //          stage becomes the currentStage
    //          screen becomes the makerScreen
    //          cat becomes the user's current cat (userCat)
    //          collection becomes the user's current cat collection (userCollection)
    public MakerAction(Stage stage, StackPane screen, Cat cat, CatCollection collection) {
        currentStage = stage;
        makerScreen = screen;
        userCat = cat;
        userCollection = collection;
        loadOkayButton();
    }

    // MODIFIES: this
    // EFFECTS: loads and creates an okay button that returns the user back to MakerPanel
    protected void loadOkayButton() {
        ImageView buttonImage = new ImageView();
        buttonImage.setImage(new Image("ui/images/system/OkayButton.png"));
        Button button = new Button("", buttonImage);
        button.setStyle("-fx-background-color: transparent;");
        button.setOnAction(event -> new MakerPanel(currentStage, userCat, userCollection));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> button.setEffect(shadow));
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> button.setEffect(null));
        makerScreen.getChildren().add(button);
        button.setTranslateX(BUTTON_X_COORD);
        button.setTranslateY(200);
    }
}
