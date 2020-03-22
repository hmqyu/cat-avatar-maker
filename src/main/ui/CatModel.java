package ui;

import javafx.geometry.Pos;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.addons.Accessory;
import model.addons.Background;
import model.cat.Cat;
import model.cat.CatDirection;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CatModel {
    private Stage currentStage;
    protected StackPane screen;
    protected Cat userCat;
    protected String isFlipped;
    protected ImageView body;
    protected ImageView face;
    protected ImageView leftEye;
    protected ImageView rightEye;
    protected ImageView skin;
    protected ImageView base;
    protected ImageView pattern;
    protected ArrayList<ImageView> accessories;
    protected ImageView background;

    public CatModel(Stage stage, StackPane screen, Cat cat) {
        currentStage = stage;
        this.screen = screen;
        userCat = cat;
        isFlipped = cat.getDirection();
        accessories = new ArrayList<>();
        loadCat();
    }

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

    protected void renderBackground() {
        String backgroundScene = userCat.getBackground();
        background = new ImageView();
        background.setImage(new Image("ui/images/backgrounds/" + backgroundScene + "Background.png"));
    }

    protected void renderBase() {
        String baseColour = userCat.getBase();
        face = new ImageView();
        face.setImage(new Image("ui/images/cat/base/" + baseColour + "Face.png"));
        base = new ImageView();
        base.setImage(new Image("ui/images/cat/base/" + baseColour + "Base.png"));
        body = new ImageView();
        body.setImage(new Image("ui/images/cat/base/BodyLine.png"));
    }

    protected void renderEyes() {
        String leftEyeColour = userCat.getLeftEye();
        leftEye = new ImageView();
        leftEye.setImage(new Image("ui/images/cat/eyes/" + leftEyeColour + "Left.png"));

        String rightEyeColour = userCat.getRightEye();
        rightEye = new ImageView();
        rightEye.setImage(new Image("ui/images/cat/eyes/" + rightEyeColour + "Right.png"));
    }

    protected void renderSkin() {
        String skinColour = userCat.getSkin();
        skin = new ImageView();
        skin.setImage(new Image("ui/images/cat/skin/" + skinColour + "Skin.png"));
    }

    protected void renderPattern() {
        String patternColour = userCat.getPattern();
        pattern = new ImageView();
        if (patternColour.equals("TortoiseshellTabby")) {
            pattern.setImage(new Image("ui/images/cat/pattern/BrownTabby.png"));
        } else if (!patternColour.equals("Solid")) {
            pattern.setImage(new Image("ui/images/cat/pattern/" + patternColour + ".png"));
        }
    }

    protected void renderAccessories() {
        ArrayList<String> accessoriesList = userCat.getAccessoriesList();
        for (String accessory : accessoriesList) {
            ImageView accessoryImage = new ImageView();
            accessoryImage.setImage(new Image("ui/images/accessories/" + accessory + ".png"));
            accessories.add(accessoryImage);
        }
    }

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
