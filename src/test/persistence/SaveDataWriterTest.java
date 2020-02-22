package persistence;

import model.addons.Accessory;
import model.addons.Background;
import model.cat.Cat;
import model.cat.CatCollection;
import model.cat.CatDirection;
import java.util.ArrayList;
import java.io.File;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaveDataWriterTest {
    private static final String FILE_TESTER = "./data/CatCollectionTest.txt";
    private ArrayList<Cat> catArrayListTester = new ArrayList<>();
    private Cat catArrayTester1 = new Cat("Heeny", "red", "tabby", "pink", "copper",
            new CatDirection("backward", "right"), new Accessory(),
            new Background("nighttime"));
    private Cat catArrayTester2 = new Cat("Holly", "brown", "tabby", "black", "green",
            new CatDirection("forward", "left"), new Accessory(),
            new Background("city"));

    private SaveDataWriter writerTester;
    private CatCollection catCollectionTester;
    private Cat catTester;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        writerTester = new SaveDataWriter(new File(FILE_TESTER));
        catTester = new Cat();

        catArrayTester1.addAccessory("bag");
        catArrayTester1.addAccessory("amulet");
        catArrayTester1.addAccessory("wings");

        catArrayListTester.add(catArrayTester1);
        catArrayListTester.add(catArrayTester2);
        catCollectionTester = new CatCollection(catArrayListTester);
    }

    @Test
    void testWriteCatCollection() {
        writerTester.write(catCollectionTester);
        writerTester.write(catTester);
        writerTester.close();

        try {
            CatCollection collection = SaveDataReader.readCollection(new File(FILE_TESTER));

            Cat heeny = collection.getCatFromCollection(0);
            assertEquals("Heeny", heeny.getName());
            assertEquals("red", heeny.getBase());
            assertEquals("tabby", heeny.getPattern());
            assertEquals("pink", heeny.getNose());
            assertEquals("copper", heeny.getEyes());
            assertEquals("backward and to the right", heeny.getDirection());
            assertEquals("a bag, an amulet, and wings", heeny.getAllAccessories());
            assertEquals("nighttime", heeny.getBackground());

            Cat holly = collection.getCatFromCollection(1);
            assertEquals("Holly", holly.getName());
            assertEquals("brown", holly.getBase());
            assertEquals("tabby", holly.getPattern());
            assertEquals("black", holly.getNose());
            assertEquals("green", holly.getEyes());
            assertEquals("forward and to the left", holly.getDirection());
            assertEquals("no accessories", holly.getAllAccessories());
            assertEquals("city", holly.getBackground());

            Cat yourCat = collection.getCatFromCollection(2);
            assertEquals("your cat", yourCat.getName());
            assertEquals("white", yourCat.getBase());
            assertEquals("solid", yourCat.getPattern());
            assertEquals("pink", yourCat.getNose());
            assertEquals("yellow", yourCat.getEyes());
            assertEquals("forward and to the right", yourCat.getDirection());
            assertEquals("no accessories", yourCat.getAllAccessories());
            assertEquals("empty", yourCat.getBackground());
        } catch (IOException e) {
            fail("IOException shouldn't be thrown.");
        }
    }
}
