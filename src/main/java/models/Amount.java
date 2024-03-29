package models;

public class Amount {

    private final Currency currency;
    private  final int i;
    private final double amount;


    public Amount(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }

    public Amount add(Amount amount) {

        return new Amount(currency, amount.amount);
    }

    public double getAmount() {

        return amount;

    }
}
