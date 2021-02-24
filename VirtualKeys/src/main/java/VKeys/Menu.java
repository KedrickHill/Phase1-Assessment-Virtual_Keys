package VKeys;

import java.io.File;
import java.util.Scanner;

public class Menu {

    int index = 0;
    final static String PATH = System.getProperty("user.dir") + "/MockDir";

    public static void menu() {

        Scanner input = new Scanner(System.in);
        Directory dir = new Directory(new File(PATH));
        System.out.println(
                "1- Display Current Directory\n2- Show All Files\n3- Add a File\n4- Delete a File\n5- Delete All Files\n6- Search for a File\n7- Exit LockedMe\n");

        System.out.println("Enter a Choice:");
        int option = input.nextInt();
        switch (option) {
            case 1: // display current directory
                System.out.println("\nYour Current Directory: " + dir.getDir() + "\n");
                menu();
                break;

            case 2: // show all files in directory
                System.out.println("\nFiles in Directory: " + dir.showAllFiles() + "\n");
                menu();
                break;

            case 3: // add a file to the directory
                System.out.println("\nEnter the files name and type:");
                input.nextLine();
                String add = input.nextLine();
                dir.addFile(add);
                System.out.println("\nFile has been created\n");
                menu();
                break;

            case 4: // delete a file from directory
                System.out.println("\nEnter a file to be deleted:");
                input.nextLine();
                String del = input.nextLine();
                dir.deleteFile(del);
                System.out.println("\nFile has been deleted\n");
                menu();
                break;

            case 5: // delete all files from directory?
                System.out.println("\nOh! You were thinking about it! To bad.\n");
                menu();
                break;

            case 6: // search the directory for a file
                System.out.println("\nEnter a file to search:");
                input.nextLine();
                String srch = input.nextLine();
                dir.searchFile(srch);
                menu();
                break;

            case 7: //exit the application
                System.out.println("\nClosing Application...\n");
                break;
            default: // asks for
                System.out.println("\nInvalid choice! Closing Application...\n");
                break;

        }
        input.close();
    }
}