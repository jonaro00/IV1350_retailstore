package integration;

/**
 * Thrown when something goes wrong in the <code>InventorySystem</code>.
 */
public class InventorySystemException extends RuntimeException {
    /**
     * Creates a new instance describing what went wrong.
     * @param msg Message describing what went wrong.
     */
    public InventorySystemException(String msg) {
        super(msg);
    }
}
