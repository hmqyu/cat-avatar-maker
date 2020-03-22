package ui;

import javafx.geometry.Pos;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import model.addons.Accessory;
import model.addons.Background;
import model.cat.Cat;
import model.cat.CatDirection;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CatModel {
    private StackPane screen;
    private Cat userCat;
    private ImageView body;
    private ImageView face;
    private ImageView leftEye;
    private ImageView rightEye;
    private ImageView skin;
    private ImageView base;
    private ImageView pattern;
    private ArrayList<ImageView> accessories;
    private ImageView background;

    public CatModel(StackPane screen, Cat cat) {
        this.screen = screen;
        userCat = cat;
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
        screen.getChildren().addAll(background, base, skin, face, leftEye, rightEye, pattern, body);
        for (ImageView accessory : accessories) {
            screen.getChildren().add(accessory);
        }
        screen.setAlignment(Pos.CENTER_LEFT);
    }

    private void renderBackground() {
        String backgroundScene = userCat.getBackground();
        background = new ImageView();
        if (!backgroundScene.equals("Empty")) {
            background.setImage(new Image("ui/images/backgrounds/" + backgroundScene + "Background.png"));
        }
    }

    private void renderBase() {
        String baseColour = userCat.getBase();
        face = new ImageView();
        face.setImage(new Image("ui/images/cat/base/" + baseColour + "Face.png"));
        base = new ImageView();
        base.setImage(new Image("ui/images/cat/base/" + baseColour + "Base.png"));
        body = new ImageView();
        body.setImage(new Image("ui/images/cat/base/BodyLine.png"));
    }

    private void renderEyes() {
        String leftEyeColour = userCat.getLeftEye();
        leftEye = new ImageView();
        leftEye.setImage(new Image("ui/images/cat/eyes/" + leftEyeColour + "Left.png"));

        String rightEyeColour = userCat.getRightEye();
        rightEye = new ImageView();
        rightEye.setImage(new Image("ui/images/cat/eyes/" + rightEyeColour + "Right.png"));
    }

    private void renderSkin() {
        String skinColour = userCat.getSkin();
        skin = new ImageView();
        skin.setImage(new Image("ui/images/cat/skin/" + skinColour + "Skin.png"));
    }

    private void renderPattern() {
        String patternColour = userCat.getPattern();
        pattern = new ImageView();
        if (!patternColour.equals("Solid")) {
            pattern.setImage(new Image("ui/images/cat/pattern/" + patternColour + ".png"));
        }
    }

    private void renderAccessories() {
        ArrayList<String> accessoriesList = userCat.getAccessoriesList();
        for (String accessory : accessoriesList) {
            ImageView accessoryImage = new ImageView();
            accessoryImage.setImage(new Image("ui/images/accessories/" + accessory + ".png"));
            accessories.add(accessoryImage);
        }
    }

}
