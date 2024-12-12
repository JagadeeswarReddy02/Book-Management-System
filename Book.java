package bookstore;

import java.util.*;
enum Language { ENGLISH, HINDI, FRENCH }
enum Genre { EDUCATION, FICTION, BUSINESS }

final class Book extends Media {
    private Language language;
    private List<Genre> genre;
    private int pages;

    // Constructor
    public Book(String bookName, String author, double price, Language language, Genre genre, int pages) {
        super(bookName, author, price); // Call the parent class constructor
        this.language = language;
        this.genre = Arrays.asList(genre); // Convert to list
        this.pages = pages;
    }

    // Overloaded constructor
    public Book(String bookName, String author, double price, Language language, int pages, Genre... genres) {
        super(bookName, author, price);
        this.language = language;
        this.genre = List.of(genres); // Using varargs
        this.pages = pages;
    }

    // Getters
    public Language getLanguage() { return language; }
    public List<Genre> getGenre() { return genre; }
    public int getPages() { return pages; }

    // Overridden method to display book details
    @Override
    public void displayDetails() {
        System.out.printf("%s | %s | $%.2f | %s | %s | %d pages\n",
                          getBookName(), getAuthor(), getPrice(), language, genre, pages);
    }
}

