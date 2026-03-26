package SplitWise.Services;

import SplitWise.Entities.*;
import SplitWise.Repositories.GroupRepository;

import java.util.List;

public class GroupService {
    GroupRepository groupRepository;
    ExpenseService expenseService;

    public GroupService(GroupRepository groupRepo) {
        this.groupRepository = groupRepo;
    }

    public ExpenseService getExpenseService() {
        return expenseService;
    }

    public void setExpenseService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // should be synchronized
    public synchronized Expense AddExpense(int groupId , User paidBy, Expense expense )
    {
        Group group = groupRepository.getById(groupId);

        group.UpdateBalance( paidBy , expense.getSplits() );
        group.getExpenseList().add( expense );

        return expenseService.AddExpense(expense);
    }
    public Group getGroupId( int groupId )
    {
        return groupRepository.getById( groupId );
    }

    public Group AddNewGroup(Group group)
    {
        groupRepository.addGroup( group );
        return group;
    }

    public void SettleUp(int groupId , User user1 , User user2 )
    {
        groupRepository.getById(groupId).SettleUp( user1 , user2 );
    }

    public void SimplifyDebt(int groupId)
    {
        groupRepository.getById(groupId).getBalanceSheet().SimplfyDebt();
    }

    public void UpdateGroupDetails()
    {

    }
}
