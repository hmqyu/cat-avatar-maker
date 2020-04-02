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

// Represents an action panel for a cat's skin colour
public class SkinAction extends MakerAction {
    public static final String[] SKINS = {"Pink", "Mauve", "Black"};   // all available skin colours for a cat

    // EFFECTS: creates an action panel that lets the user change a cat's skin colour
    public SkinAction(Stage stage, StackPane screen, Cat cat, CatCollection collection) {
        super(stage, screen, cat, collection);
    }

    // MODIFIES: this
    // EFFECTS: loads and creates skin colour buttons that let the user change the cat's skin colour
    protected void loadColourButtons() {
        newYPos = BUTTON_Y_POS;
        for (int count = 0; count < SKINS.length; count++) {
            Button button = (new ButtonVisualsMaker("system/skins/" + SKINS[count])).getButton();
            int finalCount = count;
            button.setOnAction(event -> buttonAction(finalCount));
            setColourButtonPosition(button, count);
        }
    }

    // MODIFIES: this
    // EFFECTS: changes the cat's skin colour and updates the CatModel
    private void buttonAction(int colourNum) {
        userCat.changeSkin(SKINS[colourNum]);
        refreshCatModel();
    }
}