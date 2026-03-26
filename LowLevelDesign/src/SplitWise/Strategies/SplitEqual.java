package SplitWise.Strategies;

        import SplitWise.Entities.Split;
        import SplitWise.Entities.User;
        import SplitWise.Factories.SplitFactory;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;

public class SplitEqual implements ISplitStrategy {

    private SplitFactory splitFactory;

    public SplitEqual() {
        this.splitFactory = splitFactory;
    }

    @Override
    public List<Split> createSplit( User paidBy, Double amount, List<User> splitAmong, SplitStrategy strategy, Map<User, Double> percentges) {

        List<Split> splits = new ArrayList<>();

        // Each person's equal share of the total bill
        double sharePerPerson = amount / splitAmong.size();

        for (User user : splitAmong) {
            // amountPaid = full bill if this user is the payer, else 0
            double amountPaid = (user.getUserId() == paidBy.getUserId()) ? amount : 0;

            // net = what you OWE - what you PAID
            // A: 100 - 300 = -200 (owed money back)
            // B: 100 - 0   = +100 (owes money)
            // C: 100 - 0   = +100 (owes money)
            double userShare = sharePerPerson - amountPaid;
            splits.add( new Split( user, userShare ) );
        }

        return splits;
    }
}