package SplitWise.Strategies;

import SplitWise.Entities.Split;
import SplitWise.Entities.User;

import java.util.List;

public class SplitByPercentage implements ISplitStrategy{

    @Override
    public List<Split> createSplit(User paidBy, Double amount, List<User> splitAmong, SplitStrategy strategy) {
        return null;
    }

}
