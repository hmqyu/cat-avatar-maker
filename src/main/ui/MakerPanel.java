package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.cat.Cat;

public class MakerPanel {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    private Stage currentStage;
    private StackPane makerScreen;
    private CatModel catModel;
    private Button baseButton;
    private Button patternButton;
    private Button eyesButton;
    private Button skinButton;
    private Button flipButton;
    private Button accessoriesButton;
    private Button backgroundButton;
    private Button saveButton;
    private Button menuButton;

    public MakerPanel(Stage stage, Cat cat) {
        makerScreen = new StackPane();
        catModel = new CatModel(makerScreen, cat);
        loadMakerButtons();
        makerScreen.setStyle("-fx-background-color: #f5efed");
        currentStage = stage;
        currentStage.setScene(new Scene(makerScreen, WIDTH, HEIGHT));
        currentStage.show();
    }

    private void loadMakerButtons() {
        makeBaseButton();
        makePatternButton();
        makeEyesButton();
        makeSkinButton();
        makeAccessoriesButton();
        makeBackgroundButton();
        makeFlipButton();
        makeSaveButton();
        makeMenuButton();
        ImageView divider = new ImageView();
        divider.setImage(new Image("ui/images/system/Divider.png"));
        setPositions(divider);
    }

    private void makeBaseButton() {
        ImageView baseButtonImage = new ImageView();
        baseButtonImage.setImage(new Image("ui/images/system/BaseColour.png"));
        baseButton = new Button("", baseButtonImage);
        baseButton.setStyle("-fx-background-color: transparent;");
        //baseButton.setOnAction(event -> new BaseAction(currentStage));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        baseButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> baseButton.setEffect(shadow));
        baseButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> baseButton.setEffect(null));
    }

    private void makePatternButton() {
        ImageView patternButtonImage = new ImageView();
        patternButtonImage.setImage(new Image("ui/images/system/CoatPattern.png"));
        patternButton = new Button("", patternButtonImage);
        patternButton.setStyle("-fx-background-color: transparent;");
        patternButton.setOnAction(event -> System.out.println("woo"));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        patternButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> patternButton.setEffect(shadow));
        patternButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> patternButton.setEffect(null));
    }

    private void makeEyesButton() {
        ImageView eyesButtonImage = new ImageView();
        eyesButtonImage.setImage(new Image("ui/images/system/EyeColour.png"));
        eyesButton = new Button("", eyesButtonImage);
        eyesButton.setStyle("-fx-background-color: transparent;");
        eyesButton.setOnAction(event -> System.out.println("woo"));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        eyesButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> eyesButton.setEffect(shadow));
        eyesButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> eyesButton.setEffect(null));
    }

    private void makeSkinButton() {
        ImageView skinButtonImage = new ImageView();
        skinButtonImage.setImage(new Image("ui/images/system/SkinColour.png"));
        skinButton = new Button("", skinButtonImage);
        skinButton.setStyle("-fx-background-color: transparent;");
        skinButton.setOnAction(event -> System.out.println("woo"));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        skinButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> skinButton.setEffect(shadow));
        skinButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> skinButton.setEffect(null));
    }

    private void makeAccessoriesButton() {
        ImageView accessoryButtonImage = new ImageView();
        accessoryButtonImage.setImage(new Image("ui/images/system/Accessories.png"));
        accessoriesButton = new Button("", accessoryButtonImage);
        accessoriesButton.setStyle("-fx-background-color: transparent;");
        accessoriesButton.setOnAction(event -> System.out.println("woo"));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        accessoriesButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> accessoriesButton.setEffect(shadow));
        accessoriesButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> accessoriesButton.setEffect(null));
    }

    private void makeBackgroundButton() {
        ImageView backgroundButtonImage = new ImageView();
        backgroundButtonImage.setImage(new Image("ui/images/system/Background.png"));
        backgroundButton = new Button("", backgroundButtonImage);
        backgroundButton.setStyle("-fx-background-color: transparent;");
        backgroundButton.setOnAction(event -> System.out.println("woo"));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        backgroundButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> backgroundButton.setEffect(shadow));
        backgroundButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> backgroundButton.setEffect(null));
    }

    private void makeFlipButton() {
        ImageView flipButtonImage = new ImageView();
        flipButtonImage.setImage(new Image("ui/images/system/FlipDirection.png"));
        flipButton = new Button("", flipButtonImage);
        flipButton.setStyle("-fx-background-color: transparent;");
        flipButton.setOnAction(event -> System.out.println("woo"));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        flipButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> flipButton.setEffect(shadow));
        flipButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> flipButton.setEffect(null));
    }

    private void makeSaveButton() {
        ImageView saveButtonImage = new ImageView();
        saveButtonImage.setImage(new Image("ui/images/system/SaveCat.png"));
        saveButton = new Button("", saveButtonImage);
        saveButton.setStyle("-fx-background-color: transparent;");
        saveButton.setOnAction(event -> System.out.println("woo"));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        saveButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> saveButton.setEffect(shadow));
        saveButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> saveButton.setEffect(null));
    }

    private void makeMenuButton() {
        ImageView menuButtonImage = new ImageView();
        menuButtonImage.setImage(new Image("ui/images/system/MenuScreen.png"));
        menuButton = new Button("", menuButtonImage);
        menuButton.setStyle("-fx-background-color: transparent;");
        menuButton.setOnAction(event -> new MenuPanel(currentStage));
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("0xc98d92"));
        menuButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                event -> menuButton.setEffect(shadow));
        menuButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                event -> menuButton.setEffect(null));
    }

    private void setPositions(ImageView divider) {
        makerScreen.getChildren().addAll(baseButton, patternButton, eyesButton, skinButton, accessoriesButton,
                backgroundButton, flipButton, divider, saveButton, menuButton);
        baseButton.setTranslateX(440);
        baseButton.setTranslateY(-225);
        patternButton.setTranslateX(440);
        patternButton.setTranslateY(-175);
        eyesButton.setTranslateX(440);
        eyesButton.setTranslateY(-125);
        skinButton.setTranslateX(440);
        skinButton.setTranslateY(-75);
        accessoriesButton.setTranslateX(440);
        accessoriesButton.setTranslateY(-25);
        backgroundButton.setTranslateX(440);
        backgroundButton.setTranslateY(25);
        flipButton.setTranslateX(440);
        flipButton.setTranslateY(75);
        divider.setTranslateX(450);
        divider.setTranslateY(125);
        saveButton.setTranslateX(440);
        saveButton.setTranslateY(175);
        menuButton.setTranslateX(440);
        menuButton.setTranslateY(225);
    }

}
