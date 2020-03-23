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
import ui.CatModel;

// Represents an action panel for a cat's wearable accessories
public class AccessoriesAction extends MakerAction {
    public static final String[] ACCESSORIES = {"Bag", "Bow", "Hat", "Horns", "LeftHoopEarring", "RightHoopEarring",
            "LeftStudEarring", "RightStudEarring", "Mask", "Scarf", "Wings"};   // all available accessories for a cat

    // EFFECTS: creates an action panel that lets the user add and remove accessories to a cat
    public AccessoriesAction(Stage stage, StackPane screen, Cat cat, CatCollection collection) {
        super(stage, screen, cat, collection);
        loadColourButtons();
    }

    // MODIFIES: this
    // EFFECTS: loads and creates accessory buttons that let the user add and remove accessories to a cat
    private void loadColourButtons() {
        int addY = -50;
        for (int count = 0; count < ACCESSORIES.length; count++) {
            ImageView buttonImage = new ImageView();
            buttonImage.setImage(new Image("ui/images/system/accessories/" + ACCESSORIES[count] + ".png"));
            Button button = new Button("", buttonImage);
            button.setStyle("-fx-background-color: transparent;");
            int finalCount = count;
            button.setOnAction(event -> buttonAction(finalCount, button));
            DropShadow shadow = new DropShadow();
            shadow.setColor(Color.web("0xc98d92"));
            button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    event -> button.setEffect(shadow));
            button.addEventHandler(MouseEvent.MOUSE_EXITED,
                    event -> button.setEffect(null));
            makerScreen.getChildren().add(button);
            if (!((count + 1) % 2 == 0)) {
                button.setTranslateX(BUTTON_X_COORD);
                addY += 50;
            } else {
                button.setTranslateX(BUTTON_X_COORD + 125);
            }
            button.setTranslateY(-225 + addY);
        }
    }

    // MODIFIES: this, button
    // EFFECTS: adds an accessory to the cat and updates the CatModel
    //          changes the button to a remove accessory button
    private void buttonAction(int colourNum, Button button) {
        userCat.addAccessory(ACCESSORIES[colourNum]);
        new CatModel(currentStage, makerScreen, userCat);
        button.setOnAction(event -> removeButtonAction(colourNum, button));
    }

    // MODIFIES: this, button
    // EFFECTS: removes an accessory from the cat and updates the CatModel
    //          changes the button to an add accessory button
    private void removeButtonAction(int colourNum, Button button) {
        userCat.removeAccessory(ACCESSORIES[colourNum]);
        new CatModel(currentStage, makerScreen, userCat);
        button.setOnAction(event -> buttonAction(colourNum, button));
    }

}