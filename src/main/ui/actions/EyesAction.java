package ui.actions;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.cat.Cat;
import model.cat.CatCollection;
import ui.ButtonVisuals;

// Represents an action panel to change a cat's eye colours
public class EyesAction extends MakerAction {
    public static final String[] EYES = {"Copper", "Pink", "Yellow", "Green", "Blue"};   // all available eye colours
                                                                                         // for a cat

    // EFFECTS: creates an action panel that lets the user change a cat's eye colours
    public EyesAction(Stage stage, StackPane screen, Cat cat, CatCollection collection) {
        super(stage, screen, cat, collection);
    }

    // MODIFIES: this
    // EFFECTS: loads and creates eye colour buttons that let the user change the cat's eye colours
    protected void loadColourButtons() {
        int eyeCounter = 1;
        newYPos = BUTTON_Y_POS;
        for (int count = 0; count < EYES.length; count++) {
            Button button = (new ButtonVisuals("system/eyes/" + EYES[count])).getButton();
            int finalCount = count;
            int finalEyeCounter = eyeCounter;
            button.setOnAction(event -> buttonAction(finalCount, finalEyeCounter));
            setColourButtonPosition(button, eyeCounter - 1);
            if ((eyeCounter % 2) == 1) {
                count--;
            }
            eyeCounter++;
        }
    }

    // MODIFIES: this
    // EFFECTS: changes the cat's left eye colour and updates the CatModel
    private void buttonAction(int colourNum, int eyeCounter) {
        if (!((eyeCounter % 2) == 0)) {
            userCat.changeLeftEye(EYES[colourNum]);
        } else {
            userCat.changeRightEye(EYES[colourNum]);
        }
        refreshCatModel();
    }
}