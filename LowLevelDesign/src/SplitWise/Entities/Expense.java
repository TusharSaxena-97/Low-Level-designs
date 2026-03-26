package SplitWise.Entities;

import SplitWise.Builder.ExpenseBuilder;
import SplitWise.Strategies.SplitStrategy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Expense {
    private volatile static AtomicInteger nextId = new AtomicInteger(0);
    private int expenseId;
    private double Amount;
    private String description;
    private String name;
    private User paidBy;
    private List<User> splitAmong;
    private SplitStrategy splitStrategy;
    private List<Split> splits;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    private Group group;

    public Expense(ExpenseBuilder eb)
    {
        this.name = eb.name;
        this.description = eb.description;;
        this.group = eb.group;
        this.splitAmong = eb.splitAmong;
        this.paidBy = eb.paidBy;
        this.splitStrategy = eb.splitStrategy;
        this.Amount = eb.Amount;
        this.splits = eb.splits;

        this.expenseId = nextId.getAndIncrement();
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setSplit(List<Split> splits)
    {
        this.splits = splits;
    }

    public List<Split> getSplits( )
    {
        return splits;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<User> getSplitAmong() {
        return splitAmong;
    }

    public void setSplitAmong(List<User> splitAmong) {
        this.splitAmong = splitAmong;
    }

    public SplitStrategy getSplitStrategy() {
        return splitStrategy;
    }

    public void setSplitStrategy(SplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
    }

    public void setGroupId(Group group) {
        this.group = group;
    }


    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(paidBy.name).append(" Paid Rs. => ").append(Amount).append(" Split among ")
                .append( splitAmong.stream().map( User::getName )
                        .reduce( ( a,b ) -> a + " , " + b  )
                        .get());

        return sb.toString();
    }
}

