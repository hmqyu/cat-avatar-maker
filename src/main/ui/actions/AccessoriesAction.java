package ui.actions;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.cat.Cat;
import model.cat.CatCollection;
import ui.ButtonVisuals;

// Represents an action panel to change a cat's wearable accessories
public class AccessoriesAction extends MakerAction {
    public static final String[] ACCESSORIES = {"Bag", "Bow", "Hat", "Horns", "LeftHoopEarring", "RightHoopEarring",
            "LeftStudEarring", "RightStudEarring", "Mask", "Scarf", "Wings"};   // all available accessories for a cat

    // EFFECTS: creates an action panel that lets the user add and remove accessories to a cat
    public AccessoriesAction(Stage stage, StackPane screen, Cat cat, CatCollection collection) {
        super(stage, screen, cat, collection);
    }

    // MODIFIES: this
    // EFFECTS: loads and creates accessory buttons that let the user add and remove accessories to a cat
    protected void loadColourButtons() {
        newYPos = BUTTON_Y_POS;
        for (int count = 0; count < ACCESSORIES.length; count++) {
            Button button = (new ButtonVisuals("system/accessories/" + ACCESSORIES[count])).getButton();
            int finalCount = count;
            button.setOnAction(event -> buttonAction(finalCount, button));
            setColourButtonPosition(button, count);
        }
    }

    // MODIFIES: this, button
    // EFFECTS: adds an accessory to the cat and updates the CatModel
    //          changes the button to a remove accessory button
    private void buttonAction(int colourNum, Button button) {
        userCat.addAccessory(ACCESSORIES[colourNum]);
        refreshCatModel();
        button.setOnAction(event -> removeButtonAction(colourNum, button));
    }

    // MODIFIES: this, button
    // EFFECTS: removes an accessory from the cat and updates the CatModel
    //          changes the button to an add accessory button
    private void removeButtonAction(int colourNum, Button button) {
        userCat.removeAccessory(ACCESSORIES[colourNum]);
        refreshCatModel();
        button.setOnAction(event -> buttonAction(colourNum, button));
    }

}