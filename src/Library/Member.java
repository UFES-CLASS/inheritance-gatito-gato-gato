package Library;

//This file is to store the member data like Member Id, Name, and their phone number that use encapsulation and setter and getter.

public class Member extends Person {
    private String phone;

    public Member(String id, String name, String phone) {
        super(id, name); 
        this.phone = phone;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String getInfo() {
        return "[Member] " + name + " (ID: " + id + "), Phone: " + phone;
    }
}
