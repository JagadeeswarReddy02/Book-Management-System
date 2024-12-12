package bookstore;

import java.util.ArrayList;
import java.util.List;
class Cart {
    private final List<Media> cartItems; // Defensive copying with final
    private double totalPrice;

    public Cart() {
        cartItems = new ArrayList<>();
        totalPrice = 0.0;
    }

    public void addToCart(Media media) {
        cartItems.add(media);
        totalPrice += media.getPrice();
    }

    public void displayCart() {
        System.out.println("Your Cart:");
        cartItems.forEach(Media::displayDetails); // Method reference
        System.out.printf("Total Price: $%.2f\n", totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}


