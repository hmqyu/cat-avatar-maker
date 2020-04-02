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
import ui.ButtonVisualsMaker;
import ui.CatModel;

// Represents an action panel for a cat's base colour
public class BaseAction extends MakerAction {
    protected static final String[] BASES = {"Black", "Brown", "Tortoiseshell", "Red", "Cream", "Blue", "Silver",
            "White"};   // all available base colours for a cat

    // EFFECTS: creates an action panel that lets the user change a cat's base colour
    public BaseAction(Stage stage, StackPane screen, Cat cat, CatCollection collection) {
        super(stage, screen, cat, collection);
    }

    // MODIFIES: this
    // EFFECTS: loads and creates base colour buttons that let the user change the cat's base colour
    protected void loadColourButtons() {
        newYPos = BUTTON_Y_POS;
        for (int count = 0; count < BASES.length; count++) {
            Button button = (new ButtonVisualsMaker("system/colours/" + BASES[count])).getButton();
            int finalCount = count;
            button.setOnAction(event -> buttonAction(finalCount));
            setColourButtonPosition(button, count);
        }
    }

    // MODIFIES: this
    // EFFECTS: changes the cat's base colour and updates the CatModel
    private void buttonAction(int colourNum) {
        userCat.changeBase(BASES[colourNum]);
        refreshCatModel();
    }
}
