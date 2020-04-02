package ui.actions;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.cat.Cat;
import model.cat.CatCollection;
import ui.ButtonVisualsMaker;
import ui.CatModel;
import ui.MakerPanel;
import ui.MenuPanel;

// Represents a base action panel for all maker buttons
public abstract class MakerAction {
    protected static final int BUTTON_X_POS = MenuPanel.BUTTON_X_POS;   // location of the buttons' x-coordinate
    protected static final int BUTTON_Y_POS = -50;                      // location of the buttons' y-coordinate
    protected Stage currentStage;                                       // the current stage
    protected StackPane makerScreen;                                    // the maker screen
    protected Cat userCat;                                              // the user's current cat
    protected CatCollection userCollection;                             // the user's current cat collection
    protected int newYPos = 0;

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
        loadColourButtons();
    }

    protected abstract void loadColourButtons();

    // EFFECTS: refreshes the cat model to display new changes to it, if any
    protected void refreshCatModel() {
        new CatModel(currentStage, makerScreen, userCat);
    }

    // MODIFIES: this
    // EFFECTS: adds button to respective position based on count and newYPos
    protected void setColourButtonPosition(Button button, int count) {
        makerScreen.getChildren().add(button);
        if (!((count + 1) % 2 == 0)) {
            button.setTranslateX(BUTTON_X_POS);
            newYPos += 50;
        } else {
            button.setTranslateX(BUTTON_X_POS + 125);
        }
        button.setTranslateY(-225 + newYPos);
    }

    // MODIFIES: this
    // EFFECTS: loads and creates an okay button that returns the user back to MakerPanel
    protected void loadOkayButton() {
        Button button = (new ButtonVisualsMaker("system/OkayButton")).getButton();
        button.setOnAction(event -> new MakerPanel(currentStage, userCat, userCollection));
        makerScreen.getChildren().add(button);
        button.setTranslateX(BUTTON_X_POS);
        button.setTranslateY(200);
    }
}
