package model.addons;

public class Background {
    private static final String EMPTY = "empty";
    private static final String BEACH = "beach";
    private static final String CITY = "city";
    private static final String FOREST = "forest";
    private static final String GARDEN = "garden";
    private static final String NIGHTTIME = "nighttime";

    private static final String[] BACKGROUNDS = {BEACH, CITY, FOREST, GARDEN, NIGHTTIME};

    private String background;

    public Background() {
        this.background = EMPTY;
    }

    public boolean changeBackground(String background) {
        for (String s : BACKGROUNDS) {
            if (s.equals(background)) {
                this.background = s;
                return true;
            }
        }

        return false;
    }

    public String getBackground() {
        return background;
    }

    public void deleteBackground() {
        this.background = EMPTY;
    }

    public boolean noBackground() {
        return background.equals(EMPTY);
    }
}
