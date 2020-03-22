package persistence;

import model.cat.Cat;
import model.cat.CatCollection;
import java.io.File;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaveDataReaderTest {
    SaveDataReader dummyJacoco;

    @BeforeEach
    void runBefore() {
        dummyJacoco = new SaveDataReader();
    }

    @Test
    void testDummyConstructor() {
        assertEquals("dummy jacoco!", dummyJacoco.getSaveDataReaderValue());
    }

    @Test
    void testParseSingleCatCollection() {
        try {
            CatCollection collection = SaveDataReader.readCollection
                    (new File("./data/testSingleCatCollection.txt"));
            Cat holly = collection.getCatFromCollection(0);
            assertEquals("Holly", holly.getName());
            assertEquals("white", holly.getBase());
            assertEquals("solid", holly.getPattern());
            assertEquals("pink", holly.getSkin());
            assertEquals("yellow", holly.getLeftEye());
            assertEquals("forward and to the right", holly.getDirection());
            assertEquals("no accessories", holly.getAllAccessories());
            assertEquals("empty", holly.getBackground());
        }
        catch (IOException e) {
            fail("IOException shouldn't be thrown.");
        }
    }

    @Test
    void testParseMultiCatCollection() {
        try {
            CatCollection collection = SaveDataReader.readCollection
                    (new File("./data/testMultiCatCollection.txt"));
            Cat holly = collection.getCatFromCollection(0);
            assertEquals("Holly", holly.getName());
            assertEquals("white", holly.getBase());
            assertEquals("solid", holly.getPattern());
            assertEquals("pink", holly.getSkin());
            assertEquals("yellow", holly.getLeftEye());
            assertEquals("forward and to the right", holly.getDirection());
            assertEquals("no accessories", holly.getAllAccessories());
            assertEquals("empty", holly.getBackground());

            Cat heeny = collection.getCatFromCollection(1);
            assertEquals("Heeny", heeny.getName());
            assertEquals("red", heeny.getBase());
            assertEquals("tabby", heeny.getPattern());
            assertEquals("pink", heeny.getSkin());
            assertEquals("copper", heeny.getLeftEye());
            assertEquals("backward and to the right", heeny.getDirection());
            assertEquals("a bag", heeny.getAllAccessories());
            assertEquals("garden", heeny.getBackground());

            Cat al = collection.getCatFromCollection(2);
            assertEquals("Al", al.getName());
            assertEquals("red", al.getBase());
            assertEquals("calico", al.getPattern());
            assertEquals("mauve", al.getSkin());
            assertEquals("green", al.getLeftEye());
            assertEquals("forward and to the left", al.getDirection());
            assertEquals("horns, and an amulet", al.getAllAccessories());
            assertEquals("nighttime", al.getBackground());
        }
        catch (IOException e) {
            fail("IOException shouldn't be thrown.");
        }
    }

    @Test
    void testIOException() {
        try {
            SaveDataReader.readCollection(new File("./no/path/here/testCollection.txt"));
        } catch (IOException e) {
            // expected IOException
        }
    }
}
