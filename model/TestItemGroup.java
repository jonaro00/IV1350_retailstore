package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.ItemDTO;

import static org.junit.jupiter.api.Assertions.*;

public class TestItemGroup {
    private ItemDTO dummyItem = new ItemDTO("ID", 10.0F, 0.25F, "description");

    @Test
    public void testAddingQuantity() {
        int initialQuantity = 3;
        ItemGroup group = new ItemGroup(dummyItem, initialQuantity);
        int addedQuantity = 8;
        group.add(addedQuantity);
        int expected = initialQuantity + addedQuantity;
        int actual = group.getQuantity();
        assertEquals(expected, actual, "Incorrect quantity after adding");
    }

    @Test
    public void testAddingNegativeQuantity() {
        int initialQuantity = 5;
        ItemGroup group = new ItemGroup(dummyItem, initialQuantity);
        int addedQuantity = -2;
        group.add(addedQuantity);
        int expected = initialQuantity + addedQuantity;
        int actual = group.getQuantity();
        assertEquals(expected, actual, "Incorrect quantity after adding negative amount");
    }

    @Test
    public void testTotalVAT() {
        int quantity = 5;
        ItemGroup group = new ItemGroup(dummyItem, quantity);
        float expected = dummyItem.getPrice() * dummyItem.getVAT() * quantity;
        float actual = group.getTotalVAT();
        assertEquals(expected, actual, "Incorrect VAT");
    }

    @Test
    public void testTotalPrice() {
        int quantity = 7;
        ItemGroup group = new ItemGroup(dummyItem, quantity);
        float expected = dummyItem.getPrice() * (1 + dummyItem.getVAT()) * quantity;
        float actual = group.getTotalPrice();
        assertEquals(expected, actual, "Incorrect Price");
    }
}
