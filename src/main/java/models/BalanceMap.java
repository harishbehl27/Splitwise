package models;

import java.util.HashMap;
import java.util.Map;

public class BalanceMap {

    private final Map<User, Amount> balances;


    public BalanceMap(Map<User, Amount> resultBalances) {
        this.balances = resultBalances;
    }

    public BalanceMap() {

        this.balances= new HashMap<>();

    }

    public Map<User, Amount> getBalances() {

        return balances;
    }

    @Override
    public String toString() {
        return "BalanceMap{" +
                "balances=" + balances +
                '}';
    }
}
