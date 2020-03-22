package model.addons;

// Represents different available backgrounds
public class Background {
    private static final String EMPTY = "Empty";           // no background
    private static final String HOME = "Home";             // home background
    private static final String FOREST = "Forest";         // forest background
    private static final String BEACH = "Beach";           // beach background
    private static final String NIGHTTIME = "Nighttime";   // nighttime background

    private static final String[] BACKGROUNDS = {EMPTY, HOME, FOREST, BEACH, NIGHTTIME};   // all usable backgrounds

    private String background;   // the current background

    // EFFECTS: creates an empty background for an object
    public Background() {
        this.background = EMPTY;
    }

    // EFFECTS: creates a background with background
    public Background(String background) {
        this.background = background;
    }

    // MODIFIES: this
    // EFFECTS: changes the current background to the given one if in BACKGROUNDS, and returns true
    //          otherwise, returns false
    public boolean changeBackground(String background) {
        for (String s : BACKGROUNDS) {
            if (s.equals(background)) {
                this.background = s;
                return true;
            }
        }
        return false;
    }

    // EFFECTS: returns the current background
    public String getBackground() {
        return background;
    }

    // MODIFIES: this
    // EFFECTS: deletes the current background
    public void deleteBackground() {
        this.background = EMPTY;
    }

    // EFFECTS: returns true if the background is empty
    public boolean noBackground() {
        return background.equals(EMPTY);
    }
}
