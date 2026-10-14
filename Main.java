
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        itemService service = new itemService();

        while (true) {
            System.out.println("\n1. Add item");
            System.out.println("2. Show count");
            System.out.println("3. Show item");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter item name: ");
                        service.addItem(sc.nextLine());
                        System.out.println("Item added.");
                        break;

                    case 2:
                        System.out.println(
                            "Total items: " + service.getCount()
                        );
                        break;

                    case 3:
                        System.out.print("Enter index: ");
                        int index = Integer.parseInt(sc.nextLine());
                        System.out.println(
                            service.getItem(index).getName()
                        );
                        break;

                    case 4:
                        System.out.println("Exiting.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (IllegalArgumentException |
                     IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
