package model;

import java.util.ArrayList;

/**
 * Represents a cash register
 */
public class Register {
    private float balance;
    private ArrayList<RevenueObserver> revenueObservers = new ArrayList<>();

    /**
     * Initiates a register with a balance of 0.
     */
    public Register() {
        this.balance = 0;
    }

    /**
     * @param amount The amount to add to balance.
     */
    public void addPayment(float amount) {
        this.balance += amount;
        notifyObservers();
    }

    /**
     * Adds a <code>RevenueObserver</code> to send revenue notifications to.
     * @param obs The observer to add.
     */
    public void addRevenueObserver(RevenueObserver obs) {
        revenueObservers.add(obs);
    }

    private void notifyObservers() {
        for (RevenueObserver obs : revenueObservers) {
            obs.newTotalRevenue(this.balance);
        }
    }
}
