package SplitWise.Builder;

import SplitWise.Entities.BalanceSheet;
import SplitWise.Entities.Expense;
import SplitWise.Entities.Group;
import SplitWise.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class GroupBuilder {
    public int groupId;
    public String Name;
    public String description;
    public String image;
    public List<User> members = new ArrayList<>();
    public List<Expense> expenseList = new ArrayList<>();
    public BalanceSheet balanceSheet;

    public GroupBuilder AddDescription(String desc)
    {
        this.description = desc;
        return this;
    }

    public GroupBuilder AddImage(String image)
    {
        this.image = image;
        return this;
    }

    public GroupBuilder AddMember(User member)
    {
        this.members.add( member );
        return this;
    }

    public GroupBuilder AddExpense(Expense expense)
    {
        this.expenseList.add(expense);
        return this;
    }

    public GroupBuilder AddBalanceSheet( BalanceSheet balanceSheet )
    {
        this.balanceSheet = balanceSheet;
        return this;
    }

    public GroupBuilder AddName( String Name )
    {
        this.Name = Name;
        return this;
    }

    public Group build()
    {
        return new Group( this );
    }

}
