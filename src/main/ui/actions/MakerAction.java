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
import ui.CatModel;
import ui.MakerPanel;

import java.util.ArrayList;

public class MakerAction {
    public static final String[] COLOURS = {"Black", "Brown", "Tortoiseshell", "Red", "Cream", "Blue", "Silver",
            "White"};
    private static final int BUTTON_X_COORD = 390;
    private Stage currentStage;
    private StackPane makerScreen;
    private ArrayList<Button> buttons;
    private Cat userCat;

    public MakerAction(Stage stage, StackPane screen, String[] colours, Cat cat) {
        currentStage = stage;
        makerScreen = screen;
        buttons = new ArrayList<>();
        userCat = cat;
        loadColourButtons(colours);
        loadOkayButton();
    }

    private void loadColourButtons(String[] colours) {
        int addY = -50;
        for (int count = 0; count < colours.length; count++) {
            ImageView buttonImage = new ImageView();
            buttonImage.setImage(new Image("ui/images/system/colours/" + colours[count] + ".png"));
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

    private void buttonAction(int colourNum) {
        userCat.changeBase(COLOURS[colourNum]);
        new CatModel(makerScreen, userCat);
    }

    private void loadOkayButton() {
        ImageView buttonImage = new ImageView();
        buttonImage.setImage(new Image("ui/images/system/OkayButton.png"));
        Button button = new Button("", buttonImage);
        button.setStyle("-fx-background-color: transparent;");
        button.setOnAction(event -> new MakerPanel(currentStage, userCat));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> button.setEffect(shadow));
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> button.setEffect(null));
        makerScreen.getChildren().add(button);
        button.setTranslateX(BUTTON_X_COORD);
        button.setTranslateY(200);
    }
}
