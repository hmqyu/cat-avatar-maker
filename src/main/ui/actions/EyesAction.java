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

// Represents an action panel for a cat's eye colours
public class EyesAction extends MakerAction {
    public static final String[] EYES = {"Copper", "Pink", "Yellow", "Green", "Blue"};   // all available eye colours
                                                                                         // for a cat

    // EFFECTS: creates an action panel that lets the user change a cat's eye colours
    public EyesAction(Stage stage, StackPane screen, Cat cat, CatCollection collection) {
        super(stage, screen, cat, collection);
        loadLeftColourButtons();
        loadRightColourButtons();
    }

    // MODIFIES: this
    // EFFECTS: loads and creates left eye colour buttons that let the user change the cat's left eye colour
    private void loadLeftColourButtons() {
        for (int count = 0; count < EYES.length; count++) {
            ImageView buttonImage = new ImageView();
            buttonImage.setImage(new Image("ui/images/system/eyes/" + EYES[count] + ".png"));
            Button button = new Button("", buttonImage);
            button.setStyle("-fx-background-color: transparent;");
            int finalCount = count;
            button.setOnAction(event -> leftButtonAction(finalCount));
            DropShadow shadow = new DropShadow();
            shadow.setColor(Color.web("0xc98d92"));
            button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    event -> button.setEffect(shadow));
            button.addEventHandler(MouseEvent.MOUSE_EXITED,
                    event -> button.setEffect(null));
            makerScreen.getChildren().add(button);
            button.setTranslateX(BUTTON_X_COORD);
            button.setTranslateY(-225 + (count * 50));
        }
    }

    // MODIFIES: this
    // EFFECTS: loads and creates right eye colour buttons that let the user change the cat's right eye colour
    private void loadRightColourButtons() {
        for (int count = 0; count < EYES.length; count++) {
            ImageView buttonImage = new ImageView();
            buttonImage.setImage(new Image("ui/images/system/eyes/" + EYES[count] + ".png"));
            Button button = new Button("", buttonImage);
            button.setStyle("-fx-background-color: transparent;");
            int finalCount = count;
            button.setOnAction(event -> rightButtonAction(finalCount));
            DropShadow shadow = new DropShadow();
            shadow.setColor(Color.web("0xc98d92"));
            button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    event -> button.setEffect(shadow));
            button.addEventHandler(MouseEvent.MOUSE_EXITED,
                    event -> button.setEffect(null));
            makerScreen.getChildren().add(button);
            button.setTranslateX(BUTTON_X_COORD + 125);
            button.setTranslateY(-225 + (count * 50));
        }
    }

    // MODIFIES: this
    // EFFECTS: changes the cat's left eye colour and updates the CatModel
    private void leftButtonAction(int colourNum) {
        userCat.changeLeftEye(EYES[colourNum]);
        new CatModel(currentStage, makerScreen, userCat);
    }

    // MODIFIES: this
    // EFFECTS: changes the cat's right eye colour and updates the CatModel
    private void rightButtonAction(int colourNum) {
        userCat.changeRightEye(EYES[colourNum]);
        new CatModel(currentStage, makerScreen, userCat);
    }
}