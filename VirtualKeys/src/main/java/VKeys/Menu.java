package VKeys;

import java.io.File;
import java.util.Scanner;

public class Menu {

    int index = 0;
    final static String PATH = "C:/Users/hill_/OneDrive/HCL-Projects/Phase1-Assessment-Virtual_Keys/VirtualKeys";

    public static void menu() {
        // TODO: ask user for input on what they would like to do in the app
        // TODO: using a switch to change the case would work here (Check with previous
        // assignemnt: Bug Fixes)
        Scanner input = new Scanner(System.in);
        Directory dir = new Directory(new File(PATH));
        System.out.println(
                "1- Display Current Directory\n2- Show All Files\n3- Add a File\n4- Delete a File\n5- Delete All Files\n6- Search for a File\n7- Exit LockedMe\n");

        System.out.println("Enter a Choice:");
        int option = input.nextInt();
        switch (option) {
            case 1: // display current directory
                System.out.println("Your Current Directory: " + dir.getDir());
                menu();
            case 2: // show all files in directory
                System.out.println(dir.getFiles());
                menu();
            case 3: // add a file to the directory
                System.out.println("Enter the files name and type:");
                dir.addFile(input.nextLine());
                menu();
            case 4: // delete a file from directory
                System.out.println("Enter a file to be deleted:");
                dir.deleteFile(input.nextLine());
                menu();
            case 5: // delete all files from directory?
                break;
            case 6: // search the directory for a file
                System.out.println("Enter a file to search:");
                menu();
            default: // exit the application
                break;

        }
        input.close();
    }
}