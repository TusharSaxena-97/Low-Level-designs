package SplitWise.Strategies;

import SplitWise.Entities.Expense;
import SplitWise.Entities.Split;
import SplitWise.Entities.User;

import java.util.*;

public interface ISplitStrategy {
    public abstract List<Split> createSplit(User paidBy, Double amount , List<User> splitAmong , SplitStrategy strategy );
}
