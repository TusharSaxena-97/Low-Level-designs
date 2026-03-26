package SplitWise.Builder;

import SplitWise.Entities.Expense;
import SplitWise.Entities.Group;
import SplitWise.Entities.Split;
import SplitWise.Entities.User;
import SplitWise.Factories.SplitFactory;
import SplitWise.Strategies.ISplitStrategy;
import SplitWise.Strategies.SplitStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpenseBuilder {

    public String description;

    public String name;
    public User paidBy;
    public List<User> splitAmong = new ArrayList<>();
    public SplitStrategy splitStrategy;
    public Group group;
    public double Amount;
    public List<Split> splits;
    public  Map<User, Double> percentages;

    public ExpenseBuilder AddAmount(double Amount)
    {
        this.Amount = Amount;
        return this;
    }

    public ExpenseBuilder AddDescription( String desc)
    {
        this.description = desc;
        return this;
    }

    public ExpenseBuilder AddName( String Name )
    {
        this.name =Name;
        return this;
    }

    public ExpenseBuilder AddPaidBy( User pb)
    {
        this.paidBy = pb;
        return this;
    }

    public ExpenseBuilder AddSplitAmong(User user)
    {
        this.splitAmong.add( user );
        return this;
    }

    public ExpenseBuilder AddSplitAmongList(List<User> users)
    {
        this.splitAmong = users;
        return this;
    }

    public ExpenseBuilder AddSplitStrategy(SplitStrategy strategy )
    {
        this.splitStrategy = strategy;
        return this;
    }

    public ExpenseBuilder AddGroup(Group group)
    {
        this.group = group;
        return this;
    }

    public ExpenseBuilder AddPercentageSplits(Map<User, Double> percentages)
    {
        this.percentages = percentages;
        return this;
    }

    public Expense build( )
    {
        this.splits = SplitFactory.createSplit( this.paidBy , this.Amount , this.splitAmong ,  this.splitStrategy, this.percentages );
        return new Expense( this );
    }
}
