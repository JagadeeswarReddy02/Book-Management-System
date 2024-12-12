package bookstore;

import java.util.*;
import java.util.function.Predicate;

sealed interface StoreOperations permits BookStore {
    void viewBooks();
    void addToCart(int bookNumber);
    void viewCart();
    void makePayment();

    // Default method
    default void showWelcomeMessage() {
        System.out.println("Welcome to the Book Store!");
    }

    // Static method
    static void printDivider() {
        System.out.println("=================================");
    }
}

final class BookStore implements StoreOperations {
    private List<Media> availableMedia;
    private Cart cart;

    public BookStore() {
        var availableMedia = new ArrayList<Media>();
        availableMedia.add(new Book("Java Basics", "John Doe", 25.99, Language.ENGLISH, 300, Genre.EDUCATION));
        availableMedia.add(new Book("Core Java", "John Doe", 15.99, Language.ENGLISH, 100, Genre.EDUCATION, Genre.BUSINESS));
        this.availableMedia = availableMedia;
        var cart = new Cart();
        this.cart = cart;
    }

    @Override
    public void viewBooks() {
        StoreOperations.printDivider();
        System.out.println("Available Books:");
        var predicate = (Predicate<Media>) media -> media instanceof Book;
        availableMedia.stream().filter(predicate).forEach(Media::displayDetails); // Method reference
        StoreOperations.printDivider();
    }

    @Override
    public void addToCart(int bookNumber) {
        var media = availableMedia.get(bookNumber - 1);
        cart.addToCart(media);
        System.out.println("Book is added to Cart...");
    }

    @Override
    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            cart.displayCart();
        }
    }

    @Override
    public void makePayment() {
        System.out.println("Payment processing...");
        System.out.printf("Payment Done! Total: $%.2f\n", cart.getTotalPrice());
    }
}

