package ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.cat.Cat;
import model.cat.CatCollection;

public class LoadPanel {
    public static final int WIDTH = 650;
    public static final int HEIGHT = 500;

    private CatCollection userCollection;
    private Stage currentStage;
    private StackPane loadScreen;
    private Cat userCat;

    public LoadPanel(Stage stage, CatCollection collection, Cat cat) {
        loadScreen = new StackPane();
        userCollection = collection;
        userCat = cat;
        loadSavedCats();
        loadBackButton();
        loadScreen.setStyle("-fx-background-color: #f5efed");
        currentStage = stage;
        currentStage.setScene(new Scene(loadScreen, WIDTH, HEIGHT));
        currentStage.show();
    }

    private void loadSavedCats() {
        VBox buttonBox = new VBox(10);
        for (int i = 0; i < userCollection.getCollection().size(); i++) {
            Button button = new Button(userCollection.getCatFromCollection(i).getName());
            int catNum = i;
            button.setOnAction(event -> new MakerPanel(currentStage, userCollection.getCatFromCollection(catNum),
                    userCollection));
            buttonBox.getChildren().add(button);
        }
        buttonBox.setAlignment(Pos.CENTER);
        ImageView selectImage = new ImageView();
        selectImage.setImage(new Image("ui/images/system/SelectACat.png"));
        VBox loadBox = new VBox();
        loadBox.getChildren().addAll(selectImage, buttonBox);
        loadBox.setAlignment(Pos.TOP_CENTER);
        loadScreen.getChildren().add(loadBox);
    }

    private void loadBackButton() {
        ImageView quitButtonImage = new ImageView();
        quitButtonImage.setImage(new Image("ui/images/system/BackButton.png"));
        Button backButton = new Button("", quitButtonImage);
        backButton.setStyle("-fx-background-color: transparent;");
        backButton.setOnAction(event -> new MenuPanel(currentStage, userCat));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        backButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> backButton.setEffect(shadow));
        backButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> backButton.setEffect(null));
        loadScreen.getChildren().add(backButton);
        backButton.setTranslateY(200);
    }

}
