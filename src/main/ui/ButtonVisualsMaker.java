package ui;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

// Adds different effects for buttons specific to the CatMaker program
public class ButtonVisualsMaker {
    private Button button;

    // EFFECTS: creates a button and its visuals with the help of imageURL
    public ButtonVisualsMaker(String imageURL) {
        ImageView buttonImage = new ImageView();
        buttonImage.setImage(new Image("ui/images/" + imageURL + ".png"));
        button = new Button("", buttonImage);
        button.setStyle("-fx-background-color: transparent;");
        addButtonDropShadow(button);
    }

    // MODIFIES: this
    // EFFECTS: adds drop shadow when the cursor hovers over the button
    private void addButtonDropShadow(Button button) {
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> button.setEffect(shadow));
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> button.setEffect(null));
    }

    // EFFECTS: returns button
    public Button getButton() {
        return button;
    }

}
