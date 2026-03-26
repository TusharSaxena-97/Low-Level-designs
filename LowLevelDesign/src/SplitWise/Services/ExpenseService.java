package SplitWise.Services;

import SplitWise.Builder.ExpenseBuilder;
import SplitWise.Entities.Expense;
import SplitWise.Entities.User;
import SplitWise.Repositories.ExpenseRepository;

import java.util.concurrent.atomic.AtomicInteger;

public class ExpenseService {
    private GroupService groupService;
    private ExpenseRepository expenseRepository;
    private ExpenseBuilder expenseBuilder;

    public ExpenseService(GroupService groupService, ExpenseRepository expenseRepo) {
        this.expenseRepository = expenseRepo;
        this.groupService = groupService;
    }

    public synchronized Expense AddExpense( Expense expense )
    {
        return expenseRepository.AddExpense( expense );
    }

    public synchronized void EditExpense( int expenseId, Expense newExpense )
    {
        expenseRepository.DeleteExpense( expenseId );
        expenseRepository.AddExpense( newExpense );
    }

    // this is redundant and can be removed
    public void SettleUp(int groupId , User paidBy , User paidTo )
    {
        groupService.SettleUp( groupId , paidBy , paidTo );
    }
}
