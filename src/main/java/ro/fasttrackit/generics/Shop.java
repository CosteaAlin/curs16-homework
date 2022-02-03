package ro.fasttrackit.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shop<T extends ShopItem> {
    private final List<T> items = new ArrayList<>();

    public Shop(List<T> items) {
        this.items.addAll(items);
    }

    public void addItem(T item) {
        if (item == null) {
            throw new IllegalArgumentException("You can not pass null as parameter!");
        }
        this.items.add(item);
    }

    public List<T> getItems() {
        return new ArrayList<>(items);
    }

    public List<T> findByCategory(Category cat) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (item.category() == cat) {
                result.add(item);
            }
        }
        return result;
    }

    public List<T> findWithLowerPrice(int maxPrice) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (item.price() < maxPrice) {
                result.add(item);
            }
        }
        return result;
    }

    public Optional<T> findByName(String name) {
        for (T item : items) {
            if (item.name().equalsIgnoreCase(name)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public Optional<T> removeItem(String name) {
        for (T item : items) {
            if (item.name().equalsIgnoreCase(name)) {
                items.remove(item);
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }
}