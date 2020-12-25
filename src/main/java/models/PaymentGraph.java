package models;

import java.util.HashMap;
import java.util.Map;

public class PaymentGraph {
//User -> User, Amount


    private final Map<User, BalanceMap> graph;

    public PaymentGraph(Map<User, BalanceMap> graph) {
        this.graph = graph;
    }
}
