package controller;

import integration.ExternalSystemCreator;
import integration.InventorySystem;
import integration.InventorySystemException;
import integration.SaleLog;
import model.Register;
import model.RevenueObserver;
import model.Sale;
import integration.Accounting;
import integration.ItemDTO;
import integration.ItemIDNotFoundException;
import integration.Printer;

/**
 * This is the application’s only controller class. All calls to the model pass
 * through here.
 */
public class Controller {
    private InventorySystem inventorySystem;
    private SaleLog saleLog;
    private Accounting accounting;
    private Printer printer;
    private Register register;

    private Sale sale;

    /**
     * Creates a new instance.
     *
     * @param creator ExternalSystemCreator that contains instances of external systems
     * @param printer The printer for printing receipts
     */
    public Controller(ExternalSystemCreator creator, Printer printer) {
        this.inventorySystem = creator.getInventorySystem();
        this.saleLog = creator.getSaleLog();
        this.accounting = creator.getAccounting();
        this.printer = printer;
        this.register = new Register();
    }

    /**
     * Starts a new Sale. Discards any previous instance.
     */
    public void startSale() {
        this.sale = new Sale();
    }

    /**
     * Searches for an item with an ID matching <code>itemID</code>.
     * If found, <code>quantity</code> of that item is added to the
     * current sale and the corresponding <code>ItemDTO</code> is returned.
     *
     * @param itemID The item to search for.
     * @param quantity The amount of items to add.
     * @return The matching <code>ItemDTO</code>.
     * @throws ItemIDNotFoundException If itemID was not found.
     * @throws OperationFailedException If the item could not be entered for other reasons.
     */
    public ItemDTO enterItem(String itemID, int quantity) throws ItemIDNotFoundException, OperationFailedException {
        try {
            ItemDTO item = inventorySystem.getItemInfo(itemID);
            this.sale.addItem(item, quantity);
            return item;
        } catch (InventorySystemException invSysExc) {
            throw new OperationFailedException("Could not add the item", invSysExc);
        }
    }

    /**
     * @return The current total price (including VAT) of all items in the current sale.
     */
    public float getSaleTotal() {
        return this.sale.getTotalPrice();
    }

    /**
     * Takes the amount paid by the customer, ends the sale,
     * updates external systems and returns the change to give back.
     *
     * @param paidAmount The amount paid by the customer.
     * @return The amount of change to give back.
     */
    public float payAndCalculateChange(float paidAmount) {
        float amount = this.getSaleTotal();
        saleLog.logSale(sale);
        accounting.updateAccounting(amount);
        inventorySystem.updateInventory(sale);
        register.addPayment(amount);

        return paidAmount - amount;
    }

    /**
     * Prints the receipt for the sale.
     */
    public void printReceipt() {
        printer.printReceipt(sale.getReceipt());
    }

    /**
     * Registers a <code>RevenueObserver</code> to receive notifications about total revenue.
     * @param obs The observer to register.
     */
    public void addRevenueObserver(RevenueObserver obs) {
        this.register.addRevenueObserver(obs);
    }
}
