import java.util.Scanner;

public class TollBooth {

    record Vehicle(String number, String type) {}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int total = 0;
        int bike = 0;
        int car = 0;
        int truck = 0;

        while (true) {

            System.out.print("Enter vehicle number: ");
            String number = sc.nextLine();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type: ");
            String type = sc.nextLine().toLowerCase();

            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type()) {
                case "bike" -> {
                    bike++;
                    yield 20;
                }

                case "car" -> {
                    car++;
                    yield 50;
                }

                case "truck" -> {
                    truck++;
                    yield 150;
                }

                default -> {
                    System.out.println("Invalid type");
                    yield 0;
                }
            };

            total = total + toll;
        }

        String mostFrequent;

        if (bike >= car && bike >= truck) {
            mostFrequent = "bike";
        }
        else if (car >= bike && car >= truck) {
            mostFrequent = "car";
        }
        else {
            mostFrequent = "truck";
        }

        System.out.println("Total toll: " + total);
        System.out.println("Most frequent: " + mostFrequent);

        sc.close();
    }
}