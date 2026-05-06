package Library;

//This file to store the librarian data like Their Name and Staff Id that use setter and getter.

import java.util.ArrayList;

public class Librarian extends Person {
    public Librarian(String id, String name) {
        super(id, name);
    }

    public void addBook(ArrayList<LibraryItem> inventory, String id, String title, String author) {
        inventory.add(new Book(id, title, author, "Unknown")); 
        System.out.println("Book added successfully!");
    }

    public void addBook(ArrayList<LibraryItem> inventory, String id, String title, String author, String genre) {
        inventory.add(new Book(id, title, author, genre)); 
        System.out.println("Book with genre added successfully!");
    }
}