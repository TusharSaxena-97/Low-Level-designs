package SplitWise.Services;

import SplitWise.Entities.*;
import SplitWise.Factories.SplitFactory;
import SplitWise.Repositories.GroupRepository;

public class GroupService {
    GroupRepository groupRepository;
    ExpenseService expenseService;

    // should be synchronized
    public synchronized void UpdateBalanceSheet(int groupId , User paidBy, Expense expense )
    {
        expenseService.AddExpense(expense);

        Group group = groupRepository.getById(groupId);

        group.UpdateBalance( paidBy , expense.getSplits() );
    }
    public Group getGroupId( int groupId )
    {
        return groupRepository.getById( groupId );
    }

    public void SettleUp(int groupId , User user1 , User user2 )
    {
        groupRepository.getById(groupId).SettleUp( user1 , user2 );
    }

    public void SimplifyDebt()
    {

    }
    public void UpdateGroupDetails()
    {

    }
}
