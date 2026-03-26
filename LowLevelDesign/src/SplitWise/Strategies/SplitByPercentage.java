package SplitWise.Strategies;

import SplitWise.Entities.Split;
import SplitWise.Entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SplitByPercentage implements ISplitStrategy {

    @Override
    public List<Split> createSplit(User paidBy, Double amount, List<User> splitAmong, SplitStrategy strategy, Map<User, Double> percentages) {

        // Guard: percentages must sum to 100
        double totalPercentage = percentages.values().stream().mapToDouble(Double::doubleValue).sum();
        if (Math.abs(totalPercentage - 100.0) > 0.001) {
            throw new IllegalArgumentException("Percentages must sum to 100, but got: " + totalPercentage);
        }

        List<Split> splits = new ArrayList<>();

        for (User user : splitAmong) {

            double percentage  = percentages.get(user);
            double userShare   = (amount * percentage / 100);  // what this user owes from the bill
            double amountPaid  = (user.getUserId() == paidBy.getUserId()) ? amount : 0;

            // net = what you OWE - what you PAID
            // e.g. amount=1000, A(payer,50%) : (500 - 1000) = -500
            //                   B(30%)        : (300 - 0)    = +300
            //                   C(20%)        : (200 - 0)    = +200
            double netShare = userShare - amountPaid;

            splits.add(new Split( user , netShare));
        }

        return splits;
    }
}