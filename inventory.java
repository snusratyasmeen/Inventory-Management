import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class InventoryManagement {

    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        products.add(new Product(id, name, price, quantity));

        System.out.println("Product added successfully!");
    }

    static void viewProducts() {

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n===== PRODUCT LIST =====");

        for (Product p : products) {
            System.out.println(
                "ID: " + p.id +
                " | Name: " + p.name +
                " | Price: Rs." + p.price +
                " | Quantity: " + p.quantity
            );
        }
    }

    static void searchProduct() {

        sc.nextLine();

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Product p : products) {

            if (p.name.equalsIgnoreCase(name)) {
                System.out.println("\nProduct Found!");
                System.out.println("ID: " + p.id);
                System.out.println("Name: " + p.name);
                System.out.println("Price: Rs." + p.price);
                System.out.println("Quantity: " + p.quantity);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }

    static void updateStock() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : products) {

            if (p.id == id) {

                System.out.print("Enter new quantity: ");
                p.quantity = sc.nextInt();

                System.out.println("Stock updated successfully!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    static void deleteProduct() {

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : products) {

            if (p.id == id) {
                products.remove(p);

                System.out.println("Product deleted successfully!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    static void totalStockValue() {

        double total = 0;

        for (Product p : products) {
            total += p.price * p.quantity;
        }

        System.out.println("Total Stock Value: Rs." + total);
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== INVENTORY MANAGEMENT =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Delete Product");
            System.out.println("6. Total Stock Value");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    viewProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateStock();
                    break;

                case 5:
                    deleteProduct();
                    break;

                case 6:
                    totalStockValue();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
