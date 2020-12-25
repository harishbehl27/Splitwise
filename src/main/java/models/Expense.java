package models;

import services.GroupService;

import java.util.Map;

public class Expense {

    private final BalanceMap userBalances;
    private final String title;

    private final String imageURL;

    private final String description;

    public Expense( BalanceMap userBalances, String title, String imageURL, String description) {
        this.userBalances = userBalances;
        this.title = title;
        this.imageURL = imageURL;
        this.description = description;
    }


    public BalanceMap getUserBalances() {

        return userBalances;
    }
}
