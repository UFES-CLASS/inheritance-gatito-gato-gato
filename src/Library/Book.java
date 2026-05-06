package Library;

//This class is use to save the book data

public class Book extends LibraryItem {
    private String author;
    private String genre;

    public Book(String itemId, String title, String author, String genre) {
        super(itemId, title); 
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String getInfo() {
        return "[Book] " + getTitle() + " | Author: " + author + " | Genre: " + genre;
    }

    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
}