package integration;

/**
 * Thrown when an item ID could not be found in <code>InventorySystem</code>.
 */
public class ItemIDNotFoundException extends Exception {
    private final String notFoundItemID;

    /**
     * Creates a new instance, specifying which item ID wasn't found.
     * @param itemIDThatWasNotFound The item ID that was not found.
     */
    public ItemIDNotFoundException(String itemIDThatWasNotFound) {
        super(itemIDThatWasNotFound + " was not found in Inventory.");
        this.notFoundItemID = itemIDThatWasNotFound;
    }

    /**
     * @return The item ID that was not found.
     */
    public String getNotFoundItemID() {
        return this.notFoundItemID;
    }
}
