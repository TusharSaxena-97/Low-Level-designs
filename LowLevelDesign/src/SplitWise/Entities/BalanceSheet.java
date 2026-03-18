package SplitWise.Entities;

import java.util.*;


public class BalanceSheet {
    private Map<User,Map<User,Double>> balanceSheet = new HashMap<>();

    public Map<User,Double> getUserBalances( User user)
    {
        return balanceSheet.getOrDefault( user, new HashMap<User,Double>() );
    }

    public void updateBalance(Split split)
    {
        // logic to update the balance sheet for the group
    }

    public void update()
    {
        // Send notifications to all the users
    }
}
