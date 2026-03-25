package SplitWise.Factories;

import Logger.LoggerService.LoggerService;
import SplitWise.Entities.Split;
import SplitWise.Entities.User;
import SplitWise.Strategies.ISplitStrategy;
import SplitWise.Strategies.SplitStrategy;

import java.util.*;

public class SplitFactory {
    public Split createSplit()
    {
        return new Split( new User() , 12.23D);
    }

    public List<Split> createSplit( double Amount , List<User> splitAmong , User paidBy, SplitStrategy splitStrategy )
    {
        List<Split> splits = new ArrayList<>();

        for( User x : splitAmong ){
            if( x.equals(paidBy) )
                splits.add( new Split(x , Amount ));
            else
              splits.add( new Split( x , 0 ));
        }

        double perPerson = Amount / splitAmong.size();

        if( splitStrategy.equals(SplitStrategy.equal))
        {
            for( Split s : splits )
                s.setAmount( s.getAmount() - perPerson );
        }
        else{
            LoggerService.getinstance("").Error("This Split Strategy is not yet supported");
            return null;
        }

        return splits;
    }
}
