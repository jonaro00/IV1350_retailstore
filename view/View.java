package view;

import java.util.Locale;

import controller.Controller;

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

        System.out.println("Test execution:\n");

        contr.startSale();
        System.out.println("Added item(s): " + contr.enterItem("Apple", 3));
        System.out.println("    Running total: " + contr.getSaleTotal());
        System.out.println("Added item(s): " + contr.enterItem("Banana", 5));
        System.out.println("    Running total: " + contr.getSaleTotal());
        System.out.println("Added item(s): " + contr.enterItem("Apple", 1));
        System.out.println("    Running total: " + contr.getSaleTotal());
        System.out.println("Added item(s): " + contr.enterItem("Cherry", 1));
        System.out.println("    Running total: " + contr.getSaleTotal());

        float paidAmount = 60;
        float change = contr.payAndCalculateChange(paidAmount);
        System.out.println();
        System.out.println("Paid " + paidAmount + ", change is " + change);

        System.out.println();
        System.out.println("Printing Receipt: ");
        System.out.println();
        contr.printReceipt();
    }
}