package SplitWise;

import SplitWise.Builder.ExpenseBuilder;
import SplitWise.Builder.GroupBuilder;
import SplitWise.Entities.BalanceSheet;
import SplitWise.Entities.Expense;
import SplitWise.Entities.Group;
import SplitWise.Entities.User;
import SplitWise.Factories.SplitFactory;
import SplitWise.Repositories.ExpenseRepository;
import SplitWise.Repositories.GroupRepository;
import SplitWise.Services.ExpenseService;
import SplitWise.Services.GroupService;
import SplitWise.Strategies.ISplitStrategy;
import SplitWise.Strategies.SplitStrategy;

import java.util.*;

public class Splitwise {

    public static void main(String[] args) {

        // ── 1. Create Users ───────────────────────────────────────────
        System.out.println("\n=== 1. Creating Users ===");
        User alice   = new User( "Alice",   "alice@mail.com" ,"");
        User bob     = new User( "Bob",     "bob@mail.com", "");
        User charlie = new User( "Charlie", "charlie@mail.com" , "");
        System.out.println("Users created: " + alice.toString() + ", " + bob.toString() + ", " + charlie.toString() );

        // ── 2. Setup Repositories & Services ─────────────────────────
        ExpenseRepository expenseRepo = new ExpenseRepository();
        GroupRepository groupRepo   = new GroupRepository();

        GroupService groupService   = new GroupService(groupRepo);
        ExpenseService expenseService = new ExpenseService(groupService, expenseRepo);
        groupService.setExpenseService( expenseService );

        GroupBuilder gb = new GroupBuilder();

        // ── 3. Create a Group (uses Builder internally) ───────────────
        System.out.println("\n=== 2. Creating Group 'Goa Trip' ===");
        Group goaTrip = groupService.AddNewGroup(
                gb.AddMember(alice).
                AddMember(bob).
                AddMember(charlie).
                        AddBalanceSheet(new BalanceSheet()).
                        AddDescription("Southern Beauty Beach Trip").
                        AddName("Trip 2026").
                        build( )
        );
        System.out.println("Group created → id=" + goaTrip.getGroupId()
                + ", members=" + goaTrip.getMembers().size() + "  Group Name = " + goaTrip.getName() );

        // ── 4. Add an Equal-Split Expense ─────────────────────────────
        // A = 180, B = C = -60  (from your diagram example)
        ExpenseBuilder eb = new ExpenseBuilder();
        System.out.println("\n=== 3. Equal Split — Hotel ₹180 paid by Alice ===");
        Expense hotel = groupService.AddExpense( goaTrip.getGroupId(),
                alice,
                eb.AddName("Expense 1").
                        AddDescription("Beer").
                        AddGroup( groupService.getGroupId(goaTrip.getGroupId()) ).
                        AddPaidBy( alice ).
                        AddSplitAmongList(Arrays.asList( alice , bob , charlie)).
                        AddSplitStrategy( SplitStrategy.equal ).
                        AddAmount(180.0)
                        .build()
        );

        System.out.println("Expense added → " + hotel.getName() );
        goaTrip.PrintBalances();

        // ── 5. Add a Percentage-Split Expense ─────────────────────────
        System.out.println("\n=== 4. Percentage Split — Dinner ₹1000 paid by Bob ===");
        Map<User, Double> percentages = new HashMap<>();
        percentages.put(alice ,  50.0);
        percentages.put(bob ,   30.0);
        percentages.put(charlie, 20.0);

        Expense dinner = groupService.AddExpense(
                goaTrip.getGroupId(),
                bob,
                eb.AddName("Expense 2").
                        AddDescription("Dinner").
                        AddGroup( groupService.getGroupId(goaTrip.getGroupId()) ).
                        AddPaidBy( bob ).
                        AddSplitAmongList(Arrays.asList( alice , bob , charlie)).
                        AddSplitStrategy( SplitStrategy.percentage ).
                        AddAmount(1000).
                        AddPercentageSplits( percentages )
                        .build()
        );

        System.out.println("Expense added → " + dinner.getName());
        goaTrip.PrintBalances();

        System.out.println("\n\nAfter Simplifying Debt ");
        groupService.SimplifyDebt(goaTrip.getGroupId());
        goaTrip.PrintBalances();

        // ── 6. Settle an expense ──────────────────────────────────────
        System.out.println("\n=== 5. Settlement — Bob pays Alice entire Amount");
        expenseService.SettleUp(
                goaTrip.getGroupId(),
                bob,
                alice
        );
        goaTrip.PrintBalances();

        // ── 7. Print full expense history ─────────────────────────────
        System.out.println("\n=== 6. Expense History ===");
        for( Expense ex : goaTrip.getExpenseList() )
            System.out.println( ex.toString() );

    }
}
