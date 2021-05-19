package view;

import model.RevenueObserver;

public class TotalRevenueView implements RevenueObserver {
    public TotalRevenueView() {

    }

    @Override
    public void newTotalRevenue(float amount) {
        System.out.printf("[TotalRevenueView] The total revenue is now %.2f.\n", amount);
    }
}
