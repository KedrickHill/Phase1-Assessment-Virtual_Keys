# Phase1-Assessment-Virtual_Keys
A Full Stack Development Application ran through Command Line issued and directed by Simplilearn. Created to show the ability of use with java and agile techniques. Sprints and GIT techniques are applied and source code is written using Java 1.8 JDK and JRE. Project was created and worked on for a duration of 15 work days from its initial commit. 

## The Working Problem
Company Lockers Pvt. Ltd. hired you as a Full Stack Developer. They aim to digitize their products and chose LockedMe.com as their first project to start with. You’re asked to develop a prototype of the application. The prototype of the application will be then presented to the relevant stakeholders for the budget approval. Your manager has set up a meeting where you’re asked to present the following in the next 15 working days (3 weeks).

## Requirements

- [x] Specification document - Product’s capabilities, appearance, and user interactions

- [x] Number and duration of sprints required 

- [x] Setting up Git and GitHub account to store and track your enhancements of the prototype 

- [x] Java concepts being used in the project 

- [x] Data Structures where sorting and searching techniques are used. 

- [x] Generic features and three operations: 

  - [x] Retrieving the file names in an ascending order

  - [x] Business-level operations:

    - [x] Option to add a user specified file to the application

    - [x] Option to delete a user specified file from the application

    - [x] Option to search a user specified file from the application

    - [x] Navigation option to close the current execution context and return to the main context

  - [x] Option to close the application 
  
### Features  
- [x] Plan more than two sprints to complete the application

- [ ] Document the flow of the application and prepare a flow chart 

- [ ] List the core concepts and algorithms being used to complete this application

- [ ] Code to display the welcome screen. It should display:

  - [x] Application name and the developer details 

  - [x] The details of the user interface such as options displaying the user interaction information 

  - [x] Features to accept the user input to select one of the options listed 

- [x] The first option should return the current file names in ascending order. The root directory can be either empty or contain few files or folders in it

- [x] The second option should return the details of the user interface such as options displaying the following:

  - [x] Add a file to the existing directory list

    - [x] You can ignore the case sensitivity of the file names 

  - [x] Delete a user specified file from the existing directory list

    - [x] You can add the case sensitivity on the file name in order to ensure that the right file is deleted from the directory list

    - [x] Return a message if FNF (File not found)

  - [x] Search a user specified file from the main directory

    - [x] You can add the case sensitivity on the file name to retrieve the correct file

    - [x] Display the result upon successful operation

    - [x] Display the result upon unsuccessful operation

  - [x] Option to navigate back to the main context

- [x] There should be a third option to close the application

- [x] Implement the appropriate concepts such as exceptions, collections, and sorting techniques for source code optimization and increased performance 

The goal of the company is to deliver a high-end quality product as early as possible. 

# Virtual Keys Application
## How to Run Virtual Keys
Running Virtual Keys Application is simple and can be run as a normal program in command line. Nothing super special here that is complicated.
## The Main Menu
The Main Menu consists of the ability to show the list of files in the current working directory which is then moved to the MockDir in this project. The Second option on the menu moves the user to the sub menu called File Managment were they can add, delete, and search files that are in the mock directory. Lastly, the main menu allows the user to close the application. The menu is shown below:
```
****************************************************************

WELCOME TO LOCKEDME.COM

****************************************************************

Developed by: Kedrick Hill

Use numerical values for pathing along routes.
Selecting option 1 will display all the current files in the directory
Selecting option 2 brings you to file managment where you can create, delete, and search files.
Selecting option 3 or a invalid choice will close the application.

***** MAIN MENU *****
1- Show All Files
2- File Management
3- Exit LockedMe

Enter a Choice:

```
## Showing File List in a Directory
The Showing all files in the directory shows all files and directorys that are in the mock directory. It uses a array of files to store the data which can be accessed through the method *showAllFiles()* which is shown below:
```
public List<String> showAllFiles() {
        return files.stream().map(f -> f.getName()).collect(Collectors.toList());
    }
```
This collects all of the names of the files rather than all of the files absoulute paths.

## File Management
File Management is a sub menu to main which allows the user to manipulate and search files in the mock directory. The user can Add, delete, or search files that are of a valid. In order for the string to be a valid file name it must contain the file name and its type. Using the *isValidFile()* shown below, the application will ensure that the user is entering a valid file name when adding files.
```
public boolean isValidFile(String name) {       
        Pattern p = Pattern.compile("(\\w+\\.(txt|jpeg|xlsx|docx|png|csv|dat|db|sql|tar|xml|gif|ppt|pptx))", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(name);
        if (!m.matches()) return false;
        return true;
    }
```

The Users view of the File Management Menu:

```
***** FILE MANAGEMENT *****
1- Add a File
2- Delete a File
3- Search for a File       
4- Return to Main Menu     

Enter a Choice:

```

### Adding a New File to Directory
The first option in File Management allows the user to add a new file to the directory. The user must enter a valid file in order for it to be added to the mock directory. If failing to do so then they are sent back to File Management. The user is prompted to enter the name and when successful its is added the list of files in the directory and muct be deleted if the user wants to ensure they have the default files. The following code demonstrates the methods for adding a file:
```
------------------------------------------------------App Display------------------------------------------------------------
Enter the files name and type:
temp.txt //successful

File has been created

temp //unsuccessful

File Name Invalid.

Returning to File Management...

------------------------------------------------------Menu.java------------------------------------------------------------
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
                
------------------------------------------------------Directory.java------------------------------------------------------------

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
```

### Deleting a File From Directory
The following option in File Management is the ability to delete a file from the directory. A user can delete any file that is not a directory in the list of files from mock directory. The user is prompted to enter file name and type which is then checked for a match in the list then checked if it is a directory. If its a match and not a directory then its deleted, else the app responds with a statement that the file they want to delete is a directory. This process is shown below:
```
------------------------------------------------------App Display------------------------------------------------------------

Enter a file to be deleted:
temp 

//unsuccessful: cannot find
FILE NOT FOUND. CANNOT DELETE.

//successful
DELETING FILE...

temp.txt has been deleted.

//unsuccessful: directory
Enter a file to be deleted:
Users

FILE IS A DIRECTORY. CANNOT DELETE.
------------------------------------------------------Menu.java------------------------------------------------------------

case 2: // delete a file from the directory
                System.out.println("\nEnter a file to be deleted:");
                input.nextLine();
                String del = input.nextLine();
                dir.deleteFile(del);
                subMenu();
                break;
                
------------------------------------------------------Directory.java------------------------------------------------------------

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
```

### Searching for a File in the Directory
The Third option in file Management is the ability to search for a file in the directory. The user is allowed to search for any file or directory in the mock dir list. The output of a successful search will display *File Found!* and a *Could not find the file* on a unsuccessful one. The search method is shown below with the process:
```
------------------------------------------------------App Display------------------------------------------------------------

//successful
Enter a file to search:
Users

File Found!

//unsuccessful
Enter a file to search:
User

Could not find the file
------------------------------------------------------Menu.java------------------------------------------------------------

case 3: // search for a file in the directory
                System.out.println("\nEnter a file to search:");
                input.nextLine();
                String srch = input.nextLine();
                dir.searchFile(srch);
                subMenu();
                break;
                
------------------------------------------------------Directory.java------------------------------------------------------------

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
    
```
### Returning to the Menu
The final option in File Management is the ability to return to the previous menu, Main. Any other value above this defaults back to File Management with a out print stating an invalid input.

## Closing the Application
The Last option in the Main Menu is closing the application which can be done by entering the integer value 3 and if the user enters a value that is not on the list the application out prints a invalid choice and then closes the application.

