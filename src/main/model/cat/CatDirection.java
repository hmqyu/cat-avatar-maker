package model.cat;

// Represents which way the cat is facing and which side the cat is turned to
public class CatDirection {
    private static final String LEFT = "left";           // to the left side
    private static final String RIGHT = "right";         // to the right side

    private String side;     // the current side the cat is turned to

    // EFFECTS: creates a direction facing forward and turned to the right side
    public CatDirection() {
        this.side = LEFT;
    }

    // EFFECTS: creates a direction with facing and side
    public CatDirection(String side) {
        this.side = side;
    }

    // MODIFIES: this
    // EFFECTS: flips the cat to the opposite side
    public void flip() {
        if (side.equals(LEFT)) {
            this.side = RIGHT;
            return;
        }
        this.side = LEFT;
    }

    // EFFECTS: returns the side the cat is turned to
    public String getSide() {
        return this.side;
    }

}
