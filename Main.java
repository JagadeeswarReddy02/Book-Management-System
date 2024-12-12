package bookstore;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookStore store = new BookStore();
        store.showWelcomeMessage();

        while (true) {
            System.out.println("""
                    1. View Books
                    2. Add Book to Cart
                    3. View Cart
                    4. Payment
                    0. Exit
                    """);
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> store.viewBooks();
                case 2 -> {
                    System.out.print("Enter Book Number: ");
                    int bookNumber = sc.nextInt();
                    store.addToCart(bookNumber);
                }
                case 3 -> store.viewCart();
                case 4 -> store.makePayment();
                case 0 -> {
                    System.out.println("Thank you for visiting!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}



