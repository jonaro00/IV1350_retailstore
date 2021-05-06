package model;

/**
 * Represents a cash register
 */
public class Register {
    private float balance;

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
    }
}
