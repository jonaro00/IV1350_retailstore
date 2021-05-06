package model;

/**
 * Wrapper for a String. Could contain more info about the receipt in a real scenario.
 */
public class Receipt {
    private String message;

    public Receipt(String message) {
        this.message = message;
    }
    
    /** 
     * @return The message String.
     */
    @Override
    public String toString() {
        return this.message;
    }
}
