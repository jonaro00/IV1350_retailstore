package integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestInventorySystem {
    private InventorySystem inventory;

    @BeforeEach
    public void setup() {
        inventory = new InventorySystem();
    }
    @AfterEach
    public void teardown() {
        inventory = null;
    }

    @Test
    public void testCorrectIDFromGetItemInfo() {
        String searchedItem = "Apple";
        String result = inventory.getItemInfo(searchedItem).getID();
        assertEquals(searchedItem, result, "Item from inventory does not have same ID as searched item.");
    }
    @Test
    public void testNullFromIncorrectID() {
        String madeUpItem = "ThisItemSurelyDoesNotExist... or?";
        ItemDTO result = inventory.getItemInfo(madeUpItem);
        assertNull(result, "Made up item did not return null.");
    }
}
