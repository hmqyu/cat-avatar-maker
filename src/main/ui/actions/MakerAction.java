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
import ui.MakerPanel;

public class MakerAction {
    public static final String[] COLOURS = {"Black", "Brown", "Tortoiseshell", "Red", "Cream", "Blue", "Silver",
            "White"};
    protected static final int BUTTON_X_COORD = 390;
    protected Stage currentStage;
    protected StackPane makerScreen;
    protected Cat userCat;
    protected CatCollection userCollection;

    public MakerAction(Stage stage, StackPane screen, Cat cat, CatCollection collection) {
        currentStage = stage;
        makerScreen = screen;
        userCat = cat;
        userCollection = collection;
        loadOkayButton();
    }

    protected void loadOkayButton() {
        ImageView buttonImage = new ImageView();
        buttonImage.setImage(new Image("ui/images/system/OkayButton.png"));
        Button button = new Button("", buttonImage);
        button.setStyle("-fx-background-color: transparent;");
        button.setOnAction(event -> new MakerPanel(currentStage, userCat, userCollection));
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
