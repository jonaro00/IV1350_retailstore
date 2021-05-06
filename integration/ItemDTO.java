package integration;

/**
 * Stores data related to an item.
 */
public final class ItemDTO {
    private final String ID;
    private final float price;
    private final float VAT;
    private final String description;

    ItemDTO(String ID, float price, float VAT, String description){
        this.ID = ID;
        this.price = price;
        this.VAT = VAT;
        this.description = description;
    }

    /**
     * @return The ID (name) of the item
     */
    public String getID() {
        return ID;
    }

    /**
     * @return The price of the item (excl VAT)
     */
    public float getPrice() {
        return price;
    }

    /**
     * @return The value of VAT, for example 0.25
     */
    public float getVAT() {
        return VAT;
    }

    /**
     * @return The item description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return A String representation of the item
     */
    @Override
    public String toString() {
        return String.format("%s (%.2f) - %s", ID, price, description);
    }
}
