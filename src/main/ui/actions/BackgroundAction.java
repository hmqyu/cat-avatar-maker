package ui.actions;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.cat.Cat;
import model.cat.CatCollection;
import ui.ButtonVisuals;

// Represents an action panel to change a cat's background image
public class BackgroundAction extends MakerAction {
    public static final String[] BACKGROUNDS = {"Empty", "Beach", "Forest", "Home", "Nighttime"};   // all available
                                                                                                    // backgrounds for
                                                                                                    // a cat

    // EFFECTS: creates an action panel that lets the user change a cat's background image
    public BackgroundAction(Stage stage, StackPane screen, Cat cat, CatCollection collection) {
        super(stage, screen, cat, collection);
    }

    // MODIFIES: this
    // EFFECTS: loads and creates background image buttons that let the user change the cat's background image
    protected void loadColourButtons() {
        newYPos = BUTTON_Y_POS;
        for (int count = 0; count < BACKGROUNDS.length; count++) {
            Button button = (new ButtonVisuals("system/backgrounds/" + BACKGROUNDS[count])).getButton();
            int finalCount = count;
            button.setOnAction(event -> buttonAction(finalCount));
            setColourButtonPosition(button, count);
        }
    }

    // MODIFIES: this
    // EFFECTS: changes the cat's background image and updates the CatModel
    private void buttonAction(int colourNum) {
        userCat.changeBackground(BACKGROUNDS[colourNum]);
        refreshCatModel();
    }
}