import models.BalanceMap;
import models.Currency;
import models.Expense;

import models.*;
import org.junit.Assert;
import org.junit.Test;
import services.ExpenseService;
import services.GroupService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class GroupPaymentGraphTest {


    @Test
    public void defaultTest() throws IllegalAccessException {

        final var expenseService = constructExpenseService();



        final HashMap<String, Group> groups = getGroups();
        GroupService groupService = new GroupService(expenseService, groups);

        final var balances = groupService.getBalances("123","A");

        //System.out.println(expenseService.getGroupExpenses("123"));

        System.out.println("balance is " + balances);


        System.out.println( balances.getBalances().get("A"));

        Assert.assertEquals(balances.getBalances().get("A").getAmount(),50.0, 0.0001);





    }


    private ExpenseService constructExpenseService() {
        //String -> User id
        final var groupExpenses = new HashMap<String, List<Expense>>();
        final var expenses = new ArrayList<Expense>();


        final var firstExpense = new BalanceMap();

        firstExpense.getBalances().put("A",new Amount(Currency.USD,10));
        firstExpense.getBalances().put("B",new Amount(Currency.USD,20));
        firstExpense.getBalances().put("C",new Amount(Currency.USD,-30));

        expenses.add(new Expense(firstExpense,"outing1","www.eurotrip","outing1" ));

        final var secondExpense = new BalanceMap();

        secondExpense.getBalances().put("A",new Amount(Currency.USD,-50));
        secondExpense.getBalances().put("B",new Amount(Currency.USD,10));
        secondExpense.getBalances().put("C",new Amount(Currency.USD,40));

        expenses.add(new Expense(secondExpense,"outing2","www.eurotrip","outing2" ));

        final var thirdExpense = new BalanceMap();

        thirdExpense.getBalances().put("A",new Amount(Currency.USD,90));
        thirdExpense.getBalances().put("C",new Amount(Currency.USD,-90));
        expenses.add(new Expense(thirdExpense,"outing3","www.eurotrip","outing3" ));

        groupExpenses.put("123",expenses);
        return new ExpenseService(groupExpenses);


        // A -> 50, B -> 30  c -> -80


    }


    private HashMap<String, Group> getGroups() {
        final var groups = new HashMap<String, Group>();

        final var userList = new ArrayList<String>();

        userList.add("A");
        userList.add("B");


        userList.add("C");
        groups.put("123", new Group("Europe", "Euro trip","www.eurotrip.com",userList));
        return groups;
    }
}
