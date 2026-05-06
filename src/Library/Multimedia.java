package Library;

public class Multimedia extends LibraryItem {
    private String type;
    private String duration;

    public Multimedia(String itemId, String title, String type, String duration) {
        super(itemId, title);
        this.type = type;
        this.duration = duration;
    }

    @Override
    public String getInfo() {
        return "[Multimedia] " + getTitle() + " (" + type + ") - Duration: " + duration;
    }
}