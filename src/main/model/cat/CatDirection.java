package model.cat;

public class CatDirection {
    private static final String FORWARD = "forward";
    private static final String BACKWARD = "backward";
    private static final String LEFT = "left";
    private static final String RIGHT = "right";
    
    private String facing;
    private String side;
    
    public CatDirection() {
        this.facing = FORWARD;
        this.side = RIGHT;
    }
    
    public void flip() {
        if (side.equals(LEFT)) {
            this.side = RIGHT;
        }
        if (side.equals(RIGHT)) {
            this.side = LEFT;
        }
    }

    public void turn() {
        if (facing.equals(FORWARD)) {
            this.facing = BACKWARD;
        }
        if (facing.equals(BACKWARD)) {
            this.facing = FORWARD;
        }
    }

    public String getFacing() {
        return this.facing;
    }

    public String getSide() {
        return this.side;
    }

}
