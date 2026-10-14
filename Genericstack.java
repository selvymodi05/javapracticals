
class Stack<T> {
    private Object[] arr;
    private int top;

    Stack(int size) {
        arr = new Object[size];
        top = -1;
    }

    public void push(T value) {
        if (top == arr.length - 1) {
            System.out.println("Stack is full.");
            return;
        }

        arr[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return null;
        }

        T value = (T) arr[top];
        arr[top--] = null;
        return value;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class Genericstack {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>(3);

        s1.push(10);
        s1.push(20);

        System.out.println("Integer stack: " + s1.pop());
        System.out.println("Integer stack: " + s1.pop());
        System.out.println("Integer stack: " + s1.pop());

        Stack<String> s2 = new Stack<>(3);

        s2.push("Java");
        s2.push("Python");

        System.out.println("String stack: " + s2.pop());
        System.out.println("String stack: " + s2.pop());
    }
}
