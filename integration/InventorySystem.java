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
     * Looks for an item and returns corresponding ItemDTO or null of not found.
     *
     * @param itemID The item to search for
     *
     * @return ItemDTO Reference to a matching item or null
     */
    public ItemDTO getItemInfo(String itemID) {
        for (ItemDTO item : items)
            if (item.getID().equals(itemID))
                return item;
        return null;
    }

    /**
     * Placeholder for updating the availible inventory with the items that were sold.
     *
     * @param sale The sale that contains the items purchased
     */
    public void updateInventory(Sale sale) {

    }
}
