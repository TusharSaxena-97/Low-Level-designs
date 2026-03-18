package SplitWise.Builder;

import SplitWise.Entities.BalanceSheet;
import SplitWise.Entities.Expense;
import SplitWise.Entities.Group;
import SplitWise.Entities.User;

import java.util.List;

public class GroupBuilder {
    public int groupId;
    public String description;
    public String image;
    public List<User> members;
    public List<Expense> expenseList;
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

    public Group build()
    {
        return new Group( this );
    }

}
