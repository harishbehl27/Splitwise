package models;

import java.util.Map;

public class PaymentGraph {
//User -> User, Amount

    private final Map<String, BalanceMap> graph;

    public PaymentGraph(Map<String, BalanceMap> graph) {
        this.graph = graph;
    }
}
