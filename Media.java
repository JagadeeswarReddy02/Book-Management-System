package bookstore;

abstract sealed class Media permits Book { // Sealed class
    private final String bookName;
    private final String author;
    private final double price;

    // Constructor
    public Media(String bookName, String author, double price) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    // Getters
    public String getBookName() { return bookName; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }

    // Abstract method to display media details
    public abstract void displayDetails();
}