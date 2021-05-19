package view;

import java.util.Locale;

import controller.Controller;
import integration.ItemIDNotFoundException;
import util.DateTime;

/**
 * This program has no view, instead, this class is a placeholder for the entire
 * view.
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance.
     *
     * @param contr The controller that is used for all operations.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Simulates a user input that generates calls to all system operations.
     */
    public void sampleExecution() {
        Locale.setDefault(Locale.US);

        SampleData[] itemsToAdd = {
            new SampleData("Apple", 3),
            new SampleData("Banana", 5),
            new SampleData("Apple", 1),
            new SampleData("AnItemThatDoesNotExist", 1),
            new SampleData("Cherry", 1),
            new SampleData("MakeDatabaseFail", -1231513251),
        };

        System.out.println("Test execution:\n");

        contr.startSale();

        for (SampleData data : itemsToAdd) {
            try {
                System.out.println("[UI] Added item(s): " + contr.enterItem(data.getID(), data.getAmount()));
            } catch (ItemIDNotFoundException itemNotFoundExc) {
                System.out.println("[UI] " + itemNotFoundExc.getMessage());
            } catch (Exception exc) {
                System.out.println("[UI] " + exc.getMessage());
                System.out.println("[LOG] " + DateTime.now() + " Exception was thrown: " + exc.getMessage());
                exc.printStackTrace(System.out);
                System.out.println();
            }
            System.out.println("[UI]    Running total: " + contr.getSaleTotal());
        }
        float paidAmount = 60;
        float change = contr.payAndCalculateChange(paidAmount);
        System.out.println();
        System.out.println("[UI] Paid " + paidAmount + ", change is " + change);

        System.out.println();
        System.out.println("Printing Receipt: ");
        System.out.println();
        contr.printReceipt();
    }

    /**
     * Tuple with ID and amount for testing.
     */
    private class SampleData {
        private final String ID;
        private final int amount;
        SampleData(String ID, int amount) {
            this.ID = ID;
            this.amount = amount;
        }
        public String getID() {
            return ID;
        }
        public int getAmount() {
            return amount;
        }
    }
}