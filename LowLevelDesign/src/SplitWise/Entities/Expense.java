package SplitWise.Entities;

import SplitWise.Builder.ExpenseBuilder;
import SplitWise.Strategies.SplitStrategy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Expense {
    private volatile static AtomicInteger nextId = new AtomicInteger(0);
    private int expenseId;
    private String description;
    private String name;
    private User paidBy;
    private List<User> splitAmong;
    private SplitStrategy splitStrategy;
    private Group group;

    public Expense(ExpenseBuilder eb)
    {
        this.name = eb.name;
        this.description = eb.description;;
        this.group = eb.group;
        this.splitAmong = eb.splitAmong;
        this.paidBy = eb.paidBy;
        this.splitStrategy = eb.splitStrategy;

        this.expenseId = nextId.getAndIncrement();
    }

    public Group getGroupId() {
        return group;
    }

    public int getExpenseId() {
        return expenseId;
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
}

