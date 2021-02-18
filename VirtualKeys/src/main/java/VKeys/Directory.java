package VKeys;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Directory {

    HashMap<File, File[]> files = new HashMap<File, File[]>();
    String path;
    String name;

    public Directory(File dir) {
        if (dir.isDirectory()) {
            files.put(dir, dir.listFiles());
        } else {
            System.out.println("This is not a Directory! Not adding to ");
        }

    }

    public Directory(String path, String name) {

    }

    public HashMap<File, ArrayList<File>> getFiles() {
        return files;
    }

    public void setFiles(HashMap<File, ArrayList<File>> files) {
        this.files = files;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFile(String name) {
        // Adds a file to the current directory
    }

    public void deleteFile(String name) {
        // deletes file from the current directory
    }

    public void changeDir() {
        // Changes to another directory that is in its HashMap
    }

    public void currentDir() {
        // returns the currnet directory and some info
    }

    public void searchFile() {
        // searches through all of the directories in current directory and returns the
        // file if its found else returns FileNotFound
    }

    public String dirTreeStruct() {
        // should throw command into cmd/terminal that will call the tree function to
        // produce what files and directories are below it
        return "tree";
    }

}