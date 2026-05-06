package Library;

public class LibraryItem {
    protected String itemId;
    protected String title;
    protected boolean available;

    public LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
        this.available = true;
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String getInfo() {
    return "ID: " + itemId + ", Title: " + title;
}
}