
public class Product {
    private String productName;
    private double price;
    private int quantity;

    Product(String productName, double price, int quantity) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be blank");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    void updatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
    }

    void updateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        this.quantity = quantity;
    }

    void display() {
        System.out.println("Product: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public static void main(String[] args) {
        Product p = new Product("Laptop", 50000, 5);
        p.updatePrice(45000);
        p.updateQuantity(10);
        p.display();
    }
}
