package ui;

import javafx.geometry.Pos;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import model.cat.Cat;

import java.util.ArrayList;

public class CatModel {
    private StackPane screen;
    private Cat userCat;
    private ImageView body;
    private ImageView face;
    private ImageView leftEye;
    private ImageView rightEye;
    private ImageView nose;
    private ImageView base;
    private ImageView pattern;
    private ArrayList<ImageView> accessories;
    private ImageView background;

    public CatModel(StackPane screen, Cat cat) {
        this.screen = screen;
        userCat = cat;
        loadCat();
    }

    private void loadCat() {
        renderBase();
        screen.getChildren().addAll(face, base);
        screen.setAlignment(Pos.CENTER_LEFT);
    }

    private void renderBase() {
        String baseColour = userCat.getBase();
        face = new ImageView();
        face.setImage(new Image("ui/images/cat/base/" + baseColour + "Face.png"));
        base = new ImageView();
        base.setImage(new Image("ui/images/cat/base/" + baseColour + "Base.png"));
    }

}
