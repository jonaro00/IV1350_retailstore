package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.StringJoiner;

import integration.ItemDTO;

/**
 * Handles items, price and receipt for an ongoing sale.
 */
public class Sale {
    private ArrayList<ItemGroup> items;

    /**
     * Starts a new sale with an empty list of items.
     */
    public Sale() {
        items = new ArrayList<ItemGroup>();
    }

    /**
     * Add item(s) to this sale
     *
     * @param item The item to add
     * @param quantity How many of the item to add
     */
    public void addItem(ItemDTO item, int quantity) {
        for (ItemGroup itemgroup : items) {
            if (itemgroup.getItem().equals(item)) {
                itemgroup.add(quantity);
                return;
            }
        }
        items.add(new ItemGroup(item, quantity));
    }

    /**
     * @return The total price (including VAT) of the items in this sale.
     */
    public float getTotalPrice() {
        float sum = 0;
        for (ItemGroup itemgroup : items)
            sum += itemgroup.getTotalPrice();
        return sum;
    }

    /**
     * @return The total VAT of all the items in this sale.
     */
    public float getTotalVAT() {
        float sum = 0;
        for (ItemGroup itemgroup : items)
            sum += itemgroup.getTotalVAT();
        return sum;
    }

    /**
     * @return A receipt representing this sale.
     */
    public Receipt getReceipt() {
        StringJoiner builder = new StringJoiner("\n");
        builder
        .add("Your local store")
        .add("Unknown Road 1337, JavaLand")
        .add(LocalDateTime.now().toString())
        .add("")
        ;
        for (ItemGroup itemgroup : items) {
            ItemDTO item = itemgroup.getItem();
            builder.add(String.format("%s: %d x %.2f", item.getID(), itemgroup.getQuantity(), item.getPrice()));
        }
        builder
        .add("----------------")
        .add("Total price: " + this.getTotalPrice())
        .add("Total VAT:   " + this.getTotalVAT())
        ;
        return new Receipt(builder.toString());
    }
}
