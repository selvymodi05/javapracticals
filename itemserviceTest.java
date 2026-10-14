
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class itemserviceTest {

    @Test
    void addingItemIncreasesCount() {
        itemservice service = new itemservice();

        service.addItem("Book");

        assertEquals(1, service.getCount());
    }

    @Test
    void addingTwoItemsIncreasesCountByTwo() {
        itemservice service = new itemservice();

        service.addItem("Book");
        service.addItem("Pen");

        assertEquals(2, service.getCount());
    }

    @Test
    void emptyNameThrowsException() {
        itemservice service = new itemservice();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.addItem("")
        );
    }

    @Test
    void invalidIndexThrowsException() {
        itemservice service = new itemservice();

        assertThrows(
            IndexOutOfBoundsException.class,
            () -> service.getItem(0)
        );
    }
}
