package ro.fasttrackit.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ro.fasttrackit.generics.Category.*;

public class ShopTest {
    Shop<Fruits> fruitsShop;
    Shop<Electronics> electronicsShop;
    Shop<Clothes> clothesShop;

    @BeforeEach
    void setup() {
        fruitsShop = new Shop<>(List.of(
                new Fruits("apple", 3, ON_SALE),
                new Fruits("orange", 7, NEW)));

        electronicsShop = new Shop<>(List.of(
                new Electronics("refrigerator", 320, ON_SALE),
                new Electronics("microwave", 120, NEW)));

        clothesShop = new Shop<>(List.of(
                new Clothes("jeans", 49, ON_SALE),
                new Clothes("sweater", 59, NEW)));
    }

    @Test
    @DisplayName("WHEN passing a valid item to the function THEN add that item")
    void testAddItem() {
        fruitsShop.addItem(new Fruits("banana", 5, ON_SALE));
        electronicsShop.addItem(new Electronics("TV", 200, NEW));
        clothesShop.addItem(new Clothes("T-Shirt", 99, ON_SALE));

        assertThat(fruitsShop.getItems().size()).isEqualTo(3);
        assertThat(electronicsShop.getItems().size()).isEqualTo(3);
        assertThat(electronicsShop.getItems().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("WHEN trying to add a null item THEN throw an exception")
    void testAddNullItem() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> fruitsShop.addItem(null));
        assertThat(e.getMessage()).isEqualTo("You can not pass null as parameter!");
    }

    @Test
    void testFindByCategory() {
        assertThat(fruitsShop.findByCategory(ON_SALE).size()).isEqualTo(1);
        assertThat(electronicsShop.findByCategory(NEW).size()).isEqualTo(1);
        assertThat(clothesShop.findByCategory(REFURBISHED).size()).isEqualTo(0);
    }

    @Test
    void testFindWithLowerPrice() {
        assertThat(fruitsShop.findWithLowerPrice(5).size()).isEqualTo(1);
        assertThat(electronicsShop.findWithLowerPrice(120).size()).isEqualTo(0);
        assertThat(clothesShop.findWithLowerPrice(60).size()).isEqualTo(2);
    }

    @Test
    void testFindByNameWithSuccess() {
        assertThat(fruitsShop.findByName("apple").isPresent()).isTrue();
        assertThat(electronicsShop.findByName("refrigerator").isPresent()).isTrue();
        assertThat(clothesShop.findByName("jeans").isPresent()).isTrue();
    }

    @Test
    void testFindByNameWithoutSuccess() {
        assertThat(fruitsShop.findByName("test").isPresent()).isFalse();
        assertThat(electronicsShop.findByName("test").isPresent()).isFalse();
        assertThat(clothesShop.findByName("test").isPresent()).isFalse();
    }

    @Test
    void testRemoveItemWithSuccess() {
        assertThat(fruitsShop.removeItem("apple").isPresent()).isTrue();
        assertThat(electronicsShop.removeItem("refrigerator").isPresent()).isTrue();
        assertThat(clothesShop.removeItem("jeans").isPresent()).isTrue();
    }

    @Test
    void testRemoveItemWithoutSuccess() {
        assertThat(fruitsShop.removeItem("test").isPresent()).isFalse();
        assertThat(electronicsShop.removeItem("test").isPresent()).isFalse();
        assertThat(clothesShop.removeItem("test").isPresent()).isFalse();
    }
}
