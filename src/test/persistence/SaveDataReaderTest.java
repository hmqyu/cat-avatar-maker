package persistence;

import exceptions.SaveDataException;
import model.cat.Cat;
import model.cat.CatCollection;
import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

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
            assertEquals("right", holly.getDirection());
            assertEquals(new ArrayList<>(), holly.getAccessories());
            assertEquals("empty", holly.getBackground());
        }
        catch (IOException | SaveDataException e) {
            fail("IOException and/or SaveDataException shouldn't be thrown.");
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
            assertEquals("right", holly.getDirection());
            assertEquals(new ArrayList<>(), holly.getAccessories());
            assertEquals("empty", holly.getBackground());

            Cat heeny = collection.getCatFromCollection(1);
            assertEquals("Heeny", heeny.getName());
            assertEquals("red", heeny.getBase());
            assertEquals("tabby", heeny.getPattern());
            assertEquals("pink", heeny.getSkin());
            assertEquals("copper", heeny.getLeftEye());
            assertEquals("right", heeny.getDirection());
            ArrayList<String> heenyAccessories = new ArrayList<>();
            heenyAccessories.add("bag");
            assertEquals(heenyAccessories, heeny.getAccessories());
            assertEquals("garden", heeny.getBackground());

            Cat al = collection.getCatFromCollection(2);
            assertEquals("Al", al.getName());
            assertEquals("red", al.getBase());
            assertEquals("calico", al.getPattern());
            assertEquals("mauve", al.getSkin());
            assertEquals("green", al.getLeftEye());
            assertEquals("left", al.getDirection());
            ArrayList<String> alAccessories = new ArrayList<>();
            alAccessories.add("horns");
            alAccessories.add("amulet");
            assertEquals(alAccessories, al.getAccessories());
            assertEquals("nighttime", al.getBackground());
        }
        catch (IOException | SaveDataException e) {
            fail("IOException and/or SaveDataException shouldn't be thrown.");
        }
    }

    @Test
    void testIOException() {
        try {
            SaveDataReader.readCollection(new File("./no/path/here/testCollection.txt"));
        } catch (SaveDataException e) {
            fail("SaveDataException shouldn't be thrown.");
        } catch (IOException e) {
            // expected IOException
        }
    }

    @Test
    void testSaveDataException() {
        try {
            SaveDataReader.readCollection(new File("./data/testSaveFileException.txt"));
        } catch (IOException e) {
            fail("IOException shouldn't be thrown.");
        } catch (SaveDataException e) {
            // expected SaveFileException
        }
    }
}
