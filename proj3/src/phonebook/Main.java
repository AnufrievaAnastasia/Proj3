package phonebook;

public class Main {
    public static void main(String[] args) {
        Record p1 = new Record(1,"1111", "A");
        Record p2 = new Record(2,"2222", "B");
        Record p3 = new Record(3,"2222", "C");
        Record p4 = new Record(4,"3333", "D");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.createRecord(p1);
        phoneBook.createRecord(p2);
        phoneBook.createRecord(p3);
        phoneBook.createRecord(p4);
        phoneBook.updateRecord(p1);
        System.out.println(phoneBook.getAllRecords());
        phoneBook.deleteRecord(25);
        System.out.println(phoneBook.getAllRecords());
    }
}

