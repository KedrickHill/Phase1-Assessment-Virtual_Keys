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
        Directory dir = new Directory(PATH);
        int option = input.nextInt();
        switch (option) {
            case 1: // display current directory
                System.out.println("Your Current Directory: " + dir.getAbsolutePath());
                menu();
            case 2: // add a file to the directory
                System.out.println("Enter the files name and type:");
                dir.addFile(input.nextLine());
            case 3: // delete a file from directory
                System.out.println("Enter a file to be deleted:");
                dir.deleteFile(input.nextLine());
            case 4: // delete all files from directory?
            case 5: // search the directory for a file
                System.out.println("Enter a file to search:");
            case 6: // exit the application

        }
    }
}