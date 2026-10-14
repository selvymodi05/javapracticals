
class MyResource implements AutoCloseable {
    public void use() {
        System.out.println("Resource is being used.");
    }

    public void close() {
        System.out.println("Resource is closed.");
    }
}

public class ResourceDemo {
    public static void main(String[] args) {
        try (MyResource r = new MyResource()) {
            r.use();
            throw new RuntimeException("Original error occurred.");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
