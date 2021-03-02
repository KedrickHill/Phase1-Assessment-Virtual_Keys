package VKeys;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Directory {

    // Init Variables
    List<File> files = new ArrayList<File>();    
    File dir;
    String path;
    String name;


    public Directory(File dir) {
        if (dir.isDirectory()) {
            setFiles(dir.listFiles());
            setDir(dir);
            setPath(dir.getAbsolutePath());
            setName(dir.getName());
        } else {
            System.out.println("This is not a Directory!");
        }
    }


    public List<File> getFiles() {
        return files;
    }


    public void setFiles(File[] files) {
        this.files = Arrays.asList(files);
    }


    public File getDir() {
        return dir;
    }


    public void setDir(File dir) {
        this.dir = dir;
    }


    public String getPath() {
        return path; // works
    }


    public void setPath(String path) {
        this.path = path; // works
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void addFile(String name) {
        // Adds a file to the current directory
        try {
            File nf = new File(dir.getPath() + "/" + name);
            nf.createNewFile();
            updateFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateFiles() {
        setFiles(dir.listFiles());
    }


    public void deleteFile(String name) {
        // deletes file from the current directory
        if (showAllFiles().contains(name)) {
            for (File file : files) {
                if(file.getName().equals(name) && !file.isDirectory()) {
                    System.out.println("\nDELETING FILE...");
                    file.delete();
                    System.out.println("\n" + file.getName() + " has been deleted.");
                    updateFiles();
                    break;
                }
                else if (file.getName().equals(name) && file.isDirectory()) {
                    System.out.println("\nFILE IS A DIRECTORY. CANNOT DELETE.");
                    break;
                }
            }
        }
        else {
            System.out.println("\nFILE NOT FOUND. CANNOT DELETE.");
        }
    }


    public File searchFile(String name) {
        // searches through all of the directories in current directory and returns the
        // file if its found else returns FileNotFound
        for (File file : files) {
            if(file.getName().equals(name)) {
                System.out.println("\nFile Found!\n");
                return file;
            }
        }
        System.out.println("\nCould not find the file\n");
        return null;
    }


    public List<String> showAllFiles() {
        return files.stream().map(f -> f.getName()).collect(Collectors.toList());
    }


    public boolean isValidFile(String name) {       

        // takes only some majorly used file types...can expand later if needed
        Pattern p = Pattern.compile("(\\w+\\.(txt|jpeg|xlsx|docx|png|csv|dat|db|sql|tar|xml|gif|ppt|pptx))", Pattern.CASE_INSENSITIVE);
        // check regex: should be *.[a-z]+ what ever name then contain some sort of type
        // if it applies to this then its valid else not valid
        Matcher m = p.matcher(name);

        if (!m.matches()) return false;

        return true;
    }



}