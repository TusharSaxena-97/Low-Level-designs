package SplitWise.Entities;
import java.util.*;

public class BalanceSheet {
    private Map<User,Map<User,Double>> balanceSheet = new HashMap<>();

    public Map<User, Double> getUserBalances(User user)
    {
        return balanceSheet.computeIfAbsent(user, k -> new HashMap<>());
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

    public void AddTransaction( User paidBy , User paidTo , double Amount )
    {
        Map<User , Double> nowBalance = getUserBalances( paidBy );
        nowBalance.put( paidTo , nowBalance.getOrDefault( paidTo , (double) 0) +  Amount );

        nowBalance = getUserBalances( paidTo );
        nowBalance.put( paidBy , nowBalance.getOrDefault( paidBy , (double) 0) -  Amount );
    }

    public void SimplfyDebt()
    {
        List<Transaction> simpleTxns = simplifyTransactions();

        balanceSheet.clear();

        for( Transaction txn : simpleTxns )
            AddTransaction(txn.from , txn.to, txn.amount);
    }

    public List<Transaction> simplifyTransactions() {

        // Step 1: compute net balance of every user
        Map<User, Double> net = new HashMap<>();

        for (User u : balanceSheet.keySet()) {
            net.putIfAbsent(u, 0.0);

            for (Map.Entry<User, Double> entry : balanceSheet.get(u).entrySet()) {
                User v = entry.getKey();
                double amount = entry.getValue();

                net.put(u, net.getOrDefault(u, 0.0) - amount);
                net.put(v, net.getOrDefault(v, 0.0) + amount);
            }
        }

        // Step 2: split into creditors & debtors
        PriorityQueue<Map.Entry<User, Double>> creditors =
                new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));

        PriorityQueue<Map.Entry<User, Double>> debtors =
                new PriorityQueue<>();

        for (Map.Entry<User, Double> entry : net.entrySet()) {
            double amount = entry.getValue();
            if (amount > 0) creditors.add(entry);
            else if (amount < 0) debtors.add(entry);
        }

        // Step 3: greedy settle
        List<Transaction> result = new ArrayList<>();

        while (!creditors.isEmpty() && !debtors.isEmpty()) {

            Map.Entry<User, Double> creditor = creditors.poll();
            Map.Entry<User, Double> debtor = debtors.poll();

            double settleAmount = Math.min(creditor.getValue(), -debtor.getValue());

            result.add(new Transaction(debtor.getKey(), creditor.getKey(), settleAmount));

            // update balances
            double newCred = creditor.getValue() - settleAmount;
            double newDebt = debtor.getValue() + settleAmount;

            if (newCred > 0)
                creditors.add(new AbstractMap.SimpleEntry<>(creditor.getKey(), newCred));

            if (newDebt < 0)
                debtors.add(new AbstractMap.SimpleEntry<>(debtor.getKey(), newDebt));
        }

        return result;
    }
}

class Transaction {
    User from;
    User to;
    double amount;

    public Transaction(User from, User to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
}
