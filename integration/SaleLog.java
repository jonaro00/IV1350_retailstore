package integration;

import java.util.ArrayList;

import model.Sale;

/**
 * Placeholder for a log of sales
 */
public class SaleLog {
    private ArrayList<Sale> sales;
    SaleLog() {
        this.sales = new ArrayList<Sale>();
    }

    /**
     * Log a sale
     *
     * @param sale The sale to add to the log
     */
    public void logSale(Sale sale) {
        this.sales.add(sale);
    }
}
