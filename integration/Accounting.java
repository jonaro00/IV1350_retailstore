package integration;

import java.util.ArrayList;

public class Accounting {
    private ArrayList<Float> sales;
    Accounting() {
        this.sales = new ArrayList<Float>();
    }

    /**
     * Update accounting with the amount paid
     *
     * @param amount The amount paid
     */
    public void updateAccounting(float amount) {
        this.sales.add(amount);
    }
}
