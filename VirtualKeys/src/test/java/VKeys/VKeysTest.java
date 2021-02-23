package VKeys;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for Virtual Keys App.
 */
public class VKeysTest {
    /**
     * Rigorous Testing
     */
    Directory dir = new Directory(new File("C:/Users/Kedrick/HCL-Projects/Phase1-Assessment-Virtual_Keys/VirtualKeys/MockDir"));
            // Directory dir = new Directory( new File("C:/Users/hill_/OneDrive/HCL-Projects/Phase1-Assessment-Virtual_Keys/VirtualKeys/MockDir")); // laptop pathing
    List<File> correctFiles = Arrays.asList(new File(dir.getPath() + "/Info"), new File(dir.getPath() + "/LockedMe.com"),
            new File(dir.getPath() + "/Users"), new File(dir.getPath() + "/List.docx"),
            new File(dir.getPath() + "/READ.txt"), new File(dir.getPath() + "/Spreadsheet.xlsx"));

    @Test
    public void getFilesTest() {
        List<File> files = dir.getFiles();
        Collections.sort(correctFiles);
        assertTrue(files.equals(correctFiles));
    }

    @Test
    public void AddFileTest() {
        File temp = new File(dir.getPath() + "/temp.txt"); // used for comparison
        System.out.println(temp);

        dir.addFile("temp.txt");
        dir.updateFiles();
        List<File> f = dir.getFiles();
        System.out.println("Recieved:");
        System.out.println(f);
        assertTrue(f.contains(temp));
    }

    @Test
    public void searchFileTest() {

        String srch = "temp.txt";

        System.out.println(dir.searchFile(srch));
        System.out.println(dir.searchFile(srch).getName());
        System.out.println(srch.equals(dir.searchFile(srch).getName()));

        assertTrue(srch.equals(dir.searchFile(srch).getName()));

        srch = "temp.docx";

        assertNull(dir.searchFile(srch));
    }

    @Test
    public void deleteFileTest() {
        dir.addFile("temp.xlsx");
        dir.addFile("deleteMe.docx");
        dir.addFile("Virus.txt");

        dir.updateFiles();
        List<File> f = dir.getFiles();
        
        // assertFalse(f.contains(o));
    }
}
