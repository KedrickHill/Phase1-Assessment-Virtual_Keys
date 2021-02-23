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
        System.out.println("\nGETTING FILES TEST...");
        List<File> files = dir.getFiles();
        Collections.sort(correctFiles);
        assertTrue(files.equals(correctFiles));
    }

    @Test
    public void AddFileTest() {
        System.out.println("\nADDING A FILE TEST...");
        File temp = new File(dir.getPath() + "/temp.txt"); // used for comparison
        System.out.println(temp);

        dir.addFile("temp.txt");
        List<File> f = dir.getFiles();
        System.out.println("Recieved:");
        System.out.println(f);
        assertTrue(f.contains(temp));
    }

    @Test
    public void searchFileTest() {
        System.out.println("\nSEARCHING FOR A FILE TEST...");
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
        System.out.println("\nDELETING A FILE(S) TEST...");
        
        // used as temp files that are deleted later
        File t1 = new File(dir.getPath() + "/" + "temp.xlsx");
        File t2 = new File(dir.getPath() + "/" + "deleteMe.docx");
        File t3 = new File(dir.getPath() + "/" + "Virus.txt");

        dir.addFile("temp.xlsx");
        dir.addFile("deleteMe.docx");
        dir.addFile("Virus.txt");

        List<File> f = dir.getFiles();
        System.out.println("List of current paths in directory:\n" + f);

        assertTrue(f.contains(t1));
        assertTrue(f.contains(t2));
        assertTrue(f.contains(t3));

        dir.deleteFile("temp.xlsx");
        dir.deleteFile("deleteMe.docx");
        dir.deleteFile("Virus.txt");

        f = dir.getFiles();
        System.out.println("List of files after deletion in directory:\n" + f);

        assertFalse(f.contains(t1));
        assertFalse(f.contains(t2));
        assertFalse(f.contains(t3));




    }
}
