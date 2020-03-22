package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelpPanel {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    private Stage currentStage;
    private StackPane helpScreen;
    private Button backButton;

    public HelpPanel(Stage stage) {
        helpScreen = new StackPane();
        // Background code from: https://stackoverflow.com/questions/9738146/javafx-how-to-set-scene-background-image
        BackgroundImage helpScreenBackground = new BackgroundImage(new Image("ui/images/system/HelpScreen.png"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        loadBackButton();
        helpScreen.setBackground(new Background(helpScreenBackground));
        currentStage = stage;
        currentStage.setScene(new Scene(helpScreen, WIDTH, HEIGHT));
        currentStage.show();
    }

    private void loadBackButton() {
        makeBackButton();
        helpScreen.getChildren().add(backButton);
        backButton.setTranslateX(185);
        backButton.setTranslateY(155);
    }

    private void makeBackButton() {
        ImageView quitButtonImage = new ImageView();
        quitButtonImage.setImage(new Image("ui/images/system/BackButton.png"));
        backButton = new Button("", quitButtonImage);
        backButton.setStyle("-fx-background-color: transparent;");
        backButton.setOnAction(event -> new MenuPanel(currentStage));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        backButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> backButton.setEffect(shadow));
        backButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> backButton.setEffect(null));
    }
}
