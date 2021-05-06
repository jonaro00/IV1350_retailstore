package integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestIntegration {
    @Test
    public void testInventorySystemSearch() {
        InventorySystem inventory = new InventorySystem();
        String searchedItem = "Apple";
        String result = inventory.getItemInfo(searchedItem).getID();
        assertEquals(searchedItem, result, "Item from inventory does not have same ID as searched item.");
    }
}
