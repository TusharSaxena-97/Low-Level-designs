package SplitWise.Strategies;

import SplitWise.Entities.Split;
import SplitWise.Entities.User;
import SplitWise.Factories.SplitFactory;

import java.util.ArrayList;
import java.util.List;

public class SplitEqual implements ISplitStrategy{

    private SplitFactory splitFactory;


    @Override
    public List<Split> createSplit(User paidBy, Double amount, List<User> splitAmong, SplitStrategy strategy) {
        // LOGIC FOR CREATING EQUAL SPLIT
        return new ArrayList<Split>();
    }
}
