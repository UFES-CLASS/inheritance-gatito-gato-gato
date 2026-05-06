package Library;
import java.util.Scanner;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<LibraryItem> inventory = new ArrayList<>();
        ArrayList<Member> newMember = new ArrayList<>();

        newMember.add(new Member("011", "Juan Carlos", "08123456789"));
        inventory.add(new Book("B01", "Twokinds", "Thomas Fischbach", "Fantasy"));
        inventory.add(new Book("B02", "Gravitation", "Charles W. Misner", "Physics"));

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== Welcome to the Library System v0.8 ===");
            System.out.println("1. Login as a Librarian");
            System.out.println("2. Login as a Member");
            System.out.println("3. Continue as Guest");
            System.out.println("4. Exit this program");
            System.out.print("Please pick an option (1-4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": 
                    System.out.println("--- Librarian Login ---");
                    System.out.print("Enter Librarian Name: ");
                    String libName = scanner.nextLine();
                    System.out.print("Enter Librarian Id: ");
                    String staffId = scanner.nextLine();

                    // Login Damian
                    if (libName.equals("Damian") && staffId.equals("101")) {
                        System.out.println("Login Successful! Welcome " + libName);
                        Librarian admin = new Librarian(staffId, libName);
                        runLibrarianMenu(scanner, inventory, newMember, admin);
                    } else {
                        System.out.println("Invalid Librarian Login Info");
                    }
                    break;

                case "2": 
                    System.out.println("--- Member Login ---");
                    System.out.print("Enter Member Name: ");
                    String findName = scanner.nextLine();
                    System.out.print("Enter Member Id: ");
                    String findId = scanner.nextLine();

                    boolean found = false;
                    for (Member m : newMember) {
                        if (m.getName().equalsIgnoreCase(findName) && m.getId().equals(findId)) {
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("Login Successful! Welcome back.");
                        runMemberMenu(scanner, inventory);
                    } else {
                        System.out.println("Invalid Credentials");
                    }
                    break;

                case "3":
                    runMemberMenu(scanner, inventory);
                    break;

                case "4":
                    System.out.println("See you later alligator!");
                    isRunning = false; 
                    break;
            }
        }
        scanner.close();
    }

    public static void runLibrarianMenu(Scanner scanner, ArrayList<LibraryItem> inventory, ArrayList<Member> newMember, Librarian admin) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- Librarian Menu ---");
            System.out.println("1. Add New Books (Overloading Test)");
            System.out.println("2. Register a New Member");
            System.out.println("3. View All Items (Polymorphism Test)");
            System.out.println("4. Logout");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    
                    System.out.print("Add Genre? (y/n): ");
                    if(scanner.nextLine().equalsIgnoreCase("y")) {
                        System.out.print("Enter Genre: ");
                        String genre = scanner.nextLine();
                        admin.addBook(inventory, id, title, author, genre);
                    } else {
                        admin.addBook(inventory, id, title, author);
                    }
                    break; 

                case "2":
                    registerNewMember(scanner, newMember);
                    break;

                case "3":
                    System.out.println("\n--- Current Inventory ---");
                    for(LibraryItem item : inventory) {
                        System.out.println(item.getInfo());
                    }
                    break;

                case "4":
                    inMenu = false;
                    break;
            }
        }
    }

    public static void runMemberMenu(Scanner keyboard, ArrayList<LibraryItem> inventory) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- MEMBER MENU ---");
            System.out.println("1. Borrow an Item");
            System.out.println("2. Return an Item");
            System.out.println("3. Logout");
            System.out.print("Choose: ");
            
            String choice = keyboard.nextLine();
            switch (choice) {
                case "1": 
                    System.out.print("Enter title to borrow: ");
                    String sTitle = keyboard.nextLine();
                    boolean itemFound = false;

                    for (LibraryItem item : inventory) {
                        if (item.getTitle().equalsIgnoreCase(sTitle)) {
                            itemFound = true;
                            if (item.isAvailable()) {
                                item.setAvailable(false);
                                System.out.println("Success! You borrowed: " + item.getTitle());
                            } else {
                                System.out.println("Sorry, item is checked out.");
                            }
                            break; 
                        }
                    }
                    if (!itemFound) System.out.println("Item not found.");
                    break;
                case "2": 
                    System.out.print("Enter title to return: ");
                    String rTitle = keyboard.nextLine();
                    for (LibraryItem item : inventory) {
                        if (item.getTitle().equalsIgnoreCase(rTitle)) {
                            item.setAvailable(true);
                            System.out.println("Returned: " + item.getTitle());
                            break;
                        }
                    }
                    break;
                case "3": 
                    inMenu = false; 
                    break;
            }
        }
    }

    public static void registerNewMember(Scanner scanner, ArrayList<Member> newMember) {
        System.out.print("Enter new Member ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        
        newMember.add(new Member(id, name, phone));
        System.out.println("Success! " + name + " is now a member.");
    }
}