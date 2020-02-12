package model.cat;

// Represents which way the cat is facing and which side the cat is turned to
public class CatDirection {
    private static final String FORWARD = "forward";     // facing forwards
    private static final String BACKWARD = "backward";   // facing backwards
    private static final String LEFT = "left";           // to the left side
    private static final String RIGHT = "right";         // to the right side
    
    private String facing;   // the current way the cat is facing
    private String side;     // the current side the cat is turned to

    // EFFECTS: creates a direction facing forward and turned to the right side
    public CatDirection() {
        this.facing = FORWARD;
        this.side = RIGHT;
    }

    // MODIFIES: this
    // EFFECTS: turns the cat around to face the opposite way
    public void turn() {
        if (facing.equals(FORWARD)) {
            this.facing = BACKWARD;
            return;
        }
        this.facing = FORWARD;
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

    // EFFECTS: returns the way the cat is facing
    public String getFacing() {
        return this.facing;
    }

    // EFFECTS: returns the side the cat is turned to
    public String getSide() {
        return this.side;
    }

}
