package integration;

public class Amount {
    private final float value;
    private final String currency;
    public Amount(float value) {
        this.value = value;
        this.currency = "SEK";
    }
    public Amount(float value, String currency) {
        this.value = value;
        this.currency = currency;
    }
}
