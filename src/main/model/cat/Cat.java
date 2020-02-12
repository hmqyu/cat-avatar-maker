package model.cat;

import model.addons.Background;

public class Cat {
    private String name;
    private String base;
    private String pattern;
    private String nose;
    private String eyes;
    private CatDirection direction;
    private CatAccessory accessories;
    private Background background;

    public Cat() {
        this.name = "your cat";
        this.base = "white";
        this.pattern = "solid";
        this.nose = "pink";
        this.eyes = "yellow";
        this.direction = new CatDirection();
        this.accessories = new CatAccessory();
        this.background = new Background();
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeBase(String base) {
        this.base = base;
    }

    public void changePattern(String pattern) {
        this.pattern = pattern;
    }

    public void changeNose(String nose) {
        this.nose = nose;
    }

    public void changeEyes(String eyes) {
        this.eyes = eyes;
    }

    public boolean changeBackground(String background) {
        return this.background.changeBackground(background);
    }

    public void removeBackground() {
        this.background.deleteBackground();
    }

    public void flipDirection() {
        this.direction.flip();
    }

    public void turnDirection() {
        this.direction.turn();
    }

    public boolean addAccessory(String accessory) {
        return this.accessories.addCatAccessory(accessory);
    }

    public boolean removeAccessory(String accessory) {
        return this.accessories.removeCatAccessory(accessory);
    }

    public void removeAllAccessories() {
        this.accessories.removeAllCatAccessories();
    }

    public String getName() {
        return this.name;
    }

    public String getBase() {
        return this.base;
    }

    public String getPattern() {
        return this.pattern;
    }

    public String getNose() {
        return this.nose;
    }

    public String getEyes() {
        return this.eyes;
    }

    public String getDirection() {
        return this.direction.getFacing() + " and to the " + this.direction.getSide();
    }

    public String getAllAccessories() {
        if (accessories.getAllCatAccessories().equals("")) {
            return "no accessories";
        }
        return this.accessories.getAllCatAccessories();
    }

    public boolean emptyBackground() {
        return background.noBackground();
    }

    public String getBackground() {
        return this.background.getBackground();
    }

}
