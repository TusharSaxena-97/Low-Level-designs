package SplitWise.Repositories;

import SplitWise.Entities.Expense;
import SplitWise.Entities.Group;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExpenseRepository {
    List<Expense> expenses = new ArrayList<>();

    public Expense AddExpense(Expense expense)
    {
       expenses.add( expense );
       return expense;
    }

    public List<Expense> getByGroupId( Group group )
    {
        return expenses.stream().filter( o -> o.equals(group)).collect(Collectors.toList());
    }

    public void DeleteExpense( int expenseId )
    {
        Predicate<Expense> p = ex -> ex.getExpenseId() == expenseId;
        expenses.removeIf( p );
    }
}
