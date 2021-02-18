package VKeys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;

import org.junit.Test;

/**
 * Unit test for Virtual Keys App.
 */
public class VKeysTest {
    /**
     * Rigorous Testing
     */
    Directory dir = new Directory(
            new File("C:/Users/hill_/OneDrive/HCL-Projects/Phase1-Assessment-Virtual_Keys/VirtualKeys/MockDir"));
    File[] CORRECT_FILES = { new File(dir.getPath() + "/Info"), new File(dir.getPath() + "/LockedMe.com"),
            new File(dir.getPath() + "/Users"), new File(dir.getPath() + "/List.docx"),
            new File(dir.getPath() + "/READ.txt"), new File(dir.getPath() + "/Spreadsheet.xlsx") };

    @Test
    public void getFilesTest() {
        File[] files = dir.getFiles();
        Arrays.sort(CORRECT_FILES);
        assertTrue(Arrays.deepEquals(CORRECT_FILES, files));
    }

    @Test
    public void AddFileTest() {
        dir.addFile("temp.txt");
        // assertTrue(dir.files.;
    }
}
