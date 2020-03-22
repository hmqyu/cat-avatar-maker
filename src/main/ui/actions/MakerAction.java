package ui.actions;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MakerAction {
    public static final String[] COLOURS = {"Black", "Brown", "Tortoiseshell", "Red", "Cream", "Blue", "Silver",
            "White"};
    private static final int BUTTON_X_COORD = 390;
    private StackPane makerScreen;

    public MakerAction(StackPane screen, String[] colours) {
        makerScreen = screen;
        loadButtons(colours);
    }

    private void loadButtons(String[] colours) {
        int addY = -50;
        for (int count = 0; count < colours.length; count++) {
            Button button;
            ImageView buttonImage = new ImageView();
            buttonImage.setImage(new Image("ui/images/system/colours/" + colours[count] + ".png"));
            button = new Button("", buttonImage);
            button.setStyle("-fx-background-color: transparent;");
            button.setOnAction(event -> buttonAction(button));
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

    private void buttonAction(Button button) {
        makerScreen.getChildren().remove(button);
        button = null;
    }
}
