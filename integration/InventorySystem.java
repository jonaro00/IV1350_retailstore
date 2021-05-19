package integration;

import java.util.ArrayList;

import model.Sale;

/**
 * Placeholder for an inventory database.
 * Contains test items.
 */
public class InventorySystem {
    private ArrayList<ItemDTO> items;

    InventorySystem() {
        this.items = new ArrayList<ItemDTO>();
        addSampleItems();
    }

    private void addSampleItems() {
        items.add(new ItemDTO("Apple", 4F, 0.25F, "a red apple"));
        items.add(new ItemDTO("Banana", 5F, 0.25F, "a yellow banana"));
        items.add(new ItemDTO("Cherry", 2F, 0.25F, "a red cherry"));
    }

    /**
     * Looks for an item and returns corresponding ItemDTO.
     *
     * @param itemID The item to search for.
     *
     * @return ItemDTO Reference to a matching item.
     *
     * @throws ItemIDNotFoundException If itemID was not found.
     * @throws InventorySystemException If something went wrong while accessing the database.
     */
    public ItemDTO getItemInfo(String itemID) throws ItemIDNotFoundException, InventorySystemException {
        if (itemID.equals("MakeDatabaseFail"))
            throw new InventorySystemException("Connection to database failed.");
        for (ItemDTO item : items)
            if (item.getID().equals(itemID))
                return item;
        throw new ItemIDNotFoundException(itemID);
    }

    /**
     * Placeholder for updating the availible inventory with the items that were sold.
     *
     * @param sale The sale that contains the items purchased
     */
    public void updateInventory(Sale sale) {

    }
}
