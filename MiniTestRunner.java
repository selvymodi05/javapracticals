import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class MyTests {

    @Run
    public void testLogin() {
        System.out.println("testLogin executed");
    }

    @Run
    public void testSignup() {
        System.out.println("testSignup executed");
    }

    public void normalMethod() {
        System.out.println("normalMethod executed");
    }

    @Run
    public void testCalculator() {
        System.out.println("testCalculator executed");
    }
}

public class MiniTestRunner {

    public static void main(String[] args) {

        MyTests obj = new MyTests();

        int count = 0;

        Method[] methods = MyTests.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Run.class)) {

                try {
                    method.invoke(obj);
                    count++;
                } catch (Exception e) {
                    System.out.println("Error running "
                            + method.getName());
                }
            }
        }

        System.out.println("Total methods executed: " + count);
    }
}