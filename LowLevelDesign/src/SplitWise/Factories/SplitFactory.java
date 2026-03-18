package SplitWise.Factories;

import SplitWise.Entities.Split;
import SplitWise.Entities.User;

public class SplitFactory {
    public Split createSplit()
    {
        return new Split( new User() , 12.23D);
    }
}
