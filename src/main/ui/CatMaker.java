package ui;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class CatMaker extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Cat Avatar Maker - Create Your Own Cat!");
        stage.getIcons().add(new Image("ui/images/CatAvatarMakerIcon.png"));
        TitlePanel title = new TitlePanel(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
