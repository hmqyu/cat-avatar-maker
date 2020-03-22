package ui.old;/*
package ui.old;

import model.cat.Cat;
import model.cat.CatCollection;
import persistence.SaveDataReader;
import persistence.SaveDataWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

// Cat Maker Application
// Class is heavily inspired by the AccountNotRobust project (specifically the TellerApp class) given to us in CPSC 210
public class OldCatMaker {
    private Scanner userInput;
    private boolean newCat = true;
    private Cat userCat;
    private String catName;
    private static final String CAT_COLLECTION = "./data/CatCollection.txt";
    private CatCollection collection;

    // EFFECTS: runs the cat maker application
    public OldCatMaker() {
        runCatMaker();
    }

    // MODIFIES: this
    // EFFECTS: processes user commands including program quitting
    public void runCatMaker() {
        boolean running = true;
        userInput = new Scanner(System.in);
        String userCommand;
        userCat = new Cat();

        loadCollection();

        System.out.println("CAT MAKER");
        System.out.println("\nWelcome!");

        while (running) {
            catName = userCat.getName();

            menu();
            userCommand = userInput.next();
            userCommand = userCommand.toLowerCase();

            if (userCommand.equals("quit")) {
                running = false;
            } else {
                completeCommand(userCommand);
            }
        }

        System.out.println("\nThanks for playing!");
    }

    // MODIFIES: this
    // EFFECTS: loads collection from CAT_COLLECTION, if the file exists
    //          otherwise, creates a new CatCollection as collection
    private void loadCollection() {
        try {
            collection = SaveDataReader.readCollection(new File(CAT_COLLECTION));
        } catch (IOException e) {
            collection = new CatCollection();
        }
    }

    // EFFECTS: displays the commands a user can input
    public void menu() {
        System.out.println("\nPlease select an option:");
        System.out.println("\tname");
        System.out.println("\tbase");
        System.out.println("\tpattern");
        System.out.println("\tnose");
        System.out.println("\teyes");
        System.out.println("\tdirection");
        System.out.println("\taccessories");
        System.out.println("\tbackground");
        System.out.println("\tdescription");
        System.out.println("\n\tload");
        System.out.println("\tsave");
        System.out.println("\thelp");
        System.out.println("\tquit");

    }

    // MODIFIES: this
    // EFFECTS: processes the user's inputted command
    private void completeCommand(String input) {
        if (input.equals("name")) {
            nameCommand();
        } else if (input.equals("base")) {
            baseCommand();
        } else if (input.equals("pattern")) {
            patternCommand();
        } else if (input.equals("nose")) {
            noseCommand();
        } else if (input.equals("eyes")) {
            eyesCommand();
        } else if (input.equals("direction")) {
            directionCommand();
        } else if (input.equals("accessories")) {
            accessoriesCommand();
        } else if (input.equals("background")) {
            backgroundCommand();
        } else if (input.equals("description")) {
            descriptionCommand();
        } else {
            completeSystemCommand(input);
        }
    }

    // MODIFIES: this
    // EFFECTS: processes the user's inputted, system-related commands
    private void completeSystemCommand(String input) {
        switch (input) {
            case "load":
                loadCommand();
                break;
            case "save":
                saveCommand();
                break;
            case "help":
                helpCommand();
                break;
            default:
                System.out.println("ERROR: Invalid command.");
                break;
        }
    }

    // MODIFIES: this and newCat
    // EFFECTS: if a newCat, gives the cat a name and changes newCat to false
    //          otherwise, renames a cat
    private void nameCommand() {
        if (newCat) {
            System.out.println("\nWhat would you like to name " + catName + "?");
            String name = userInput.next();
            userCat.changeName(name);
            System.out.println("\nYou named your cat " + name + "!");
            newCat = false;
        } else {
            System.out.println("What would you like to rename " + catName + " to?");
            String name = userInput.next();
            userCat.changeName(name);
            System.out.println("\n" + catName + " has been renamed to " + name + "!");
        }
    }

    // MODIFIES: this
    // EFFECTS: changes a cat's base colour
    private void baseCommand() {
        System.out.println("\nChoose the base colour you want " + catName + " to have:");
        System.out.println("\tblack");
        System.out.println("\tgrey");
        System.out.println("\tbrown");
        System.out.println("\tred");
        System.out.println("\tcream");
        System.out.println("\twhite");

        String base = userInput.next();
        userCat.changeBase(base);
        System.out.println("\n" + catName + "'s new base colour is now " + base + ".");
    }

    // MODIFIES: this
    // EFFECTS: changes a cat's coat pattern
    private void patternCommand() {
        System.out.println("\nChoose the coat pattern you want " + catName + " to have:");
        System.out.println("\tsolid");
        System.out.println("\ttabby");
        System.out.println("\ttortoiseshell");
        System.out.println("\tcalico");
        System.out.println("\tpoint");

        String pattern = userInput.next();
        userCat.changePattern(pattern);
        System.out.println("\n" + catName + "'s new coat pattern is now " + pattern + ".");
    }

    // MODIFIES: this
    // EFFECTS: changes a cat's nose colour
    private void noseCommand() {
        System.out.println("\nChoose the nose colour you want " + catName + " to have:");
        System.out.println("\tpink");
        System.out.println("\tmauve");
        System.out.println("\tgrey");
        System.out.println("\tblack");

        String skin = userInput.next();
        userCat.changeSkin(skin);
        System.out.println("\n" + catName + "'s new nose colour is now " + skin + ".");
    }

    // MODIFIES: this
    // EFFECTS: changes a cat's eye colour
    private void eyesCommand() {
        System.out.println("\nChoose the eye colour you want " + catName + " to have:");
        System.out.println("\tyellow");
        System.out.println("\tgreen");
        System.out.println("\tblue");
        System.out.println("\tcopper");
        if (userCat.getBase().equals("white") && userCat.getPattern().equals("solid")) {
            System.out.println("\tpink");
        }

        String eyes = userInput.next();
        userCat.changeEyes(eyes);
        System.out.println("\n" + catName + "'s new eye colour is now " + eyes + ".");
    }

    // MODIFIES: this
    // EFFECTS: changes the direction(s) the cat is facing
    private void directionCommand() {
        System.out.println("\nWhat would you like to do to " + catName + "'s direction?");
        System.out.println("\tflip");
        System.out.println("\tturn");
        System.out.println("\tboth");

        String direction = userInput.next();
        String oldDirection = userCat.getDirection();
        if (direction.equals("flip")) {
            userCat.flipDirection();
        } else if (direction.equals("turn")) {
            userCat.turnDirection();
        } else if (direction.equals("both")) {
            userCat.flipDirection();
            userCat.turnDirection();
        } else {
            System.out.println("\nERROR: Invalid input. Please try again.");
            directionCommand();
            return;
        }

        System.out.println("\n" + catName + " was facing " + oldDirection + ", and now it's facing "
                + userCat.getDirection() + ".");
    }

    // MODIFIES: this
    // EFFECTS: edits the accessories (if any) on a cat
    private void accessoriesCommand() {
        if (userCat.getAllAccessories().equals("no accessories")) {
            addAccessoryCommand();
            return;
        }

        System.out.println("\nWhat would you like to do to " + catName + "'s accessories?");
        System.out.println("\tadd");
        System.out.println("\tremove");
        System.out.println("\tremoveall");
        String command = userInput.next();

        if (command.equals("add")) {
            addAccessoryCommand();
        } else if (command.equals("remove")) {
            removeAccessoryCommand();
        } else if (command.equals("removeall")) {
            removeAllAccessoryCommand();
        } else {
            System.out.println("\nERROR: Invalid input. Please try again.");
            accessoriesCommand();
        }
    }

    // MODIFIES: this
    // EFFECTS: adds an accessory to a cat
    private void addAccessoryCommand() {
        System.out.println("\nWhat accessory would you like to add to " + catName + "?");
        System.out.println("It's currently wearing " + userCat.getAllAccessories() + ".");
        System.out.println("\that");
        System.out.println("\tbag");
        System.out.println("\tmask");
        System.out.println("\tscarf");
        System.out.println("\twings");
        System.out.println("\thorns");

        String accessory = userInput.next();
        if (userCat.addAccessory(accessory)) {
            System.out.println("\n" + catName + " is now wearing " + userCat.getAllAccessories() + ".");
        } else {
            System.out.println("\nERROR: Invalid input or cat is already wearing inputted accessory."
                    + "Please try again.");
            addAccessoryCommand();
        }

    }

    // MODIFIES: this
    // EFFECTS: removes an accessory from a cat
    private void removeAccessoryCommand() {
        System.out.println("\nWhat accessory would you like to remove from " + catName + "?");
        System.out.println("It's currently wearing " + userCat.getAllAccessories() + ".");

        String accessory = userInput.next();
        if (userCat.removeAccessory(accessory)) {
            System.out.println("\nYou removed " + accessory + " from " + catName + ".");
        } else {
            System.out.println("\nERROR: Invalid input or cat is not wearing inputted accessory. Please try again.");
            removeAccessoryCommand();
        }
    }

    // MODIFIES: this
    // EFFECTS: removes all accessories on a cat
    private void removeAllAccessoryCommand() {
        System.out.println("\nWARNING: This action cannot be reversed. ");
        System.out.println("Are you sure you would like to remove all accessories? (Type yes or no):");

        String command = userInput.next();
        if (command.equals("yes")) {
            userCat.removeAllAccessories();
            System.out.println("\n" + catName + " is now wearing " + userCat.getAllAccessories());
        } else if (command.equals("no")) {
            System.out.println("\nNo accessories have been removed. Returning to the menu...");
        } else {
            System.out.println("\nERROR: Invalid input. Please try again.");
            removeAllAccessoryCommand();
        }
    }

    // MODIFIES: this
    // EFFECTS: edits the background of a cat
    private void backgroundCommand() {
        if (userCat.emptyBackground()) {
            changeBackgroundCommand();
            return;
        }

        System.out.println("\nWhat would you like to do to " + catName + "'s background?");
        System.out.println("\tchange");
        System.out.println("\tremove");

        String command = userInput.next();
        if (command.equals("change")) {
            changeBackgroundCommand();
        } else if (command.equals("remove")) {
            removeBackgroundCommand();
        } else {
            System.out.println("\nERROR: Invalid input. Please try again.");
            accessoriesCommand();
        }
    }

    // MODIFIES: this
    // EFFECTS: changes the background of a cat
    private void changeBackgroundCommand() {
        System.out.println("\nWhat would you like to change " + catName + "'s background to?");
        System.out.println("\tbeach");
        System.out.println("\tcity");
        System.out.println("\tforest");
        System.out.println("\tgarden");
        System.out.println("\tnighttime");

        String background = userInput.next();
        if (userCat.changeBackground(background)) {
            System.out.println("\n" + catName + "'s background is now " + userCat.getBackground() + ".");
        } else {
            System.out.println("\nERROR: Invalid input. Please try again.");
            changeBackgroundCommand();
        }
    }

    // MODIFIES: this
    // EFFECTS: removes the background of a cat
    private void removeBackgroundCommand() {
        System.out.println("\nWARNING: This action cannot be reversed.");
        System.out.println("Are you sure you would like to remove the background? (Type yes or no):");

        String command = userInput.next();
        if (command.equals("yes")) {
            userCat.removeBackground();
            System.out.println("\n" + catName + "'s background is now " + userCat.getBackground() + ".");
        } else if (command.equals("no")) {
            System.out.println("\nThe background has not been removed. Returning to the menu...");
        } else {
            System.out.println("\nERROR: Invalid input. Please try again.");
            removeBackgroundCommand();
        }
    }

    // EFFECTS: displays a description of the cat and stays there until the user inputs something
    private void descriptionCommand() {
        System.out.println("\n" + catName + "'s Description");
        System.out.println(catName + " is a " + userCat.getBase() + " " + userCat.getPattern() + " cat.");
        System.out.println(catName + " has " + userCat.getLeftEye() + " eyes and a " + userCat.getSkin() + " nose.");
        System.out.println(catName + " is currently wearing " + userCat.getAllAccessories() + ".");
        System.out.println(catName + " currently has a(n) " + userCat.getBackground() + " background.");
        System.out.println(catName + " is facing " + userCat.getDirection() + ".");
        System.out.println("\nPlease type anything to continue...");
        String command = userInput.next();
        while (command.equals("")) {
            command = userInput.next();
        }
    }

    // MODIFIES: this
    // EFFECTS: loads selected cat from CAT_FILE, if that file exists;
    //          otherwise returns to the menu
    private void loadCommand() {
        try {
            Cat currentCat;
            collection = SaveDataReader.readCollection(new File(CAT_COLLECTION));
            System.out.println("All cats in the cat collection:");
            for (int count = 0; count < collection.numOfCats(); count++) {
                currentCat = collection.getCatFromCollection(count);
                System.out.println((count + 1) + ". " + currentCat.getName());
            }
            System.out.println("\nPlease enter the number of the cat you wish to load "
                    + "(enter 0 if you don't want to load a cat):");
            int command = userInput.nextInt();
            if (command == 0) {
                System.out.println("No cat has been loaded.");
            } else {
                userCat = collection.getCatFromCollection(command - 1);
                System.out.println("\n" + userCat.getName() + " has been loaded.");
            }
            System.out.println("Returning to the menu...");
        } catch (IOException e) {
            System.out.println("There are no cats to load.");
            System.out.println("Returning to the menu...");
        }
    }

    // EFFECTS: adds the current cat (userCat) to collection, which is saved to CAT_COLLECTION
    private void saveCommand() {
        try {
            SaveDataWriter writer = new SaveDataWriter(new File(CAT_COLLECTION));
            collection.addToCollection(userCat);
            writer.write(collection);
            writer.close();
            System.out.println(catName + " has been saved to file " + CAT_COLLECTION);
        } catch (FileNotFoundException e) {
            System.out.println("File not found - unable to save cat to " + CAT_COLLECTION);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: displays a description of the commands that can be used and stays there until the user inputs something
    private void helpCommand() {
        System.out.println("\nname: changes " + catName + "'s name.");
        System.out.println("base: changes " + catName + "'s current base colour.");
        System.out.println("pattern: changes " + catName + "'s current coat pattern.");
        System.out.println("nose: changes " + catName + "'s current nose colour.");
        System.out.println("eyes: changes " + catName + "'s current eye colour.");
        System.out.println("direction: changes the direction " + catName + " is currently facing.");
        System.out.println("accessories: changes the accessories " + catName + " is currently wearing, if any.");
        System.out.println("background: changes " + catName + "'s current background.");
        System.out.println("description: gives a description of " + catName + "'s current appearance.");
        System.out.println("load: loads a cat from your cat collection.");
        System.out.println("save: saves " + catName + " to your cat collection.");
        System.out.println("quit: quits the cat maker application.");
        System.out.println("\nPlease type anything to continue...");
        String command = userInput.next();
        while (command.equals("")) {
            command = userInput.next();
        }
    }

}
*/
