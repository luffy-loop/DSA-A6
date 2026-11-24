
public class Library {

    private String ISBN;
    private String bookTitle;
    private boolean issued;

    // Constructor
    Library(String ISBN, String bookTitle) {

        if (ISBN == null || ISBN.isBlank()) {
            throw new IllegalArgumentException("ISBN cannot be empty");
        }

        if (bookTitle == null || bookTitle.isBlank()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }

        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.issued = false;
    }

    // Issue book
    void issueBook() {

        if (issued) {
            System.out.println("Book is already issued");
        } else {
            issued = true;
            System.out.println("Book issued successfully");
        }
    }

    // Return book
    void returnBook() {

        if (!issued) {
            System.out.println("Book is not issued");
        } else {
            issued = false;
            System.out.println("Book returned successfully");
        }
    }

    // Display book details
    void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Issued: " + issued);
    }

    // Main method
    public static void main(String[] args) {

        Library b = new Library("ISBN101", "Java Programming");

        System.out.println("Book Details:");
        b.display();

        System.out.println("\nIssuing Book:");
        b.issueBook();

        System.out.println("\nAfter Issue:");
        b.display();

        System.out.println("\nReturning Book:");
        b.returnBook();

        System.out.println("\nAfter Return:");
        b.display();
    }
}
