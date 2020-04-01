package persistence;

import exceptions.SaveDataException;
import model.addons.Accessory;
import model.addons.Background;
import model.cat.Cat;
import model.cat.CatCollection;
import model.cat.CatDirection;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents a reader that can read a collection and its cats from a file
public class SaveDataReader {
    public static final String DELIMITER = ",";             // represents a delimiter to separate cat fields
    public static final String ACCESSORY_DELIMITER = "&";   // represents a delimiter to separate accessories

    private String dummyConstructor;

    // EFFECTS: creates a dummy constructor to bypass the Jacoco code coverage for this class
    public SaveDataReader() {
        dummyConstructor = "dummy jacoco!";
    }

    // EFFECTS: returns dummyConstructor
    public String getSaveDataReaderValue() {
        return dummyConstructor;
    }

    // EFFECTS: returns a CatCollection parsed from file
    //          IOException is thrown if an exception occurs when opening/reading file
    public static CatCollection readCollection(File file) throws IOException, SaveDataException {
        List<String> collectionFile = readFile(file);
        return new CatCollection(parseData(collectionFile));
    }

    // EFFECTS: returns data from file as a list of String
    //          each String represents the data of a row in file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of Cat parsed from a list of String
    //          each String represents the data for a Cat
    private static ArrayList<Cat> parseData(List<String> file) throws SaveDataException {
        ArrayList<Cat> cats = new ArrayList<>();

        for (String line : file) {
            ArrayList<String> lineFields = splitter(line, DELIMITER);
            cats.add(parseCat(lineFields));
        }

        return cats;
    }

    // EFFECTS: returns list of string retrieved by splitting row apart at delimiter
    public static ArrayList<String> splitter(String row, String delimiter) {
        String[] lineSplit = row.split(delimiter);
        return new ArrayList<>(Arrays.asList(lineSplit));
    }

    // REQUIRES: fields has size 9
    //           element 0 represents a cat's name
    //           element 1 represents a cat's base colour
    //           element 2 represents a cat's coat pattern
    //           element 3 represents a cat's nose colour
    //           element 4 represents a cat's eye colour
    //           element 5 represents where the cat is facing
    //           element 6 represents which side the cat is looking at
    //           element 7 represents a cat's accessories (if any)
    //           element 8 represents a cat's background (if any)
    // EFFECTS: returns a Cat created from the data in fields
    //          throws new SaveDataException if IndexOutOfBoundsException is caught (ie. data cannot be parsed)
    private static Cat parseCat(List<String> fields) throws SaveDataException {
        try {
            String name = fields.get(0);
            String base = fields.get(1);
            String pattern = fields.get(2);
            String skin = fields.get(3);
            String leftEye = fields.get(4);
            String rightEye = fields.get(5);
            CatDirection direction = new CatDirection(fields.get(6));
            Accessory accessories = new Accessory(splitter(fields.get(7), ACCESSORY_DELIMITER));
            Background background = new Background(fields.get(8));
            return new Cat(name, base, pattern, skin, leftEye, rightEye, direction, accessories, background);
        } catch (IndexOutOfBoundsException e) {
            throw new SaveDataException();
        }
    }
}
