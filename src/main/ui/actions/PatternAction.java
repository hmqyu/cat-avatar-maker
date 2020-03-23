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

// Represents an action panel for a cat's coat pattern
public class PatternAction extends MakerAction {
    public static final String[] PATTERNS = {"BlackTabby", "BrownTabby", "PointPattern", "RedTabby", "CreamTabby",
            "BlueTabby", "SilverTabby", "WhitePattern"};

    // EFFECTS: creates an action panel that lets the user change a cat's coat pattern
    public PatternAction(Stage stage, StackPane screen, Cat cat, CatCollection collection) {
        super(stage, screen, cat, collection);
        loadColourButtons();
    }

    // MODIFIES: this
    // EFFECTS: loads and creates coat pattern buttons that let the user change the cat's coat pattern
    private void loadColourButtons() {
        int addY = -50;
        for (int count = 0; count < COLOURS.length; count++) {
            ImageView buttonImage = new ImageView();
            buttonImage.setImage(new Image("ui/images/system/colours/" + COLOURS[count] + ".png"));
            Button button = new Button("", buttonImage);
            button.setStyle("-fx-background-color: transparent;");
            int finalCount = count;
            button.setOnAction(event -> buttonAction(finalCount));
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

    // MODIFIES: this
    // EFFECTS: changes the cat's coat pattern and updates the CatModel
    private void buttonAction(int colourNum) {
        userCat.changePattern(PATTERNS[colourNum]);
        new CatModel(currentStage, makerScreen, userCat);
    }
}