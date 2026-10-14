
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public void display() {
        System.out.println(first + " " + second);
    }
}

public class Generics{
    public static <T> T firstElement(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        return arr[0];
    }

    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>();
        b1.set(100);
        System.out.println("Integer: " + b1.get());

        Box<String> b2 = new Box<>();
        b2.set("Java");
        System.out.println("String: " + b2.get());

        Pair<String, Integer> p1 = new Pair<>("Aman", 90);
        p1.display();

        Integer[] nums = {10, 20, 30};
        String[] names = {"Riya", "Selvy", "Aman"};

        System.out.println("First number: " + firstElement(nums));
        System.out.println("First name: " + firstElement(names));
    }
}
