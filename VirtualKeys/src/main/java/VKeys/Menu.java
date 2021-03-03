package VKeys;

import java.io.File;
import java.util.Scanner;

public class Menu {

    // Working directory
        static Directory dir = new Directory(new File(System.getProperty("user.dir") + "/MockDir"));

    public static void menu() {

        Scanner input = new Scanner(System.in);
        System.out.println("***** MAIN MENU *****");
        System.out.println(
                "1- Show All Files\n2- File Management\n3- Exit LockedMe\n");

        System.out.println("Enter a Choice:");
        int option = input.nextInt();
        switch (option) {
            case 1: // show all files in directory
                System.out.println("\nFiles in Directory: " + dir.showAllFiles() + "\n");
                menu();
                break;
            
            case 2: // move to File Management processes
                subMenu();
                break;

            case 3: //exit the application
                System.out.println("\nClosing Application...\n");
                break;

            default: // closes application if not a 1-3 option
                System.out.println("\nInvalid choice! Closing Application...\n");
                break;
        }
        input.close();
    }


    public static void subMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n***** FILE MANAGEMENT *****");
        System.out.println("1- Add a File\n2- Delete a File\n3- Search for a File\n4- Return to Main Menu\n");
        System.out.println("Enter a Choice:");
        int option = input.nextInt();
        switch(option) {
            case 1: // adds a file to current directory
                System.out.println("\nEnter the files name and type:");
                input.nextLine();
                String add = input.nextLine();
                if (dir.isValidFile(add)) {
                    dir.addFile(add);
                    System.out.println("\nFile has been created\n");
                }
                else {
                    System.out.println("\nFile Name is Invalid. \n\nReturning to File Management...\n");
                }
                subMenu();
                break;

            case 2: // delete a file from the directory
                System.out.println("\nEnter a file to be deleted:");
                input.nextLine();
                String del = input.nextLine();
                dir.deleteFile(del);
                subMenu();
                break;

            case 3: // search for a file in the directory
                System.out.println("\nEnter a file to search:");
                input.nextLine();
                String srch = input.nextLine();
                dir.searchFile(srch);
                subMenu();
                break;

            case 4: // return to the main menu
                System.out.println("\nReturning to Main Menu...\n");
                menu();
                break;

            default:
                System.out.println("\nInvalid Choice! Try Again.");
                subMenu();
                break;
        }
        input.close();
    }
}