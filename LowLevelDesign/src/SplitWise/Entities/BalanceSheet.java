package SplitWise.Entities;

import java.util.*;


public class BalanceSheet {
    private Map<User,Map<User,Double>> balanceSheet = new HashMap<>();

    public Map<User,Double> getUserBalances( User user)
    {
        return balanceSheet.getOrDefault( user, new HashMap<User,Double>() );
    }

    public void updateBalance(User paidBy , List<Split> split)
    {
        for( Split nowSplit : split ) {
            if (nowSplit.getUser().equals(paidBy)) continue;

            User user = nowSplit.getUser();
            Map<User, Double> mp = getUserBalances(paidBy);

            mp.put(user, mp.getOrDefault(user, (double) 0) + nowSplit.getAmount());
            mp.put(paidBy, mp.getOrDefault(user, (double) 0) - nowSplit.getAmount());
        }
    }

    public void SettleBalance( User paidBy, User paidTo )
    {
        if (!balanceSheet.containsKey(paidBy) ||
                !balanceSheet.get(paidBy).containsKey(paidTo)) {
            return;
        }

        balanceSheet.get(paidBy).remove(paidTo);
        balanceSheet.get(paidTo).remove(paidBy);

        // optional cleanup
        if (balanceSheet.get(paidBy).isEmpty()) {
            balanceSheet.remove(paidBy);
        }
        if (balanceSheet.get(paidTo).isEmpty()) {
            balanceSheet.remove(paidTo);
        }
    }
}
