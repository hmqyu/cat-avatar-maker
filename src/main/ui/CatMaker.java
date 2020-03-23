package ui;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.cat.Cat;

// Represents a Cat Avatar Maker application
public class CatMaker extends Application {

    // MODIFIES: this, stage
    // EFFECTS: begins the cat maker application by loading MenuPanel
    @Override
    public void start(Stage stage) {
        stage.setTitle("Cat Avatar Maker - Create Your Own Cat!");
        stage.getIcons().add(new Image("ui/images/system/CatAvatarMakerIcon.png"));
        new MenuPanel(stage, new Cat());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
