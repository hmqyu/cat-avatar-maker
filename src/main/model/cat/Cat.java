package model.cat;

import model.addons.Accessory;
import model.addons.Background;
import persistence.SaveData;
import persistence.SaveDataReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Represents a cat with a name, base colour, coat pattern, nose colour,
// eye colour, direction, any accessories, and a background
public class Cat implements SaveData {
    private String name;                // the cat's name, if any
    private String base;                // the cat's current base colour
    private String pattern;             // the cat's current coat pattern
    private String skin;                // the cat's current nose colour
    private String leftEye;             // the cat's current left eye colour
    private String rightEye;            // the cat's current right eye colour
    private CatDirection direction;     // the cat's current direction (where it's facing and turned to)
    private Accessory accessories;      // the cat's current accessories
    private Background background;      // the cat's current background

    // EFFECTS: creates a cat with no name (ie. "your cat") that is set to have
    //          a white base, solid pattern, pink nose, yellow eyes, facing forward and
    //          to the right as its direction, no accessories, and no background
    public Cat() {
        this.name = "your cat";
        this.base = "White";
        this.pattern = "Solid";
        this.skin = "Pink";
        this.leftEye = "Yellow";
        this.rightEye = "Yellow";
        this.direction = new CatDirection();
        this.accessories = new Accessory();
        this.background = new Background();
    }

    // EFFECTS: creates a cat with name, base, pattern, nose, eyes, direction, accessories, background
    public Cat(String name, String base, String pattern, String skin, String leftEye, String rightEye,
               CatDirection direction, Accessory accessories, Background background) {
        this.name = name;
        this.base = base;
        this.pattern = pattern;
        this.skin = skin;
        this.leftEye = leftEye;
        this.rightEye = rightEye;
        this.direction = direction;
        this.accessories = accessories;
        this.background = background;
    }

    // MODIFIES: this
    // EFFECTS: changes the name of a cat to name
    public void changeName(String name) {
        this.name = name;
    }

    // EFFECTS: returns the cat's current name
    public String getName() {
        return this.name;
    }

    // MODIFIES: this
    // EFFECTS: changes the base colour of a cat to base
    public void changeBase(String base) {
        this.base = base;
    }

    // EFFECTS: returns the cat's current base colour
    public String getBase() {
        return this.base;
    }

    // MODIFIES: this
    // EFFECTS: changes the coat pattern of a cat to pattern
    public void changePattern(String pattern) {
        this.pattern = pattern;
    }

    // EFFECTS: returns the cat's current coat pattern
    public String getPattern() {
        return this.pattern;
    }

    // MODIFIES: this
    // EFFECTS: changes the nose colour of a cat to nose
    public void changeSkin(String skin) {
        this.skin = skin;
    }

    // EFFECTS: returns the cat's current nose colour
    public String getSkin() {
        return this.skin;
    }

    // MODIFIES: this
    // EFFECTS: changes the eye colour of a cat to eyes
    public void changeLeftEye(String leftEye) {
        this.leftEye = leftEye;
    }

    // EFFECTS: returns the cat's current eye colour
    public String getLeftEye() {
        return this.leftEye;
    }

    // MODIFIES: this
    // EFFECTS: changes the eye colour of a cat to eyes
    public void changeRightEye(String rightEye) {
        this.rightEye = rightEye;
    }

    // EFFECTS: returns the cat's current eye colour
    public String getRightEye() {
        return this.rightEye;
    }

    // MODIFIES: this
    // EFFECTS: flips the side the cat is looking at
    public void flipDirection() {
        this.direction.flip();
    }

    // EFFECTS: returns the cat's current direction as a string
    public String getDirection() {
        return this.direction.getSide();
    }

    // MODIFIES: this
    // EFFECTS: if the cat isn't wearing the accessory, adds it and returns true
    //          otherwise, returns false
    public boolean addAccessory(String accessory) {
        return this.accessories.addAccessory(accessory);
    }

    // MODIFIES: this
    // EFFECTS: if the cat is wearing the accessory, removes it and returns true
    //          otherwise, returns false
    public boolean removeAccessory(String accessory) {
        return this.accessories.removeAccessory(accessory);
    }

    // EFFECTS: returns the ArrayList<String> within accessories
    public ArrayList<String> getAccessories() {
        return accessories.getAllAccessories();
    }

    // MODIFIES: this
    // EFFECTS: changes the background image of a cat to background
    public void changeBackground(String background) {
        this.background.changeBackground(background);
    }

    // EFFECTS: returns the cat's current background
    public String getBackground() {
        return this.background.getBackground();
    }

    // EFFECTS: saves all of a cat's fields to a file
    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(name);
        printWriter.print(SaveDataReader.DELIMITER);
        printWriter.print(base);
        printWriter.print(SaveDataReader.DELIMITER);
        printWriter.print(pattern);
        printWriter.print(SaveDataReader.DELIMITER);
        printWriter.print(skin);
        printWriter.print(SaveDataReader.DELIMITER);
        printWriter.print(leftEye);
        printWriter.print(SaveDataReader.DELIMITER);
        printWriter.print(rightEye);
        printWriter.print(SaveDataReader.DELIMITER);
        printWriter.print(direction.getSide());
        printWriter.print(SaveDataReader.DELIMITER);
        saveAccessory(printWriter);
        printWriter.print(SaveDataReader.DELIMITER);
        printWriter.println(background.getBackground());
    }

    // EFFECTS: saves all of a cat's accessories (if any) to a file
    private void saveAccessory(PrintWriter printWriter) {
        List<String> currentAccessories = accessories.getAllAccessories();
        if (currentAccessories.isEmpty()) {
            return;
        }
        int count;
        for (count = 0; count < currentAccessories.size() - 1; count++) {
            printWriter.print(currentAccessories.get(count));
            printWriter.print(SaveDataReader.ACCESSORY_DELIMITER);
        }
        printWriter.print(currentAccessories.get(count));
    }
}
