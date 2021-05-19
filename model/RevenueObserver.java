package model;

/**
 * A listener interface for receiving notifications about total revenue.
 * An observer implements this interface, which gets called from
 * classes where such observers are registered.
 */
public interface RevenueObserver {
    /**
     * This is called by observed classes when a new total revenue is recorded.
     * @param amount The total revenue.
     */
    public void newTotalRevenue(float amount);
}
