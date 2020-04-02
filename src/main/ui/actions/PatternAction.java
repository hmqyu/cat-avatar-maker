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

// Represents an action panel for a cat's coat pattern
public class PatternAction extends MakerAction {
    protected static final String[] COLOURS = {"Black", "Brown", "Tortoiseshell", "Red", "Cream", "Blue", "Silver",
            "White"};   // all available colours for a cat's pattern button view
    public static final String[] PATTERNS = {"BlackTabby", "BrownTabby", "PointPattern", "RedTabby", "CreamTabby",
            "BlueTabby", "SilverTabby", "WhitePattern"};   // all available coat patterns for a cat

    // EFFECTS: creates an action panel that lets the user change a cat's coat pattern
    public PatternAction(Stage stage, StackPane screen, Cat cat, CatCollection collection) {
        super(stage, screen, cat, collection);
    }

    // MODIFIES: this
    // EFFECTS: loads and creates coat pattern buttons that let the user change the cat's coat pattern
    protected void loadColourButtons() {
        newYPos = BUTTON_Y_POS;
        for (int count = 0; count < COLOURS.length; count++) {
            Button button = (new ButtonVisualsMaker("system/colours/" + COLOURS[count])).getButton();
            int finalCount = count;
            button.setOnAction(event -> buttonAction(finalCount));
            setColourButtonPosition(button, count);
        }
    }

    // MODIFIES: this
    // EFFECTS: changes the cat's coat pattern and updates the CatModel
    private void buttonAction(int colourNum) {
        userCat.changePattern(PATTERNS[colourNum]);
        refreshCatModel();
    }
}
