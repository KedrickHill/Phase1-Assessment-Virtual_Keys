package VKeys;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Directory {

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

        for (File file : files) {
            if(file.getName().equals(name)) {
                file.delete();
                break;
            }
        }
        updateFiles();
    }

    public File searchFile(String name) {
        // searches through all of the directories in current directory and returns the
        // file if its found else returns FileNotFound
        for (File file : files) {
            if(file.getName().equals(name)) {
                return file;
            }
        }
        return null;
    }
}