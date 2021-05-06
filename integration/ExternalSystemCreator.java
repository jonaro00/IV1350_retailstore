package integration;

/**
 * Creates instances of InventorySystem, SaleLog and
 * Accounting
 */
public class ExternalSystemCreator {
    private InventorySystem inventorySystem = new InventorySystem();
    private SaleLog saleLog = new SaleLog();
    private Accounting accounting = new Accounting();

    /**
     * @return The InventorySystem instance
     */
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }

    /**
     * @return The SaleLog instance
     */
    public SaleLog getSaleLog() {
        return saleLog;
    }

    /**
     * @return The Accounting instance
     */
    public Accounting getAccounting() {
        return accounting;
    }
}
