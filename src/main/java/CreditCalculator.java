import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public interface CreditCalculator {

    @Contract(pure = true)
    static @Nullable CreditCalculator getCalculator(int loanAmount, int annualInterestRate, int paymentTerm) {
        return null;
    }

    double monthlyPayment();
    double paymentsTotalAmount();
    double overpayment();
}
