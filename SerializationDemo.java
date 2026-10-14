
import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    void display() {
        System.out.println(id + " " + name + " " + password);
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "Aman", "abc123"),
            new Student(2, "Riya", "xyz456")
        };

        try {
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("students.dat")
            );
            out.writeObject(students);
            out.close();

            ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("students.dat")
            );
            Student[] loaded = (Student[]) in.readObject();
            in.close();

            for (Student s : loaded) {
                s.display();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
