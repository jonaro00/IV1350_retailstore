

import controller.Controller;
import integration.ExternalSystemCreator;
import integration.Printer;
import view.View;

/**
 * Contains the <code>main</code> method. Performs all startup of the
 * application.
 */
public class Main {
    /**
     * Starts the application.
     *
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args) {
        ExternalSystemCreator creator = new ExternalSystemCreator();
        Printer printer = new Printer();
        Controller contr = new Controller(creator, printer);
        new View(contr).sampleExecution();
    }
}