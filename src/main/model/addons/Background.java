package model.addons;

// Represents different available backgrounds for a cat
public class Background {
    private static final String EMPTY = "Empty";   // no/empty background
    private String background;                     // the current background

    // EFFECTS: creates an empty background for an object
    public Background() {
        this.background = EMPTY;
    }

    // EFFECTS: creates a background with background
    public Background(String background) {
        this.background = background;
    }

    // MODIFIES: this
    // EFFECTS: changes the current background image to background
    public void changeBackground(String background) {
        this.background = background;
    }

    // EFFECTS: returns the current background
    public String getBackground() {
        return background;
    }

}
