import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class CreditCalculatorImpl implements CreditCalculator {

    private final int loanAmount;
    private final int annualInterestRate;
    private final int paymentTerm;

    private CreditCalculatorImpl(int loanAmount, int annualInterestRate, int paymentTerm) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.paymentTerm = paymentTerm;
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull CreditCalculator getCalculator(int loanAmount, int annualInterestRate, int paymentTerm) {
        return new CreditCalculatorImpl(loanAmount, annualInterestRate, paymentTerm);
    }

    private double calc() {
        double rate = annualInterestRate / 12.0 / 100;
        return loanAmount * rate / (1 - 1 / Math.pow(1 + rate, paymentTerm));
    }

    @Override
    public double monthlyPayment() {
        return Math.round(calc() * 100) / 100.0;
    }

    @Override
    public double paymentsTotalAmount() {
        return Math.round(calc() * paymentTerm * 100) / 100.0;
    }

    @Override
    public double overpayment() {
        return paymentsTotalAmount() - loanAmount;
    }
}
