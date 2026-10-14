
import java.util.ArrayList;

public class itemService {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Item name cannot be empty."
            );
        }

        items.add(new Item(name));
    }

    public int getCount() {
        return items.size();
    }

    public Item getItem(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException(
                "Invalid item index."
            );
        }

        return items.get(index);
    }
}
