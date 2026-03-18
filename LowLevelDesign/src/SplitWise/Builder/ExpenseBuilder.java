package SplitWise.Builder;

import SplitWise.Entities.Expense;
import SplitWise.Entities.Group;
import SplitWise.Entities.User;
import SplitWise.Strategies.ISplitStrategy;
import SplitWise.Strategies.SplitStrategy;

import java.util.ArrayList;
import java.util.List;

public class ExpenseBuilder {

    public String description;

    public String name;
    public User paidBy;
    public List<User> splitAmong = new ArrayList<>();
    public SplitStrategy splitStrategy;
    public Group group;

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

    public Expense build( )
    {
        return new Expense( this );
    }
}
