
import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        String[] logins = {
            "aman", "riya", "aman", "selvy",
            "riya", "dev", "selvy", "karan"
        };

        HashSet<String> unique = new HashSet<>();
        LinkedHashSet<String> ordered = new LinkedHashSet<>();

        for (String name : logins) {
            unique.add(name);
            ordered.add(name);
        }

        System.out.println("Unique visitors: " + unique.size());
        System.out.println("First three distinct names:");

        int count = 0;

        for (String name : ordered) {
            if (count == 3) {
                break;
            }

            System.out.println(name);
            count++;
        }
    }
}
