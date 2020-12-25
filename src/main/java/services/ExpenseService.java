package services;

import models.*;
import models.Currency;

import java.util.*;

public class ExpenseService {

    private final Map<String, List<Expense> > groupExpenses;

    public ExpenseService(Map<String, List<Expense>> groupExpenses) {
        this.groupExpenses = groupExpenses;
    }


    public List<Expense> getGroupExpenses(String groupId)
    {
        return groupExpenses.get(groupId);

    }

    public PaymentGraph getPaymentGraph (BalanceMap groupBalances)
    {

        final var graph = new HashMap<User, BalanceMap>();
        PriorityQueue<Map.Entry<User, Amount>> positiveAmounts
                = new PriorityQueue<>(Comparator.comparing(balance -> -balance.getValue().getAmount()));


        PriorityQueue<Map.Entry<User, Amount>> negativeAmounts
                = new PriorityQueue<>(Comparator.comparing(balance -> balance.getValue().getAmount()));

        for (var balance : groupBalances.getBalances().entrySet())
        {
            if (balance.getValue().getAmount()> 0)
            {
                positiveAmounts.add(balance);
            }
            else
            {
                negativeAmounts.add(balance);
            }
        }

        while(positiveAmounts.isEmpty() && !negativeAmounts.isEmpty())
        {
            final var largestPositive = positiveAmounts.poll();
            final var largestnegative = negativeAmounts.poll();


            final var  negativeAmount = -largestnegative.getValue().getAmount();
            final var  positiveAmount = largestPositive.getValue().getAmount();

            graph.putIfAbsent(largestPositive.getKey(), new BalanceMap());
            graph.get(largestPositive.getKey()).getBalances().put(largestnegative.getKey(), new Amount(Currency.USD,Math.min(positiveAmount,negativeAmount)));

            double remaining = positiveAmount-negativeAmount;
            final var remainingAmount = new Amount(Currency.USD, remaining);

            if (remaining > 0)
            {
                positiveAmounts.add(new AbstractMap.SimpleEntry<>(largestPositive.getKey(),remainingAmount));
            }
            else if (remaining < 0)
            {
                negativeAmounts.add(new AbstractMap.SimpleEntry<>(largestPositive.getKey(),remainingAmount));

            }





        }



        return new PaymentGraph(graph);
    }



}
