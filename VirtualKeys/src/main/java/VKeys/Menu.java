package VKeys;

import java.util.Scanner;

public class Menu {

    int index = 0;

    public static void menu() {
        // TODO: ask user for input on what they would like to do in the app
        // TODO: using a switch to change the case would work here (Check with previous
        // assignemnt: Bug Fixes)

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option) {
            case 1: // display current directory
                System.out.println("Your Current Directory: " + currentDir());
            case 2: // add a file to the directory
            case 3: // delete a file from directory
            case 4: // delete all files from directory?
            case 5: // search the directory for a file
            case 6: // exit the application

        }
    }
}