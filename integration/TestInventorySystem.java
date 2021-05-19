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
        try {
            String result = inventory.getItemInfo(searchedItem).getID();
            assertEquals(searchedItem, result, "Item from inventory does not have same ID as searched item.");
        } catch (Exception e) {
            fail("Could not get valid item ID.");
        }
    }
    @Test
    public void testExceptionFromIncorrectID() {
        String madeUpItem = "ThisItemSurelyDoesNotExist... or?";
        try {
            inventory.getItemInfo(madeUpItem);
            fail("Exception was not thrown for invalid item ID.");
        } catch (ItemIDNotFoundException e) {
            assertEquals(madeUpItem, e.getNotFoundItemID(), "Exception contained wrong item ID.");
        } catch (Exception e) {
            fail("Incorrect exception thrown.");
        }
    }
    @Test
    public void testExceptionFromDBFailure() {
        String makeDatabaseFail = "MakeDatabaseFail";
        try {
            inventory.getItemInfo(makeDatabaseFail);
        } catch (InventorySystemException e) {
            // good
        } catch (Exception e) {
            fail("Incorrect exception thrown.");
        }
    }
}
