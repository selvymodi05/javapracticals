
import java.util.*;

class OutOfStockException extends Exception {
    int shortfall;

    OutOfStockException(int shortfall) {
        super("Insufficient stock. Shortfall: " + shortfall);
        this.shortfall = shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    int stock = 10;

    void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than zero."
            );
        }

        if (qty > stock) {
            throw new OutOfStockException(qty - stock);
        }

        stock -= qty;
        System.out.println(qty + " units of " + item + " issued.");
        System.out.println("Remaining stock: " + stock);
    }
}

public class WarehouseDemo {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();

        String[] items = {"Pen", "Book", "Pencil", "Bag"};
        int[] quantities = {3, 12, 0, 4};

        for (int i = 0; i < items.length; i++) {
            try {
                w.issue(items[i], quantities[i]);
            } catch (OutOfStockException e) {
                System.out.println(e.getMessage());
            } catch (InvalidQuantityException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("All requests processed.");
    }
}
