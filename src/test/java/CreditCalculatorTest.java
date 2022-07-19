import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditCalculatorTest {

    static final int loanAmount = 1000000;
    static final int annualInterestRate = 18;
    static final int paymentTerm = 36;

    static CreditCalculator calculator;

    @BeforeAll
    @Test
    static void getCalculatorTest() {
        calculator = CreditCalculatorImpl.getCalculator(loanAmount, annualInterestRate, paymentTerm);
        assertNotNull(calculator);
    }

    @Test
    void monthlyPaymentTest() {
        assertEquals(36152.4, calculator.monthlyPayment());
    }

    @Test
    void paymentsTotalAmountTest() {
        assertEquals(1301486.24, calculator.paymentsTotalAmount());
    }

    @Test
    void overpaymentTest() {
        assertEquals(301486.24, calculator.overpayment());
    }

}
