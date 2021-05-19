package controller;

/**
 * Wrapper for <code>Exception</code> that is thrown in the
 * controller layer when an internal operation failed.
 */
public class OperationFailedException extends Exception {
    public OperationFailedException(String msg, Exception cause) {
        super(msg, cause);
    }
}
