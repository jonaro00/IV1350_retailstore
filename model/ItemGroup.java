package model;

import integration.ItemDTO;

/**
 * Represents one or multiple of the same item (ItemDTO and quantity).
 */
public class ItemGroup {
    private final ItemDTO item;
    private int quantity;

    ItemGroup(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * @param quantity The amount of items to add to this group.
     */
    public void add(int quantity) {
        this.quantity += quantity;
    }

    /**
     * @return The total price of the item(s) in the group (including VAT).
     */
    public float getTotalPrice() {
        return item.getPrice() * quantity + getTotalVAT();
    }

    /**
     * @return The total VAT of the item(s).
     */
    public float getTotalVAT() {
        return item.getPrice() * item.getVAT() * quantity;
    }

    /**
     * @return The ItemDTO this group represents.
     */
    public ItemDTO getItem() {
        return item;
    }

    /**
     * @return The number of items in this group.
     */
    public int getQuantity() {
        return quantity;
    }
}
