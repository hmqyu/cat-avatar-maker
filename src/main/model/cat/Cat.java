package model.cat;

import model.addons.Accessory;
import model.addons.Background;
import persistence.SaveData;
import persistence.SaveDataReader;

import java.io.PrintWriter;
import java.util.ArrayList;

// Represents a cat with a name, base colour, coat pattern, nose colour,
// eye colour, direction, any accessories, and a background
public class Cat implements SaveData {
    private String name;                // the cat's name, if any
    private String base;                // the cat's current base colour
    private String pattern;             // the cat's current coat pattern
    private String nose;                // the cat's current nose colour
    private String eyes;                // the cat's current eye colour
    private CatDirection direction;     // the cat's current direction (where it's facing and turned to)
    private Accessory accessories;      // the cat's current accessories
    private Background background;      // the cat's current background

    // EFFECTS: creates a cat with no name (ie. "your cat") that is set to have
    //          a white base, solid pattern, pink nose, yellow eyes, facing forward and
    //          to the right as its direction, no accessories, and no background
    public Cat() {
        this.name = "your cat";
        this.base = "white";
        this.pattern = "solid";
        this.nose = "pink";
        this.eyes = "yellow";
        this.direction = new CatDirection();
        this.accessories = new Accessory();
        this.background = new Background();
    }

    // EFFECTS: creates a cat with name, base, pattern, nose, eyes, direction, accessories, background
    public Cat(String name, String base, String pattern, String nose, String eyes,
               CatDirection direction, Accessory accessories, Background background) {
        this.name = name;
        this.base = base;
        this.pattern = pattern;
        this.nose = nose;
        this.eyes = eyes;
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
    public void changeNose(String nose) {
        this.nose = nose;
    }

    // EFFECTS: returns the cat's current nose colour
    public String getNose() {
        return this.nose;
    }

    // MODIFIES: this
    // EFFECTS: changes the eye colour of a cat to eyes
    public void changeEyes(String eyes) {
        this.eyes = eyes;
    }

    // EFFECTS: returns the cat's current eye colour
    public String getEyes() {
        return this.eyes;
    }

    // MODIFIES: this
    // EFFECTS: flips the side the cat is looking at
    public void flipDirection() {
        this.direction.flip();
    }

    // MODIFIES: this
    // EFFECTS: turns the cat around to change where it's facing
    public void turnDirection() {
        this.direction.turn();
    }

    // EFFECTS: returns the cat's current direction as a string
    public String getDirection() {
        return this.direction.getFacing() + " and to the " + this.direction.getSide();
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

    // MODIFIES: this
    // EFFECTS: removes all accessories from a cat
    public void removeAllAccessories() {
        this.accessories.removeAllAccessories();
    }

    // EFFECTS: if the cat has no accessories, returns "no accessories"
    //          otherwise, returns the cat's current accessories
    public String getAllAccessories() {
        ArrayList<String> accessoriesArray = accessories.getAllAccessories();
        if (accessoriesArray.isEmpty()) {
            return "no accessories";
        } else if (accessoriesArray.size() == 1) {
            return addArticle(accessoriesArray.get(0));
        }
        String accessoriesString = "";
        int count;
        for (count = 0; count < accessoriesArray.size() - 1; count++) {
            accessoriesString += addArticle(accessoriesArray.get(count)) + ", ";
        }
        accessoriesString += "and " + addArticle(accessoriesArray.get(count));
        return accessoriesString;
    }

    // EFFECTS: returns word with its correct indefinite article
    private String addArticle(String word) {
        String firstLetter = word.substring(0, 1);
        String lastLetter = word.substring(word.length() - 1);
        String article = "a ";
        if (firstLetter.equals("a") || firstLetter.equals("e") || firstLetter.equals("i")
                || firstLetter.equals("o") || firstLetter.equals("u")) {
            article = "an ";
        }
        if (lastLetter.equals("s")) {
            article = "";
        }
        return article + word;
    }

    // MODIFIES: this
    // EFFECTS: if background is available, changes the background of a cat and returns true
    //          otherwise, returns false
    public boolean changeBackground(String background) {
        return this.background.changeBackground(background);
    }

    // MODIFIES: this
    // EFFECTS: removes the cat's background
    public void removeBackground() {
        this.background.deleteBackground();
    }

    // EFFECTS: returns true if the cat's background is empty
    public boolean emptyBackground() {
        return background.noBackground();
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
        printWriter.print(nose);
        printWriter.print(SaveDataReader.DELIMITER);
        printWriter.print(eyes);
        printWriter.print(SaveDataReader.DELIMITER);
        saveDirection(printWriter);
        printWriter.print(SaveDataReader.DELIMITER);
        saveAccessory(printWriter);
        printWriter.print(SaveDataReader.DELIMITER);
        printWriter.println(background.getBackground());
    }

    // EFFECTS: saves a cat's direction to a file
    private void saveDirection(PrintWriter printWriter) {
        printWriter.print(direction.getFacing());
        printWriter.print(SaveDataReader.DELIMITER);
        printWriter.print(direction.getSide());
    }

    // EFFECTS: saves all of a cat's accessories (if any) to a file
    private void saveAccessory(PrintWriter printWriter) {
        ArrayList<String> currentAccessories = accessories.getAllAccessories();
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
