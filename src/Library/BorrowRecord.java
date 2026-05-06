package Library;

//This file is for record the book that the user borrow that use setter and getter

public class BorrowRecord {
    private Member member;
    private LibraryItem item;

    public BorrowRecord(Member member, LibraryItem item) {
        this.member = member;
        this.item = item;
    }

    public void showRecord() {
        System.out.println(member.getName() + " borrowed " + item.getTitle());
    }
}