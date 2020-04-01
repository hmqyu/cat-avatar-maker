package ui;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.cat.Cat;

import java.util.ArrayList;

// Represents a cat avatar
public class CatModel {
    private Stage currentStage;                   // the current stage
    protected StackPane screen;                   // the current screen (makerScreen)
    protected Cat userCat;                        // the user's current cat
    protected String isFlipped;                   // the cat's current direction
    protected ImageView body;                     // the cat's current body image
    protected ImageView face;                     // the cat's current face lines image
    protected ImageView leftEye;                  // the cat's current left eye image
    protected ImageView rightEye;                 // the cat's current right eye image
    protected ImageView skin;                     // the cat's current skin image
    protected ImageView base;                     // the cat's current base colour image
    protected ImageView pattern;                  // the cat's current coat pattern image
    protected ArrayList<ImageView> accessories;   // the cat's current accessories's images
    protected ImageView background;               // the cat's current background image

    // EFFECTS: creates a cat avatar from cat
    //          stage becomes the currentStage
    //          screen becomes the current screen to apply the cat avatar to
    //          cat becomes the user's current cat (userCat)
    public CatModel(Stage stage, StackPane screen, Cat cat) {
        currentStage = stage;
        this.screen = screen;
        userCat = cat;
        isFlipped = cat.getDirection();
        accessories = new ArrayList<>();
        loadCat();
    }

    // MODIFIES: this
    // EFFECTS: loads the cat's body, face, eyes, skin, base, pattern, accessories, and background images onto screen
    private void loadCat() {
        renderBackground();
        renderBase();
        renderEyes();
        renderSkin();
        renderPattern();
        renderAccessories();
        if (isFlipped.equals("right")) {
            flipModel();
        }
        screen.getChildren().addAll(background, base, pattern, skin, face, leftEye, rightEye, body);
        for (ImageView accessory : accessories) {
            screen.getChildren().add(accessory);
        }
        screen.setAlignment(Pos.CENTER_LEFT);
        if (userCat.getBase().equals("White") && userCat.getRightEye().equals("Blue")
                && (userCat.getLeftEye().equals("Yellow"))) {
            currentStage.getIcons().add(new Image("ui/images/system/snas.png"));
            currentStage.setTitle("it's a beautiful day outside.");
        }
    }

    // MODIFIES: this
    // EFFECTS: creates and renders the cat's background image
    protected void renderBackground() {
        String backgroundScene = userCat.getBackground();
        background = new ImageView();
        background.setImage(new Image("ui/images/backgrounds/" + backgroundScene + "Background.png"));
    }

    // MODIFIES: this
    // EFFECTS: creates and renders the cat's base and face lines images
    protected void renderBase() {
        String baseColour = userCat.getBase();
        face = new ImageView();
        face.setImage(new Image("ui/images/cat/base/" + baseColour + "Face.png"));
        base = new ImageView();
        base.setImage(new Image("ui/images/cat/base/" + baseColour + "Base.png"));
        body = new ImageView();
        body.setImage(new Image("ui/images/cat/base/BodyLine.png"));
    }

    // MODIFIES: this
    // EFFECTS: creates and renders the cat's eye images
    protected void renderEyes() {
        String leftEyeColour = userCat.getLeftEye();
        leftEye = new ImageView();
        leftEye.setImage(new Image("ui/images/cat/eyes/" + leftEyeColour + "Left.png"));

        String rightEyeColour = userCat.getRightEye();
        rightEye = new ImageView();
        rightEye.setImage(new Image("ui/images/cat/eyes/" + rightEyeColour + "Right.png"));
    }

    // MODIFIES: this
    // EFFECTS: creates and renders the cat's skin image
    protected void renderSkin() {
        String skinColour = userCat.getSkin();
        skin = new ImageView();
        skin.setImage(new Image("ui/images/cat/skin/" + skinColour + "Skin.png"));
    }

    // MODIFIES: this
    // EFFECTS: creates and renders the cat's pattern image
    protected void renderPattern() {
        String patternColour = userCat.getPattern();
        pattern = new ImageView();
        if (patternColour.equals("TortoiseshellTabby")) {
            pattern.setImage(new Image("ui/images/cat/pattern/BrownTabby.png"));
        } else if (!patternColour.equals("Solid")) {
            pattern.setImage(new Image("ui/images/cat/pattern/" + patternColour + ".png"));
        }
    }

    // MODIFIES: this
    // EFFECTS: creates and renders the cat's accessories' images
    protected void renderAccessories() {
        ArrayList<String> accessoriesList = userCat.getAccessories();
        for (String accessory : accessoriesList) {
            ImageView accessoryImage = new ImageView();
            accessoryImage.setImage(new Image("ui/images/accessories/" + accessory + ".png"));
            accessories.add(accessoryImage);
        }
    }

    // MODIFIES: this
    // EFFECTS: flips the cat avatar images from left to right, and vice versa
    protected void flipModel() {
        body.setScaleX(-1);
        face.setScaleX(-1);
        leftEye.setScaleX(-1);
        rightEye.setScaleX(-1);
        skin.setScaleX(-1);
        base.setScaleX(-1);
        pattern.setScaleX(-1);
        for (ImageView accessory : accessories) {
            accessory.setScaleX(-1);
        }
    }

}
