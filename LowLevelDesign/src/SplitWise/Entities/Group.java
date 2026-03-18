package SplitWise.Entities;
import SplitWise.Builder.GroupBuilder;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// can implement interface IObservable
public class Group {
    private static AtomicInteger nextId = new AtomicInteger(1);
    private int groupId;
    private String description;
    private String image;
    private List<User> members;
    private List<Expense> expenseList;
    private BalanceSheet balanceSheet;

    public Group( GroupBuilder groupBuilder)
    {
        this.groupId = nextId.incrementAndGet();

        this.description = groupBuilder.description;;
        this.image = groupBuilder.image;
        this.members = new ArrayList<>( groupBuilder.members);
        this.balanceSheet = groupBuilder.balanceSheet;
        this.expenseList = new ArrayList<>( groupBuilder.expenseList );
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }
}
