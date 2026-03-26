package SplitWise.Factories;

import Logger.LoggerService.LoggerService;
import SplitWise.Entities.Split;
import SplitWise.Entities.User;
import SplitWise.Strategies.ISplitStrategy;
import SplitWise.Strategies.SplitByPercentage;
import SplitWise.Strategies.SplitEqual;
import SplitWise.Strategies.SplitStrategy;

import java.util.*;

public class SplitFactory {
    public Split createSplit()
    {
        return new Split( new User("","","") , 12.23D);
    }

    public static List<Split> createSplit(  User paidBy, double Amount , List<User> splitAmong , SplitStrategy splitStrategy , Map<User,Double> percentages)
    {
        if( splitStrategy.equals(SplitStrategy.equal))
        {
            return ( new SplitEqual( ) ).createSplit( paidBy , Amount , splitAmong , splitStrategy , percentages );
        }
        else if(splitStrategy.equals(SplitStrategy.percentage)){
            return ( new SplitByPercentage()).createSplit( paidBy , Amount , splitAmong , splitStrategy , percentages );
        }

        return new ArrayList<Split>();
    }
}
