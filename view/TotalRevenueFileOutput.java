package view;

import model.RevenueObserver;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TotalRevenueFileOutput implements RevenueObserver {
    private PrintWriter logStream;

    /**
     * Creates a new instance and also creates a new log file.
     * An existing log file will be deleted.
     */
    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (IOException ioe) {
            System.out.println("CAN NOT LOG.");
            ioe.printStackTrace();
        }
    }

    @Override
    public void newTotalRevenue(float amount) {
        System.out.println("[TotalRevenueFileOutput] Printing to file...");
        logStream.printf("[TotalRevenueFileOutput] The total revenue is now %.2f.\n", amount);
    }
}
