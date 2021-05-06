package integration;

import model.Receipt;

/**
 * Represents a connection to a printer.
 * In this case, it just prints to the console.
 */
public class Printer {
    public Printer() {

    }

    /**
     * Prints <code>receipt</code> to the console (would be something else in a real scenario).
     *
     * @param receipt The receipt to print.
     */
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt);
    }
}
