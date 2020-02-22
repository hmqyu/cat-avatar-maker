package persistence;

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

public class SaveDataReader {
    public static final String DELIMITER = ",";
    public static final String ACCESSORY_DELIMITER = "&";

    // EFFECTS: returns a list of accounts parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static CatCollection readCollection(File file) throws IOException {
        List<String> catFile = readFile(file);
        return new CatCollection(parseData(catFile));
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of accounts parsed from list of strings
    // where each string contains data for one account
    private static ArrayList<Cat> parseData(List<String> file) {
        ArrayList<Cat> cats = new ArrayList<>();

        for (String line : file) {
            ArrayList<String> lineFields = splitter(line, DELIMITER);
            cats.add(parseCat(lineFields));
        }

        return cats;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on delimiter
    public static ArrayList<String> splitter(String line, String delimiter) {
        String[] lineSplit = line.split(delimiter);
        return new ArrayList<>(Arrays.asList(lineSplit));
    }

    // REQUIRES: components has size 4 where element 0 represents the
    // id of the next account to be constructed, element 1 represents
    // the id, elements 2 represents the name and element 3 represents
    // the balance of the account to be constructed
    // EFFECTS: returns an account constructed from components
    private static Cat parseCat(List<String> fields) {
        String name = fields.get(0);
        String base = fields.get(1);
        String pattern = fields.get(2);
        String nose = fields.get(3);
        String eyes = fields.get(4);
        CatDirection direction = new CatDirection(fields.get(5), fields.get(6));
        Accessory accessories = new Accessory(splitter(fields.get(7), ACCESSORY_DELIMITER));
        Background background = new Background(fields.get(8));
        return new Cat(name, base, pattern, nose, eyes, direction, accessories, background);
    }
}
